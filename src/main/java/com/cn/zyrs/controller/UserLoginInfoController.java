package com.cn.zyrs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.UserLoginInfo;
import com.cn.zyrs.service.IUserLoginInfo;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/loginInfo")
public class UserLoginInfoController {
	
	@Resource(name="loginInfoService")
	private IUserLoginInfo loginInfoService;
	
	/**
	 * 
	 * 业  务: 记录当前登录信息 <br>
	 * 英文名: showUserLoginInfo 
	 * 功能号: TODO
	 * 时  间: 2016年8月9日 上午9:22:53
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
	@RequestMapping("/showLoginInfo")
	public UserLoginInfo showUserLoginInfo(HttpServletRequest request,
			HttpServletResponse response) {
		String userid = ParamsUtil.initFilter(request.getParameter("userid"),
				null);
		UserLoginInfo loginInfo = this.loginInfoService.getLoginInfoByPrimaryKey(userid);
		return loginInfo;

	}
	
	/**
	 * 
	 * 业  务: 获取销售代表信息 <br>
	 * 英文名: getServicer 
	 * 功能号: TODO
	 * 时  间: 2016年8月9日 下午3:18:22
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
	@RequestMapping("/showSellers")
	public List<String> getSeller(HttpServletRequest request,
			HttpServletResponse response){
		String odpID= ((UserLoginInfo)request.getSession().getAttribute("loginUser")).getOwnerdepartid();
		List<String> sellers =this.loginInfoService.getUserNameByOwnerdepartID(odpID);
		return sellers;
		
	}

}
