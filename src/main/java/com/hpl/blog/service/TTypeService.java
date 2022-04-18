package com.hpl.blog.service;

import com.hpl.blog.entity.TBlog;
import com.hpl.blog.entity.TType;
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

public interface TTypeService extends IService<TType> {

    List<TType> findAll();
}
