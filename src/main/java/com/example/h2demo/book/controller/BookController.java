package com.example.h2demo.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2demo.book.data.Book;
import com.example.h2demo.book.service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookservice;
	

	@GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookservice.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") String id){
        return bookservice.getBook(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        bookservice.addBook(book);
    }

    @PutMapping("/books/{id}")
    public void updateBook(@PathVariable("id") String bookId, @RequestBody Book book) {
        bookservice.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") String bookId) {
        bookservice.deleteBook(bookId);
    }
}