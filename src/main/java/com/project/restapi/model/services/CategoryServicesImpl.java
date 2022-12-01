package com.project.restapi.model.services;

import com.project.restapi.model.entities.Category;
import com.project.restapi.model.repositories.CategoryRepository;
import com.project.restapi.model.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServicesImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
