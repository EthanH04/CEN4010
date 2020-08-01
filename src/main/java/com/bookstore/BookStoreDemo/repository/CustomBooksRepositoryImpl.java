package com.bookstore.BookStoreDemo.repository;


import com.bookstore.BookStoreDemo.model.Books;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
class CustomBooksRepositoryImpl implements CustomBooksRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Books> findOrderedByPriceLimitedTo(int limit) {
        return entityManager.createQuery("SELECT p FROM Books p ORDER BY p.price", Books.class).setMaxResults(limit).getResultList();
    }



}

