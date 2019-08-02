package com.example.h2demo.product.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.h2demo.product.data.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, String> {
}