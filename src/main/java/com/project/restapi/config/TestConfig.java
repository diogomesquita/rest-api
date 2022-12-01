package com.project.restapi.config;

import com.project.restapi.model.entities.Category;
import com.project.restapi.model.repositories.CategoryRepository;
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

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "limpeza", "produtos diversos");
        Category cat2 = new Category(null, "açougue", "cares variadas");
        Category cat3 = new Category(null, "perfumaria", "embonecamento");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }
}
