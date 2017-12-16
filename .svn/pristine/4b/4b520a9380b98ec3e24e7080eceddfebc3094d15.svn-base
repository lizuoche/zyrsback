/**  
 * 工程: zyrsback <br>
 * 标题: UserLoginInfoImpl.java <br>
 * 描述: TODO <br>
 * 作者: 严昊 yanhao@rewin.com.cn<br>
 * 时间: 2016年8月9日 上午9:13:17 <br>
 * 版权: Copyright 2016 1000CHI Software Technology Co.,Ltd. <br>
 * All rights reserved.
 *
 */

package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.UserLoginInfo;
import com.cn.zyrs.mapper.UserLoginInfoMapper;
import com.cn.zyrs.service.IUserLoginInfo;

/**
 * 类: UserLoginInfoImpl <br>
 * 描述: TODO <br>
 * 作者: 严昊 yanhao@rewin.com.cn<br>
 * 版本: 1.0<br>
 * 时间: 2016年8月9日 上午9:13:17
 */
@Service("loginInfoService")
public class UserLoginInfoServiceImpl implements IUserLoginInfo {

	@Resource(name = "userLoginInfoMapper")
	private UserLoginInfoMapper userLoginInfoMapper;
	
	public UserLoginInfo getLoginInfoByPrimaryKey(String userid) {
		return this.userLoginInfoMapper.getLoginInfo(userid);
	}
	
	public UserLoginInfo getUserLoginInfo(String username, String password) {
		return this.userLoginInfoMapper.getUserLoginInfo(username,password);
	}
	
	public List<String> getUserNameByOwnerdepartID(String odpid){
		return this.userLoginInfoMapper.getUserName(odpid);
		
	}

	public UserLoginInfo getUserLoginInfoByUsername(String username) {
		return this.userLoginInfoMapper.getUserLoginInfoByUsername(username);
	}

	public UserLoginInfo getUserLoginInfoByPassword(String password) {
		return this.userLoginInfoMapper.getUserLoginInfoByPassword(password);
	}

	@Override
	public String login(String dc, String pw) {
		return this.userLoginInfoMapper.login(dc, pw);
	}

	@Override
	public int searchDeptCode(String dc) {
		return this.userLoginInfoMapper.searchDeptCode(dc);
	}
	
	@Transactional
	@Override
	public int writeKey(String key) {
		return this.userLoginInfoMapper.writeKey(key);
	}

}
