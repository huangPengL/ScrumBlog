package com.hpl.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hpl.blog.entity.TBlog;
import com.hpl.blog.entity.TType;
import com.hpl.blog.service.TBlogService;
import com.hpl.blog.service.TTypeService;
import com.hpl.blog.utils.ReturnResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */

@Api(description="分类模块")
@CrossOrigin
@RestController
@RequestMapping("/blog/t-type")
public class TTypeController {
    @Autowired
    TTypeService tTypeService;

    @Autowired
    TBlogService tBlogService;

    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID查询分类")
    public ReturnResult findById(@PathVariable String id){
        TType type = tTypeService.getById(id);
        return ReturnResult.ok().data("type", type);
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有分类,以列表的形式返回")
    public ReturnResult findAll(){
        List<TType> typeList = tTypeService.findAll();
        return ReturnResult.ok().data("typeList", typeList);
    }

    @DeleteMapping("/{typeId}")
    @ApiOperation(value = "根据ID删除分类标签（若该分类下有博客则无法删除）")
    public ReturnResult deleteById(@PathVariable String typeId){
        int countBlog = tBlogService.countByTypeId(typeId);
        if(countBlog <= 0) {
            boolean b = tTypeService.removeById(Long.parseLong(typeId));
            if (b) {
                return ReturnResult.ok().message("删除分类成功！");
            }
        }
        return ReturnResult.error().message("删除分类失败！该分类下有"+countBlog+"篇博客！");

    }

    @PutMapping("/update")
    @ApiOperation(value = "修改分类")
    public ReturnResult update(@RequestBody TType tType){

        tTypeService.updateById(tType);

        return  ReturnResult.ok().message("修改分类成功！");
    }
}

