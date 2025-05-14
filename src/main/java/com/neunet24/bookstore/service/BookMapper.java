package com.neunet24.bookstore.service;

import com.neunet24.bookstore.dto.BookDto;
import com.neunet24.bookstore.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookDto toDto(Book book) {
        return BookDto.builder()
                .isbn(book.getIsbn())
                .title(book.getTitle())
                .authors(book.getAuthors())
                .publisher(book.getPublisher())
                .publishedDate(book.getPublishedDate())
                .coverImage(book.getCoverImage())
                .description(book.getDescription())
                .pageCount(book.getPageCount())
                .language(book.getLanguage())
                .categories(book.getCategories())
                .previewLink(book.getPreviewLink())
                .found(book.isFound())
                .error(book.isError())
                .searchDate(book.getSearchDate())
                .mylocation(book.getMylocation())
                .updatedAt(book.getUpdatedAt())

                .build();
    }
}  
