package com.brunoIgarzabal.invcontrol.resources;

import com.brunoIgarzabal.invcontrol.domain.orders.Order;
import com.brunoIgarzabal.invcontrol.domain.orders.dto.CreateOrderDTO;
import com.brunoIgarzabal.invcontrol.domain.orders.dto.OrderDTO;
import com.brunoIgarzabal.invcontrol.services.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "api/orders")
@Api( tags = "Orders")
public class OrderResource extends BaseResource<Order> {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CreateOrderDTO orderDTO) {
        Order order = new Order(
                null, orderDTO.getDescription(), orderDTO.getPrice(), orderDTO.getFinished());


        order = service.insert(order);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(order.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody OrderDTO orderDTO, @PathVariable Long id) {
        Order order = new Order(
                orderDTO.getId(), orderDTO.getDescription(), orderDTO.getPrice(), orderDTO.getFinished());
        order.setId(id);

        order = service.update(order, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<Order> list = service.findAll();

        List<OrderDTO> listDto = list
                .stream()
                .map(obj -> new OrderDTO(obj))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }
}
