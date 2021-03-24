package com.brunoIgarzabal.invcontrol.services;

import com.brunoIgarzabal.invcontrol.domain.orders.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends BaseService<Order> {

    @Override
    protected void updateData(Order newObj, Order oldObj) {
        newObj.setId(oldObj.getId());
        newObj.setDescription(oldObj.getDescription());
        newObj.setPrice(oldObj.getPrice());
        newObj.setFinished(oldObj.getFinished());
    }
}
