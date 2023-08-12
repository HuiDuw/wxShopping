package com.huiduw.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.mapper.NxSystemFileInfoMapper;
import com.huiduw.xshopping.model.NxSystemFileInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/11 18:18
 * 文件相关的service
 */

@Service
public class NxSystemFileInfoService {

    @Resource
    private NxSystemFileInfoMapper nxSystemFileInfoMapper;

    /**
     * 新增文件
     */
    public NxSystemFileInfo add(NxSystemFileInfo nxSystemFileInfo){
        nxSystemFileInfoMapper.insertSelective(nxSystemFileInfo);
        return nxSystemFileInfo;
    }

    /**
     * 修改文件信息
     */
    public void update(NxSystemFileInfo nxSystemFileInfo){
        nxSystemFileInfoMapper.updateByPrimaryKeySelective(nxSystemFileInfo);
    }

    /**
     * 删除文件信息
     */
    public void delete(Long id){
        nxSystemFileInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取文件
     */
    public NxSystemFileInfo findById(Long id){
        return nxSystemFileInfoMapper.selectByPrimaryKey(id);
    }
}
