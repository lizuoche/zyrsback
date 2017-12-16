package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.CustomerMeasureData;
import com.cn.zyrs.mapper.CustomerMeasureDataMapper;
import com.cn.zyrs.service.ICustomerMeasureData;

@Service("customerMeasureDataService")
public class CustomerMeasureDataServiceImpl implements ICustomerMeasureData {

	@Resource(name="customerMeasureDataMapper")
	private CustomerMeasureDataMapper customerMeasureDataMapper;
	
	
	public List<CustomerMeasureData> getCustomerMeasureData(String customerid,
			String style) {
		return this.customerMeasureDataMapper.getCustomerMeasureData(customerid,style);
	}
	
	@Transactional
	public int addCustomerMeasureData(CustomerMeasureData cmd) {
		return this.customerMeasureDataMapper.addCustomerMeasureData(cmd);
	}
	
	@Transactional
	public int updateCustomerMeasureData(CustomerMeasureData cmd) {
		return this.customerMeasureDataMapper.updateCustomerMeasureData(cmd);
	}

}
