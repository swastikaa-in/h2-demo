package com.example.h2demo.book.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private String id = "";
    private String title = "";
   


    public Book() {
    }

    public Book(String id, String title) {
        this.id = id;
        this.title = title;
      
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

  
}