package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.sellers.Seller;
import com.brunoIgarzabal.invcontrol.repositories.AddressRepository;
import com.brunoIgarzabal.invcontrol.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SellerService extends BaseService<Seller> {

    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public Seller insert(Seller entity) {
        super.insert(entity);

        this.saveEntities(entity);

        return entity;
    }

    @Override
    public Seller update(Seller entity, Long id) {
        this.saveEntities(entity);

        return super.update(entity, id);

    }

    @Override
    protected void updateData(Seller newObj, Seller oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setFullName(oldObj.getFullName());
        newObj.setCpf(oldObj.getCpf());
        newObj.setContact(oldObj.getContact());
        newObj.setAddress(oldObj.getAddress());
    }

    private void saveEntities(Seller seller) {
        contactRepository.save(seller.getContact());
        addressRepository.save(seller.getAddress());
    }
}
