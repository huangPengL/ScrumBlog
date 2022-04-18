package com.hpl.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hpl.blog.entity.TBlog;
import com.hpl.blog.entity.TType;
import com.hpl.blog.mapper.TTypeMapper;
import com.hpl.blog.service.TTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HPL
 * @since 2022-04-15
 */
@Service
public class TTypeServiceImpl extends ServiceImpl<TTypeMapper, TType> implements TTypeService {

    @Override
    public List<TType> findAll() {
        List<TType> typeList = baseMapper.selectList(null);
        return typeList;
    }


}
