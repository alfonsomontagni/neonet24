package com.neunet24.controller;

import com.neunet24.bookstore.dto.BookDto;
import com.neunet24.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.neunet24.bookstore.entity.Book;
import com.neunet24.bookstore.repository.BookRepository;
import com.neunet24.bookstore.service.BookMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Sort;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Neunet24Controller {

	 private final BookService bookService;


	    @PostMapping("/books")
	    public ResponseEntity<Void> saveBooks(@RequestBody List<BookDto> books) {
	    	 books.forEach(System.out::println); // debug
	        bookService.saveAll(books);
	        return ResponseEntity.ok().build();
	    }

	    private final BookMapper bookMapper;
	    private final BookRepository bookRepository;

	    @GetMapping("/books")
	    public ResponseEntity<Page<BookDto>> listBooks(
	            @RequestParam(required = false) Boolean found,
	            @RequestParam(required = false) String language,
	            @RequestParam(required = false) String mylocation,
	            @RequestParam(required = false) String title,
	            @RequestParam(required = false) String authors,
	            @PageableDefault(
	            		size = 10, sort = "searchDate", 
	            		direction = Sort.Direction.DESC)  Pageable pageable

	    ) {
	        Page<Book> page;

	        // Default fallback: found = true se non specificato
	        boolean foundValue = (found != null) ? found : true;

	        if (language != null && mylocation != null && title != null && authors != null) {
	            page = bookRepository.findByFoundAndLanguageAndMylocationAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
	                    foundValue, language, mylocation, title, authors, pageable);
	        } else if (language != null && title != null && authors != null) {
	            page = bookRepository.findByFoundAndLanguageAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
	                    foundValue, language, title, authors, pageable);
	        } else if (mylocation != null && title != null && authors != null) {
	            page = bookRepository.findByFoundAndMylocationAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
	                    foundValue, mylocation, title, authors, pageable);
	        } else if (title != null && authors != null) {
	            page = bookRepository.findByFoundAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
	                    foundValue, title, authors, pageable);
	        } else if (title != null) {
	            page = bookRepository.findByFoundAndTitleContainingIgnoreCase(foundValue, title, pageable);
	        } else if (authors != null) {
	            page = bookRepository.findByFoundAndAuthorsContainingIgnoreCase(foundValue, authors, pageable);
	        } else if (language != null && mylocation != null) {
	            page = bookRepository.findByFoundAndLanguageAndMylocation(foundValue, language, mylocation, pageable);
	        } else if (language != null) {
	            page = bookRepository.findByFoundAndLanguage(foundValue, language, pageable);
	        } else if (mylocation != null) {
	            page = bookRepository.findByFoundAndMylocation(foundValue, mylocation, pageable);
	        } else {
	            page = bookRepository.findByFound(foundValue, pageable);
	        }

	        return ResponseEntity.ok(page.map(bookMapper::toDto));
	    }
	    
	    @CrossOrigin(origins = "http://localhost:4200")
	    @PutMapping("/books/{isbn}")
	    public ResponseEntity<Void> updateBook(@PathVariable String isbn, @RequestBody BookDto bookDto) {
	        if (!isbn.equals(bookDto.getIsbn())) {
	            return ResponseEntity.badRequest().build();
	        }
	        bookService.updateBook(bookDto);
	        return ResponseEntity.ok().build();
	    }

	    @GetMapping("/books/{isbn}")
	    public ResponseEntity<BookDto> getBookByIsbn(@PathVariable String isbn) {
	        return bookRepository.findById(isbn)
	            .map(book -> ResponseEntity.ok(bookMapper.toDto(book)))
	            .orElse(ResponseEntity.notFound().build());
	    }
	    
	    @PostMapping("/books/by-isbn-list")
	    public ResponseEntity<List<BookDto>> getBooksByIsbnList(@RequestBody List<String> isbns) {
	        List<BookDto> results = isbns.stream()
	            .map(bookService::findByIsbn)
	            .filter(Optional::isPresent)
	            .map(Optional::get)
	            .map(bookMapper::toDto)
	            .toList();

	        return ResponseEntity.ok(results);
	    }



}
