package com.cn.zyrs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.Customer;
import com.cn.zyrs.domain.CustomerAddresses;
import com.cn.zyrs.domain.CustomerBaseInfo;
import com.cn.zyrs.domain.DeptAddresses;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.UserLoginInfo;
import com.cn.zyrs.service.ICustomer;
import com.cn.zyrs.service.ICustomerAddress;
import com.cn.zyrs.utils.DynamicDataSource;

@Controller
@RequestMapping("/address")
public class CustomerAddressController {

	Logger log = Logger.getLogger(CustomerAddressController.class);

	@Resource(name = "customerAddressService")
	private ICustomerAddress customerAddressService;

	@Resource(name = "customerService")
	private ICustomer customerService;

	/**
	 * 
	 * 业  务: 查询客户以及门店收货地址 <br>
	 * 英文名: getAddress 
	 * 功能号: TODO
	 * 时  间: 2016年11月8日 下午5:35:48
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/getAddress")
	public ResultJsonBean getAddress(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;
		List<CustomerAddresses> cal = null;
		List<DeptAddresses> dal = null;

		// 入参
		String tel = request.getParameter("tel");
		String deptid = null;
		
		Customer customer = new Customer();
		customer.setTel(tel);

		UserLoginInfo uli = (UserLoginInfo) request.getSession().getAttribute(
				"loginUser");
		// 验证登录
		if (uli == null) {
			log.error("登录失败!");
			rjb = new ResultJsonBean(false, null, "-1", "登录失败！");
			return rjb;
		}
		// 验证入参
		deptid = uli.getDepartid();
		if (tel == null || deptid == null) {
			log.error("参数不完整，请检查参数!");
			rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数!");
			return rjb;

		}
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		List<CustomerBaseInfo> cl = this.customerService.getCustomerInfoBase(customer,"1",deptid);
		
		if(cl == null ||cl.size() == 0){
			log.error("不存在这个客户！");
			rjb = new ResultJsonBean(false,cl,"-1","不存在这个客户！");
			return rjb;
			
		}
		String customerid = cl.get(0).getCustomerid();
		// 客户所有收货地址
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		cal = this.customerAddressService.getCustomerAddress(customerid);
		// 门店收货地址
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
		dal = this.customerAddressService.getDeptAddress(deptid);

		Map<String, List<?>> map = new HashMap<String, List<?>>();
		map.put("customerAddresses", cal);
		map.put("deptAddresses", dal);

		rjb = new ResultJsonBean(true, map, "1", "查询成功！");

		return rjb;

	}

	/**
	 * 
	 * 业  务: 更新客户收货地址，存在则更新 不存在则新增 <br>
	 * 英文名: addCustomerAddress 
	 * 功能号: TODO
	 * 时  间: 2016年11月10日 下午3:59:04
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
//	@ResponseBody
//	@RequestMapping("/updateCustomerAddress")
//	public ResultJsonBean addCustomerAddress(HttpServletRequest request,
//			HttpServletResponse response) {
//		ResultJsonBean rjb = null;
//
//		// 入参
//		
//		String addressid = request.getParameter("addressid");
//		String addressname = request.getParameter("addressname");
//		String customer_tel = request.getParameter("customer_tel");
//		String province = request.getParameter("province");
//		String city = request.getParameter("city");
//		String area = request.getParameter("area");
//		String address = request.getParameter("address");
//		String tel = request.getParameter("tel");
//		String isdefault = request.getParameter("isdefault");
//		String receiver = request.getParameter("receiver");
//		
//		Customer customer = new Customer();
//		customer.setTel(customer_tel);
//		
//		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//		List<CustomerBaseInfo> cl = this.customerService.getCustomerInfoBase(customer,"1");
//		
//		if(cl == null || cl.size() == 0 ){
//			log.error("不存在这个客户！");
//			rjb = new ResultJsonBean(false,cl,"-1","不存在这个客户！");
//			return rjb;
//			
//		}
//		String customerid = cl.get(0).getCustomerid();
//
//		// 校验参数 	addressid=null 则新增，否则更新
//		if(addressid == null){
//			//新增收货地址
//			if (addressname == null || customerid == null || province == null
//					|| city == null || area == null || address == null
//					|| tel == null || isdefault == null || receiver == null) {
//				
//				log.equals("参数不完整，请检查参数！");
//				
//				rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数！");
//				return rjb;
//			}
//			
//			CustomerAddresses ca = new CustomerAddresses();
//			
////		ca.setAddressid(addressid);
//			ca.setAddressname(addressname);
//			ca.setCustomerid(customerid);
//			ca.setProvince(province);
//			ca.setCity(city);
//			ca.setArea(area);
//			ca.setAddress(address);
//			ca.setTel(tel);
//			ca.setReceiver(receiver);
//			ca.setIsdefault(Integer.valueOf(isdefault));
//			ca.setIsvalid(1);
//			ca.setDelflag(0);
//			
//			// 判断是否设为默认地址
//
//			if ("1".equals(isdefault)) {
//				// 重置以前的默认地址
//				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//				int res = this.customerAddressService.resetIsdefault(customerid);
//				if (res == 1) {
//					log.info("重置默认地址状态成功！");
//				} else if (res > 1) {
//					log.error("默认地址数目大于1，重置失败！");
//					rjb = new ResultJsonBean(false, res, "-1", "默认地址数目大于1，重置失败！");
//					return rjb;
//				} else if (res == 0) {
//					log.info("该客户尚未设置过默认地址，无需重置！");
//				}
//				
//			}
//			
//			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//			int result = this.customerAddressService.addCustomerAddress(ca);
//			
//			if (result == 1) {
//				log.info("新增客户收货地址成功！");
//				rjb = new ResultJsonBean(true, result, "1", "新增客户收货地址成功!");
//				return rjb;
//			} else {
//				log.error("新增客户收货地址失败！");
//				rjb = new ResultJsonBean(false, result, "-1", "新增客户收货地址失败！");
//				return rjb;
//			}
//		}else{
//			//更新收货地址
//			// 校验参数
//
//			if (addressid == null || customerid == null || isdefault == null) {
//
//				log.equals("参数不完整，请检查参数！");
//
//				rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数！");
//				return rjb;
//			}
//
//			CustomerAddresses ca = new CustomerAddresses();
//
//			ca.setAddressid(addressid);
//			ca.setAddressname(addressname);
//			ca.setCustomerid(customerid);
//			ca.setProvince(province);
//			ca.setCity(city);
//			ca.setArea(area);
//			ca.setAddress(address);
//			ca.setTel(tel);
//			ca.setReceiver(receiver);
//			ca.setIsdefault(Integer.valueOf(isdefault));
//
//			// 判断是否设为默认地址
//
//			if ("1".equals(isdefault)) {
//				// 重置以前的默认地址
//				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//				int res = this.customerAddressService.resetIsdefault(customerid);
//				if (res == 1) {
//					log.info("重置默认地址状态成功！");
//				} else if (res > 1) {
//					log.error("默认地址数目大于1，重置失败！");
//					rjb = new ResultJsonBean(false, res, "-1", "默认地址数目大于1，重置失败！");
//					return rjb;
//				} else if (res == 0) {
//					log.info("该客户尚未设置过默认地址，无需重置！");
//				}
//				
//			}
//
//			//更新地址信息
//			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//			int res1 = this.customerAddressService.updateCustomerAddress(ca);
//			
//			if(res1==1){
//				log.info("收货地址更新成功！");
//				rjb = new ResultJsonBean(true, res1, "1", "收货地址更新成功！");
//				return rjb;
//			}else{
//				log.error("收货地址更新失败！");
//				rjb = new ResultJsonBean(false, res1, "-1", "收货地址更新失败！");
//				return rjb;
//			}
//
//		}
//
//	}
	
	
//	/**
//	 * 
//	 * 业  务: 更新客户收货地址 <br>
//	 * 英文名: updateCustomerAddress 
//	 * 功能号: TODO
//	 * 时  间: 2016年11月10日 下午4:57:08
//	 * 应用项目: 中依睿晟新增订单APP后台管理系统
//	 * 作者: 严昊 <br>
//	 *
//	 * 入参：TODO
//	 * TODO   TODO	TODO
//		TODO	 TODO	TODO	
//		
//	 * 
//	 * 出参：JSON
//	 */
//	@ResponseBody
//	@RequestMapping("/updateCustomerAddress")
//	public ResultJsonBean updateCustomerAddress(HttpServletRequest request,
//			HttpServletResponse response) {
//		ResultJsonBean rjb = null;
//
//		// 入参
//		String addressid = request.getParameter("addressid");
//		String addressname = request.getParameter("addressname");
//		String customerid = request.getParameter("customerid");
//		String province = request.getParameter("province");
//		String city = request.getParameter("city");
//		String area = request.getParameter("area");
//		String address = request.getParameter("address");
//		String tel = request.getParameter("tel");
//		String isdefault = request.getParameter("isdefault");
//		String receiver = request.getParameter("receiver");
//
//		// 校验参数
//
//		if (addressid == null || customerid == null || isdefault == null) {
//
//			log.equals("参数不完整，请检查参数！");
//
//			rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数！");
//			return rjb;
//		}
//
//		CustomerAddresses ca = new CustomerAddresses();
//
//		ca.setAddressid(addressid);
//		ca.setAddressname(addressname);
//		ca.setCustomerid(customerid);
//		ca.setProvince(province);
//		ca.setCity(city);
//		ca.setArea(area);
//		ca.setAddress(address);
//		ca.setTel(tel);
//		ca.setReceiver(receiver);
//		ca.setIsdefault(Integer.valueOf(isdefault));
//
//		// 判断是否设为默认地址
//
//		if ("1".equals(isdefault)) {
//			// 重置以前的默认地址
//			int res = this.customerAddressService.resetIsdefault(customerid);
//			if (res == 1) {
//				log.info("重置默认地址状态成功！");
//			} else if (res > 1) {
//				log.error("默认地址数目大于1，重置失败！");
//				rjb = new ResultJsonBean(false, res, "-1", "默认地址数目大于1，重置失败！");
//				return rjb;
//			} else if (res == 0) {
//				log.info("该客户尚未设置过默认地址，无需重置！");
//			}
//			
//		}
//
//		//更新地址信息
//		int res1 = this.customerAddressService.updateCustomerAddress(ca);
//		
//		if(res1==1){
//			log.info("收货地址更新成功！");
//			rjb = new ResultJsonBean(true, res1, "1", "收货地址更新成功！");
//			return rjb;
//		}else{
//			log.error("收货地址更新失败！");
//			rjb = new ResultJsonBean(false, res1, "-1", "收货地址更新失败！");
//			return rjb;
//		}
//
//	}
//	
//	
	
