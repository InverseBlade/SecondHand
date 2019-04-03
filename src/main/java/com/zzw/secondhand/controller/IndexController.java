package com.zzw.secondhand.controller;

import com.zzw.secondhand.dto.UserLoginDTO;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.LoginService;
import com.zzw.secondhand.util.Functions;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/index")
public class IndexController {

    @Resource
    LoginService loginService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public JsonRes index() {
        return JsonRes.createSuccess("(｡･∀･)ﾉﾞ嗨");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonRes<String> login(UserLoginDTO userLoginDTO, HttpServletRequest request) {
        userLoginDTO.setLoginIP(Functions.getIpAddr(request));
        return loginService.checkIn(userLoginDTO);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonRes<Integer> register(User user) {
        return loginService.register(user);
    }

}
