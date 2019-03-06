package com.zzw.secondhand.controller;

import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.UserService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    JsonRes get(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    JsonRes create(User user, HttpServletRequest request) {
        return userService.add(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    JsonRes update(User user, HttpServletRequest request) {
        return userService.modify(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    JsonRes delete(Integer id) {
        return userService.removeById(id);
    }

}
