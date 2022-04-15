package com.hpl.blog.service.impl;

import com.hpl.blog.entity.TUser;
import com.hpl.blog.mapper.TUserMapper;
import com.hpl.blog.service.TUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

}
