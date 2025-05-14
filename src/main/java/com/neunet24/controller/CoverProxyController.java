package com.neunet24.controller;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/covers")
@RequiredArgsConstructor
public class CoverProxyController {

    private final RestTemplateBuilder restBuilder;

    /**
     * Proxy che scarica la copertina remota, aggiunge gli header CORS
     * e la restituisce come <code>image/jpeg</code>.
     *
     * Esempio chiamata:  
     * <pre>
     * GET /api/covers/9788804686237?url=https%3A%2F%2Fbooks.google.com%2Fbooks%2Fcontent%3Fid%3D...
     * </pre>
     */
    @GetMapping("/{isbn}")
    public ResponseEntity<byte[]> proxyCover(@PathVariable String isbn,
                                             @RequestParam String url) {

        var rest = restBuilder
                   .setConnectTimeout(Duration.ofSeconds(5))
                   .setReadTimeout   (Duration.ofSeconds(10))
                   .build();

        byte[] bytes = rest.getForObject(url, byte[].class);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        headers.setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));

        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
