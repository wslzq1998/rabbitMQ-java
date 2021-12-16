package com.lzq.controller;

import com.lzq.dao.UserRoleDao;
import com.lzq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userRoleController {
    @Autowired
    UserRoleDao userRoleDao;

    @GetMapping("/userRole/{username}")
    public User selectUserRoleByUsername(@PathVariable("username") String username){
        return userRoleDao.selectByUserName(username);
    }
}
