package com.hpl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hpl.blog.entity.TBlog;
import com.hpl.blog.mapper.TBlogMapper;
import com.hpl.blog.service.TBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */
@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements TBlogService {

    @Override
    public Map<String, Object> findAllByPage(Long current, Long limit) {
        Page<TBlog> page = new Page<>(current, limit);

        IPage<TBlog> tBlogIPage = baseMapper.selectPage(page, null);

        // 封装结果
        Map<String, Object> map = new HashMap<>();
        map.put("total", tBlogIPage.getTotal());
        map.put("blogList", tBlogIPage.getRecords());
        map.put("curSize", tBlogIPage.getRecords().size());

        return map;
    }


    @Override
    public Map<String, Object> findAllByTypeID(String typeId, Long current, Long limit) {
        Page<TBlog> page = new Page<>(current, limit);

        QueryWrapper<TBlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id", typeId);

        IPage<TBlog> tBlogIPage = baseMapper.selectPage(page, queryWrapper);
        // 封装结果
        Map<String, Object> map = new HashMap<>();
        map.put("total", tBlogIPage.getTotal());
        map.put("blogList", tBlogIPage.getRecords());
        map.put("curSize", tBlogIPage.getRecords().size());
        return map;
    }

    @Override
    public int countByTypeId(String typeId) {
        QueryWrapper<TBlog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type_id", typeId);

        Integer count = baseMapper.selectCount(queryWrapper);
        return count;
    }
}
