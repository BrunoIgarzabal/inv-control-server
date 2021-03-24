package com.brunoIgarzabal.invcontrol.domain.orders.dto;

import com.brunoIgarzabal.invcontrol.domain.orders.Order;

import java.io.Serializable;

public final class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String description;
    private String price;

    private Boolean finished;

    public OrderDTO() {}

    public OrderDTO(Order order) {
        this.id = order.getId();
        this.description = order.getDescription();
        this.price = order.getPrice();
        this.finished = order.getFinished();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public Boolean getFinished() {
        return finished;
    }
}
