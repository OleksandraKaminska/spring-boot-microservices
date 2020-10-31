package com.softserve.goodsservice.controller;

import com.softserve.goodsservice.model.Goods;
import com.softserve.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/{id}")
    public Goods getGoods(@PathVariable("id") Long id) {
        return goodsService.findById(id);
    }

    @RequestMapping("/list")
    public List<Goods> getGoodsByIds(@RequestParam List<Long> ids) {
        return goodsService.findByIds(ids);
    }

}
