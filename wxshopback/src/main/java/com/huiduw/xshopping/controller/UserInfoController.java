package com.huiduw.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.common.Result;
import com.huiduw.xshopping.model.UserInfo;
import com.huiduw.xshopping.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/12 18:59
 * 用户增删改查控制器
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService userInfoService;

    /**
     * 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @param name
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<UserInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @PathVariable String name){
        return Result.success(userInfoService.findPage(pageNum,pageSize,name));
    }

    /**
     * 新增用户
     */
    @PostMapping
    public Result<UserInfo> add(@RequestBody UserInfo userInfo){
        userInfoService.add(userInfo);
        return Result.success(userInfo);
    }

    /**
     * 更新用户
     */
    @PutMapping
    public Result update(@RequestBody UserInfo userInfo){
        userInfoService.update(userInfo);
        return Result.success();
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        userInfoService.delete(id);
        return Result.success();
    }
}
