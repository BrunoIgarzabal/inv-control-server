package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.categories.Category;
import com.brunoIgarzabal.invcontrol.domain.categories.dto.CategoryDTO;
import com.brunoIgarzabal.invcontrol.domain.categories.dto.CreateCategoryDTO;
import com.brunoIgarzabal.invcontrol.services.CategoryService;
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
@RequestMapping(value = "api/categories")
@Api( tags = "Categories")
public class CategoryResource extends BaseResource<Category> {

    @Autowired
    private CategoryService service;

    @PostMapping
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
    public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Long id) {
        Category category = new Category(categoryDTO.getId(), categoryDTO.getName());
        category.setId(id);

        category = service.update(category, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> list = service.findAll();

        List<CategoryDTO> listDto = list
                .stream()
                .map(obj -> new CategoryDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
