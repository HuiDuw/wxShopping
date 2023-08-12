package com.huiduw.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.mapper.TypesInfoMapper;
import com.huiduw.xshopping.model.TypesInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/11 18:18
 * 商品类别相关的service
 */

@Service
public class TypesInfoService {

    @Resource
    private TypesInfoMapper typesInfoMapper;

    /**
     * 分页查询
     */
    public PageInfo<TypesInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<TypesInfo> list = typesInfoMapper.findByName(name);
        return PageInfo.of(list);
    }

    /**
     * 新增商品类别
     */
    public TypesInfo add(TypesInfo typesInfo){
        typesInfoMapper.insertSelective(typesInfo);
        return typesInfo;
    }

    /**
     * 修改商品类别信息
     */
    public void update(TypesInfo typesInfo){
        typesInfoMapper.updateByPrimaryKeySelective(typesInfo);
    }

    /**
     * 删除商品类别信息
     */
    public void delete(Long id){
        typesInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取商品类别
     */
    public TypesInfo findById(Long id){
        return typesInfoMapper.selectByPrimaryKey(id);
    }
}
