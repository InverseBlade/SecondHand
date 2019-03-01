package com.zzw.secondhand.controller;

import com.zzw.secondhand.dto.JsonRes;
import com.zzw.secondhand.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user/{id}")
    JsonRes get(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

}
