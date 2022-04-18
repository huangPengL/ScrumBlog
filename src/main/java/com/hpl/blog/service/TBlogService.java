package com.hpl.blog.service;

import com.hpl.blog.entity.TBlog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */

public interface TBlogService extends IService<TBlog> {

    Map<String, Object> findAllByPage(Long current, Long limit);

    Map<String, Object> findAllByTypeID(String typeId, Long current, Long limit);

    int countByTypeId(String typeId);
}
