package com.project.restapi.controllers;

import com.project.restapi.model.entities.Product;
import com.project.restapi.model.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id) {
        Product obj = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
