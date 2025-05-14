package com.neunet24.bookstore.repository;

import com.neunet24.bookstore.entity.Book;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
	 Page<Book> findByFound(boolean found, Pageable pageable);
	 Page<Book> findByLanguage(String language, Pageable pageable);
	 Page<Book> findByFoundAndLanguage(boolean found, String language, Pageable pageable);
	 Page<Book> findByFoundAndLanguageAndMylocation(boolean found, String language, String mylocation, Pageable pageable);
	 Page<Book> findByFoundAndMylocation(boolean found, String mylocation, Pageable pageable);
	 Page<Book> findByLanguageAndMylocation(String language, String mylocation, Pageable pageable);
	 Page<Book> findByMylocation(String mylocation, Pageable pageable);
	 Page<Book> findByFoundAndLanguageAndMylocationAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
			    boolean found, String language, String mylocation, String title, String authors, Pageable pageable);

			Page<Book> findByFoundAndLanguageAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
			    boolean found, String language, String title, String authors, Pageable pageable);

			Page<Book> findByFoundAndMylocationAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
			    boolean found, String mylocation, String title, String authors, Pageable pageable);

			Page<Book> findByFoundAndTitleContainingIgnoreCaseAndAuthorsContainingIgnoreCase(
			    boolean found, String title, String authors, Pageable pageable);

			Page<Book> findByFoundAndTitleContainingIgnoreCase(boolean found, String title, Pageable pageable);

			Page<Book> findByFoundAndAuthorsContainingIgnoreCase(boolean found, String authors, Pageable pageable);

			List<Book> findByIsbnIn(List<String> isbns);

}
