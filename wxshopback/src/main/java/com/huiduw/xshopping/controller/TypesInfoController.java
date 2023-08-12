package com.huiduw.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.common.Result;
import com.huiduw.xshopping.model.TypesInfo;
import com.huiduw.xshopping.service.TypesInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/12 18:59
 * 商品类别增删改查控制器
 */
@RestController
@RequestMapping(value = "/typesInfo")
public class TypesInfoController {

    @Resource
    private TypesInfoService typesServiceInfo;

    /**
     * 分页查询商品类别列表
     * @param pageNum
     * @param pageSize
     * @param name
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<TypesInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @PathVariable String name){
        return Result.success(typesServiceInfo.findPage(pageNum,pageSize,name));
    }

    /**
     * 新增商品类别
     */
    @PostMapping
    public Result<TypesInfo> add(@RequestBody TypesInfo typesInfo){
        typesServiceInfo.add(typesInfo);
        return Result.success(typesInfo);
    }

    /**
     * 更新商品类别
     */
    @PutMapping
    public Result update(@RequestBody TypesInfo typesInfo){
        typesServiceInfo.update(typesInfo);
        return Result.success();
    }

    /**
     * 删除商品类别
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        typesServiceInfo.delete(id);
        return Result.success();
    }

    /**
     * 查询商品类别
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){
        return Result.success(typesServiceInfo.findById(id));
    }
}
