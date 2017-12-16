package com.cn.zyrs.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.UserLogin;
import com.cn.zyrs.mapper.UserLoginMapper;
import com.cn.zyrs.service.IUserLogin;

@Service("userLoginService")
public class UserLoginServiceImpl implements IUserLogin {
	
	@Resource(name="userLoginMapper")
	private UserLoginMapper userLoginMapper;

	/**
	 * 
	 * 业  务: 登录系统 <br>
	 * 英文名: getUserLoginInfo 
	 * 功能号: TODO
	 * 时  间: 2016年8月8日 下午3:50:41
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：username
	 * 	   password 
	 *   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public UserLogin getUserLoginInfo(String username, String password) {
		return this.userLoginMapper.getUserLoginInfo(username,password);
	}

}
