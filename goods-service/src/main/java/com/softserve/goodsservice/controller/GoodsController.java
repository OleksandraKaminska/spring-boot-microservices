package com.softserve.goodsservice.controller;

import com.softserve.goodsservice.model.Goods;
import com.softserve.goodsservice.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @RequestMapping("/listByIds")
    public List<Goods> getGoodsByIds(@ModelAttribute("ids") ArrayList<Long> ids) {
        return goodsService.findByIds(ids);
    }

}
