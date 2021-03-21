package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.providers.Provider;
import com.brunoIgarzabal.invcontrol.repositories.AddressRepository;
import com.brunoIgarzabal.invcontrol.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProviderService extends BaseService<Provider> {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public Provider insert(Provider entity) {
        super.insert(entity);
        contactRepository.save(entity.getContact());
        addressRepository.save(entity.getAddress());

        return entity;
    }
}
