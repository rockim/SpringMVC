package com.rockim.service;

import com.rockim.model.Login;
import com.rockim.model.User;

public interface UserService {
    int register(User user);

    User validateUser(Login login);
}
