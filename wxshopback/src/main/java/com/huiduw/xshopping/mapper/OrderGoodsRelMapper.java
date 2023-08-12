package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.OrderGoodsRel;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderGoodsRelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderGoodsRel row);

    int insertSelective(OrderGoodsRel row);

    OrderGoodsRel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderGoodsRel row);

    int updateByPrimaryKey(OrderGoodsRel row);
}