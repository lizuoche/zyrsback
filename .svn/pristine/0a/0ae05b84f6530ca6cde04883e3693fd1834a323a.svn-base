package com.cn.zyrs.mapper;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.UserLogin;

public interface UserLoginMapper {
    int deleteByPrimaryKey(String userid);

    int insert(UserLogin record);

    int insertSelective(UserLogin record);

    UserLogin selectByPrimaryKey(String userid);

    int updateByPrimaryKeySelective(UserLogin record);

    int updateByPrimaryKey(UserLogin record);
    
    UserLogin getUserLoginInfo(@Param("username") String paramString1, @Param("password") String paramString2);
}