	/**
	 * 
	 * 业  务: 删除客户收货地址 <br>
	 * 英文名: deleteCustomerAddress 
	 * 功能号: TODO
	 * 时  间: 2016年11月10日 下午5:04:38
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/deleteCustomerAddress")
	public ResultJsonBean deleteCustomerAddress(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String addressid = request.getParameter("addressid");
//		String addressname = request.getParameter("addressname");
//		String customerid = request.getParameter("customerid");
//		String province = request.getParameter("province");
//		String city = request.getParameter("city");
//		String area = request.getParameter("area");
//		String address = request.getParameter("address");
//		String tel = request.getParameter("tel");
//		String isdefault = request.getParameter("isdefault");
//		String receiver = request.getParameter("receiver");

		// 校验参数

		if (addressid == null) {

			log.equals("参数不完整，请检查参数！");

			rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数！");
			return rjb;
		}

		CustomerAddresses ca = new CustomerAddresses();

		ca.setAddressid(addressid);
//		ca.setAddressname(addressname);
//		ca.setCustomerid(customerid);
//		ca.setProvince(province);
//		ca.setCity(city);
//		ca.setArea(area);
//		ca.setAddress(address);
//		ca.setTel(tel);
//		ca.setReceiver(receiver);
//		ca.setIsdefault(Integer.valueOf(isdefault));
		ca.setDelflag(1);

		//更新地址信息
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		int res1 = this.customerAddressService.updateCustomerAddress(ca);
		
		if(res1==1){
			log.info("收货地址删除成功！");
			rjb = new ResultJsonBean(true, res1, "1", "收货地址删除成功！");
			return rjb;
		}else{
			log.error("收货地址删除失败！");
			rjb = new ResultJsonBean(false, res1, "-1", "收货地址删除失败！");
			return rjb;
		}

	}
	
	

}
