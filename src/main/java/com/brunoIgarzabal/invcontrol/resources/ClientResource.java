package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.clients.Client;
import com.brunoIgarzabal.invcontrol.domain.clients.dto.ClientDTO;
import com.brunoIgarzabal.invcontrol.domain.clients.dto.CreateClientDTO;
import com.brunoIgarzabal.invcontrol.domain.sellers.Seller;
import com.brunoIgarzabal.invcontrol.domain.sellers.dto.SellerDTO;
import com.brunoIgarzabal.invcontrol.services.ClientService;
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
@RequestMapping(value = "api/clients")
@Tag(name = "Clients")
public class ClientResource extends BaseResource<Client> {

    @Autowired
    private ClientService service;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateClientDTO clientDTO) {
        Client client = new Client(
                null,
                clientDTO.getFullName(),
                clientDTO.getCpfCnpj(),
                clientDTO.getClientType(),
                clientDTO.getContact().toContact(),
                clientDTO.getAddress().toAddress());

        client = service.insert(client);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ClientDTO clientDTO, @PathVariable Long id) {
        Client client = new Client(
                clientDTO.getId(),
                clientDTO.getName(),
                clientDTO.getCpfCnpj(),
                clientDTO.getClientType(),
                clientDTO.getContact(),
                clientDTO.getAddress());

        client.setId(id);
        client = service.update(client, id);
        return ResponseEntity.noContent().build();
    }

}
