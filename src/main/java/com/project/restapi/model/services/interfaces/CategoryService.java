package com.project.restapi.model.services.interfaces;

import com.project.restapi.model.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(UUID id);
}
