package com.project.restapi.model.services.interfaces;

import com.project.restapi.model.entities.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(Long id);

    public Category save(Category obj);

    public void delete(Long id);

    public Category update(Long id, Category obj);
}
