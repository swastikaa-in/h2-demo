package com.example.h2demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.h2demo.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}