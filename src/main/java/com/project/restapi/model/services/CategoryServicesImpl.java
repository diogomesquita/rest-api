package com.project.restapi.model.services;

import com.project.restapi.exceptions.DBexceptions;
import com.project.restapi.exceptions.NotFoundExceptions;
import com.project.restapi.model.entities.Category;
import com.project.restapi.model.repositories.CategoryRepository;
import com.project.restapi.model.services.interfaces.CategoryService;
import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryServicesImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
    public Category findById(UUID id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> {
            return new NotFoundExceptions(id);
        });
    }

    public Category save(Category obj) {
        return categoryRepository.save(obj);
    }

    public void delete(UUID id) {
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NotFoundExceptions(id);
        } catch (DataIntegrityViolationException e) {
            throw new DBexceptions(e.getMessage());
        }
    }

    public Category update(UUID id, Category obj) {
        Category data = findById(id);
        BeanUtils.copyProperties(obj, data, "id");
        return categoryRepository.save(data);
    }
}
