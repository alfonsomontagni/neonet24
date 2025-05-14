package com.neunet24.bookstore.service;

import com.neunet24.bookstore.dto.BookDto;
import com.neunet24.bookstore.entity.Book;
import com.neunet24.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public void updateBook(BookDto dto) {
        bookRepository.findById(dto.getIsbn()).ifPresent(book -> {
            book.setTitle(dto.getTitle());
            book.setAuthors(dto.getAuthors());
            book.setPublisher(dto.getPublisher());
            book.setPublishedDate(dto.getPublishedDate());
            book.setCoverImage(dto.getCoverImage());
            book.setDescription(dto.getDescription());
            book.setPageCount(dto.getPageCount());
            book.setLanguage(dto.getLanguage());
            book.setCategories(dto.getCategories());
            book.setPreviewLink(dto.getPreviewLink());
            book.setFound(dto.isFound());
            book.setError(dto.isError());
            book.setSearchDate(dto.getSearchDate() != null ? dto.getSearchDate() : LocalDateTime.now());
            book.setMylocation(dto.getMylocation());
            book.setUpdatedAt(LocalDateTime.now());

            bookRepository.save(book);
        });
    }

    public void saveAll(List<BookDto> dtos) {
        List<Book> books = new ArrayList<>();

        for (BookDto dto : dtos) {
            if (!bookRepository.existsById(dto.getIsbn())) {
                books.add(toEntity(dto));
            }
        }

        bookRepository.saveAll(books);
    }

    public Optional<Book> findByIsbn(String isbn) {
        return bookRepository.findById(isbn);
    }

    public Book save(BookDto dto) {
        if (!bookRepository.existsById(dto.getIsbn())) {
            return bookRepository.save(toEntity(dto));
        }
        return null; // oppure puoi lanciare eccezione se preferisci
    }

    private Book toEntity(BookDto dto) {
        return Book.builder()
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .authors(dto.getAuthors())
                .publisher(dto.getPublisher())
                .publishedDate(dto.getPublishedDate())
                .coverImage(dto.getCoverImage())
                .description(dto.getDescription())
                .pageCount(dto.getPageCount())
                .language(dto.getLanguage())
                .categories(dto.getCategories())
                .previewLink(dto.getPreviewLink())
                .found(dto.isFound())
                .error(dto.isError())
                .searchDate(dto.getSearchDate())
                .mylocation(dto.getMylocation())
                .updatedAt(dto.getUpdatedAt())
                .build();
    }
} 

/*
public void saveAll(List<BookDto> dtos) {
    List<Book> books = new java.util.ArrayList<>();

    for (BookDto dto : dtos) {
        if (!bookRepository.existsById(dto.getIsbn())) {
            Book book = Book.builder()
                    .isbn(dto.getIsbn())
                    .title(dto.getTitle())
                    .authors(dto.getAuthors())
                    .publisher(dto.getPublisher())
                    .publishedDate(dto.getPublishedDate())
                    .coverImage(dto.getCoverImage())
                    .description(dto.getDescription())
                    .pageCount(dto.getPageCount())
                    .language(dto.getLanguage())
                    .categories(dto.getCategories())
                    .previewLink(dto.getPreviewLink())
                    .found(dto.isFound())
                    .error(dto.isError())
                    .searchDate(dto.getSearchDate())
                    .mylocation(dto.getMylocation())
                    .build();

            books.add(book);
        }
    }

    bookRepository.saveAll(books);
}
*/
