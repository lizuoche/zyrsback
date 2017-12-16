package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.BomFabric;
import com.cn.zyrs.domain.Fabric;

public interface IBomInfo {
	
	List<BomFabric> getBomInfo(String bomcode, String type, String ownerdeptid, String Style, String page);
	
	/**
	 * 
	 * 业  务: 根据面料ID查询面料信息 <br>
	 * 英文名: getBomInfoByID 
	 * 功能号: TODO
	 * 时  间: 2017年7月17日 下午2:54:26
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	BomFabric getBomInfoByID(String farbricid, String di);
	
	List<Fabric> getFabricInfo(String bomcode, String type, String ownerdeptid, String Style, String page);
	
	List<String> getStyle();
	
	String getStyleCode(String stylename);
	
	String getSort(String stylecode);

}
