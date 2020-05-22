package com.rockim.login.dao;

import com.rockim.login.model.Login;
import com.rockim.login.model.User;

public interface UserDao {
    int register(User user);
    User validateUser(Login login);
}
