package com.zzw.secondhand.service;

import com.zzw.secondhand.dto.UserLoginDTO;
import com.zzw.secondhand.po.User;
import com.zzw.secondhand.util.JsonRes;

public interface LoginService {

    /**
     * 登录接口
     *
     * @param loginDTO UserLoginDTO
     * @return JsonRes
     */
    JsonRes<String> checkIn(UserLoginDTO loginDTO);

    /**
     * 注册接口
     *
     * @param user User
     * @return JsonRes
     */
    JsonRes register(User user);

    /**
     * 获取图片验证码
     *
     * @return JsonRes
     */
    JsonRes getImageCode();

    /**
     * 用户名查重
     *
     * @param userName String
     * @return JsonRes
     */
    JsonRes checkUserName(String userName);

}
