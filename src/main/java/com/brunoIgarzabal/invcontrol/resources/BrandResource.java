package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import com.brunoIgarzabal.invcontrol.domain.brands.dto.BrandDTO;
import com.brunoIgarzabal.invcontrol.domain.brands.dto.CreateBrandDTO;
import com.brunoIgarzabal.invcontrol.services.BrandService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @CacheEvict(value = "findPageBrands", allEntries = true)
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
    @CacheEvict(value = "findPageBrands", allEntries = true)
    public ResponseEntity<Void> update(@Valid @RequestBody BrandDTO brandDTO, @PathVariable Long id) {
        Brand brand = new Brand(brandDTO.getId(), brandDTO.getName());
        brand.setId(id);

        brand = service.update(brand, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    @Cacheable(value = "findPageBrands")
    public ResponseEntity<Page<BrandDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<Brand> list = service.findPage(page, linesPerPage, orderBy, direction);

        Page<BrandDTO> listDto = list.map(BrandDTO::new);

        return ResponseEntity.ok().body(listDto);
    }

    @Override
    @CacheEvict(value = "findPageBrands", allEntries = true)
    public ResponseEntity<Void> delete(Long id) {
        return super.delete(id);
    }
}
