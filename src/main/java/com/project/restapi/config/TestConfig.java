package com.project.restapi.config;

import com.project.restapi.model.entities.Category;
import com.project.restapi.model.entities.Product;
import com.project.restapi.model.entities.enums.ProductStatus;
import com.project.restapi.model.repositories.CategoryRepository;
import com.project.restapi.model.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat0 = new Category("Padaria", "panificação em geral");
        Category cat1 = new Category("limpeza", "produtos diversos");
        Category cat2 = new Category("açougue", "carnes variadas");
        Category cat3 = new Category("perfumaria", "embonecamento");

        categoryRepository.saveAll(Arrays.asList(cat0, cat1, cat2, cat3));

        Product prod1 = new Product("Desinfetante", 12.34, ProductStatus.BOUGHT, cat1);
        Product prod2 = new Product("maminha", 12.12, ProductStatus.BOUGHT, cat2);
        Product prod3 = new Product("pão", 13.13, ProductStatus.UNBOUGHT, cat0);
        Product prod4 = new Product("perfume", 11.11, ProductStatus.UNBOUGHT, cat3);

        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
    }
}
