package com.genuinecoder.springserver.controller;


import com.genuinecoder.springserver.model.employee.user.User;
import com.genuinecoder.springserver.model.employee.user.UserDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserDao userDao;

    @GetMapping("/employee/get-all")
    public List<User> getAllEmployees() {
        return userDao.getAllUsers();
    }

    @PostMapping("/employee/save")
    public User save(@RequestBody User user) {
        return userDao.save(user);
    }

}
