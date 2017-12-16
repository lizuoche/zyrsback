package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.CustomerAddresses;
import com.cn.zyrs.domain.DeptAddresses;
import com.cn.zyrs.mapper.CustomerAddressesMapper;
import com.cn.zyrs.service.ICustomerAddress;

@Service("customerAddressService")
public class CustomerAddressImpl implements ICustomerAddress {

	Logger log = Logger.getLogger(CustomerAddressImpl.class);
	
	@Resource(name = "customerAddressesMapper")
	private CustomerAddressesMapper customerAddressesMapper;
	
	
	/**
     * 
     * 业  务: 根据客户ID查询客户所有收货地址 <br>
     * 英文名: selectByCustomerID 
     * 功能号: TODO
     * 时  间: 2016年11月8日 下午3:29:58
     * 应用项目: 中依睿晟新增订单APP后台管理系统
     * 作者: 严昊 <br>
     *
     * 入参：TODO
     * TODO   TODO	TODO
    	TODO	 TODO	TODO	
    	
     * 
     * 出参：JSON
     */
	@Override
	public List<CustomerAddresses> getCustomerAddress(String customerid) {
		return this.customerAddressesMapper.selectByCustomerID(customerid);
	}
	
	
	 /**
     * 
     * 业  务: 根据门店ID查询门店所有收货地址 <br>
     * 英文名: selectByDeptID 
     * 功能号: TODO
     * 时  间: 2016年11月8日 下午6:29:13
     * 应用项目: 中依睿晟新增订单APP后台管理系统
     * 作者: 严昊 <br>
     *
     * 入参：TODO
     * TODO   TODO	TODO
    	TODO	 TODO	TODO	
    	
     * 
     * 出参：JSON
     */
	@Override
	public List<DeptAddresses> getDeptAddress(String deptid) {
		return this.customerAddressesMapper.selectByDeptID(deptid);
	}

	
	  /**
     * 
     * 业  务: 新增客户收货地址 <br>
     * 英文名: addCustomerAddress 
     * 功能号: TODO
     * 时  间: 2016年11月10日 下午2:46:47
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
	@Override
	public int addCustomerAddress(CustomerAddresses customeraddress) {
		return this.customerAddressesMapper.insertSelective(customeraddress);
	}

	
	/**
	 * 
	 * 业  务: 更新客户收货地址信息 <br>
	 * 英文名: updateCustomerAddress 
	 * 功能号: TODO
	 * 时  间: 2016年11月10日 下午4:18:45
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
	@Override
	public int updateCustomerAddress(CustomerAddresses customeraddress) {
		return this.customerAddressesMapper.updateByPrimaryKeySelective(customeraddress);
	}

	
	/**
	 * 
	 * 业  务: 重置默认地址 <br>
	 * 英文名: resetIsdefault 
	 * 功能号: TODO
	 * 时  间: 2016年11月10日 下午4:35:15
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
	@Override
	public int resetIsdefault(String customerid) {
		return this.customerAddressesMapper.resetIsdefault(customerid);
	}

}
