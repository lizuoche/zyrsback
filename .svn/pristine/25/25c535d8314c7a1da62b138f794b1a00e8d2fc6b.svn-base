package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.UserLoginInfo;

public interface UserLoginInfoMapper {
	int insert(UserLoginInfo record);

	int insertSelective(UserLoginInfo record);
	
	String login(@Param("dc") String dc,@Param("pw") String pw);
	
	int searchDeptCode(@Param("dc") String dc);
	
	int writeKey(@Param("key") String key);

	UserLoginInfo getLoginInfo(@Param("userid") String userid);

	UserLoginInfo getUserLoginInfo(@Param("username") String paramString1,	@Param("password") String paramString2);

	UserLoginInfo getUserLoginInfoByUsername(@Param("username") String username);

	UserLoginInfo getUserLoginInfoByPassword(@Param("password") String password);

	List<String> getUserName(@Param("odpid") String paramString1);

}