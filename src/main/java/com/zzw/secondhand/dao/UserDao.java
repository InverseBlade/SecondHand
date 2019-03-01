package com.zzw.secondhand.dao;

import com.zzw.secondhand.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserDao {

    User selectOne(@Param("id") Integer id) throws Exception;

}
