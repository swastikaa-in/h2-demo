package com.example.h2demo.product.data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private String id = "";
    private String title = "";
   


    public Product() {
    }

    public Product(String id, String title) {
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