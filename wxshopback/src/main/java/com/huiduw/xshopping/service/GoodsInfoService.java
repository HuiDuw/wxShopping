package com.huiduw.xshopping.service;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.mapper.GoodsInfoMapper;
import com.huiduw.xshopping.model.GoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/11 18:18
 * 商品详情相关的service
 */

@Service
public class GoodsInfoService {

    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 分页查询
     */
    public PageInfo<GoodsInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findByName(name,null);
        return PageInfo.of(list);
    }

    /**
     * 新增商品
     */
    public GoodsInfo add(GoodsInfo goodsInfo){
        convertFileListToFields(goodsInfo);
        goodsInfoMapper.insertSelective(goodsInfo);
        return goodsInfo;
    }

    /**
     * 修改商品信息
     */
    public void update(GoodsInfo goodsInfo){
        convertFileListToFields(goodsInfo);
        goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
    }

    /**
     * 删除商品信息
     */
    public void delete(Long id){
        goodsInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 将前端传来的文件列表转换成以逗号隔开的id列表
     */
    private void convertFileListToFields(GoodsInfo goodsInfo){
        List<Long> fileList = goodsInfo.getFileList();
        if(!CollectionUtil.isEmpty(fileList)){
            goodsInfo.setFields(fileList.toString());
        }
    }

    /**
     * 根据id获取商品
     */
    public GoodsInfo findById(Long id){
        List<GoodsInfo> list = goodsInfoMapper.findByName(null,id);
        if(list==null || list.size()==0) {
            return null;
        }
        return list.get(0);
    }
}
