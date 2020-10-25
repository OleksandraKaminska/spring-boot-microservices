package com.softserve.orderservice.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_info")
@Getter
@Setter
@ToString
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "shipping_destination")
    private String shippingDestination;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Item> items;

    public Order() {
    }

    public Order(long userId, String shippingDestination, Date orderDate, List<Item> items) {
        this.userId = userId;
        this.shippingDestination = shippingDestination;
        this.orderDate = orderDate;
        this.items = items;
    }

}
