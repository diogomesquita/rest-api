package com.project.restapi.controllers;

import com.project.restapi.model.entities.Product;
import com.project.restapi.model.services.interfaces.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/total")
    public ResponseEntity<Double> valorTotal(){
        Double obj = productService.getTotal();
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid Product obj) {
        obj = productService.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable UUID id, @RequestBody @Valid Product obj) {
        obj = productService.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
