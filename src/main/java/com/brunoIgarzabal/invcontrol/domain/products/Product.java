package com.brunoIgarzabal.invcontrol.domain.products;

import com.brunoIgarzabal.invcontrol.domain.Base;
import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import com.brunoIgarzabal.invcontrol.domain.categories.Category;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_products")
public final class Product extends Base<Product> implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, updatable = false, length = 40)
    private String productCode;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @Embedded
    private ProductComplement productComplement;

    public Product() {}

    public Product(Long id, String name, String productCode, Brand brand, Category category, Provider provider, ProductComplement productComplement) {
        this.id = id;
        this.name = name;
        this.productCode = productCode;
        this.brand = brand;
        this.category = category;
        this.provider = provider;
        this.productComplement = productComplement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public ProductComplement getProductComplement() {
        return productComplement;
    }

    public void setProductComplement(ProductComplement productComplement) {
        this.productComplement = productComplement;
    }
}
