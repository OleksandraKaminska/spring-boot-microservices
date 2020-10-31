package com.softserve.orderservice.controller;

import com.softserve.orderservice.dto.GoodsDTO;
import com.softserve.orderservice.dto.OrderDTO;
import com.softserve.orderservice.model.Goods;
import com.softserve.orderservice.model.Item;
import com.softserve.orderservice.model.Order;
import com.softserve.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{id}")
    public OrderDTO getOrder(@PathVariable("id") Long id) {
        Order order = orderService.findById(id);
        List<Long> orderGoodsIds = order.getItems().stream().map(Item::getId).collect(Collectors.toList());
        ResponseEntity<List<Goods>> response = restTemplate.exchange("http://goods-service/goods/list?ids=" +
                        orderGoodsIds.stream().map(l -> Long.toString(l)).collect(Collectors.joining(",")),
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {});

        return new OrderDTO(order.getId(), order.getUserId(), order.getShippingDestination(), order.getOrderDate(),
                response.getBody().stream().map(g -> new GoodsDTO(g.getName(), g.getPrice())).collect(Collectors.toList()));

    }

}
