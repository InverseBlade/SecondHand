package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.dto.JsonRes;
import com.zzw.secondhand.entity.User;
import com.zzw.secondhand.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public JsonRes getUser(Integer id) {
        try {
            User user;
            if ((user = userDao.selectOne(id)) != null) {
                return new JsonRes(0, "succeed")
                        .setData(user);
            } else {
                return new JsonRes(1, "error");
            }
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }
}
