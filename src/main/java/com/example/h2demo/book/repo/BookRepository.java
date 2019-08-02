package com.example.h2demo.book.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.h2demo.book.data.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}