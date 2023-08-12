package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户相关的mapper
 */
@Repository
public interface UserInfoMapper extends Mapper<UserInfo> {
    /*根据用户名查询*/
    List<UserInfo> findByName(@Param("name") String name);

    /*用户唯一性判断*/
    int checkRepeat(@Param("column") String column,@Param("value") String value);
//    int deleteByPrimaryKey(Long id);
//
//    int insert(UserInfo row);
//
//    int insertSelective(UserInfo row);
//
//    UserInfo selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(UserInfo row);
//
//    int updateByPrimaryKey(UserInfo row);
}