package com.project.restapi.model.services.interfaces;

import com.project.restapi.model.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();

    public Product findById(Long id);

    public Double getTotal();

    public Product save(Product obj);

    public Void delete(Long id);

    public Product update(Long id, Product obj);
}
