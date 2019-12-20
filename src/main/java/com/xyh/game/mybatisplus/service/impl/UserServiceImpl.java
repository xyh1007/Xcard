package com.xyh.game.mybatisplus.service.impl;

import com.xyh.game.mybatisplus.entity.User;
import com.xyh.game.mybatisplus.dao.UserMapper;
import com.xyh.game.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xyh
 * @since 2019-12-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
