package com.softserve.goodsservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
public class Goods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal price;

    public Goods() {
    }

    public Goods(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Goods(long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
