package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.TypesInfo;
import com.huiduw.xshopping.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TypesInfoMapper extends Mapper<TypesInfo> {
    /*根据类别名称查询*/
    List<TypesInfo> findByName(@Param("name") String name);
}