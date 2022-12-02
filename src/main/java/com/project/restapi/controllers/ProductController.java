package com.project.restapi.controllers;

import com.project.restapi.exceptions.NotFoundExceptions;
import com.project.restapi.model.entities.Product;
import com.project.restapi.model.entities.dtos.ProductDto;
import com.project.restapi.model.services.interfaces.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Api("Products Rest API")
@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "List all Products")
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @ApiOperation(value = "Search Product by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable UUID id) {
        Product obj = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @ApiOperation(value = "Get Total")
    @GetMapping("/total")
    public ResponseEntity<Double> valorTotal(){
        Double obj = productService.getTotal();
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @ApiOperation(value = "New Product")
    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid ProductDto dto) {
        var obj = new Product();
        BeanUtils.copyProperties(dto, obj);
        obj = productService.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @ApiOperation(value = "Delete by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        try {
            productService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundExceptions(e.getMessage());
        }
    }

    @ApiOperation(value = "Update Product")
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable UUID id, @RequestBody @Valid Product obj) {
        obj = productService.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
