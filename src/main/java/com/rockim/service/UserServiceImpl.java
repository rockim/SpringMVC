package com.rockim.service;

import com.rockim.dao.UserDao;
import com.rockim.model.Login;
import com.rockim.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{
    @Autowired
    public UserDao userDao;

    public int register(User user){
        return userDao.register(user);
    }

    public User validateUser(Login login){
        return userDao.validateUser(login);
    }
}
