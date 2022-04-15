package com.hpl.blog.controller;


import com.hpl.blog.entity.TBlog;
import com.hpl.blog.service.TBlogService;
import com.hpl.blog.utils.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */
@RestController
@RequestMapping("/blog/t-blog")
public class TBlogController {

    @Autowired
    TBlogService tBlogService;

    @GetMapping("/{id}")
    public ReturnResult findById(@PathVariable String id){
        TBlog blog = tBlogService.getById(id);
        return ReturnResult.ok().data("blog", blog);
    }
}

