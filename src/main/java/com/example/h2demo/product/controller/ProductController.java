package com.example.h2demo.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.h2demo.product.data.Product;
import com.example.h2demo.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	

	@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getallProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") String id){
        return productService.getProduct(id);
    }

    @PostMapping("/products")
    public void addBook(@RequestBody Product product) {
    	productService.addProduct(product);
    }

    @PutMapping("/products/{id}")
    public void updateBook(@PathVariable("id") String productId, @RequestBody Product product) {
    	productService.updateProduct(productId, product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") String bookId) {
    	productService.deleteProduct(bookId);
    }
}