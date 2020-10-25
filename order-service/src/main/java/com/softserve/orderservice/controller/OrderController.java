package com.softserve.orderservice.controller;

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
    public Order getOrder(@PathVariable("id") Long id) {
        Order order = orderService.findById(id);
//        ResponseEntity<List<Goods>> response = restTemplate.exchange("http://goods-service/goods", HttpMethod.GET, null,
//                new ParameterizedTypeReference<>() {
//                },
//                order.getItems().stream().map(Item::getId).collect(Collectors.toList()));
//        System.out.println(response.getBody());
        Goods goods = restTemplate.getForObject("http://goods-service/goods/1", Goods.class);
        System.out.println(goods);
        return null;
    }

}
