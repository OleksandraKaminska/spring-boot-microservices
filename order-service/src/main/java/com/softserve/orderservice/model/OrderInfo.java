package com.softserve.orderservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class OrderInfo {

    private long id;
    private long userId;
    private String shippingDestination;
    private Date orderDate;


}
