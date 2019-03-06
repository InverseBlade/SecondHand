package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.UserService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public JsonRes<Integer> add(User user) {
        try {
            int uid;
            userDao.insertAndGetId(user);
            uid = user.getId();
            return new JsonRes<Integer>(0, "succeed").setData(uid);
        } catch (Exception e) {
            return new JsonRes<Integer>(1, e.getMessage());
        }
    }

    @Override
    public JsonRes modify(User user) {
        try {
            userDao.updateById(user);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes modifySelective(User user) {
        try {
            userDao.updateSelectiveById(user);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes removeById(Integer id) {
        try {
            userDao.deleteById(id);
            return new JsonRes(0, "succeed");
        } catch (Exception e) {
            return new JsonRes(1, e.getMessage());
        }
    }

    @Override
    public JsonRes<User> findById(Integer id) {
        try {
            User user;
            if ((user = userDao.selectById(id)) != null) {
                user.setPassword(null);
                return new JsonRes<User>(0, "succeed").setData(user);
            } else {
                return new JsonRes<User>(1, "error");
            }
        } catch (Exception e) {
            return new JsonRes<User>(1, e.getMessage());
        }
    }
}
