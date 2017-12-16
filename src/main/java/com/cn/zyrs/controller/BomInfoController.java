package com.cn.zyrs.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.BomFabric;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.SaleSetting;
import com.cn.zyrs.domain.UserLoginInfo;
import com.cn.zyrs.service.IBomInfo;
import com.cn.zyrs.service.ISaleSetting;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.Calculate;
import com.cn.zyrs.utils.DynamicDataSource;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/bomInfo")
public class BomInfoController {

	private static Logger log = Logger.getLogger(BomInfoController.class);

	@Resource(name = "userService")
	private IUser userService;

	@Resource(name = "bomInfoService")
	private IBomInfo bomInfoService;

	@Resource(name = "saleSettingService")
	private ISaleSetting saleSettingService;

	/**
	 * 
	 * 业  务: 查询面料信息 <br>
	 * 英文名: showBomInfo 
	 * 功能号: TODO
	 * 时  间: 2016年8月16日 上午11:10:37
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String bomcode
	 * 	   String type
		   String style	
		
	 * 
	 * 出参：List<BomInfo>
	 */
	@ResponseBody
	@RequestMapping("/showBomInfo")
	public ResultJsonBean showBomInfo(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String fabriccode = ParamsUtil.initFilter(
				request.getParameter("bomcode"), null);
		String type = ParamsUtil.initFilter(request.getParameter("type"), null);
		String style = ParamsUtil.initFilter(request.getParameter("style"),
				null);
		String page = ParamsUtil.initFilter(request.getParameter("page"), "1");
		// String ownerdeptid = ParamsUtil.initFilter(
		// request.getParameter("ownerdeptid"), null);
		UserLoginInfo uli = (UserLoginInfo) request.getSession().getAttribute(
				"loginUser");
		if (uli == null) {
			log.error("尚未登录,请先登录！");
			rjb = new ResultJsonBean(false, null, "-1", "尚未登录,请先登录！");
			return rjb;
		}
		String ownerdeptid = uli.getOwnerdepartid();

		// 校验参数
		if (ownerdeptid == null) {
			log.error("缺少ownerdeptid参数！无法查询面料信息！");
			rjb = new ResultJsonBean(false, null, "-1",
					"缺少ownerdeptid参数！无法查询面料信息！");
			return rjb;
		}
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		List<BomFabric> bomInfoList = this.bomInfoService.getBomInfo(
				fabriccode, type, ownerdeptid, style, page);
		rjb = new ResultJsonBean(true, bomInfoList, "1", "面料查询成功！");
		return rjb;
	}

	/**
	 * 
	 * 业  务: 根据面料ID查询指定面料信息 以及门店设置的款式折扣 <br>
	 * 英文名: showBomInfoByID 
	 * 功能号: TODO
	 * 时  间: 2017年6月24日 下午3:02:46
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
	@RequestMapping("/showBomInfoByID")
	public ResultJsonBean showBomInfoByID(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String style = request.getParameter("styleid");
		String fabricid = request.getParameter("bi");
		// 验证参数
		if (di == null) {
			log.error("[查询面料信息]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询面料信息]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[查询面料信息]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询面料信息]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (fabricid == null) {
			log.error("[查询面料信息]===>缺少面料ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询面料信息]===>缺少面料ID参数！<===");
			return rjb;
		} else if (style == null) {
			log.error("[查询面料信息]===>缺少款式ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询面料信息]===>缺少款式ID参数！<===");
			return rjb;
		}

		// 验证合法用户
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[查询面料信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询面料信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
			String stylecode = "";

			if ("suit".equalsIgnoreCase(style)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("西服");
			} else if ("shirt".equalsIgnoreCase(style)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("长袖衬衫");
			} else if ("trousers".equalsIgnoreCase(style)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("裤子");
			} else if ("vest".equalsIgnoreCase(style)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("马甲");
			} else if ("coat".equalsIgnoreCase(style)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("大衣");
			}
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			BomFabric bomInfo = this.bomInfoService
					.getBomInfoByID(fabricid, di);
			bomInfo.setBigimage("Dress/data/TextureMaterial/"+ style +"_texture/" + bomInfo.getBigimage());
			bomInfo.setSmallimage("Dress/data/TextureMaterial/"+ style +"_texture/" + bomInfo.getSmallimage());

			// 查询连锁店设置的折扣

			double stylediscount = 0.00;
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			String percent = this.saleSettingService.getStyleDiscount(
					stylecode, di);
			if (percent == null) {
				percent = this.saleSettingService.getStyleDiscount(stylecode,
						null);
			}
			stylediscount = Calculate.div(Double.valueOf(percent), 100);

			bomInfo.setStylediscount(stylediscount);
			rjb = new ResultJsonBean(true, bomInfo, "1", "面料查询成功！");
		}
		return rjb;

	}

	/**
	 * 
	 * 业  务: TODO <br>
	 * 英文名: getStyle 
	 * 功能号: TODO
	 * 时  间: 2016年8月16日 上午11:13:16
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：List<String>
	 */
	@ResponseBody
	@RequestMapping("/showStyle")
	public List<String> getStyle() {
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		return this.bomInfoService.getStyle();
	}

}
