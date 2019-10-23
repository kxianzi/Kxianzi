package com.turing.sb.service.impl;

import com.turing.sb.entity.User;
import com.turing.sb.entity.UserExample;
import com.turing.sb.mapper.UserMapper;
import com.turing.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
//    @Resource
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        UserExample example = new UserExample();
        example.createCriteria()
                .andUserNameEqualTo(user.getUserName())
                .andPassWordEqualTo(user.getPassWord());
        List<User> list = userMapper.selectByExample(example);
        if(list != null && list.size()==1){
            return list.get(0);
        }else{
            return null;
        }
    }
}
