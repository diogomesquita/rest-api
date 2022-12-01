package com.project.restapi.model.services;

import com.project.restapi.model.entities.Product;
import com.project.restapi.model.repositories.ProductRepository;
import com.project.restapi.model.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(UUID id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }
}
