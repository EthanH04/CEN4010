package com.bookstore.BookStoreDemo.repository;

import com.bookstore.BookStoreDemo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomBooksRepository {
    


    List<Books> findOrderedByPriceLimitedTo(int limit);
}
