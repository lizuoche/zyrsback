package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.CustomerData;
import com.cn.zyrs.mapper.CustomerDataMapper;
import com.cn.zyrs.service.ICustomerData;

@Service("customerDataService")
public class CustomerDataServiceImpl implements ICustomerData {

	@Resource(name = "customerDataMapper")
	private CustomerDataMapper customerDataMapper;
	
	public List<CustomerData> getCustomerData(String ordercode) {
		return this.customerDataMapper.getCustomerData(ordercode);
	}
	
	public CustomerData getCustomerDataByDetailcode(String detailcode) {
		return this.customerDataMapper.selectByPrimaryKey(detailcode);
	}
	
	public CustomerData getCustomerDataByCustomerid(String customerid) {
		return this.customerDataMapper.selectByCustomerid(customerid);
	}
	
	@Transactional
	public int addCustomerData(CustomerData customerdata) {
		return this.customerDataMapper.insertSelective(customerdata);
	}

}
