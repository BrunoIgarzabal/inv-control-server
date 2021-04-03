package com.brunoIgarzabal.invcontrol.domain.products.dto;

import com.brunoIgarzabal.invcontrol.domain.brands.dto.BrandDTO;
import com.brunoIgarzabal.invcontrol.domain.categories.dto.CategoryDTO;
import com.brunoIgarzabal.invcontrol.domain.products.ProductComplement;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.ProviderDTO;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.SimpleProviderDTO;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public final class CreateProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Nome do produto é obrigatório")
    @Size(max = 255, message = "Nome do produto é muito grande")
    private String name;

    @NotEmpty(message = "Código do produto é obrigatório")
    @Size(max = 40, message = "Código do produto é muito grande")
    private String productCode;

    private BrandDTO brand;

    private CategoryDTO category;

    private SimpleProviderDTO provider;

    private ProductComplement productComplement;

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
