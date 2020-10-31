package com.softserve.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDTO {

    private String name;
    private BigDecimal price;

}
