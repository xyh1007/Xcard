package com.xyh.game.service;

import com.xyh.game.model.User;

public interface UserService {
    User findByUsername(String username);
}
