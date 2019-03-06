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

    /**
     * 获取用户详细信息
     *
     * @param id Id
     * @return JsonRes
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    JsonRes<User> get(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    /**
     * 创建新用户
     *
     * @param user    User
     * @param request Request
     * @return JsonRes
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    JsonRes create(User user, HttpServletRequest request) {
        return userService.add(user);
    }

    /**
     * 修改用户信息
     *
     * @param user    User
     * @param request Request
     * @return JsonRes
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    JsonRes update(User user, HttpServletRequest request) {
        return userService.modify(user);
    }

    /**
     * 删除用户
     *
     * @param id Id
     * @return JsonRes
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    JsonRes delete(Integer id) {
        return userService.removeById(id);
    }

}
