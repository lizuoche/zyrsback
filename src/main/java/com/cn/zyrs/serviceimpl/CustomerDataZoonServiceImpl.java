package com.cn.zyrs.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.CustomerDataZoon;
import com.cn.zyrs.mapper.CustomerDataZoonMapper;
import com.cn.zyrs.service.ICustomerDataZoon;

@Service("customerDataZoonService")
public class CustomerDataZoonServiceImpl implements ICustomerDataZoon {

	@Resource(name="customerDataZoonMapper")
	private CustomerDataZoonMapper customerDataZoonMapper;
	
	@Transactional
	public int addCustomerDataZoon(CustomerDataZoon customerdatazoon) {
		return this.customerDataZoonMapper.insertSelective(customerdatazoon);
	}

}
