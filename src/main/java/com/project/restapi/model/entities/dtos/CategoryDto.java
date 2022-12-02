package com.project.restapi.model.entities.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryDto {
    @NotBlank(message = "Required data")
    private String name;
    private String description;

    public CategoryDto() {}

    public CategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
