package com.softserve.goodsservice.controller;

import com.softserve.goodsservice.model.Goods;
import com.softserve.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/{goodsId}")
    public Goods getGoods(@PathVariable("goodsId") Long goodsId) {
        return goodsService.findById(goodsId);
    }

}
