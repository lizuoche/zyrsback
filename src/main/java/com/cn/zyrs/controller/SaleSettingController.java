package com.cn.zyrs.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.BomFabric;
import com.cn.zyrs.domain.SaleSetting;
import com.cn.zyrs.service.IBomInfo;
import com.cn.zyrs.service.ISaleSetting;
import com.cn.zyrs.utils.Calculate;


@Controller
@RequestMapping("/saleSetting")
public class SaleSettingController {
	
	private static final Logger log = Logger.getLogger(SaleSettingController.class);

	@Resource(name = "saleSettingService")
	private ISaleSetting saleSettingService;
	
	@Resource(name = "bomInfoService")
	private IBomInfo bomInfoService;
	/**
	 * 
	 * 业  务: 查询当前门店指定款式物料的价格 <br>
	 * 英文名: getPrice 
	 * 功能号: TODO
	 * 时  间: 2016年8月27日 下午5:20:37
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
	@RequestMapping("/getPrice")
	public BigDecimal getPrice(SaleSetting salesetting,String bomcode, String ownerdeptid) {
		String percent = null;
		BigDecimal price=null;
		String basePrice=null;
		//优先查询当前门店设置的价格折扣，如果没有设置，则查询SYS系统设置的折扣价格
		SaleSetting salesetting1 = this.saleSettingService.getSaleSetting(salesetting);
		if (salesetting1 == null) {
			salesetting.setOwerdeptid("SYS");
			salesetting1 = this.saleSettingService.getSaleSetting(salesetting);
			if (salesetting1 == null) {
				percent = "";
				log.error("SYS_SaleSetting表中未设置相关价格参数！");
			}else{
				percent = salesetting1.getValuei();
			}
		} else {
			percent = salesetting1.getValuei();
		}
		//折扣
		Double discount = Calculate.div(Double.valueOf(percent), 100); 
		//确认价格
		List<BomFabric> bomInfoList = this.bomInfoService.getBomInfo(bomcode, "",ownerdeptid, "", "1");
		if(bomInfoList!=null && bomInfoList.size()!=0){
			 basePrice = bomInfoList.get(0).getSellprice();
		}else{
			log.error("查询不到匹配的物料信息！");
			return null;
		}
		price = BigDecimal.valueOf(Calculate.mul(Double.valueOf(basePrice), discount));
		
		return price;
	}

}
