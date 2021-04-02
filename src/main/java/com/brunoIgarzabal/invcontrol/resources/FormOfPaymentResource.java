package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.formsOfPayment.FormOfPayment;
import com.brunoIgarzabal.invcontrol.domain.formsOfPayment.dto.CreateFormOfPaymentDTO;
import com.brunoIgarzabal.invcontrol.domain.formsOfPayment.dto.FormOfPaymentDTO;
import com.brunoIgarzabal.invcontrol.services.FormOfPaymentService;
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
@RequestMapping(value = "api/formsOfPayments")
@Api( tags = "Forms of payment")
public class FormOfPaymentResource extends BaseResource<FormOfPayment> {

    @Autowired
    private FormOfPaymentService service;

    @PostMapping
    @CacheEvict(value = "findPagePayments", allEntries = true)
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateFormOfPaymentDTO formOfPaymentDTO) {
        FormOfPayment formOfPayment = new FormOfPayment(
                null, formOfPaymentDTO.getName(), formOfPaymentDTO.getCanParcel());

        formOfPayment = service.insert(formOfPayment);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(formOfPayment.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    @CacheEvict(value = "findPagePayments", allEntries = true)
    public ResponseEntity<Void> update(@Valid @RequestBody FormOfPaymentDTO formOfPaymentDTO, @PathVariable Long id) {
        FormOfPayment formOfPayment = new FormOfPayment(
                formOfPaymentDTO.getId(), formOfPaymentDTO.getName(), formOfPaymentDTO.getCanParcel());

        formOfPayment.setId(id);

        formOfPayment = service.update(formOfPayment, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/page")
    @Cacheable(value = "findPagePayments")
    public ResponseEntity<Page<FormOfPaymentDTO>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        Page<FormOfPayment> list = service.findPage(page, linesPerPage, orderBy, direction);

        Page<FormOfPaymentDTO> listDto = list.map(FormOfPaymentDTO::new);

        return ResponseEntity.ok().body(listDto);
    }

    @CacheEvict(value = "findPagePayments", allEntries = true)
    @Override
    public ResponseEntity<Void> delete(Long id) {
        return super.delete(id);
    }
}
