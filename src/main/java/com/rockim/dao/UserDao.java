package com.rockim.dao;

import com.rockim.model.Login;
import com.rockim.model.User;

public interface UserDao {
    int register(User user);
    User validateUser(Login login);
}
