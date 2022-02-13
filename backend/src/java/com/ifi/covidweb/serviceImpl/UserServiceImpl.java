package com.ifi.covidweb.serviceImpl;

import com.ifi.covidweb.entity.User;
import com.ifi.covidweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifi.covidweb.repos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username,String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }
}
