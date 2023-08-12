package com.huiduw.xshopping.mapper;

import com.huiduw.xshopping.model.CommentInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentInfo row);

    int insertSelective(CommentInfo row);

    CommentInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentInfo row);

    int updateByPrimaryKeyWithBLOBs(CommentInfo row);

    int updateByPrimaryKey(CommentInfo row);
}