package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.brands.Brand;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends BaseService<Brand> {

    @Override
    protected void updateData(Brand newObj, Brand oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setName(oldObj.getName());
    }
}
