package com.softserve.orderservice.service;

import com.softserve.orderservice.model.Item;
import com.softserve.orderservice.model.Order;
import com.softserve.orderservice.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void findByIdTest() throws ParseException {
        Order order = new Order();
        order.setId(1L);
        order.setUserId(2L);
        order.setShippingDestination("UK");
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-11"));
        order.setItems(Arrays.asList(new Item(1L, order, 1L), new Item(2L, order, 3L)));

        given(orderRepository.findById(1L)).willReturn(Optional.of(order));

        final Optional<Order> expected = Optional.ofNullable(orderService.findById(1L));

        assertEquals(expected.get(), order);
    }

}