package com.zzw.secondhand.service;

import com.zzw.secondhand.dto.UserBasicDTO;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.util.JsonRes;

public interface UserService {

    /**
     * 获取用户
     *
     * @param id Id
     * @return JsonRes
     */
    JsonRes<UserBasicDTO> findById(Integer id);

    /**
     * 添加新用户
     *
     * @param user User
     * @return JsonRes
     */
    JsonRes<Integer> add(User user);

    /**
     * 修改用户部分信息
     *
     * @param user User
     * @return JsonRes
     */
    JsonRes modifySelective(User user);

    /**
     * 更新用户
     *
     * @param user User
     * @return JsonRes
     */
    JsonRes modify(User user);

    /**
     * 删除用户
     *
     * @param id Id
     * @return JsonRes
     */
    JsonRes removeById(Integer id);

}
