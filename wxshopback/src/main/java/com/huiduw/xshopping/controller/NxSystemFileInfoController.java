package com.huiduw.xshopping.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import com.github.pagehelper.PageInfo;
import com.huiduw.xshopping.common.Result;
import com.huiduw.xshopping.exception.CustomException;
import com.huiduw.xshopping.model.NxSystemFileInfo;
import com.huiduw.xshopping.service.NxSystemFileInfoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Author: 灰渡w
 * @Date: 2023/5/12 18:59
 * 文件增删改查控制器
 */
@RestController
@RequestMapping(value = "/files")
public class NxSystemFileInfoController {

    private static final String BASE_PATH = System.getProperty("user.dir")+"/src/main/resources/static/file/";

    @Resource
    private NxSystemFileInfoService nxSystemFileServiceInfo;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public Result<NxSystemFileInfo> upload(MultipartFile file) throws IOException {
        String originalName = file.getOriginalFilename();
        if(originalName == null){
            return Result.error("1001","文件名不能为空");
        }
        if(!(originalName.contains("png") || originalName.contains("jpg") || originalName.contains("jpeg") || originalName.contains("gif"))){
            return Result.error("1002","只能上传图片");
        }
        //文件名时间戳
        //分离扩展名和后缀
        String fileName = FileUtil.mainName(originalName)+System.currentTimeMillis()+"."+FileUtil.extName(originalName);
        //文件上传
        FileUtil.writeBytes(file.getBytes(),BASE_PATH+fileName);
        //保存信息到数据库
        NxSystemFileInfo info = new NxSystemFileInfo();
        info.setOriginname(originalName);
        info.setFilename(fileName);
        NxSystemFileInfo addInfo = nxSystemFileServiceInfo.add(info);
        if(addInfo != null){
            return Result.success(addInfo);
        }
        return Result.success();
    }

    /**
     * 更新文件
     */
    @PutMapping
    public Result update(@RequestBody NxSystemFileInfo nxSystemFileInfo){
        nxSystemFileServiceInfo.update(nxSystemFileInfo);
        return Result.success();
    }

    /**
     * 删除文件
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        nxSystemFileServiceInfo.delete(id);
        return Result.success();
    }

    /**
     * 查询文件
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){
        return Result.success(nxSystemFileServiceInfo.findById(id));
    }

    /**
     * 下载图片 根据id获取地址
     */
    @GetMapping("/download/{id}")
    public void download(@PathVariable String id, HttpServletResponse response) throws IOException {
        if(StrUtil.isBlank(id) || "null".equals(id)){
            throw new CustomException("1001","您未上传文件");
        }
        NxSystemFileInfo nxSystemFileInfo = nxSystemFileServiceInfo.findById(Long.parseLong(id));
        if(nxSystemFileInfo == null){
            throw new CustomException("1001","未找到该文件文件");
        }
        byte[] bytes = FileUtil.readBytes(BASE_PATH+nxSystemFileInfo.getFilename());
        response.reset();
        //设置respone的header
        response.addHeader("Content-Dispostion","attachment;finame=" +
                URLEncoder.encode(nxSystemFileInfo.getOriginname(),"UTF-8"));
        response.addHeader("Content-Length","" + bytes.length);
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream");
        toClient.write(bytes);
        toClient.flush();
        toClient.close();
    }
}
