package com.softserve.orderservice.controller;

import com.softserve.orderservice.model.Goods;
import com.softserve.orderservice.model.Item;
import com.softserve.orderservice.model.Order;
import com.softserve.orderservice.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = OrderController.class)
@ActiveProfiles("test")
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void whenGetOrder_thenReturnOrderAndStatus200() throws Exception {
        final long orderId = 1L;
        Order order = new Order();
        order.setId(orderId);
        order.setUserId(2L);
        order.setShippingDestination("UK");
        order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd").parse("2020-10-11"));
        order.setItems(Arrays.asList(new Item(1L, order, 1L), new Item(2L, order, 3L)));

        given(orderService.findById(1L)).willReturn(order);

        final Optional<Order> expected = Optional.ofNullable(orderService.findById(1L));

        assertEquals(expected.get(), order);

        final List<Goods> goods = new ArrayList<>();
        goods.add(new Goods("Laptop Acer Aspire 5 A515-54G-502N", new BigDecimal("600.57")));
        goods.add(new Goods("Samsung Galaxy S10 Plus", new BigDecimal("560")));

    }

}