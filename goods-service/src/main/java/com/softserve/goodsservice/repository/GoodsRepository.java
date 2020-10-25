package com.softserve.goodsservice.repository;

import com.softserve.goodsservice.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

    public List<Goods> findByIdIn(List<Long> Ids);

}
