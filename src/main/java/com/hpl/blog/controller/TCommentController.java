package com.hpl.blog.controller;


import com.hpl.blog.display.CommentTree;
import com.hpl.blog.entity.TBlog;
import com.hpl.blog.entity.TComment;
import com.hpl.blog.service.TCommentService;
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

@Api(description="评论模块")
@CrossOrigin
@RestController
@RequestMapping("/blog/t-comment")
public class TCommentController {
    @Autowired
    public TCommentService tCommentService;

    @PostMapping("/add")
    @ApiOperation(value = "添加评论，以下基本参数必填：content、email、nickname、blogId。（如果是回复评论需要附加参数：parentCommentId）")
    public ReturnResult add(@RequestBody TComment tComment){

        tCommentService.save(tComment);

        return  ReturnResult.ok().message("添加评论成功！");
    }


    @GetMapping("/{blogId}")
    @ApiOperation(value = "根据博客ID查询该博客下的所有评论信息(以层级列表的形式)")
    public ReturnResult findAllCommentByBlogId(String blogId){
        List<CommentTree> commentTree = tCommentService.findAllCommentByBlogId(blogId);

        return  ReturnResult.ok().data("commentTree", commentTree);
    }
}

