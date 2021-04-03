package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.products.Product;
import com.brunoIgarzabal.invcontrol.domain.products.dto.FormProductDTO;
import com.brunoIgarzabal.invcontrol.domain.products.dto.SimpleProductDTO;
import com.brunoIgarzabal.invcontrol.services.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<Void> insert(@Valid @RequestBody FormProductDTO productDTO) {
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody FormProductDTO productDTO, @PathVariable Long id) {
        Product product = new Product(
                null, productDTO.getName(), productDTO.getProductCode(),
                productDTO.getBrand().toBrand(),
                productDTO.getCategory().toCategory(),
                productDTO.getProvider().toProvider(),
                productDTO.getProductComplement()
        );

        product.setId(id);

        product = service.update(product, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<SimpleProductDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        Page<Product> list = service.findPage(page, linesPerPage, orderBy, direction);

        Page<SimpleProductDTO> listDto = list.map(SimpleProductDTO::new);

        return ResponseEntity.ok().body(listDto);

    }
}
