package com.zzw.secondhand.service;

import com.zzw.secondhand.po.User;
import com.zzw.secondhand.util.JsonRes;

public interface UserService {

    JsonRes<User> findById(Integer id);

    JsonRes<Integer> add(User user);

    JsonRes modifySelective(User user);

    JsonRes modify(User user);

    JsonRes removeById(Integer id);
}
