package com.neunet24.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    private String isbn;

    private String title;
    private String authors;
    private String publisher;
    private String publishedDate;
    private String coverImage;

    @Column(length = 2000)
    private String description;

    @Column(name = "mylocation", length = 100)
    private String mylocation;

    private Integer pageCount;
    private String language;
    private String categories;
    private String previewLink;

    private boolean found;
    private boolean error;
    
    @Column(name = "search_date")
    private LocalDateTime searchDate;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
