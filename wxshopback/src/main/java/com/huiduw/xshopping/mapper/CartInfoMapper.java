package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.CartInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CartInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CartInfo row);

    int insertSelective(CartInfo row);

    CartInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CartInfo row);

    int updateByPrimaryKey(CartInfo row);
}