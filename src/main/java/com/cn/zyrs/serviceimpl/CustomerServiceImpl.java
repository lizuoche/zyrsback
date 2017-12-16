package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.Customer;
import com.cn.zyrs.domain.CustomerBaseInfo;
import com.cn.zyrs.domain.CustomerVIP;
import com.cn.zyrs.mapper.CustomerMapper;
import com.cn.zyrs.service.ICustomer;

@Service("customerService")
public class CustomerServiceImpl implements ICustomer {

	@Resource(name = "customerMapper")
	private CustomerMapper customerMapper;
	
	private static Logger log = Logger.getLogger(CustomerServiceImpl.class);

	public List<CustomerBaseInfo> getCustomerInfoBase(Customer customer,String page,String di) {
		int num = 0;
		if( page != null){
			int index = Integer.valueOf(page)-1;
			if(index < 0){
				log.error("page必须为大于等于1的整数！");
				return null;
			}
			num = 100 * index;
		}
		return this.customerMapper.getCustomerInfoBase(customer,num,di);
	}
	
	@Transactional
	public int addCustomer(Customer customer){
		
		return this.customerMapper.insertSelective(customer);
		
	}
	
	@Transactional
	public int addCustomerVIP(CustomerVIP vip){
		
		return this.customerMapper.insertVIPSelective(vip);
		
	}

	@Override
	public Customer getCustomerInfoDetail(String ci) {
		return this.customerMapper.getCustomerInfoDetail(ci);
	}

}
