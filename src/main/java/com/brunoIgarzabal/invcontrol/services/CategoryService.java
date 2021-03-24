package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.categories.Category;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BaseService<Category> {

    @Override
    protected void updateData(Category newObj, Category oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setName(oldObj.getName());
    }
}
