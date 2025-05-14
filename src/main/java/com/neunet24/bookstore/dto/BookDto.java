package com.neunet24.bookstore.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class BookDto {
    private String isbn;
    private String title;
    private String authors;
    private String publisher;
    private String publishedDate;
    private String coverImage;
    private String description;
    private Integer pageCount;
    private String language;
    private String categories;
    private String previewLink;
    private boolean found;
    private boolean error;
    private LocalDateTime searchDate;
    private String mylocation;

    private LocalDateTime updatedAt;
    
    
}

