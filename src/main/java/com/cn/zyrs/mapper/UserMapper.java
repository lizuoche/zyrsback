package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.DeptLoginInfo;
import com.cn.zyrs.domain.User;
import com.cn.zyrs.domain.UserBaseInfo;

public interface UserMapper {
	
	List<UserBaseInfo> getUserInfoBase(@Param ("di") String di);
	
	User getUserInfoDetail(@Param ("ui") String ui);
	
	String getDeptKey(@Param ("di") String di);
	
	DeptLoginInfo getDeptInfo(@Param ("di") String di);
}