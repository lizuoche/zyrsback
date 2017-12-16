package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.DeptLoginInfo;
import com.cn.zyrs.domain.User;
import com.cn.zyrs.domain.UserBaseInfo;
import com.cn.zyrs.mapper.UserMapper;
import com.cn.zyrs.service.IUser;

@Service("userService")
public class UserServiceImpl implements IUser {
	
	@Resource(name = "userMapper")
	private UserMapper userMapper;
	
	@Override
	public List<UserBaseInfo> getUserInfoBase(String di) {
		return this.userMapper.getUserInfoBase(di);
	}

	@Override
	public String getDeptKey(String di) {
		return this.userMapper.getDeptKey(di);
	}

	@Override
	public DeptLoginInfo getDeptInfo(String di) {
		return this.userMapper.getDeptInfo(di);
	}

	@Override
	public User getUserInfoDetail(String ui) {
		return this.userMapper.getUserInfoDetail(ui);
	}

}
