package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.sellers.Seller;
import com.brunoIgarzabal.invcontrol.domain.sellers.dto.CreateSellerDTO;
import com.brunoIgarzabal.invcontrol.domain.sellers.dto.SellerDTO;
import com.brunoIgarzabal.invcontrol.services.SellerService;
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
@RequestMapping(value = "api/sellers")
@Api( tags = "Sellers")
public class SellerResource extends BaseResource<Seller> {

    @Autowired
    private SellerService service;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateSellerDTO sellerDTO) {
        Seller seller = new Seller(
            null, sellerDTO.getFullName(),
            sellerDTO.getCpf(),
            sellerDTO.getContact().toContact(),
            sellerDTO.getAddress().toAddress()
        );

        seller = service.insert(seller);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(seller.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody SellerDTO sellerDTO, @PathVariable Long id) {
        Seller seller = new Seller(
                null, sellerDTO.getFullName(),
                sellerDTO.getCpf(),
                sellerDTO.getContact(),
                sellerDTO.getAddress()
        );

        seller.setId(id);
        seller = service.update(seller, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<SellerDTO>> findAll() {
        List<Seller> list = service.findAll();

        List<SellerDTO> listDto = list
                .stream()
                .map(obj -> new SellerDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
