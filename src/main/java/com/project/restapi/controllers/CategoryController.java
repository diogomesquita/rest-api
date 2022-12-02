package com.project.restapi.controllers;

import com.project.restapi.model.entities.Category;
import com.project.restapi.model.entities.dtos.CategoryDto;
import com.project.restapi.model.services.interfaces.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable UUID id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @PostMapping
    public ResponseEntity<Category> save(@RequestBody @Valid CategoryDto dto) {
        var obj = new Category();
        BeanUtils.copyProperties(dto, obj);
        obj = categoryService.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable UUID id,@RequestBody @Valid Category obj) {
        obj = categoryService.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
