package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.DeptLoginInfo;
import com.cn.zyrs.domain.User;
import com.cn.zyrs.domain.UserBaseInfo;

public abstract interface IUser {

	/**
	 * 
	 * 业  务: 查询门店员工基本信息 <br>
	 * 英文名: getUserInfoBase
	 * 功能号: TODO
	 * 时  间: 2017年3月4日 上午10:14:25
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<UserBaseInfo> getUserInfoBase(String di);
	
	
	/**
	 * 
	 * 业  务: 查询指定员工的详细信息 <br>
	 * 英文名: getUserInfoDetail 
	 * 功能号: TODO
	 * 时  间: 2017年3月4日 下午3:15:00
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	User getUserInfoDetail(String ui);
	
	/**
	 * 
	 * 业  务: 获取门店密钥 <br>
	 * 英文名: getDeptKey 
	 * 功能号: TODO
	 * 时  间: 2017年3月3日 下午8:01:27
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	String getDeptKey(String di);
	
	/**
	 * 
	 * 业  务: 查询门店信息 <br>
	 * 英文名: getDeptInfo 
	 * 功能号: TODO
	 * 时  间: 2017年3月4日 上午10:17:03
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	DeptLoginInfo getDeptInfo(String di);

}
