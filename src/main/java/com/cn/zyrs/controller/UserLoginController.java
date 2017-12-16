package com.cn.zyrs.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.UserLoginInfo;
import com.cn.zyrs.service.IUserLoginInfo;
import com.cn.zyrs.utils.DynamicDataSource;
import com.cn.zyrs.utils.MD5;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/login")
public class UserLoginController {
	
	private static Logger log = Logger.getLogger(UserLoginController.class);

	@Resource(name="loginInfoService")
	private IUserLoginInfo loginInfoService;

	/**
	 * 
	 * 业  务: 登陆用户信息查询 <br>
	 * 英文名: showUser 
	 * 功能号: TODO
	 * 时  间: 2016年8月8日 下午3:38:59
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	
	//旧版本员工登录
	/**
	 * 
	 * 业  务: 登陆用户信息查询 <br>
	 * 英文名: showUser 
	 * 功能号: TODO
	 * 时  间: 2016年8月8日 下午3:38:59
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
	@RequestMapping("/userLogin")
	public ResultJsonBean showUser(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean jsonBean = null;
		String username = ParamsUtil.initFilter(request.getParameter("username"), null);
		String pwd = ParamsUtil.initFilter(request.getParameter("password"), null);
		
		//校验参数
		if(username==null||pwd==null){
			log.error("参数不完整,登录失败！");
			jsonBean= new ResultJsonBean(false,null,"-1","参数不完整,登录失败！");
			return jsonBean;
		}
		String password="";
		try {
			password = MD5.MD5Secret(pwd);
		} catch (NoSuchAlgorithmException e) {
			log.error("密码转换MD5失败！");
			jsonBean= new ResultJsonBean(false,null,"-1","密码转换MD5失败！");
			return jsonBean;
		} catch (UnsupportedEncodingException e) {
			log.error("密码转换MD5失败！");
			jsonBean= new ResultJsonBean(false,null,"-1","密码转换MD5失败！");
			return jsonBean;
		}
		
		
		UserLoginInfo userLoginInfo =null;
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		userLoginInfo= this.loginInfoService.getUserLoginInfo(username,
				password);
		if(userLoginInfo==null){
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			userLoginInfo=this.loginInfoService.getUserLoginInfoByUsername(username);
			if(userLoginInfo==null){
				jsonBean = new ResultJsonBean(false, null, "-1", "用户名不存在！");
			}else{
				jsonBean = new ResultJsonBean(false, null, "-2", "密码错误！");
			}
			
		}else{
			jsonBean = new ResultJsonBean(true, userLoginInfo, "1", "登录成功！");
		}
		request.getSession().setAttribute("loginUser", userLoginInfo);
		return jsonBean;
	}
	
	
	
		/**
		 * 
		 * 业  务: 门店登录 <br>
		 * 英文名: deptLogin 
		 * 功能号: TODO
		 * 时  间: 2017年3月3日 下午7:53:12
		 * 应用项目: 中依睿晟新增订单APP后台管理系统
		 * 作者: 严昊 <br>
		 *
		 * 入参：TODO
		 * TODO   TODO	TODO
			TODO	 TODO	TODO	
			
		 * 
		 * 出参：JSON
		 */
		//新版本门店登录借口
		@ResponseBody
		@RequestMapping("/deptLogin")
		public ResultJsonBean deptLogin(HttpServletRequest request,HttpServletResponse response) {
			ResultJsonBean rjb = null;
			String ssid = request.getSession().getId();
			
			String dc = request.getParameter("dc");
			String pw = request.getParameter("pw");
			
			//校验参数
			if(dc == null || pw == null){
				log.error("[门店登录]===>参数不完整,登录失败！<===");
				rjb = new ResultJsonBean(false,rjb,"-1","[门店登录]===>参数不完整,登录失败！<===");
				return rjb;
			}
			
			//转换密码 MD5加密
			String password="";
			
			try {
				password = MD5.MD5Secret(pw);
			} catch (NoSuchAlgorithmException e) {
				log.error("[门店登录]===>密码转换MD5失败！<===");
				rjb= new ResultJsonBean(false,rjb,"-1","[门店登录]===>密码转换MD5失败！<===");
				return rjb;
			} catch (UnsupportedEncodingException e) {
				log.error("[门店登录]===>密码转换MD5失败！<===");
				rjb= new ResultJsonBean(false,rjb,"-1","[门店登录]===>密码转换MD5失败！<===");
				return rjb;
			}
			
			//验证登录
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			String deptid = this.loginInfoService.login(dc,password);
			
			//验证登录失败原因 
			if(deptid == null){
				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				int res = this.loginInfoService.searchDeptCode(dc);
				if(res == 0){
					rjb = new ResultJsonBean(false, deptid, "-1", "[门店登录]===>用户名不存在！<===");
				}else{
					rjb = new ResultJsonBean(false, deptid, "-1", "[门店登录]===>密码错误！<===");
				}
				
			}else{
				//记录 sessionID 到 US_DeptMentKey 中
				int wr = this.loginInfoService.writeKey(ssid);	
			
				if(wr == 1){
					log.info("门店密钥更新成功！");
					rjb = new ResultJsonBean(true,deptid,"1","门店登录成功！");
				}else{
					log.error("门店密钥更新失败！");
					rjb = new ResultJsonBean(false,deptid,"-1","门店密钥更新失败,登录失败！");
				}
			}
			
			return rjb;
		}
	
}
