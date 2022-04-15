package com.hpl.blog.service.impl;

import com.hpl.blog.entity.TComment;
import com.hpl.blog.mapper.TCommentMapper;
import com.hpl.blog.service.TCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements TCommentService {

}
