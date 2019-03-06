package com.zzw.secondhand.dao;

import com.zzw.secondhand.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {

    void insertAndGetId(User user) throws Exception;

    void deleteById(@Param("id") Integer id) throws Exception;

    User selectById(@Param("id") Integer id) throws Exception;

    /**
     * Update User
     *
     * @param user User
     * @throws Exception update failed
     */
    void updateById(User user) throws Exception;

    void updateSelectiveById(User user) throws Exception;


}
