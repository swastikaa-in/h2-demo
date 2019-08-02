package com.example.h2demo.product.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.h2demo.product.data.Product;
import com.example.h2demo.product.repo.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getallProducts() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public Product getProduct(String id) {
        return productRepository.findById(id).orElseGet(Product::new);
    }

    public void addProduct(Product whiskey) {
    	productRepository.save(whiskey);
    }

    public void updateProduct(String id, Product whiskey) {
    	productRepository.save(whiskey);
    }

    public void deleteProduct(String id) {
    	productRepository.deleteById(id);
    }

}