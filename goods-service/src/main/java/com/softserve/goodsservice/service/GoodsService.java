package com.softserve.goodsservice.service;

import com.softserve.goodsservice.model.Goods;
import com.softserve.goodsservice.repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Goods findById(Long id) {
        return goodsRepository.findById(id).get();
    }

    public List<Goods> findByIds(List<Long> Ids) {
        return goodsRepository.findByIdIn(Ids);
    }

}
