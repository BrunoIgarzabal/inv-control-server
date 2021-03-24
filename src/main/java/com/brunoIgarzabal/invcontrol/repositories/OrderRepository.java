package com.brunoIgarzabal.invcontrol.repositories;

import com.brunoIgarzabal.invcontrol.domain.orders.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order> {
}
