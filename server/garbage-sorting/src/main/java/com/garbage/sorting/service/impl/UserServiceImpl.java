package com.garbage.sorting.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.garbage.sorting.domain.User;
import com.garbage.sorting.mapper.UserMapper;
import com.garbage.sorting.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 *
 * @author wanghongjie
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
