package com.zzw.secondhand.interceptor;

import com.alibaba.fastjson.JSON;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.UserService;
import com.zzw.secondhand.util.Functions;
import com.zzw.secondhand.util.JsonRes;
import com.zzw.secondhand.util.TokenInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Value("${GLOBAL.secret}")
    private String secret;

    @Resource
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //获取验证Token头
        String token = request.getHeader("token");
        try {
            TokenInfo info = new TokenInfo()
                    .setToken(token)
                    .setSecret(Functions.getIpAddr(request) + secret);
            User user = Functions.verifyToken(info);
            //TO-DO
            request.setAttribute("session:userId", user.getId());

            return true;
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("Content-Type", "application/json");
            response.getWriter().println(
                    JSON.toJSONString(new JsonRes<>(1, "Invalid"))
            );
            return false;
        }
    }

}
