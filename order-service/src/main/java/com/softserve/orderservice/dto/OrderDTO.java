package com.softserve.orderservice.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private long id;
    private long userId;
    private String shippingDestination;
    private Date orderDate;
    private List<GoodsDTO> goods;

}
