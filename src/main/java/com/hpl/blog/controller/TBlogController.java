package com.hpl.blog.controller;


import com.hpl.blog.entity.TBlog;
import com.hpl.blog.service.TBlogService;
import com.hpl.blog.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */

@Api(description="博客模块")
@RestController
@CrossOrigin
@RequestMapping("/blog/t-blog")
public class TBlogController {

    @Autowired
    TBlogService tBlogService;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询博客")
    public ReturnResult findById(@PathVariable String id){
        TBlog blog = tBlogService.getById(id);
        return ReturnResult.ok().data("blog", blog);
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加博客（以下基本参数必填：标题、内容、分类）")
    public ReturnResult add(@RequestBody TBlog tBlog){

        tBlogService.save(tBlog);

        return  ReturnResult.ok().message("添加博客成功！");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据ID删除博客")
    public ReturnResult deleteById(@PathVariable Long id){
        boolean b = tBlogService.removeById(id);
        return  ReturnResult.ok().message("删除博客成功！");
    }

    @PutMapping("/update")
    @ApiOperation(value = "修改博客（以下基本参数必填：标题、内容、分类）")
    public ReturnResult update(@RequestBody TBlog tBlog){

        tBlogService.updateById(tBlog);

        return  ReturnResult.ok().message("修改博客成功！");
    }

    @GetMapping("/findAllByPage/{current}/{limit}")
    @ApiOperation(value = "分页查询所有博客")
    public ReturnResult findAll(
            @ApiParam(name = "current", value = "当前页码", required = true)@PathVariable Long current,
            @ApiParam(name = "limit", value = "每页记录数", required = true)@PathVariable Long limit){

        Map<String, Object> blogItemsMap = tBlogService.findAllByPage(current, limit);
        return  ReturnResult.ok().data("items", blogItemsMap);
    }
}

