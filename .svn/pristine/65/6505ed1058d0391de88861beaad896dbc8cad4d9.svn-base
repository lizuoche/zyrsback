package com.cn.zyrs.controller;

import java.util.ArrayList;
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
import com.cn.zyrs.domain.CustomerBaseInfo;
import com.cn.zyrs.domain.CustomerMeasureData;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.service.IBomInfo;
import com.cn.zyrs.service.ICustomer;
import com.cn.zyrs.service.ICustomerData;
import com.cn.zyrs.service.ICustomerMeasureData;
import com.cn.zyrs.service.ICustomerMeasureDataZoon;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.ChineseUtils;
import com.cn.zyrs.utils.DynamicDataSource;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static Logger log = Logger.getLogger(CustomerController.class);

	@Resource(name = "customerService")
	private ICustomer customerService;

	@Resource(name = "customerDataService")
	private ICustomerData customerDataService;

	@Resource(name = "customerMeasureDataService")
	private ICustomerMeasureData customerMeasureDataService;

	@Resource(name = "customerMeasureDataZoonService")
	private ICustomerMeasureDataZoon customerMeasureDataZoonService;

	@Resource(name = "bomInfoService")
	private IBomInfo bomInfoService;
		
	@Resource(name = "userService")
	private IUser userService;

	/**
	 * 
	 * 业  务: 新增客户信息 <br>
	 * 英文名: addCustomer 
	 * 功能号: TODO
	 * 时  间: 2016年8月18日 下午5:19:46
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String customername
	 * 	   String tel
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
//	 @ResponseBody
//	 @RequestMapping("/addCustomer")
//	 public ResultJsonBean addCustomer(HttpServletRequest request, HttpServletResponse response) {
//		 ResultJsonBean rjb = null;
//		 
//		 //入参
//		 String customername = request.getParameter("customername");
//		 String tel = request.getParameter("tel");
//		 String height = request.getParameter("height");
//		 String weight = request.getParameter("weight");
//	
//		 //默认入参
//		 Customer customer = new Customer();
//	
//		 //校验参数
//		 if(customername == null || tel == null || height == null || weight == null){
//			 log.error("参数不完整，请检查参数！");
//			 rjb = new ResultJsonBean(false,null,"-1","参数不完整，请检查参数！");
//			 return rjb;
//		 }
//	
//		 UserLoginInfo uli = (UserLoginInfo) request.getSession().getAttribute("loginUser");
//		 if(uli == null){
//			 log.error("尚未登录,请先登录！");
//			 rjb = new ResultJsonBean(false,null,"-1","尚未登录,请先登录！");
//			 return rjb;
//		 }
//	
//		 //校验是否存在客户
//		 customer.setTel(tel);
//		 DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//		 List<CustomerBaseInfo> cbil = this.customerService.getCustomerInfoBase(customer,"1",di);
//		 if (cbil != null && cbil.size() != 0) {
//			 log.error("客户已存在！");
//			 rjb = new ResultJsonBean(false,cbil,"-1","客户已存在！");
//			 return rjb;
//		 }
//	
//		 CustomerVIP vip = new CustomerVIP();
//	
//		 String customerid = UUID.randomUUID().toString();
//		 customer.setCustomerid(customerid);
//		 customer.setCustomername(customername);
//	 	customer.setGender("1");// 默认设性别为1
//	 	customer.setTel(tel);
//	 	customer.setHeight(height);
//	 	customer.setWeight(weight);
//	 	customer.setCustomertype("VIP0");
//	 	customer.setIsvip("0");
//	 	customer.setIsvalid("1");
//	 	customer.setDelflag("0");
//	
//	 	vip.setId(UUID.randomUUID().toString());
//	 	vip.setCashback(BigDecimal.valueOf(0.00));
//	 	vip.setBalance(BigDecimal.valueOf(0.00));
//	 	vip.setType("VIP0");
//	 	vip.setServiceshop(uli.getDepartid());
//	 	vip.setScore(BigDecimal.valueOf(0.00));
//	 	vip.setIsvalid(1);
//	 	vip.setDelflag(0);
//	 	vip.setOwnerdeptid(uli.getOwnerdepartid());
//	 	vip.setCustomerid(customerid);
//	
//	 	int i = 0;
//	 	DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//	 	this.customerService.addCustomer(customer);
//	 	DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//	 	this.customerService.addCustomerVIP(vip);
//	 	i++;
//	
//	 	rjb = new ResultJsonBean(true,i,"1","新增信息成功！");
//	 	return rjb;
//	
//	 }

	/**
	 * 
	 * 业  务: 查询客户信息及其量体信息 <br>
	 * 英文名: showCustomerAndCustomerData 
	 * 功能号: TODO
	 * 时  间: 2016年8月18日 下午5:43:20
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String customername
	 *     String tel
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	// @ResponseBody
	// @RequestMapping("/showCustomerAndCustomerData")
	// public ResultJsonBean showCustomerAndCustomerData(
	// HttpServletRequest request, HttpServletResponse response) {
	// ResultJsonBean jsonBean = null;
	// String tel = ParamsUtil.initFilter(request.getParameter("tel"), "");
	// String style = ParamsUtil.initFilter(request.getParameter("style"),
	// "UPPER");
	// String zoonstyle =
	// ParamsUtil.initFilter(request.getParameter("zoonstyle"), "长袖衬衫");
	//
	// //默认入参
	// Customer customer = new Customer();
	// customer.setTel(tel);
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// String stylecode = this.bomInfoService.getStyleCode(zoonstyle);
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<CustomerBaseInfo> cbil =
	// this.customerService.getCustomerInfoBase(customer,"1");
	// List<CustomerMeasureData> customermeasuredatalist = null;
	// List<CustomerMeasureDataZoon> customermeasuredatazoonlist = null;
	// if (cbil != null && cbil.size() != 0) {
	// String customerid = cbil.get(0).getCustomerid();
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// customermeasuredatalist = this.customerMeasureDataService
	// .getCustomerMeasureData(customerid, style);
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// customermeasuredatazoonlist = this.customerMeasureDataZoonService
	// .getCustomerMeasureDataZoon(customerid, stylecode);
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("customer", cbil);
	// map.put("customermeasuredata", customermeasuredatalist);
	// map.put("customermeasuredatazoon", customermeasuredatazoonlist);
	//
	// jsonBean = new ResultJsonBean(true, map, "1", "查询客户信息成功！");
	//
	// } else {
	//
	// jsonBean = new ResultJsonBean(true, cbil, "-1", "客户不存在！");
	//
	// }
	//
	// return jsonBean;
	// }

	/**
	 * 
	 * 业  务: 查询客户信息 <br>
	 * 英文名: showCustomer 
	 * 功能号: TODO
	 * 时  间: 2017年2月27日 下午3:44:01
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
	@RequestMapping("/showCustomer")
	public ResultJsonBean showCustomer(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String tn = request.getParameter("tn");
		String gender = request.getParameter("gender");
		String page = ParamsUtil.initFilter(request.getParameter("page"), "1");
		String fc = request.getParameter("fc");

		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String ci = request.getParameter("ci");

		// 验证参数
		if (di == null) {
			log.error("[查询客户信息]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户信息]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[查询客户信息]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户信息]===>缺少门店密钥参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		Customer customer = new Customer();
		customer.setTn(tn);
		customer.setGender(gender);

		if (dk.equals(key)) {

			// 查询所有客户基本信息：ID、姓名、联系方式 、照片
			if (ci == null) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<CustomerBaseInfo> cbil = this.customerService
						.getCustomerInfoBase(customer, page, di);
				if (fc != null) {
					List<CustomerBaseInfo> res = new ArrayList<CustomerBaseInfo>();
					// 遍历结果首字母排序
					if (cbil.size() > 0) {
						for (int i = 0; i < cbil.size(); i++) {
							// 获取客户姓名首字母
							String c = ChineseUtils.getHeadChar(cbil.get(i)
									.getCustomername());
							// 匹配首字母
							if (c.equalsIgnoreCase(fc)) {
								// 整理结果集
								res.add(cbil.get(i));
							}
						}
					}
					// 替换返回结果
					cbil = res;
				}
				log.info("[查询门店的所有客户基本信息]===>查询成功！<===");
				rjb = new ResultJsonBean(true, cbil, "1",
						"[查询门店的所有客户基本信息]===>查询成功！<===");
			} else {
				// 查询指定ID的员工信息详情：
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				Customer customer1 = this.customerService
						.getCustomerInfoDetail(ci);
				log.info("[查询门店的指定客户详细信息]===>查询成功！<===");
				rjb = new ResultJsonBean(true, customer1, "1",
						"[查询门店的指定客户详细信息]===>查询成功！<===");
			}
		} else {
			log.error("[查询门店的客户信息]===>密钥不匹配,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询门店的客户信息]===>密钥不匹配,查询失败！<===");
		}
		return rjb;
	}

	/**
	*
	* 业 务: 查询客户量体信息 <br>
	* 英文名: showCustomerMeasureData
	* 功能号: TODO
	* 时 间: 2016年8月24日 下午8:16:13
	* 应用项目: 中依睿晟新增订单APP后台管理系统
	* 作者: 严昊 <br>
	*
	* 入参：TODO
	* TODO TODO TODO
	TODO TODO TODO
	
	*
	* 出参：JSON
	*/
	@ResponseBody
	@RequestMapping("/showCustomerMeasureData")
	public ResultJsonBean showCustomerMeasureData(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String ci = request.getParameter("ci");
		String style = request.getParameter("style");

		// 验证参数
		if (di == null) {
			log.error("[查询客户量体信息]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户量体信息]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[查询客户量体信息]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户量体信息]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (ci == null) {
			log.error("[查询客户量体信息]===>缺少客户ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户量体信息]===>缺少客户ID参数！<===");
			return rjb;
		} else if (style == null) {
			log.error("[查询客户量体信息]===>缺少款式参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户量体信息]===>缺少款式参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[查询客户量体信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询客户量体信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		// 查询客户量体信息
		List<CustomerMeasureData> cmdl = this.customerMeasureDataService
				.getCustomerMeasureData(ci, style);

		// 处理结果集
		if (cmdl.size() == 0) {
			List<CustomerMeasureData> cmdl1 = new ArrayList<CustomerMeasureData>();
			CustomerMeasureData cmd = new CustomerMeasureData();
			if("DOWN".equalsIgnoreCase(style)){
				cmd.setMeasureid("");
				cmd.setCustomerid(ci);
				cmd.setCustonercode("");
				cmd.setEntryday("");
				cmd.setSurveyor("");
				cmd.setStyle(style);
				cmd.setData1("0");
				cmd.setData2("0");
				cmd.setData3("0");
				cmd.setData4("0");
				cmd.setData5("0");
				cmd.setData6("0");
				cmd.setData7("0");
				cmd.setData8("0");
				cmd.setData9("0");
				cmd.setData10("0");
				cmd.setData11("");
				cmd.setData12("");
				cmd.setData13("");
				cmd.setData14("");
				cmd.setData15("");
				cmd.setData16("");
				cmd.setData17("");
				cmd.setData18("");
				cmd.setData19("");
				cmd.setData20("");
				cmd.setData21("");
				cmd.setData22("");
				cmd.setData23("");
				cmd.setData24("");
				cmd.setData25("");
			}else if("UPPER".equalsIgnoreCase(style)){
				cmd.setMeasureid("");
				cmd.setCustomerid(ci);
				cmd.setCustonercode("");
				cmd.setEntryday("");
				cmd.setSurveyor("");
				cmd.setStyle(style);
				cmd.setData1("0");
				cmd.setData2("0");
				cmd.setData3("0");
				cmd.setData4("0");
				cmd.setData5("0");
				cmd.setData6("0");
				cmd.setData7("0");
				cmd.setData8("0");
				cmd.setData9("0");
				cmd.setData10("0");
				cmd.setData11("0");
				cmd.setData12("0");
				cmd.setData13("0");
				cmd.setData14("0");
				cmd.setData15("0");
				cmd.setData16("0");
				cmd.setData17("0");
				cmd.setData18("0");
				cmd.setData19("0");
				cmd.setData20("0");
				cmd.setData21("0");
				cmd.setData22("0");
				cmd.setData23("0");
				cmd.setData24("0");
				cmd.setData25("0");
			}
			log.info("[查询客户量体信息]===>查询成功！<===");
			cmdl1.add(cmd);
			rjb = new ResultJsonBean(true, cmdl1, "1", "[查询客户量体信息]===>查询成功！<===");
			return rjb;
		}else{
			log.info("[查询客户量体信息]===>查询成功！<===");
			rjb = new ResultJsonBean(true, cmdl, "1", "[查询客户量体信息]===>查询成功！<===");
			return rjb;
		}

	}

	/**
	 * 
	 * 业  务: 修改客户量体信息 <br>
	 * 英文名: updateCustomerMeasureData 
	 * 功能号: TODO
	 * 时  间: 2017年3月27日 下午2:03:50
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
	@RequestMapping("/updateCustomerMeasureData")
	public ResultJsonBean updateCustomerMeasureData(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String ci = request.getParameter("ci");
		String style = request.getParameter("style");

		String data1 = request.getParameter("data1");
		String data2 = request.getParameter("data2");
		String data3 = request.getParameter("data3");
		String data4 = request.getParameter("data4");
		String data5 = request.getParameter("data5");
		String data6 = request.getParameter("data6");
		String data7 = request.getParameter("data7");
		String data8 = request.getParameter("data8");
		String data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		String data11 = request.getParameter("data11");
		String data12 = request.getParameter("data12");
		String data13 = request.getParameter("data13");
		String data14 = request.getParameter("data14");
		String data15 = request.getParameter("data15");
		String data16 = request.getParameter("data16");
		String data17 = request.getParameter("data17");
		String data18 = request.getParameter("data18");
		String data19 = request.getParameter("data19");
		String data20 = request.getParameter("data20");
		String data21 = request.getParameter("data21");
		String data22 = request.getParameter("data22");
		String data23 = request.getParameter("data23");
		String data24 = request.getParameter("data25");
		String data25 = request.getParameter("data25");

		// 验证参数
		if (di == null) {
			log.error("[修改客户量体信息]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[修改客户量体信息]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[修改客户量体信息]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[修改客户量体信息]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (ci == null) {
			log.error("[修改客户量体信息]===>缺少客户ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[修改客户量体信息]===>缺少客户ID参数！<===");
			return rjb;
		} else if (style == null) {
			log.error("[修改客户量体信息]===>缺少款式参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[修改客户量体信息]===>缺少款式参数！<===");
			return rjb;
		} else if (data1 == null && data2 == null && data3 == null
				&& data4 == null && data5 == null && data6 == null
				&& data7 == null && data8 == null && data9 == null
				&& data10 == null && data11 == null && data12 == null
				&& data13 == null && data14 == null && data15 == null
				&& data16 == null && data17 == null && data18 == null
				&& data19 == null && data20 == null && data21 == null
				&& data22 == null && data23 == null && data24 == null
				&& data25 == null) {
			log.error("[修改客户量体信息]===>缺少修改数据data参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[修改客户量体信息]===>缺少修改数据data参数！<===");
			return rjb;
		}

		// data
		CustomerMeasureData cmd = new CustomerMeasureData();

		if ("UPPER".equalsIgnoreCase(style)) {
			cmd.setCustomerid(ci);
			cmd.setStyle(style);
			cmd.setData1(data1);
			cmd.setData2(data2);
			cmd.setData3(data3);
			cmd.setData4(data4);
			cmd.setData5(data5);
			cmd.setData6(data6);
			cmd.setData7(data7);
			cmd.setData8(data8);
			cmd.setData9(data9);
			cmd.setData10(data10);
			cmd.setData11(data11);
			cmd.setData12(data12);
			cmd.setData13(data13);
			cmd.setData14(data14);
			cmd.setData15(data15);
			cmd.setData16(data16);
			cmd.setData17(data17);
			cmd.setData18(data18);
			cmd.setData19(data19);
			cmd.setData20(data20);
			cmd.setData21(data21);
			cmd.setData22(data22);
			cmd.setData23(data23);
			cmd.setData24(data24);
			cmd.setData25(data25);
		} else if ("DOWN".equalsIgnoreCase(style)) {
			cmd.setCustomerid(ci);
			cmd.setStyle(style);
			cmd.setData1(data1);
			cmd.setData2(data2);
			cmd.setData3(data3);
			cmd.setData4(data4);
			cmd.setData5(data5);
			cmd.setData6(data6);
			cmd.setData7(data7);
			cmd.setData8(data8);
			cmd.setData9(data9);
			cmd.setData10(data10);
		}
		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[修改客户量体信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",	"[修改客户量体信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		// 修改量体信息
		int res = this.customerMeasureDataService.updateCustomerMeasureData(cmd);

		// 处理结果集
		if (res == 0 ) {
			log.error("[修改客户量体信息]===>量体信息修改失败！<===");
			rjb = new ResultJsonBean(false, null, "-1", "[修改客户量体信息]===>量体信息修改失败！<===");
			return rjb;
		}
		
		log.info("[修改客户量体信息]===>量体信息修改成功！<===");
		rjb = new ResultJsonBean(true, res, "1", "[修改客户量体信息]===>量体信息修改成功！<===");
		return rjb;
	}

}
