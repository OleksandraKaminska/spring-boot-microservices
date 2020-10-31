package com.softserve.goodsservice.service;

import com.softserve.goodsservice.model.Goods;
import com.softserve.goodsservice.repository.GoodsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class GoodsServiceTest {

    @Mock
    private GoodsRepository goodsRepository;

    @InjectMocks
    private GoodsService goodsService;

    @Test
    void whenFindById_thenReturnGoods() {
        final Goods goods = new Goods(1,"Laptop Acer Aspire 5 A515-54G-502N", new BigDecimal("600.57"));

        given(goodsRepository.findById(1L)).willReturn(Optional.of(goods));

        final Optional<Goods> expected = Optional.ofNullable(goodsService.findById(1L));

        assertEquals(expected.get(), goods);
    }

    @Test
    void whenFindByIds_thenReturnListGoods() {
        final List<Goods> goods = new ArrayList<>();
        goods.add(new Goods(1,"Laptop Acer Aspire 5 A515-54G-502N", new BigDecimal("600.57")));
        goods.add(new Goods(2,"Samsung Galaxy S10 Plus", new BigDecimal("560")));

        given(goodsRepository.findByIdIn(Arrays.asList(1L, 2L))).willReturn(goods);

        final List<Goods> expected = goodsService.findByIds(Arrays.asList(1L, 2L));

        assertEquals(expected, goods);
    }

}