package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.dto.UserLoginDTO;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.LoginService;
import com.zzw.secondhand.util.Functions;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${GLOBAL.secret}")
    private String secret;

    @Value("${GLOBAL.expire}")
    private long expireTime;

    @Resource
    UserDao userDao;

    @Override
    public JsonRes<String> checkIn(UserLoginDTO loginDTO) {
        try {
            User user;
            if ((user = userDao.selectLoginInfoByUserName(loginDTO.getUserName())) == null) {
                throw new Exception("用户不存在");
            }
            if (!loginDTO.getPassword().equals(user.getPassword())) {
                throw new Exception("密码错误");
            }
            Date expire = new Date(System.currentTimeMillis() + expireTime);
            String token = Functions.getToken(user, expire, secret);
            return new JsonRes<String>(0, "ok").setData(token);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes register(User user) {
        return null;
    }

    @Override
    public JsonRes getImageCode() {
        return null;
    }

    @Override
    public JsonRes checkUserName(String userName) {
        return null;
    }
}
