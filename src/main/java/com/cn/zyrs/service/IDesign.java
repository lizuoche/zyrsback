package com.cn.zyrs.service;

import java.util.List;

import com.cn.zyrs.domain.Design;
import com.cn.zyrs.domain.DesignBase;
import com.cn.zyrs.domain.DesignDetail;

public abstract interface IDesign {

	/**
	 * 
	 * 业  务: 新增西服设计方案 <br>
	 * 英文名: addDseign 
	 * 功能号: TODO
	 * 时  间: 2017年3月7日 下午4:06:34
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addDseignSuit(Design design);
	
	
	/**
	 * 
	 * 业  务: 新增衬衫设计方案 <br>
	 * 英文名: addDseignShirt 
	 * 功能号: TODO
	 * 时  间: 2017年3月7日 下午4:06:34
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addDseignShirt(Design design);
	
	
	/**
	 * 
	 * 业  务: 新增裤子设计方案 <br>
	 * 英文名: addDseignTrousers 
	 * 功能号: TODO
	 * 时  间: 2017年3月7日 下午4:17:51
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addDseignTrousers(Design design);
	
	
	/**
	 * 
	 * 业  务: 新增马甲设计方案 <br>
	 * 英文名: addDseignVest 
	 * 功能号: TODO
	 * 时  间: 2017年3月7日 下午4:18:06
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addDseignVest(Design design);
	
	
	/**
	 * 
	 * 业  务: 查询所有设计基本信息 <br>
	 * 英文名: showDesignBase 
	 * 功能号: TODO
	 * 时  间: 2017年4月8日 下午2:44:33
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<DesignBase> getDesignBase(String di, String type);
	
	
	/**
	 * 
	 * 业  务: 查询指定的设计方案信息详情 <br>
	 * 英文名: getDesignDetail 
	 * 功能号: TODO
	 * 时  间: 2017年4月10日 下午2:27:46
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<DesignDetail> getDesignDetail(String di, String type, String id);


	List<Design> getDesign(String di, String type, String id);
	
	/**
	 * 
	 * 业  务: 更新西服设计方案信息 <br>
	 * 英文名: updateDesignSuit 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午2:24:52
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateDesignSuit(Design ds);
	
	/**
	 * 
	 * 业  务: 更新裤子设计方案系信息 <br>
	 * 英文名: updateDesignTrousers 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午2:25:13
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateDesignTrousers(Design ds);
	
	
	/**
	 * 
	 * 业  务: 更新衬衫设计方案信息 <br>
	 * 英文名: updateDesignShirt 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午2:25:40
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateDesignShirt(Design ds);
	
	/**
	 * 
	 * 业  务: 更新马夹设计方案信息 <br>
	 * 英文名: updateDesignVest 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午2:26:08
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateDesignVest(Design ds);

	/**
	 * 
	 * 业  务: 删除西服设计方案 <br>
	 * 英文名: deleteDesignSuit 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午5:46:08
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteDesignSuit(String di, String id);
	
	/**
	 * 
	 * 业  务: 删除裤子设计方案 <br>
	 * 英文名: deleteDesignTrousers 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午5:46:45
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteDesignTrousers(String di, String id);
	
	
	/**
	 * 
	 * 业  务: 删除衬衫设计方案 <br>
	 * 英文名: deleteDesignShirt 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午5:46:56
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteDesignShirt(String di, String id);
	
	
	/**
	 * 
	 * 业  务: 删除马甲设计方案 <br>
	 * 英文名: deleteDesignVest 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午5:47:06
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteDesignVest(String di, String id);
}
