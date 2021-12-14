package com.lzq.service;

import com.lzq.model.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> selectGoods();
    int updateGoods(Integer id);
    String secKillGoods(Integer id);
    int insertGoods(Goods goods);
}
