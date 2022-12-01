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

        Category cat0 = new Category(null, "Padaria", "panificação em geral");
        Category cat1 = new Category(null, "limpeza", "produtos diversos");
        Category cat2 = new Category(null, "açougue", "cares variadas");
        Category cat3 = new Category(null, "perfumaria", "embonecamento");
        Category cat4 = new Category(null, "Alimentos", "pereciveis e não perecíveis");

        categoryRepository.saveAll(Arrays.asList(cat0, cat1, cat2, cat3, cat4));

        Product prod1 = new Product(null, "Desinfetante", 12.34, ProductStatus.BOUGHT);
        Product prod2 = new Product(null, "maminha", 12.12, ProductStatus.BOUGHT);
        Product prod3 = new Product(null, "pão", 13.13, ProductStatus.UNBOUGHT);
        Product prod4 = new Product(null, "perfume", 11.11, ProductStatus.UNBOUGHT);

        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));

        prod1.getCategories().add(cat1);
        prod2.getCategories().add(cat2);
        prod2.getCategories().add(cat4);
        prod3.getCategories().add(cat4);
        prod3.getCategories().add(cat0);
        prod4.getCategories().add(cat3);

        productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4));
    }
}
