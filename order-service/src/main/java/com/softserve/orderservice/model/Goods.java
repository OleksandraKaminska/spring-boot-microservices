package com.softserve.orderservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class Goods {

    private long id;
    private String name;
    private BigDecimal price;

    public Goods() {
    }

    public Goods(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

}
