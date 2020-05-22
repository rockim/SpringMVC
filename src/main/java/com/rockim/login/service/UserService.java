package com.rockim.login.service;

import com.rockim.login.model.Login;
import com.rockim.login.model.User;

public interface UserService {
    int register(User user);

    User validateUser(Login login);
}
