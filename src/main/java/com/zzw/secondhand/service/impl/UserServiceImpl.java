package com.zzw.secondhand.service.impl;

import com.zzw.secondhand.dao.UserDao;
import com.zzw.secondhand.dto.UserBasicDTO;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.service.UserService;
import com.zzw.secondhand.util.JsonRes;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public JsonRes<Integer> add(User user) {
        try {
            userDao.insertAndGetId(user);
            int uid = user.getId();
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
    public JsonRes<UserBasicDTO> findById(Integer id) {
        try {
            UserBasicDTO userBasicDTO = new UserBasicDTO();
            User user;
            if ((user = userDao.selectById(id)) != null) {
                BeanUtils.copyProperties(user, userBasicDTO);
                return new JsonRes<UserBasicDTO>(0, "succeed")
                        .setData(userBasicDTO);
            } else {
                return new JsonRes<>(1, "error");
            }
        } catch (Exception e) {
            return new JsonRes<>(1, e.getMessage());
        }
    }
}
