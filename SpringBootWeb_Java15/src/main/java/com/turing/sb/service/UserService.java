package com.turing.sb.service;

import com.turing.sb.entity.User;

public interface UserService {
    /**
     * 登录验证
     * @param user
     * @return User
     */
    public User login(User user);
}
