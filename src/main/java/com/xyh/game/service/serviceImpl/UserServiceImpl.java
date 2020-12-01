package com.xyh.game.service.serviceImpl;

import com.xyh.game.annotation.RCache;
import com.xyh.game.dao.UserDao;
import com.xyh.game.model.User;
import com.xyh.game.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userservice")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    @RCache
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
