package com.softserve.goodsservice.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.softserve.goodsservice.model.Goods;
import com.softserve.goodsservice.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@WebMvcTest(controllers = GoodsController.class)
@ActiveProfiles("test")
class GoodsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GoodsService goodsService;

    @Test
    void whenGetGoods_thenReturnGoodsAndStatus200() throws Exception {
        final long goodsId = 1L;
        final Goods goods = new Goods(goodsId,"Laptop Acer Aspire 5 A515-54G-502N", new BigDecimal("600.57"));

        given(goodsService.findById(goodsId)).willReturn(goods);

        mockMvc.perform(get("/goods/{id}", goodsId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(goods.getId()))
                .andExpect(jsonPath("$.name").value(goods.getName()))
                .andExpect(jsonPath("$.price").value(goods.getPrice()));

    }

    @Test
    void whenGetGoodsByIds_thenReturnListGoodsAndStatus200() throws Exception {
        final List<Goods> goods = new ArrayList<>();
        goods.add(new Goods(1,"Laptop Acer Aspire 5 A515-54G-502N", new BigDecimal("600.57")));
        goods.add(new Goods(2,"Samsung Galaxy S10 Plus", new BigDecimal("560")));

        given(goodsService.findByIds(Arrays.asList(1L, 2L))).willReturn(goods);

        mockMvc.perform(get("/goods/list?ids=1,2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(goods.get(0).getId()))
                .andExpect(jsonPath("$.[0].name").value(goods.get(0).getName()))
                .andExpect(jsonPath("$.[1].id").value(goods.get(1).getId()))
                .andExpect(jsonPath("$.[1].name").value(goods.get(1).getName()));

    }

}