package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import com.brunoIgarzabal.invcontrol.domain.brands.dto.BrandDTO;
import com.brunoIgarzabal.invcontrol.domain.brands.dto.CreateBrandDTO;
import com.brunoIgarzabal.invcontrol.services.BrandService;
import io.swagger.annotations.Api;
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
@Api( tags = "Brands")
public class BrandResource extends BaseResource<Brand> {

    @Autowired
    private BrandService service;

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
