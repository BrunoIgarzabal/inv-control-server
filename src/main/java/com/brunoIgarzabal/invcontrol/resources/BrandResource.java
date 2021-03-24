package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import com.brunoIgarzabal.invcontrol.domain.brands.dto.BrandDTO;
import com.brunoIgarzabal.invcontrol.domain.brands.dto.CreateBrandDTO;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.ProviderDTO;
import com.brunoIgarzabal.invcontrol.services.BrandService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/brands")
@Tag(name = "Brands")
public class BrandResource {

    @Autowired
    private BrandService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Brand> find(@PathVariable Long id) {
        Brand brand = service.find(id);
        return ResponseEntity.ok().body(brand);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateBrandDTO brandDTO) {
        Brand brand = new Brand(null, brandDTO.getName());

        brand = service.insert(brand);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(brand.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody BrandDTO brandDTO, @PathVariable Long id) {
        Brand brand = new Brand(brandDTO.getId(), brandDTO.getName());
        brand.setId(id);

        brand = service.update(brand, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> findAll() {
        List<Brand> list = service.findAll();

        List<BrandDTO> listDto = list
                .stream()
                .map(obj -> new BrandDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
