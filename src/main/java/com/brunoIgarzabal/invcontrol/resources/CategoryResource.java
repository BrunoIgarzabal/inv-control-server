package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.categories.Category;
import com.brunoIgarzabal.invcontrol.domain.categories.dto.CategoryDTO;
import com.brunoIgarzabal.invcontrol.domain.categories.dto.CreateCategoryDTO;
import com.brunoIgarzabal.invcontrol.services.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/categories")
@Api( tags = "Categories")
public class CategoryResource extends BaseResource<Category> {

    @Autowired
    private CategoryService service;

    @PostMapping
    @CacheEvict(value = "findPageCategory", allEntries = true)
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateCategoryDTO categoryDTO) {
        Category category = new Category(null, categoryDTO.getName());

        category = service.insert(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @CacheEvict(value = "findPageCategory", allEntries = true)
    public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        Category category = new Category(categoryDTO.getId(), categoryDTO.getName());
        category.setId(id);

        category = service.update(category, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    @Cacheable(value = "findPageCategory")
    public ResponseEntity<Page<CategoryDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction
    ) {
        Page<Category> list = service.findPage(page, linesPerPage, orderBy, direction);

        Page<CategoryDTO> listDto = list.map(CategoryDTO::new);

        return ResponseEntity.ok().body(listDto);
    }

    @Override
    @CacheEvict(value = "findPageCategory", allEntries = true)
    public ResponseEntity<Void> delete(Long id) {
        return super.delete(id);
    }
}
