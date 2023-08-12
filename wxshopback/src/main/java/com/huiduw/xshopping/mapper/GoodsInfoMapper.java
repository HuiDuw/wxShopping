package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.GoodsInfo;
import com.huiduw.xshopping.model.TypesInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品相关的Mapper
 */
@Repository
public interface GoodsInfoMapper extends Mapper<GoodsInfo> {
    /*根据商品名称模糊查询,或者根据id查询一个商品*/
    List<GoodsInfo> findByName(@Param("name") String name,@Param("id") Long id);
}