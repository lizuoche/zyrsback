package com.cn.zyrs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.DeptLoginInfo;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.User;
import com.cn.zyrs.domain.UserBaseInfo;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.DynamicDataSource;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);
	
	@Resource(name="userService")
	private IUser userService;

	/**
	 * 
	 * 业  务: 查询指定的门店信息 <br>
	 * 英文名: showDpetInfo 
	 * 功能号: TODO
	 * 时  间: 2017年3月4日 上午10:12:16
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
	@RequestMapping("/showDpetInfo")
	public ResultJsonBean showDpetInfo(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;
		
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		
		//验证参数
		if(di == null || key == null){
			log.error("[查询门店信息]===>参数不完整！<===");
			rjb = new ResultJsonBean(false,null,"-1","[查询门店信息]===>参数不完整！<===");
			return rjb;
		}
		
		//验证合法用户
		String dk = this.userService.getDeptKey(di);
		
		if(dk == null || dk.equals("")){
			log.error("[查询门店信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false,null,"-1","[查询门店信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}
		
		if(dk.equals(key)){
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			DeptLoginInfo dli= this.userService.getDeptInfo(di);
			log.info("[查询门店信息]===>查询成功！<===");
			rjb = new ResultJsonBean(true,dli,"1","[查询门店信息]===>查询成功！<===");
		}else{
			log.error("[查询门店信息]===>密钥不匹配,查询失败！<===");
			rjb = new ResultJsonBean(false,null,"-1","[查询门店信息]===>密钥不匹配,查询失败！<===");
		}
		
		return rjb;
		
	}
	
	
	/**
	 * 
	 * 业  务: 查询门店的员工信息 <br>
	 * 英文名: showWorker 
	 * 功能号: TODO
	 * 时  间: 2016年8月24日 上午10:21:35
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
	@RequestMapping("/showWorker")
	public ResultJsonBean showWorker(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;
		
		//入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		String ui  = request.getParameter("ui");
		
		//验证参数
		if(di == null || key == null){
			log.error("[查询门店的员工信息]===>参数不完整！<===");
			rjb = new ResultJsonBean(false,null,"-1","[查询门店的员工信息]===>参数不完整！<===");
			return rjb;
		}
		
		//验证合法用户
		String dk = this.userService.getDeptKey(di);
		
		if(dk == null || dk.equals("")){
			log.error("[查询门店的员工信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false,null,"-1","[查询门店的员工信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}
		
		if(dk.equals(key)){
			
			//查询所有员工基本信息：ID、职位、姓名、联系方式 
			if(ui == null){
				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<UserBaseInfo> uibl= this.userService.getUserInfoBase(di);
				log.info("[查询门店的所有员工基本信息]===>查询成功！<===");
				rjb = new ResultJsonBean(true,uibl,"1","[查询门店的所有员工基本信息]===>查询成功！<===");
			}else{
			//查询指定ID的员工信息详情：
				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				User user= this.userService.getUserInfoDetail(ui);
				log.info("[查询门店的指定员工详细信息]===>查询成功！<===");
				rjb = new ResultJsonBean(true,user,"1","[查询门店的指定员工详细信息]===>查询成功！<===");
			}
		}else{
			log.error("[查询门店的员工信息]===>密钥不匹配,查询失败！<===");
			rjb = new ResultJsonBean(false,null,"-1","[查询门店的员工信息]===>密钥不匹配,查询失败！<===");
		}
		
		return rjb;
		
	}

}
