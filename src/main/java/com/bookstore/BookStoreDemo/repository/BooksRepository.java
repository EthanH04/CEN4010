package com.bookstore.BookStoreDemo.repository;

import com.bookstore.BookStoreDemo.model.Books;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends JpaRepository<Books, Long>, CustomBooksRepository{

    List<Books> findByAuthor(String author);
    List<Books> findByGenre(String genre);
    List<Books> findTop10ByOrderBySoldDesc();

}
