package com.brunoIgarzabal.invcontrol.domain.categories.dto;

import com.brunoIgarzabal.invcontrol.domain.categories.Category;

import java.io.Serializable;

public final class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    public CategoryDTO() {}

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
