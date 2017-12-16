package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.UserLoginInfo;

public interface IUserLoginInfo {
	
	UserLoginInfo getLoginInfoByPrimaryKey(String userid);
	
	UserLoginInfo getUserLoginInfoByUsername(String username);
	
	UserLoginInfo getUserLoginInfoByPassword(String password);
	
	UserLoginInfo getUserLoginInfo(String username,String password);
	
    List<String> getUserNameByOwnerdepartID(String odpID);
    
    /**
     * 
     * 业  务: 门店登录 <br>
     * 英文名: login 
     * 功能号: TODO
     * 时  间: 2017年3月3日 下午5:09:36
     * 应用项目: 中依睿晟新增订单APP后台管理系统
     * 作者: 严昊 <br>
     *
     * 入参：TODO
     * TODO   TODO	TODO
    	TODO	 TODO	TODO	
    	
     * 
     * 出参：JSON
     */
    String login(String dc,String pw);
    
    /**
     * 
     * 业  务: 查询门店登录账号 <br>
     * 英文名: searchDeptCode 
     * 功能号: TODO
     * 时  间: 2017年3月3日 下午5:25:29
     * 应用项目: 中依睿晟新增订单APP后台管理系统
     * 作者: 严昊 <br>
     *
     * 入参：TODO
     * TODO   TODO	TODO
    	TODO	 TODO	TODO	
    	
     * 
     * 出参：JSON
     */
    int searchDeptCode(String dc);
    
    
    /**
     * 
     * 业  务: 记录门店密钥 <br>
     * 英文名: writeKey 
     * 功能号: TODO
     * 时  间: 2017年3月3日 下午5:46:31
     * 应用项目: 中依睿晟新增订单APP后台管理系统
     * 作者: 严昊 <br>
     *
     * 入参：TODO
     * TODO   TODO	TODO
    	TODO	 TODO	TODO	
    	
     * 
     * 出参：JSON
     */
    int writeKey(String key);
}
