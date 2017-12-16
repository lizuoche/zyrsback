package com.cn.zyrs.service;

import java.util.List;
import java.util.Map;

import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.CommodityParts;
import com.cn.zyrs.domain.GoodsParts;
import com.cn.zyrs.domain.ShirtStyle;
import com.cn.zyrs.domain.SuitParts;
import com.cn.zyrs.domain.SuitStyle;
import com.cn.zyrs.domain.TrousersStyle;
import com.cn.zyrs.domain.VestStyle;

public interface IParts {
	
	/**
	 * 
	 * 业  务: 检查西服配件模型编号是否存在 <br>
	 * 英文名: checkModelName 
	 * 功能号: TODO
	 * 时  间: 2016年11月18日 下午2:52:09
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int checkSuitModelName(String modelName);
	
	/**
	 * 
	 * 业  务: 检查裤子模型编号是否存在 <br>
	 * 英文名: checkTrousersModelName 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午2:39:14
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int checkTrousersModelName(String modelName);
	
	/**
	 * 
	 * 业  务: 检查衬衫模型编号是否存在 <br>
	 * 英文名: checkShirtModelName 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午2:39:43
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int checkShirtModelName(String modelName);
	
	
	/**
	 * 
	 * 业  务: 检查马甲模型编号是否存在 <br>
	 * 英文名: checkVestModelName 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午2:39:59
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int checkVestModelName(String modelName);
	
	
	/**
	 * 
	 * 业  务: 验证面料模型名称是否存在 <br>
	 * 英文名: checkBomModelName 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 上午11:53:45
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int checkBomCode(String bomCode);
	
	/**
	 * 
	 * 业  务: 检查商品库模型名称是否存在 <br>
	 * 英文名: checkGoodsModelName 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午3:35:43
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int checkGoodsModelName(String modelName);
	
	
	/**
	 * 
	 * 业  务: 查询西服配件信息 <br>
	 * 英文名: getSuitParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月16日 下午6:06:50
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<SuitParts> getSuitParts(SuitParts sp);
	
	/**
	 * 
	 * 业  务: 查询裤子配件 <br>
	 * 英文名: getTrousersParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午3:39:36
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<SuitParts> getTrousersParts(SuitParts sp);
	
	
	/**
	 * 
	 * 业  务: 查询衬衫配件信息 <br>
	 * 英文名: getShirtParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午4:04:17
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	 
	List<SuitParts> getShirtParts(SuitParts sp);
	
	
	/**
	 * 
	 * 业  务: 查询马甲配件信息 <br>
	 * 英文名: getVestParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午4:12:47
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<SuitParts> getVestParts(SuitParts sp);
	
	/**
	 * 
	 * 业  务: 查询指定Id的配件信息 <br>
	 * 英文名: getparts 
	 * 功能号: TODO
	 * 时  间: 2017年4月12日 上午10:33:04
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	SuitParts getparts(String id);
	
	/**
	 * 
	 * 业  务: 查询西服面料配件信息 <br>
	 * 英文名: getBomParts 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 上午10:55:03
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<BomParts> getBomParts(BomParts bp);
	
	/**
	 * 
	 * 业  务: 查询商品信息 <br>
	 * 英文名: getCommodityParts 
	 * 功能号: TODO
	 * 时  间: 2017年4月20日 上午11:33:46
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<CommodityParts> getCommodityParts(CommodityParts cp);
	
	/**
	 * 
	 * 业  务: 查询面料品牌 <br>
	 * 英文名: getBomBrand 
	 * 功能号: TODO
	 * 时  间: 2016年12月9日 下午5:41:44
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<String> getBomBrand(String style);
	
	
	/**
	 * 
	 * 业  务: 查询商品品牌 <br>
	 * 英文名: getGoodsBrand 
	 * 功能号: TODO
	 * 时  间: 2016年12月10日 下午1:50:17
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<String> getGoodsBrand(String style);
	
	/**
	 * 
	 * 业  务: TODO <br>
	 * 英文名: getGoodsParts 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午3:22:04
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<GoodsParts> getGoodsParts(GoodsParts gp);
	
	
	/**
	 * 
	 * 业  务: 查询西服款式信息 <br>
	 * 英文名: getSuitStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 上午10:45:06
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<SuitStyle> getSuitStyle(Map<String,String> map);
	
	/**
	 * 
	 * 业  务: 查询裤子款式配置信息 <br>
	 * 英文名: getTrousersStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 上午10:45:26
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<TrousersStyle> getTrousersStyle(Map<String,String> map);
	
	
	/**
	 * 
	 * 业  务: 查询衬衫款式配置信息 <br>
	 * 英文名: getShirtStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 上午10:45:44
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<ShirtStyle> getShirtStyle(Map<String,String> map);
	
	
	/**
	 * 
	 * 业  务: 查询马甲款式配置信息 <br>
	 * 英文名: getVestStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 上午10:46:02
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	List<VestStyle> getVestStyle(Map<String,String> map);
	
	
	/**
	 * 
	 * 业  务: 新增西服配件 <br>
	 * 英文名: addSuitParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月17日 下午3:07:52
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	
	int addSuitParts(SuitParts sp);
	
	/**
	 * 
	 * 业  务: 新增裤子配件信息 <br>
	 * 英文名: addTrousersParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午3:11:33
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	
	int addTrousersParts(SuitParts sp);
	

	/**
	 * 
	 * 业  务: 新增衬衫配件信息 <br>
	 * 英文名: addShirtParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午4:14:28
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	
	int addShirtParts(SuitParts sp);
	
	
	/**
	 * 	
	 * 业  务: 新增马甲配件信息 <br>
	 * 英文名: addVestParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午4:13:49
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addVestParts(SuitParts sp);
	
	
	/**
	 * 
	 * 业  务: 新增西服面料配件信息 <br>
	 * 英文名: addBomParts 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 上午11:44:02
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addSuitBomParts(BomParts bp);
	
	/**
	 * 
	 * 业  务: 新增商品领带配件信息 <br>
	 * 英文名: addGoods 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午3:10:48
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addGoods(GoodsParts gp);
	
	
	/**
	 * 
	 * 业  务: 新增西服款式配置信息 <br>
	 * 英文名: addSuitStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 下午4:09:17
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addSuitStyle(SuitStyle ss);
	
	/**
	 * 
	 * 业  务: 新增裤子款式配置信息 <br>
	 * 英文名: addTrousersStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 下午4:09:41
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addTrousersStyle(TrousersStyle ts);
	
	/**
	 * 
	 * 业  务: 新增衬衫款式配置信息 <br>
	 * 英文名: addShirtStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 下午4:09:55
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addShirtStyle(ShirtStyle ss);
	
	
	/**
	 * 
	 * 业  务: 新增马甲款式配置信息 <br>
	 * 英文名: addVestStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月1日 下午4:10:09
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int addVestStyle(VestStyle vs);
	
	/**
	 * 
	 * 业  务: 更新修改西服配件信息 <br>
	 * 英文名: updateSuitCollar 
	 * 功能号: TODO
	 * 时  间: 2016年11月19日 下午4:46:18
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateSuitCollar(SuitParts sp);
	
	/**
	 * 
	 * 业  务: 更新裤子配件 <br>
	 * 英文名: updateTrousersCollar 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午3:40:00
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateTrousersCollar(SuitParts sp);
	
	
	/**
	 * 
	 * 业  务: 更新衬衫配件信息 <br>
	 * 英文名: updateShirtCollar 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午4:18:44
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateShirtCollar(SuitParts sp);
	
	
	/**
	 * 
	 * 业  务: 更新马甲配件信息 <br>
	 * 英文名: updateVestCollar 
	 * 功能号: TODO
	 * 时  间: 2016年11月24日 下午4:19:09
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateVestCollar(SuitParts sp);
	
	/**
	 * 
	 * 业  务: 更新面料配件信息 <br>
	 * 英文名: updateBomCollar 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午2:11:03
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateBomCollar(BomParts bp);
	
	
	/**
	 * 
	 * 业  务: 更新商品配件信息 <br>
	 * 英文名: updateGoods 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午3:25:01
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateGoods(GoodsParts gp);
	

	/**
	 * 
	 * 业  务: 更新西服款式信息 <br>
	 * 英文名: updateSuitStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午9:52:47
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateSuitStyle(SuitStyle ss);
	
	
	/**
	 * 
	 * 业  务: 更新裤子款式信息 <br>
	 * 英文名: updateTrousersStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午9:53:05
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateTrousersStyle(TrousersStyle ts);
	
	
	/**
	 * 
	 * 业  务: 更新衬衫款式信息 <br>
	 * 英文名: updateShirtStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午9:53:17
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateShirtStyle(ShirtStyle ss);
	
	
	/**
	 * 
	 * 业  务: 更新马甲款式信息 <br>
	 * 英文名: updateVestStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午9:53:31
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int updateVestStyle(VestStyle vs);
	
	
	/**
	 * 
	 * 业  务: 删除西服配件信息 <br>
	 * 英文名: deldteSpare 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午12:37:32
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteSuitParts(String[] ids);
	
	
	/**
	 * 
	 * 业  务: 删除裤子配件信息 <br>
	 * 英文名: deldteTrousersParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午1:03:36
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteTrousersParts(String[] ids);
	
	
	/**
	 * 删除衬衫配件信息
	 * 业  务: TODO <br>
	 * 英文名: deldteShirtParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午1:03:54
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteShirtParts(String[] ids);
	
	
	/**
	 * 
	 * 业  务: 删除马甲配件信息 <br>
	 * 英文名: deldteVParts 
	 * 功能号: TODO
	 * 时  间: 2016年11月29日 下午1:04:07
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteVestParts(String[] ids);
	
	/**
	 * 
	 * 业  务: 删除面料配件信息 <br>
	 * 英文名: deldteBomParts 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午1:44:35
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteBomParts(String[] ids);
	
	
	/**
	 * 
	 * 业  务: 删除商品信息 <br>
	 * 英文名: deleteGoods 
	 * 功能号: TODO
	 * 时  间: 2016年12月6日 下午3:32:49
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteGoods(String[] ids);
	
	/**
	 * 
	 * 业  务: 删除西服款式配置信息 <br>
	 * 英文名: deldteSuitStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午10:23:10
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteSuitStyle(String[] ids);
	
	/**
	 * 
	 * 业  务: 删除裤子款式配置信息 <br>
	 * 英文名: deldteTrousersStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午10:23:33
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteTrousersStyle(String[] ids);
	
	/**
	 * 
	 * 业  务: 删除衬衫款式配置信息 <br>
	 * 英文名: deldteShirtStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午10:23:46
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteShirtStyle(String[] ids);
	
	/**
	 * 
	 * 业  务: 删除马甲款式配置信息 <br>
	 * 英文名: deldteVestStyle 
	 * 功能号: TODO
	 * 时  间: 2016年12月2日 上午10:23:57
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	int deleteVestStyle(String[] ids);

}
