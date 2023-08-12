package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.OrderInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo row);

    int insertSelective(OrderInfo row);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo row);

    int updateByPrimaryKey(OrderInfo row);
}