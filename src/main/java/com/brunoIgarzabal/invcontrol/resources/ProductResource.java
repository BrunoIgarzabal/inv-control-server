package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.products.Product;
import com.brunoIgarzabal.invcontrol.domain.products.dto.CreateProductDTO;
import com.brunoIgarzabal.invcontrol.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "api/products")
@Api( tags = "Products")
public class ProductResource extends BaseResource<Product> {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateProductDTO productDTO) {
        Product product = new Product(
            null, productDTO.getName(), productDTO.getProductCode(),
            productDTO.getBrand().toBrand(),
            productDTO.getCategory().toCategory(),
            productDTO.getProvider().toProvider(),
            productDTO.getProductComplement()
        );

        product = service.insert(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
