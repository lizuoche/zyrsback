package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.CustomerMeasureDataZoon;
import com.cn.zyrs.mapper.CustomerMeasureDataZoonMapper;
import com.cn.zyrs.service.ICustomerMeasureDataZoon;

@Service("customerMeasureDataZoonService")
public class CustomerMeasureDataZoonServiceImpl implements
		ICustomerMeasureDataZoon {
	
	@Resource(name="customerMeasureDataZoonMapper")
	private CustomerMeasureDataZoonMapper customerMeasureDataZoonMapper;
	
	public List<CustomerMeasureDataZoon> getCustomerMeasureDataZoon(
			String customerid, String style) {
		return this.customerMeasureDataZoonMapper.selectBySelective(customerid, style);
	}

	@Transactional
	public int addCustomerMeasureDataZoon(
			CustomerMeasureDataZoon customermeasuredatazoon) {
		return this.customerMeasureDataZoonMapper.insertSelective(customermeasuredatazoon);
	}
	
	@Transactional
	public int updateCustomerMeasureDataZoon(
			CustomerMeasureDataZoon customermeasuredatazoon) {
		return this.customerMeasureDataZoonMapper.updateByPrimaryKeySelective(customermeasuredatazoon);
	}

}
