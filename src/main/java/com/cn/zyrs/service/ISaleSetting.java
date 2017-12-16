package com.cn.zyrs.service;

import com.cn.zyrs.domain.SaleSetting;

public interface ISaleSetting {
	
	SaleSetting getSaleSetting(SaleSetting salesetting); 
	
	String getStyleDiscount(String ssc,String di);
	
}
