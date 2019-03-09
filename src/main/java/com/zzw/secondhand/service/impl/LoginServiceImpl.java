package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.dto.UserLoginDTO;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.LoginService;
import com.zzw.secondhand.util.Functions;
import com.zzw.secondhand.util.JsonRes;
import com.zzw.secondhand.util.TokenInfo;
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
            String password = Functions.md5(loginDTO.getPassword(), "mawenying");
            if (!password.equals(user.getPassword())) {
                throw new Exception("密码错误");
            }
            Date expire = new Date(System.currentTimeMillis() + expireTime);
            String token = Functions.getToken(
                    new TokenInfo()
                            .setUserName(user.getUserName())
                            .setUid(user.getId())
                            .setExpire(expire)
                            .setSecret(loginDTO.getLoginIP() + secret)
            );
            return new JsonRes<String>(0, "ok").setData(token);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<Integer> register(User user) {
        try {
            int uid;
            user.setPassword(Functions.md5(user.getPassword(), "mawenying"));
            userDao.insertAndGetId(user);
            uid = user.getId();
            return new JsonRes<Integer>(0, "succeed").setData(uid);
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes getImageCode() {
        return null;
    }

    @Override
    public JsonRes checkUserName(String userName) {
        try {
            User user = userDao.selectLoginInfoByUserName(userName);
            if (user == null)
                return new JsonRes(0, "not exist");
            else
                return new JsonRes(1, "exist");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }
}
