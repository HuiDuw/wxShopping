package com.huiduw.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.common.Result;
import com.huiduw.xshopping.model.AdvertiserInfo;
import com.huiduw.xshopping.service.AdvertiserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/12 18:59
 * 公告增删改查控制器
 */
@RestController
@RequestMapping(value = "/advertiserInfo")
public class AdvertiserInfoController {

    @Resource
    private AdvertiserInfoService advertiserServiceInfo;

    /**
     * 分页查询公告列表
     * @param pageNum
     * @param pageSize
     * @param name
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdvertiserInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @PathVariable String name){
        return Result.success(advertiserServiceInfo.findPage(pageNum,pageSize,name));
    }

    /**
     * 新增公告
     */
    @PostMapping
    public Result<AdvertiserInfo> add(@RequestBody AdvertiserInfo advertiserInfo){
        advertiserServiceInfo.add(advertiserInfo);
        return Result.success(advertiserInfo);
    }

    /**
     * 更新公告
     */
    @PutMapping
    public Result update(@RequestBody AdvertiserInfo advertiserInfo){
        advertiserServiceInfo.update(advertiserInfo);
        return Result.success();
    }

    /**
     * 删除公告
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        advertiserServiceInfo.delete(id);
        return Result.success();
    }

    /**
     * 查询公告
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){
        return Result.success(advertiserServiceInfo.findById(id));
    }
}
