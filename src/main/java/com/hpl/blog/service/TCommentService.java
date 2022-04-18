package com.hpl.blog.service;

import com.hpl.blog.display.CommentTree;
import com.hpl.blog.entity.TComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */

public interface TCommentService extends IService<TComment> {

    List<CommentTree> findAllCommentByBlogId(String blogId);
}
