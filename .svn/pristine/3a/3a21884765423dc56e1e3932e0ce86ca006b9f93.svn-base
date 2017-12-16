package com.cn.zyrs.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.Customer;
import com.cn.zyrs.domain.CustomerBaseInfo;
import com.cn.zyrs.domain.CustomerVIP;

public interface ICustomer {
	
	/**
	 * 
	 * 业  务: 查询所有客户基本信息 <br>
	 * 英文名: getCustomerInfoBase 
	 * 功能号: TODO
	 * 时  间: 2017年3月6日 上午10:45:45
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<CustomerBaseInfo> getCustomerInfoBase(Customer customer,String page,String di);
	
	/**
	 * 
	 * 业  务: 查询指定的客户详细信息 <br>
	 * 英文名: getCustomerInfoDetail 
	 * 功能号: TODO
	 * 时  间: 2017年3月6日 上午11:00:14
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	Customer getCustomerInfoDetail(String ci);
	
	/**
	 * 
	 * 业  务: 新增客户信息 <br>
	 * 英文名: addCustomer 
	 * 功能号: TODO
	 * 时  间: 2016年8月19日 下午3:09:35
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@Transactional
	int addCustomer(Customer customer);
	
	/**
	 * 
	 * 业  务: 新增客户VIP信息 <br>
	 * 英文名: addCustomerVIP 
	 * 功能号: TODO
	 * 时  间: 2017年3月6日 上午11:01:13
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@Transactional
	int addCustomerVIP(CustomerVIP vip);
}
