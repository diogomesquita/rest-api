package com.project.restapi.model.services;

import com.project.restapi.exceptions.NotFoundExceptions;
import com.project.restapi.model.entities.Product;
import com.project.restapi.model.entities.enums.ProductStatus;
import com.project.restapi.model.repositories.ProductRepository;
import com.project.restapi.model.services.interfaces.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> {
            return new NotFoundExceptions(id);
        });
    }

    public Double getTotal() {
        Double total = 0.0;
        List<Product> prod = findAll();
        for (Product p : prod) {
            if(p.getProductStatus() == ProductStatus.BOUGHT) {
                total += p.getPrice();
            }
        }
        return total;
    }

    public Product save(Product obj) {

        if(productRepository.existsByName(obj.getName())) {
            String message = String.format("Unavailable Name.%nThe product %s is already registered",obj.getName());
            throw new DataIntegrityViolationException(message);
        }
        return productRepository.save(obj);
    }

    public Void delete(Long id) {
        productRepository.deleteById(id);
        return null;
    }

    public Product update(Long id, Product obj){
            Product data = findById(id);
            BeanUtils.copyProperties(obj, data, "id");
            return productRepository.save(data);
    }
}
