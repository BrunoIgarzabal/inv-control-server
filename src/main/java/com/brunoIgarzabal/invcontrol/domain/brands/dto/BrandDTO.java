package com.brunoIgarzabal.invcontrol.domain.brands.dto;

import com.brunoIgarzabal.invcontrol.domain.brands.Brand;

import java.io.Serializable;

public final class BrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    public BrandDTO() {}

    public BrandDTO(Brand brand) {
        this.id = brand.getId();
        this.name = brand.getName();
    }

    public Brand toBrand() {
        return new Brand(this.id, this.name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
