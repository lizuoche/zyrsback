package com.cn.zyrs.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.SaleSetting;
import com.cn.zyrs.mapper.SaleSettingMapper;
import com.cn.zyrs.service.ISaleSetting;

@Service("saleSettingService")
public class SaleSettingServiceImpl implements ISaleSetting {
	
	@Resource(name="saleSettingMapper")
	private SaleSettingMapper saleSettingMapper;
	
	public SaleSetting getSaleSetting(SaleSetting salesetting) {
		return this.saleSettingMapper.selectByPrimaryKeySelective(salesetting);
	}

	@Override
	public String getStyleDiscount(String ssc, String di) {
		return this.saleSettingMapper.getStyleDiscount(ssc, di);
	}

}
