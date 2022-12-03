package com.project.restapi.controllers;

import com.project.restapi.model.entities.Category;
import com.project.restapi.model.entities.dtos.CategoryDto;
import com.project.restapi.model.services.interfaces.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "Category Rest API")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "List all Categories")
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @ApiOperation(value = "Search Category by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    @ApiOperation(value = "New Category")
    @PostMapping
    public ResponseEntity<Category> save(@RequestBody @Valid CategoryDto dto) {
        var obj = new Category();
        BeanUtils.copyProperties(dto, obj);
        obj = categoryService.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @ApiOperation(value = "Delete Category by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "Update Category")
    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id,@RequestBody @Valid Category obj) {
        obj = categoryService.update(id, obj);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
