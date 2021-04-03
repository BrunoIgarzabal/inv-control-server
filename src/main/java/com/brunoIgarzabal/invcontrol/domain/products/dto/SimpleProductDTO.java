package com.brunoIgarzabal.invcontrol.domain.products.dto;

import com.brunoIgarzabal.invcontrol.domain.brands.dto.BrandDTO;
import com.brunoIgarzabal.invcontrol.domain.categories.dto.CategoryDTO;
import com.brunoIgarzabal.invcontrol.domain.products.Product;
import com.brunoIgarzabal.invcontrol.domain.products.ProductComplement;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.SimpleProviderDTO;

import java.io.Serializable;

public final class SimpleProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private String productCode;

    private BrandDTO brand;

    private CategoryDTO category;

    private SimpleProviderDTO provider;

    private ProductComplement productComplement;

    public SimpleProductDTO() {}

    public SimpleProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.productCode = product.getProductCode();
        this.brand = new BrandDTO(product.getBrand());
        this.category = new CategoryDTO(product.getCategory());
        this.provider = new SimpleProviderDTO(product.getProvider());
        this.productComplement = product.getProductComplement();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductCode() {
        return productCode;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public SimpleProviderDTO getProvider() {
        return provider;
    }

    public ProductComplement getProductComplement() {
        return productComplement;
    }
}
