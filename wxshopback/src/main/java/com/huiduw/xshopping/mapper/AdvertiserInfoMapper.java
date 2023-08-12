package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.AdvertiserInfo;
import com.huiduw.xshopping.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
/**
 * 公告相关的mapper
 */
@Repository
public interface AdvertiserInfoMapper extends Mapper<AdvertiserInfo> {
    /*根据公告标题模糊查询*/
    List<AdvertiserInfo> findByName(@Param("name") String name);

}