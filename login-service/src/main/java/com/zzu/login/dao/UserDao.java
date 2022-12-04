package com.zzu.login.dao;

import com.zzu.generalApi.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    User findUserById(Long userId);

    Boolean registerUser(Long userId,String nickname,String password,String salt,String address);
}
