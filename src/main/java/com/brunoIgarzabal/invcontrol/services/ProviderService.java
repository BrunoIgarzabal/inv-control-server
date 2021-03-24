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

        this.saveEntities(entity);

        return entity;
    }

    @Override
    public Provider update(Provider entity, Long id) {
        this.saveEntities(entity);

        return super.update(entity, id);

    }

    @Override
    protected void updateData(Provider newObj, Provider oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setFantasyName(oldObj.getFantasyName());
        newObj.setIe(oldObj.getIe());
        newObj.setContact(oldObj.getContact());
        newObj.setCnpj(oldObj.getCnpj());
        newObj.setAddress(oldObj.getAddress());
    }

    private void saveEntities(Provider provider) {
        contactRepository.save(provider.getContact());
        addressRepository.save(provider.getAddress());
    }
}
