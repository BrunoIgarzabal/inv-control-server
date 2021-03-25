package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.clients.Client;
import com.brunoIgarzabal.invcontrol.repositories.AddressRepository;
import com.brunoIgarzabal.invcontrol.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService extends BaseService<Client> {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public Client insert(Client entity) {
        super.insert(entity);

        this.saveEntities(entity);

        return entity;
    }

    @Override
    public Client update(Client entity, Long id) {
        this.saveEntities(entity);
        return super.update(entity, id);
    }

    @Override
    protected void updateData(Client newObj, Client oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setName(oldObj.getName());
        newObj.setCpfCnpj(oldObj.getCpfCnpj());
        newObj.setClientType(oldObj.getClientType());
        newObj.setContact(oldObj.getContact());
        newObj.setAddress(oldObj.getAddress());
    }

    private void saveEntities(Client client) {
        contactRepository.save(client.getContact());
        addressRepository.save(client.getAddress());
    }
}
