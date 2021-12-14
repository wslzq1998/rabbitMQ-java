package com.lzq.dao;

import com.lzq.model.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Repository
@Mapper
public interface GoodsDao {
    List<Goods> selectGoods();
    int updateGoods(Integer id);
    int insertGoods(Goods goods);
}
