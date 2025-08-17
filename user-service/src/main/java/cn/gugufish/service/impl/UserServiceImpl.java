package cn.gugufish.service.impl;

import cn.gugufish.entity.User;
import cn.gugufish.mapper.UserMapper;
import cn.gugufish.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(int uid) {
        return mapper.selectById(uid);
    }
}