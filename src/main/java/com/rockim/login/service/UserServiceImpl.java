package com.rockim.login.service;

import com.rockim.login.dao.UserDao;
import com.rockim.login.model.Login;
import com.rockim.login.model.User;
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
