//  src/main/java/.../CoverController.java
package com.neunet24.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/covers")
@RequiredArgsConstructor
public class CoverController {

    private final RestTemplateBuilder restBuilder;

    /** cartella dove salvare le jpg – iniettata da application.properties */
    @Value("${covers.path:covers}")
    private String coversDir;

    @GetMapping("/{isbn}.jpg")
    public ResponseEntity<ByteArrayResource> cover(@PathVariable String isbn,
                                                   @RequestParam(required = false) String remote)
                                                   throws IOException {

        Path dir   = Paths.get(coversDir);
        Files.createDirectories(dir);                 // assicura che esista

        Path file  = dir.resolve(isbn + ".jpg");

        byte[] bytes;

        /* 1. Prova sul filesystem */
        if (Files.exists(file)) {
            bytes = Files.readAllBytes(file);

        /* 2. Altrimenti scarica dall'URL remoto (se fornito) */
        } else if (remote != null && !remote.isBlank()) {

            var rest = restBuilder
                       .setConnectTimeout(Duration.ofSeconds(5))
                       .setReadTimeout(Duration.ofSeconds(10))
                       .build();

            bytes = rest.getForObject(remote, byte[].class);

            // salvataggio su disco per i prossimi accessi
            Files.write(file, bytes, StandardOpenOption.CREATE);
        } else {
            return ResponseEntity.notFound().build();
        }

        var resource = new ByteArrayResource(bytes);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .cacheControl(CacheControl.maxAge(365, TimeUnit.DAYS))
                .body(resource);
    }
}
