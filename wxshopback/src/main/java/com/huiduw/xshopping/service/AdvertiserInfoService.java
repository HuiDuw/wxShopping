package com.huiduw.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.mapper.AdvertiserInfoMapper;
import com.huiduw.xshopping.model.AdvertiserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/11 18:18
 * 公告相关的service
 */

@Service
public class AdvertiserInfoService {

    @Resource
    private AdvertiserInfoMapper advertiserInfoMapper;

    /**
     * 分页查询
     */
    public PageInfo<AdvertiserInfo> findPage(Integer pageNum,Integer pageSize,String name){
        PageHelper.startPage(pageNum,pageSize);
        List<AdvertiserInfo> list = advertiserInfoMapper.findByName(name);
        return PageInfo.of(list);
    }

    /**
     * 新增公告
     */
    public AdvertiserInfo add(AdvertiserInfo advertiserInfo){
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoMapper.insertSelective(advertiserInfo);
        return advertiserInfo;
    }

    /**
     * 修改公告信息
     */
    public void update(AdvertiserInfo advertiserInfo){
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoMapper.updateByPrimaryKeySelective(advertiserInfo);
    }

    /**
     * 删除公告信息
     */
    public void delete(Long id){
        advertiserInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id查询公告
     */
    public AdvertiserInfo findById(Long id){
        return advertiserInfoMapper.selectByPrimaryKey(id);
    }
}
