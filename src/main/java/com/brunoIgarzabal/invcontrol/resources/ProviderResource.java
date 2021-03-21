package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.CreateProviderDTO;
import com.brunoIgarzabal.invcontrol.services.ProviderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/providers")
@Tag(name = "Providers")
public class ProviderResource {

    @Autowired
    private ProviderService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Provider> find(@PathVariable Long id) {
        Provider provider = service.find(id);
        return ResponseEntity.ok().body(provider);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateProviderDTO providerDTO) {
        Provider provider = new Provider(
            null, providerDTO.getIe(),
            providerDTO.getCnpj(),
            providerDTO.getCompanyName(),
            providerDTO.getFantasyName(),
            providerDTO.getContact().toContact(),
            providerDTO.getAddress().toAddress()
        );

        provider = service.insert(provider);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(provider.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}
