package com.cn.zyrs.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.CustomerData;
import com.cn.zyrs.service.ICustomerData;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/customerData")
public class CustomerDataController {
	
	@Resource(name = "customerDataService")
	private  ICustomerData customerDataService;
	
	/**
	 * 
	 * 业  务: 根据订单号查询客户量体信息 <br>
	 * 英文名: showCustomerData 
	 * 功能号: TODO
	 * 时  间: 2016年8月16日 上午10:17:16
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String ordercode
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：List<CustomerData>
	 */
	@ResponseBody
	@RequestMapping("/showCustomerData")
	public CustomerData showCustomerData(HttpServletRequest request,
			HttpServletResponse response){
		
		String detailcode = request.getParameter("detailcode");
		
		CustomerData customerData = this.customerDataService.getCustomerDataByDetailcode(detailcode);
		return customerData;
		
	}
}
