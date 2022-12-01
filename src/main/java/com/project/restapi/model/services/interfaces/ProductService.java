package com.project.restapi.model.services.interfaces;

import com.project.restapi.model.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    public List<Product> findAll();

    public Product findById(UUID id);

    public Double getTotal();
}
