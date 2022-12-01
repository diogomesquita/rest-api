package com.project.restapi.model.services.interfaces;

import com.project.restapi.model.entities.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();
}
