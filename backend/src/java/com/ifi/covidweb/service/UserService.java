package com.ifi.covidweb.service;

import com.ifi.covidweb.entity.User;

public interface UserService {
    User findByUsernameAndPassword(String username, String password);
}
