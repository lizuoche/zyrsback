package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.CustomerData;

public interface ICustomerData {
	
	List<CustomerData> getCustomerData (String ordercode);
	
	CustomerData getCustomerDataByDetailcode (String detailcode);
	
	CustomerData getCustomerDataByCustomerid (String customerid);
	
	int addCustomerData (CustomerData customerdata);
	
}
