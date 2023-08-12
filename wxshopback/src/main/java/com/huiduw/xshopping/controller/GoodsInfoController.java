package com.huiduw.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.common.Result;
import com.huiduw.xshopping.model.GoodsInfo;
import com.huiduw.xshopping.service.GoodsInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/12 18:59
 * 商品增删改查控制器
 */
@RestController
@RequestMapping(value = "/goodsInfo")
public class GoodsInfoController {

    @Resource
    private GoodsInfoService goodsServiceInfo;

    /**
     * 分页查询商品列表
     * @param pageNum
     * @param pageSize
     * @param name
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<GoodsInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @PathVariable String name){
        return Result.success(goodsServiceInfo.findPage(pageNum,pageSize,name));
    }

    /**
     * 新增商品
     */
    @PostMapping
    public Result<GoodsInfo> add(@RequestBody GoodsInfo goodsInfo){
        goodsServiceInfo.add(goodsInfo);
        return Result.success(goodsInfo);
    }

    /**
     * 更新商品
     */
    @PutMapping
    public Result update(@RequestBody GoodsInfo goodsInfo){
        goodsServiceInfo.update(goodsInfo);
        return Result.success();
    }

    /**
     * 删除商品
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        goodsServiceInfo.delete(id);
        return Result.success();
    }

    /**
     * 查询商品
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){
        return Result.success(goodsServiceInfo.findById(id));
    }
}
