package com.ifi.covidweb.controller;

import com.ifi.covidweb.common.Output;
import com.ifi.covidweb.entity.User;
import com.ifi.covidweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ResourceBundle;

@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/do-login")
    public Output doLogin(@RequestBody User user) {
        Output out = new Output();
        ResourceBundle r = ResourceBundle.getBundle("Bundle/config_en");
        User userDb = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (userDb == null) {
            out.setResult(2);
            out.setMessage(r.getString("2"));
            return out;
        }
        out.setResult(1);
        out.setMessage(r.getString("1"));
        return out;
    }
}
