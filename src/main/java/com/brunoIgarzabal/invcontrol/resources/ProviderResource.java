package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.contacts.Contact;
import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.CreateProviderDTO;
import com.brunoIgarzabal.invcontrol.domain.providers.dto.ProviderDTO;
import com.brunoIgarzabal.invcontrol.services.ProviderService;
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody ProviderDTO providerDTO, @PathVariable Long id) {
        Provider provider = new Provider(
                providerDTO.getId(), providerDTO.getIe(),
                providerDTO.getCnpj(),
                providerDTO.getCompanyName(),
                providerDTO.getFantasyName(),
                providerDTO.getContact(),
                providerDTO.getAddress()
        );

        provider.setId(id);
        provider = service.update(provider, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ProviderDTO>> findAll() {
        List<Provider> list = service.findAll();

        List<ProviderDTO> listDto = list
                .stream()
                .map(obj -> new ProviderDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
