package com.cn.zyrs.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.misc.BASE64Decoder;

import com.cn.zyrs.domain.BomFabric;
import com.cn.zyrs.domain.BomOrder;
import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.Craft;
import com.cn.zyrs.domain.Customer;
import com.cn.zyrs.domain.CustomerBaseInfo;
import com.cn.zyrs.domain.CustomerData;
import com.cn.zyrs.domain.CustomerDataZoon;
import com.cn.zyrs.domain.CustomerMeasureData;
import com.cn.zyrs.domain.CustomerMeasureDataZoon;
import com.cn.zyrs.domain.CustomerVIP;
import com.cn.zyrs.domain.DeptLoginInfo;
import com.cn.zyrs.domain.Fabric;
import com.cn.zyrs.domain.Order;
import com.cn.zyrs.domain.OrderCraft;
import com.cn.zyrs.domain.OrderDetail;
import com.cn.zyrs.domain.OrderSpecialCraft;
import com.cn.zyrs.domain.ProductDetail;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.SaleSetting;
import com.cn.zyrs.domain.ShoppingCart;
import com.cn.zyrs.domain.SpecialCraft;
import com.cn.zyrs.domain.UserLoginInfo;
import com.cn.zyrs.service.IBomInfo;
import com.cn.zyrs.service.ICustomer;
import com.cn.zyrs.service.ICustomerData;
import com.cn.zyrs.service.ICustomerDataZoon;
import com.cn.zyrs.service.ICustomerMeasureData;
import com.cn.zyrs.service.ICustomerMeasureDataZoon;
//import com.cn.zyrs.domain.OrderDetail;
import com.cn.zyrs.service.IOrder;
import com.cn.zyrs.service.IOrderDetail;
import com.cn.zyrs.service.IParts;
import com.cn.zyrs.service.IProductDetail;
import com.cn.zyrs.service.IProductImage;
import com.cn.zyrs.service.ISaleSetting;
import com.cn.zyrs.service.IShoppingCart;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.Calculate;
import com.cn.zyrs.utils.DateUtils;
import com.cn.zyrs.utils.DynamicDataSource;
import com.cn.zyrs.utils.JsonHelper;
import com.cn.zyrs.utils.OrderCodeFactory;
import com.cn.zyrs.utils.PCUtils;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/order")
public class OrderController {

	private static Logger log = Logger.getLogger(OrderController.class);

	final static Properties properties = PCUtils
			.getProperties("system-config.properties");

	// 下载根目录
	private static final String serverIP = properties.getProperty("server.ip");
	private static final String uploadBasePath = properties
			.getProperty("server.uploadBasePath");
	@Resource(name = "orderService")
	private IOrder orderService;

	@Resource(name = "userService")
	private IUser userService;

	@Resource(name = "shoppingCartService")
	private IShoppingCart shoppingCartService;

	@Resource(name = "partsService")
	private IParts partsService;

	@Resource(name = "orderDetailService")
	private IOrderDetail orderDetailService;

	@Resource(name = "customerService")
	private ICustomer customerService;

	@Resource(name = "customerDataService")
	private ICustomerData customerDataService;

	@Resource(name = "customerDataZoonService")
	private ICustomerDataZoon customerDataZoonService;

	@Resource(name = "customerMeasureDataService")
	private ICustomerMeasureData customerMeasureDataService;

	@Resource(name = "customerMeasureDataZoonService")
	private ICustomerMeasureDataZoon customerMeasureDataZoonService;

	@Resource(name = "productDetailService")
	private IProductDetail productDetailService;

	@Resource(name = "productImageService")
	private IProductImage productImageService;

	@Resource(name = "saleSettingService")
	private ISaleSetting saleSettingService;

	@Resource(name = "bomInfoService")
	private IBomInfo bomInfoService;

	/**
	 * 
	 * 业  务: 订单查询 <br>
	 * 英文名: showOrder 
	 * 功能号: TODO
	 * 时  间: 2016年8月8日 下午3:37:09
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：orderCode
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：List<Order>
	 */
	@ResponseBody
	@RequestMapping("/showOrder")
	public ResultJsonBean showOrder(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		// 验证参数
		if (di == null) {
			log.error("[订单查询 ]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[订单查询 ]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[订单查询 ]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[订单查询 ]===>缺少门店密钥参数！<===");
			return rjb;
		}

		// 验证合法用户
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[订单查询]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[订单查询]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			List<Order> ol = this.orderService.getOrderBase(di);

			rjb = new ResultJsonBean(true, ol, "1", "查询订单成功！");
		}
		return rjb;
	}

	// /**
	// *
	// * 业 务: 根据订单号查询订单详情 <br>
	// * 英文名: showOrder
	// * 功能号: TODO
	// * 时 间: 2016年8月11日 下午5:57:43
	// * 应用项目: 中依睿晟新增订单APP后台管理系统
	// * 作者: 严昊 <br>
	// *
	// * 入参：ordercode
	// * TODO TODO TODO
	// TODO TODO TODO
	//
	// *
	// * 出参：List<OrderDetail>
	// */
	// @ResponseBody
	// @RequestMapping("/showOrderDetail")
	// public List<OrderDetail> showOrder(String ordercode) {
	// return this.orderService.getOrderDetailByOrderCode(ordercode);
	//
	// }

	/**
	 * 
	 * 业  务: 更新订单状态 <br>
	 * 英文名: SaveOrder 
	 * 功能号: TODO
	 * 时  间: 2016年8月16日 下午2:36:12
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String ordercode
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/updateOrder")
	public ResultJsonBean updateOrder(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;
		String action = ParamsUtil.initFilter(request.getParameter("action"),
				null);
		String ordercode = ParamsUtil.initFilter(
				request.getParameter("ordercode"), null);
		// 验证参数
		if (action == null || ordercode == null) {
			log.error("缺少参数，请检查参数！");
			rjb = new ResultJsonBean(false, null, "-1", "缺少参数，请检查参数！");
			return rjb;
		}
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		Order order = this.orderService.getOrderByPrimaryKey(ordercode);
		if (order == null) {
			log.error("查询不到对应的订单，请检查订单编号！");
			rjb = new ResultJsonBean(false, null, "-1", "查询不到对应的订单，请检查订单编号！");
			return rjb;
		}
		if ("save".equalsIgnoreCase(action)) {
			order.setOrderstatus("0");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
										// 100：已完成
		} else if ("add".equalsIgnoreCase(action)) {
			order.setOrderstatus("1");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
										// 100：已完成
		} else if ("drop".equalsIgnoreCase(action)) {
			order.setOrderstatus("-1");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
										// 100：已完成
		} else if ("delete".equalsIgnoreCase(action)) {
			order.setDelflag("1");// 删除标志（0：未删除，1：已删除）
		}
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		int flag = this.orderService.updateOrder(order);
		log.info("订单操作成功！");
		rjb = new ResultJsonBean(true, flag, "1", "订单操作成功！");
		return rjb;
	}

	/**
	 * 
	 * 业  务: 新增订单 <br>
	 * 英文名: insertOrder 
	 * 功能号: TODO
	 * 时  间: 2016年8月18日 下午5:31:42
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String tel
	 *     String customername		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/addOrder")
	public ResultJsonBean addOrder(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;
		ResultJsonBean addOrder = null;
		ResultJsonBean addOrderDetail = null;
		ResultJsonBean addProductDetail = null;
		ResultJsonBean addCustomerData = null;
		ResultJsonBean addCustomerDataZoon = null;
		ResultJsonBean addOrderCraft = null;
		ResultJsonBean addOrderSpecialCraft = null;

		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String shoppingcart = request.getParameter("shoppingcart");// 购物车Json信息

		// 验证参数
		if (di == null) {
			log.error("[新增订单]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增订单]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[新增订单]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增订单]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (shoppingcart == null) {
			log.error("[新增订单]===>缺少购物车参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增订单]===>缺少购物车参数！<===");
			return rjb;
		}

		// 解析购物车参数信息
		Map<String, String> sc_map = JsonHelper.toMap(shoppingcart);
		// 客户ID
		String ci = sc_map.get("customerid");
		// 营业员ID
		String si = sc_map.get("servicerid");
		// 订单价格
		String amount = sc_map.get("All_Product_Price");

		// 购物车信息
		String sc = sc_map.get("shoppingcart");
		Map<String, String> scd_map = JsonHelper.toMap(sc);
		String scd = scd_map.get("shoppingcartdetail");
		scd = scd.replace("[", "");
		scd = scd.replace("]", "");
		String[] scdl = scd.split(",\\{");
		// 处理scdl数据完整性
		for (int i = 1; i < scdl.length; i++) {
			scdl[i] = "{" + scdl[i];
		}

		if (ci == null) {
			log.error("[新增订单]===>缺少客户ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增订单]===>缺少客户ID参数！<===");
			return rjb;
		} else if (si == null) {
			log.error("[新增订单]===>缺少营业员ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增订单]===>缺少营业员ID参数！<===");
			return rjb;
		}

		// 验证合法用户
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[加入购物车]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[加入购物车]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
			// 获取登录门店基本信息
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			DeptLoginInfo dli = this.userService.getDeptInfo(di);

			// 订单价格
			String orderamount = amount;
			// 是否加急
			String isurgent = ParamsUtil
					.initFilter(sc_map.get("isurgent"), "0");

			// 1、新增订单到订单表中
			// 生成ordercode
			String ordercode = "";
			ordercode = OrderCodeFactory.makeOrderCode(di);
			if (ordercode == null || "".equalsIgnoreCase(ordercode)) {
				rjb = new ResultJsonBean(false, null, "-1", "ordercode生成失败！");
				return rjb;
			}

			addOrder = addOrder(ordercode, di, si, ci, orderamount, isurgent,
					dli);

			for (int i = 0; i < scdl.length; i++) {
				// 2、新增订单详情表信息
				Map<String, String> scd_map1 = JsonHelper.toMap(scdl[i]);

				String scid = scd_map1.get("shoppingcartid");// 购物车id
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<ShoppingCart> scl = this.shoppingCartService
						.showShoppingCart(scid);
				ShoppingCart sc1 = scl.get(0);
				String type = sc1.getType();

				String psid = "";// 款式类型ID
				String bomcode = "";// 面料CODE

				BomParts bp = new BomParts();

				if ("suit".equalsIgnoreCase(type)) {
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					psid = this.bomInfoService.getStyleCode("西服");
					bp.setId(scd_map1.get("suitBom"));
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					bomcode = this.partsService.getBomParts(bp).get(0)
							.getCode();
				} else if ("shirt".equalsIgnoreCase(type)) {
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					psid = this.bomInfoService.getStyleCode("长袖衬衫");
					bp.setId(scd_map1.get("shirtBom"));
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					bomcode = this.partsService.getBomParts(bp).get(0)
							.getCode();
				} else if ("trousers".equalsIgnoreCase(type)) {
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					psid = this.bomInfoService.getStyleCode("裤子");
					bp.setId(scd_map1.get("suitBom"));
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					bomcode = this.partsService.getBomParts(bp).get(0)
							.getCode();
				} else if ("vest".equalsIgnoreCase(type)) {
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					psid = this.bomInfoService.getStyleCode("马甲");
					bp.setId(scd_map1.get("suitBom"));
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					bomcode = this.partsService.getBomParts(bp).get(0)
							.getCode();
				} else if ("coat".equalsIgnoreCase(type)) {
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					psid = this.bomInfoService.getStyleCode("大衣");
					bp.setId(scd_map1.get("suitBom"));
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					bomcode = this.partsService.getBomParts(bp).get(0)
							.getCode();
				}

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				String pt = this.bomInfoService.getSort(psid);// 商品还是面料

				// 售价写死
				// BigDecimal price =
				// BigDecimal.valueOf(Double.parseDouble(ParamsUtil
				// .initFilter(orderdetaillist.get(i).get("price"), "")));
				// saleSetting.setSalesettype("SALLPRICE");
				// saleSetting.setSalesetcode(psid);
				// saleSetting.setOwerdeptid(dli.getOwnerdept());
				// 获取售价
				// BigDecimal price =
				// getPrice(saleSetting,bomcode,loginInfo.getOwnerdepartid());

				String price = scd_map1.get("price");
				isurgent = scd_map1.get("isurgent");
				String ismastermeasure = scd_map1.get("ismastermeasure");
				String remark = ParamsUtil.initFilter(scd_map1.get("remark"),
						"");

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<OrderDetail> odl = this.orderDetailService
						.getOrderDetaiByOrderCode(ordercode);
				// 生成detailcode
				String exDetailCode = "";
				if (odl != null && odl.size() != 0) {
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					exDetailCode = this.orderDetailService
							.getOrderDetaiByOrderCode(ordercode).get(0)
							.getDetailcode();
				} else {
					exDetailCode = ordercode + "-00";
				}
				String num = String.valueOf(Integer.parseInt(exDetailCode
						.substring(exDetailCode.length() - 2)) + 1);
				if (num != null && num != "") {
					if (num.length() == 1) {
						num = "0" + num;
					}
				}
				String detailcode = ordercode + "-" + num;
				OrderDetail orderdetail = new OrderDetail();
				orderdetail.setDetailcode(detailcode);
				orderdetail.setOrdercode(ordercode);
				orderdetail.setProducttype(pt);
				orderdetail.setProductstyle(psid);
				orderdetail.setCount("1");
				orderdetail.setBomcount("1");
				orderdetail.setBomcode(bomcode);
				orderdetail.setIsgift("0");
				orderdetail.setBatch("0");
				orderdetail.setIsurgent(isurgent);
				orderdetail.setIsmastermeasure(ismastermeasure);
				orderdetail.setPrice(price);
				orderdetail.setDiscount("100");
				// 先默认男款
				orderdetail.setManorwormen("男款");
				orderdetail.setRemark(remark);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				int addOrderDetailRes = this.orderDetailService
						.addOrderDetail(orderdetail);

				addOrderDetail = new ResultJsonBean(true, addOrderDetailRes,
						"1", "新增订单详情表信息成功！");

				// 3、加入产品详情表
				ProductDetail pd = new ProductDetail();
				// 查询指定购物车信息
				pd.setDetailcode(detailcode);
				pd.setOrdercode(ordercode);
				pd.setProductstyle(psid);
				pd.setDesignname(sc1.getDesignname());
				pd.setPicture(sc1.getPicture());
				pd.setType(sc1.getType());
				pd.setTypename(sc1.getTypename());
				pd.setAssetbundlename(sc1.getAssetbundlename());
				pd.setCollar(sc1.getCollar());
				pd.setFont(sc1.getFont());
				pd.setBack(sc1.getBack());
				pd.setBuff(sc1.getBuff());
				pd.setBreastpocket(sc1.getBreastpocket());
				pd.setButtoneye(sc1.getButtoneye());
				pd.setFrontdart(sc1.getFrontdart());
				pd.setPocket(sc1.getPocket());
				pd.setButtonnum(sc1.getButtonnum());
				pd.setPlacket(sc1.getPlacket());
				pd.setBotouyan(sc1.getBotouyan());
				pd.setXiabai(sc1.getXiabai());
				pd.setYaotou(sc1.getYaotou());
				pd.setKujiao(sc1.getKujiao());
				pd.setCekoudai(sc1.getCekoudai());
				pd.setHoukoudai(sc1.getHoukoudai());
				pd.setSuitbom(sc1.getSuitbom());
				pd.setInsidebom(sc1.getInsidebom());
				pd.setShirtbom(sc1.getShirtbom());
				pd.setTiebom(sc1.getTiebom());
				pd.setKouyanbom(sc1.getKouyanbom());
				pd.setSuitbutton(sc1.getSuitbutton());
				pd.setTie(sc1.getTie());
				pd.setCravat(sc1.getCravat());
				pd.setBigImage(sc1.getBigImage());
				pd.setJsonurl(sc1.getJsonurl());

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				int addProductDetailres = this.productDetailService
						.addProductDetail(pd);

				addProductDetail = new ResultJsonBean(true,
						addProductDetailres, "1", "新增产品详情表信息成功！");
				// 4、新增订单客户量体信息
				// 订单量体信息
				// String ocd = scd_map1.get("ordercustomerdata");
				// Map<String,String> ocd_map = JsonHelper.toMap(ocd);
				//
				// CustomerData customerdata = new CustomerData();
				//
				// // String surveyor =
				// ParamsUtil.initFilter(orderdetaillist.get(i).get("surveyor"),
				// null);
				// String style = ParamsUtil.initFilter(ocd_map.get("style"),
				// null);
				//
				// customerdata.setOrdercode(ordercode);
				// customerdata.setDetailcode(detailcode);
				// customerdata.setCustomerid(ci);
				// customerdata.setSurveyor(si);
				// customerdata.setStyle(style);
				// customerdata.setData1(ocd_map.get("data1"));
				// customerdata.setData2(ocd_map.get("data2"));
				// customerdata.setData3(ocd_map.get("data3"));
				// customerdata.setData4(ocd_map.get("data4"));
				// customerdata.setData5(ocd_map.get("data5"));
				// customerdata.setData6(ocd_map.get("data6"));
				// customerdata.setData7(ocd_map.get("data7"));
				// customerdata.setData8(ocd_map.get("data8"));
				// customerdata.setData9(ocd_map.get("data9"));
				// customerdata.setData10(ocd_map.get("data10"));
				// customerdata.setData11(ocd_map.get("data11"));
				// customerdata.setData12(ocd_map.get("data12"));
				// customerdata.setData13(ocd_map.get("data13"));
				// customerdata.setData14(ocd_map.get("data14"));
				// customerdata.setData15(ocd_map.get("data15"));
				// customerdata.setData16(ocd_map.get("data16"));
				// customerdata.setData17(ocd_map.get("data17"));
				// customerdata.setData18(ocd_map.get("data18"));
				// customerdata.setData19(ocd_map.get("data19"));
				// customerdata.setData20(ocd_map.get("data20"));
				// customerdata.setData21(ocd_map.get("data21"));
				// customerdata.setData22(ocd_map.get("data22"));
				// customerdata.setData23(ocd_map.get("data23"));
				// customerdata.setData24(ocd_map.get("data24"));
				// customerdata.setData25(ocd_map.get("data25"));
				//
				// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				// int addCustomerDatares =
				// this.customerDataService.addCustomerData(customerdata);
				//
				// addCustomerData = new
				// ResultJsonBean(true,addCustomerDatares,"1","新增订单量体信息成功！");

				// 5、新增订单客户量体收放信息
				// 订单量体缩放信息
				// String ocdz = sc_map.get("ordercustomerdatazoon");
				// Map<String,String> ocdz_map = JsonHelper.toMap(ocdz);
				//
				// CustomerDataZoon customerdatazoon = new CustomerDataZoon();
				//
				// customerdatazoon.setOrdercode(ordercode);
				// customerdatazoon.setDetailcode(detailcode);
				// customerdatazoon.setCustomerid(ci);
				// customerdatazoon.setSurveyor(si);
				// customerdatazoon.setStyle(ocdz_map.get("style"));
				// customerdatazoon.setData1(ocdz_map.get("data1"));
				// customerdatazoon.setData2(ocdz_map.get("data2"));
				// customerdatazoon.setData3(ocdz_map.get("data3"));
				// customerdatazoon.setData4(ocdz_map.get("data4"));
				// customerdatazoon.setData5(ocdz_map.get("data5"));
				// customerdatazoon.setData6(ocdz_map.get("data6"));
				// customerdatazoon.setData7(ocdz_map.get("data7"));
				// customerdatazoon.setData8(ocdz_map.get("data8"));
				// customerdatazoon.setData9(ocdz_map.get("data9"));
				// customerdatazoon.setData10(ocdz_map.get("data10"));
				// customerdatazoon.setData11(ocdz_map.get("data11"));
				// customerdatazoon.setData12(ocdz_map.get("data12"));
				// customerdatazoon.setData13(ocdz_map.get("data13"));
				// customerdatazoon.setData14(ocdz_map.get("data14"));
				// customerdatazoon.setData15(ocdz_map.get("data15"));
				// customerdatazoon.setData16(ocdz_map.get("data16"));
				// customerdatazoon.setData17(ocdz_map.get("data17"));
				// customerdatazoon.setData18(ocdz_map.get("data18"));
				// customerdatazoon.setData19(ocdz_map.get("data19"));
				// customerdatazoon.setData20(ocdz_map.get("data20"));
				// customerdatazoon.setData21(ocdz_map.get("data21"));
				// customerdatazoon.setData22(ocdz_map.get("data22"));
				// customerdatazoon.setData23(ocdz_map.get("data23"));
				// customerdatazoon.setData24(ocdz_map.get("data24"));
				// customerdatazoon.setData25(ocdz_map.get("data25"));
				//
				// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				// int addCustomerDataZoonRes =
				// this.customerDataZoonService.addCustomerDataZoon(customerdatazoon);
				//
				// addCustomerDataZoon = new
				// ResultJsonBean(true,addCustomerDataZoonRes,"1","新增订单量体收放信息成功！");

				// 6、新增订单工艺信息
				// 工艺信息
				String craft = scd_map1.get("craft");
				if (craft != null && !"null".equalsIgnoreCase(craft)) {
					Map<String, String> craft_map = JsonHelper.toMap(craft);
					OrderCraft oc = new OrderCraft();
					oc.setId(UUID.randomUUID().toString());
					oc.setOrdercode(ordercode);
					oc.setDetailcode(detailcode);
					oc.setCraftid(craft_map.get("craftid"));
					oc.setPrice(craft_map.get("price"));

					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					int addOrderCraftRes = this.orderService.addOrderCraft(oc);

					addOrderCraft = new ResultJsonBean(true, addOrderCraftRes,
							"1", "新增订单工艺表信息成功！");
				}

				// 8、新增订单特殊工艺信息
				// 特殊工艺信息
				String scraft = scd_map1.get("specialcraft");
				if (scraft != null && !"null".equalsIgnoreCase(scraft)) {
					Map<String, String> scraft_map = JsonHelper.toMap(scraft);
					OrderSpecialCraft osc = new OrderSpecialCraft();
					osc.setId(UUID.randomUUID().toString());
					osc.setOrdercode(ordercode);
					osc.setDetailcode(detailcode);
					osc.setSpecialcraftid(scraft_map.get("specialcraftid"));
					osc.setPrice(scraft_map.get("price"));

					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);

					int addOrderSpecialCraftRes = this.orderService
							.addOrderSpecialCraft(osc);

					addOrderSpecialCraft = new ResultJsonBean(true,
							addOrderSpecialCraftRes, "1", "新增订单特殊工艺表信息成功！");
				}

			}

			Map<String, ResultJsonBean> resMap = new HashMap<String, ResultJsonBean>();
			resMap.put("addOrder", addOrder);
			resMap.put("addOrderDetail", addOrderDetail);
			resMap.put("addProductDetail", addProductDetail);
			resMap.put("addCustomerData", addCustomerData);
			resMap.put("addCustomerDataZoon", addCustomerDataZoon);
			resMap.put("addOrderCraft", addOrderCraft);
			resMap.put("addOrderSpecialCraft", addOrderSpecialCraft);

			rjb = new ResultJsonBean(true, resMap, "1", "新增订单成功！");

		} else {
			log.error("[新增订单]===>密钥不匹配,新增失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增订单]===>密钥不匹配,新增失败！<===");
		}

		return rjb;

	}

	// @ResponseBody
	// @RequestMapping("/addOrder")
	// public ResultJsonBean addOrder(HttpServletRequest request,
	// HttpServletResponse response) {
	// ResultJsonBean jsonBean = null;
	// SaleSetting saleSetting = new SaleSetting();
	// String customername = request.getParameter("customername");
	// String tel = request.getParameter("tel");
	// BigDecimal height =
	// BigDecimal.valueOf(Double.parseDouble(request.getParameter("height")));
	// BigDecimal weight =
	// BigDecimal.valueOf(Double.parseDouble(request.getParameter("weight")));
	// Integer gender = Integer.valueOf(request.getParameter("gender"));
	// String picture = request.getParameter("picture");
	// String orderdetail = request.getParameter("orderdetail");
	// // String delivery = request.getParameter("delivery");//快递信息
	// //
	// // Map<String, String> dm = null; //
	// // if(delivery!=null){//null 则自取
	// // String demo = delivery.replace("=", ":");
	// // try {
	// // dm = JsonHelper.toMap(demo);
	// // } catch (Exception e) {
	// // log.error("ERROR", e);
	// // }
	// // }
	// // 将orderDetail 数组转换成map型
	// String[] arr = orderdetail.split("},");
	// List<Map<String, String>> orderdetaillist = new ArrayList<Map<String,
	// String>>(
	// arr.length);
	// try {
	// if (arr.length == 1) {
	// String demo = arr[0].replace("=", ":");
	// Map<String, String> map = JsonHelper.toMap(demo);
	// orderdetaillist.add(map);
	// } else if (arr.length > 1) {
	// for (int i = 0; i < arr.length; i++) {
	// String demo = arr[i].replace("=", ":");
	// if (i < arr.length - 1) {
	// demo = demo + "}";
	// }
	// Map<String, String> map = JsonHelper.toMap(demo);
	// orderdetaillist.add(map);
	// }
	// }
	// } catch (Exception e) {
	// log.error("ERROR", e);
	// }
	//
	// // DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// // Customer customercount = this.customerService.getCustomer(tel);
	// // int addCustomer = 0;
	// // if (customercount == null) {
	// // // 新增客户信息到客户表中
	// //
	// // Customer customer = new Customer();
	// // CustomerVIP vip = new CustomerVIP();
	// //
	// // String customerid = UUID.randomUUID().toString();
	// // customer.setCustomerid(customerid);
	// // customer.setCustomername(customername);
	// // customer.setGender(1);// 默认设性别为1
	// // customer.setTel(tel);
	// // customer.setCustomertype("VIP0");
	// // customer.setIsvip(0);
	// // customer.setHeight(height);
	// // customer.setWeight(weight);
	// // customer.setPicture(picture);
	// // customer.setIsvalid(1);
	// // customer.setDelflag(0);
	// //
	// // vip.setId(UUID.randomUUID().toString());
	// // vip.setCashback(BigDecimal.valueOf(0.00));
	// // vip.setBalance(BigDecimal.valueOf(0.00));
	// // vip.setType("VIP0");
	// // vip.setServiceshop(((UserLoginInfo) request.getSession()
	// // .getAttribute("loginUser")).getDepartid());
	// // vip.setScore(BigDecimal.valueOf(0.00));
	// // vip.setIsvalid(1);
	// // vip.setDelflag(0);
	// // vip.setOwnerdeptid(((UserLoginInfo) request.getSession()
	// // .getAttribute("loginUser")).getOwnerdepartid());
	// // vip.setCustomerid(customerid);
	// // vip.setIsvalid(1);
	// // vip.setDelflag(0);
	// //
	// // this.customerService.addCustomer(customer);
	// // this.customerService.addCustomerVIP(vip);
	// //
	// // addCustomer++;
	// //
	// // }
	//
	// UserLoginInfo loginInfo = (UserLoginInfo)
	// request.getSession().getAttribute("loginUser");
	// if(loginInfo==null){
	// log.error("尚未登录，请先登录！");
	// jsonBean = new ResultJsonBean(false, null, "-1","尚未登录，请先登录！");
	// return jsonBean;
	// }
	//
	// //默认入参
	// Customer customer = new Customer();
	// customer.setTel(tel);
	//
	// // 新增订单到订单表中
	// String ordercode = null;
	// ordercode = OrderCodeFactory.makeOrderCode(loginInfo.getDepartid());
	// if (ordercode == null || "".equalsIgnoreCase(ordercode)) {
	// jsonBean = new ResultJsonBean(false, null, "-1","ordercode生成失败！");
	// return jsonBean;
	// }
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<CustomerBaseInfo> cl =
	// this.customerService.getCustomerInfoBase(customer,"1");
	// if(cl == null || cl.size() == 0){
	// jsonBean = new ResultJsonBean(false, cl, "-1","客户不存在！");
	// return jsonBean;
	// }
	// String customerid =cl.get(0).getCustomerid();
	//
	// BigDecimal orderamount =
	// BigDecimal.valueOf(Double.parseDouble(ParamsUtil.initFilter(request.getParameter("orderamount"),
	// "0")));
	// String action =
	// ParamsUtil.initFilter(request.getParameter("action"),null);
	// String isurgent = ParamsUtil.initFilter(request.getParameter("isurgent"),
	// "0");
	// Order order = new Order();
	//
	// order.setOrdercode(ordercode);
	// order.setCustomerid(customerid);
	// order.setCustomername(customername);
	// order.setOrderamount(orderamount);
	// order.setIsurgent(isurgent);
	// order.setTel(tel);
	// order.setServicer(loginInfo.getUserid());
	// if ("save".equalsIgnoreCase(action)) {
	// order.setOrderstatus("0");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
	// // 100：已完成
	// } else if ("add".equalsIgnoreCase(action)) {
	// order.setOrderstatus("1");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
	// // 100：已完成
	// } else if ("drop".equalsIgnoreCase(action)) {
	// order.setOrderstatus("-1");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
	// // 100：已完成
	// } else if ("delete".equalsIgnoreCase(action)) {
	// order.setDelflag(1);// 删除标志（0：未删除，1：已删除）
	// }
	// order.setOrderamount(orderamount);
	// order.setServiceshop(loginInfo.getDepartid());
	// order.setOwnerdeptid(loginInfo.getOwnerdepartid());
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// int addOrder = this.orderService.addOrder(order);
	//
	// int addOrderDetail = 0;
	// int addCustomerData = 0;
	// int addCustomerDataZoon = 0;
	// int addCustomerMeasureData = 0;
	// int addCustomerMeasureDataZoon = 0;
	// int addProductDetail = 0;
	//
	// for (int i = 0; i < orderdetaillist.size(); i++) {
	// // 新增订单详情产品到订单详情表中
	//
	// String productstyle =
	// ParamsUtil.initFilter(orderdetaillist.get(i).get("productstyle"), "");
	// String producttype = "";
	// BigDecimal count =
	// BigDecimal.valueOf(Double.parseDouble(ParamsUtil.initFilter(orderdetaillist.get(i).get("count"),
	// "")));
	// // 售价写死
	// // BigDecimal price =
	// // BigDecimal.valueOf(Double.parseDouble(ParamsUtil
	// // .initFilter(orderdetaillist.get(i).get("price"), "")));
	// saleSetting.setSalesettype("SALLPRICE");
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// String stylecode = bomInfoService.getStyleCode(productstyle);
	// if (stylecode == null) {
	// log.error("获取不到款式信息！");
	// jsonBean = new ResultJsonBean(false, null, "-1", "获取不到款式信息！");
	// return jsonBean;
	// }
	// saleSetting.setSalesetcode(stylecode);
	// saleSetting.setOwerdeptid(loginInfo.getOwnerdepartid());
	// String bomcode =
	// ParamsUtil.initFilter(orderdetaillist.get(i).get("fabriccode"), "");
	// // 获取售价
	// // BigDecimal price =
	// getPrice(saleSetting,bomcode,loginInfo.getOwnerdepartid());
	// String exprice=request.getParameter("total_price");
	// BigDecimal price = BigDecimal.valueOf(Double.valueOf(exprice));
	// String bomname =
	// ParamsUtil.initFilter(orderdetaillist.get(i).get("fabricname"), "");
	// String remark =
	// ParamsUtil.initFilter(orderdetaillist.get(i).get("remark"), "");
	// isurgent = orderdetaillist.get(i).get("isurgent");
	// String ismastermeasure = orderdetaillist.get(i).get("master");
	// if ("商品".equals(productstyle)) {
	// productstyle = "商品";
	// producttype = "商品";
	// } else if ("长袖衬衫".equals(productstyle)
	// || "短袖衬衫".equals(productstyle) || "西服".equals(productstyle)
	// || "马甲".equals(productstyle) || "裤子".equals(productstyle)) {
	// producttype = "ML";// 面料
	// } else {
	// log.error("款式参数传递错误！");
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<OrderDetail> odl =
	// this.orderDetailService.getOrderDetaiByOrderCode(ordercode);
	// String exDetailCode = "";
	// if (odl != null && odl.size() != 0) {
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// exDetailCode =
	// this.orderDetailService.getOrderDetaiByOrderCode(ordercode).get(0).getDetailcode();
	// } else {
	// exDetailCode = ordercode + "-00";
	// }
	// String num =
	// String.valueOf(Integer.parseInt(exDetailCode.substring(exDetailCode.length()
	// - 2)) + 1);
	// if (num != null && num != "") {
	// if (num.length() == 1) {
	// num = "0" + num;
	// }
	// }
	// String detailcode = ordercode + "-" + num;
	// OrderDetail orderdetail1 = new OrderDetail();
	// orderdetail1.setDetailcode(detailcode);
	// orderdetail1.setOrdercode(ordercode);
	// orderdetail1.setProductstyle(stylecode);
	// orderdetail1.setProducttype(producttype);
	// orderdetail1.setCount(count);
	// orderdetail1.setBomcount(count);
	// orderdetail1.setPrice(price);
	// orderdetail1.setBatch("0");
	// orderdetail1.setBomcode(bomcode);
	// orderdetail1.setBomname(bomname);
	// orderdetail1.setIsurgent(isurgent);
	// orderdetail1.setIsmastermeasure(ismastermeasure);
	// orderdetail1.setRemark(remark);
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.orderDetailService.addOrderDetail(orderdetail1);
	// addOrderDetail++;
	//
	// // 新增量体信息到OrderCustomerData中
	// CustomerData customerdata = new CustomerData();
	//
	// String surveyor =
	// ParamsUtil.initFilter(orderdetaillist.get(i).get("surveyor"), null);
	// String style =
	// ParamsUtil.initFilter(orderdetaillist.get(i).get("productstyle"), null);
	//
	// if(surveyor==null || style==null){
	// log.error("新增订单量体信息不完整！");
	// jsonBean = new ResultJsonBean(false,null,"-1","新增订单量体信息不完整！");
	// return jsonBean;
	//
	// }
	//
	// customerdata.setOrdercode(ordercode);
	// customerdata.setDetailcode(detailcode);
	// customerdata.setCustomerid(customerid);
	// customerdata.setSurveyor(surveyor);
	// customerdata.setStyle(style);
	// String[] data1 = orderdetaillist.get(i).get("data1").split(",");
	// customerdata.setData1(data1[0]);
	// customerdata.setData2(data1[1]);
	// customerdata.setData3(data1[2]);
	// customerdata.setData4(data1[3]);
	// customerdata.setData5(data1[4]);
	// customerdata.setData6(data1[5]);
	// customerdata.setData7(data1[6]);
	// customerdata.setData8(data1[7]);
	// customerdata.setData9(data1[8]);
	// customerdata.setData10(data1[9]);
	// if ("长袖衬衫".equals(productstyle) || "短袖衬衫".equals(productstyle)
	// || "西服".equals(productstyle) || "马甲".equals(productstyle)) {
	// customerdata.setData11(data1[10]);
	// customerdata.setData12(data1[11]);
	// customerdata.setData13(data1[12]);
	// customerdata.setData14(data1[13]);
	// customerdata.setData15(data1[14]);
	// customerdata.setData16(data1[15]);
	// customerdata.setData17(data1[16]);
	// customerdata.setData18(data1[17]);
	// customerdata.setData19(data1[18]);
	// customerdata.setData20(data1[19]);
	// customerdata.setData21(data1[20]);
	// customerdata.setData22(data1[21]);
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerDataService.addCustomerData(customerdata);
	//
	// addCustomerData++;
	//
	// // 新增量体信息到customerMeasureData表中
	// CustomerMeasureData customermeasuredata = new CustomerMeasureData();
	//
	// customermeasuredata.setCustomerid(customerid);
	// customermeasuredata.setSurveyor(surveyor);
	// if ("裤子".equalsIgnoreCase(style)) {
	// customermeasuredata.setStyle("DOWN");
	// } else {
	// customermeasuredata.setStyle("UPPER");
	// }
	// // String[] data1 = orderdetaillist.get(i).get("data1").split(",");
	// customermeasuredata.setData1(data1[0]);
	// customermeasuredata.setData2(data1[1]);
	// customermeasuredata.setData3(data1[2]);
	// customermeasuredata.setData4(data1[3]);
	// customermeasuredata.setData5(data1[4]);
	// customermeasuredata.setData6(data1[5]);
	// customermeasuredata.setData7(data1[6]);
	// customermeasuredata.setData8(data1[7]);
	// customermeasuredata.setData9(data1[8]);
	// customermeasuredata.setData10(data1[9]);
	// if ("长袖衬衫".equals(productstyle) || "短袖衬衫".equals(productstyle)
	// || "西服".equals(productstyle) || "马甲".equals(productstyle)) {
	// customermeasuredata.setData11(data1[10]);
	// customermeasuredata.setData12(data1[11]);
	// customermeasuredata.setData13(data1[12]);
	// customermeasuredata.setData14(data1[13]);
	// customermeasuredata.setData15(data1[14]);
	// customermeasuredata.setData16(data1[15]);
	// customermeasuredata.setData17(data1[16]);
	// customermeasuredata.setData18(data1[17]);
	// customermeasuredata.setData19(data1[18]);
	// customermeasuredata.setData20(data1[19]);
	// customermeasuredata.setData21(data1[20]);
	// customermeasuredata.setData22(data1[21]);
	// }
	// // 如果存在客户信息 则更新，不存在则新增
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<CustomerMeasureData> exit = this.customerMeasureDataService
	// .getCustomerMeasureData(customerid,customermeasuredata.getStyle());
	// if (exit != null && exit.size() != 0) {
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerMeasureDataService.updateCustomerMeasureData(customermeasuredata);
	// } else {
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerMeasureDataService.addCustomerMeasureData(customermeasuredata);
	// }
	//
	// addCustomerMeasureData++;
	//
	// // 新增量体收放信息到收放表中
	// CustomerDataZoon customerdatazoon = new CustomerDataZoon();
	//
	// customerdatazoon.setOrdercode(ordercode);
	// customerdatazoon.setDetailcode(detailcode);
	// customerdatazoon.setCustomerid(customerid);
	// customerdatazoon.setSurveyor(surveyor);
	// String[] data2 = orderdetaillist.get(i).get("data2").split(",");
	// customerdatazoon.setStyle(style);
	// customerdatazoon.setData1(data2[0]);
	// customerdatazoon.setData2(data2[1]);
	// customerdatazoon.setData3(data2[2]);
	// customerdatazoon.setData4(data2[3]);
	// customerdatazoon.setData5(data2[4]);
	// customerdatazoon.setData6(data2[5]);
	// customerdatazoon.setData7(data2[6]);
	// customerdatazoon.setData8(data2[7]);
	// customerdatazoon.setData9(data2[8]);
	// customerdatazoon.setData10(data2[9]);
	// if ("长袖衬衫".equals(productstyle) || "短袖衬衫".equals(productstyle)
	// || "西服".equals(productstyle) || "马甲".equals(productstyle)) {
	// customerdatazoon.setData11(data2[10]);
	// customerdatazoon.setData12(data2[11]);
	// customerdatazoon.setData13(data2[12]);
	// customerdatazoon.setData14(data2[13]);
	// customerdatazoon.setData15(data2[14]);
	// customerdatazoon.setData16(data2[15]);
	// customerdatazoon.setData17(data2[16]);
	// customerdatazoon.setData18(data2[17]);
	// customerdatazoon.setData19(data2[18]);
	// customerdatazoon.setData20(data2[19]);
	// customerdatazoon.setData21(data2[20]);
	// customerdatazoon.setData22(data2[21]);
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerDataZoonService.addCustomerDataZoon(customerdatazoon);
	//
	// addCustomerDataZoon++;
	//
	// // 新增收放信息到CustomerMeasureDataZoon
	// CustomerMeasureDataZoon customermeasuredatazoon = new
	// CustomerMeasureDataZoon();
	//
	// customermeasuredatazoon.setCustomerid(customerid);
	// customermeasuredatazoon.setSurveyor(surveyor);
	// // String[] data2 = orderdetaillist.get(i).get("data2").split(",");
	// customermeasuredatazoon.setStyle(stylecode);
	// customermeasuredatazoon.setData1(data2[0]);
	// customermeasuredatazoon.setData2(data2[1]);
	// customermeasuredatazoon.setData3(data2[2]);
	// customermeasuredatazoon.setData4(data2[3]);
	// customermeasuredatazoon.setData5(data2[4]);
	// customermeasuredatazoon.setData6(data2[5]);
	// customermeasuredatazoon.setData7(data2[6]);
	// customermeasuredatazoon.setData8(data2[7]);
	// customermeasuredatazoon.setData9(data2[8]);
	// customermeasuredatazoon.setData10(data2[9]);
	// if ("长袖衬衫".equals(productstyle) || "短袖衬衫".equals(productstyle)
	// || "西服".equals(productstyle) || "马甲".equals(productstyle)) {
	// customermeasuredatazoon.setData11(data2[10]);
	// customermeasuredatazoon.setData12(data2[11]);
	// customermeasuredatazoon.setData13(data2[12]);
	// customermeasuredatazoon.setData14(data2[13]);
	// customermeasuredatazoon.setData15(data2[14]);
	// customermeasuredatazoon.setData16(data2[15]);
	// customermeasuredatazoon.setData17(data2[16]);
	// customermeasuredatazoon.setData18(data2[17]);
	// customermeasuredatazoon.setData19(data2[18]);
	// customermeasuredatazoon.setData20(data2[19]);
	// customermeasuredatazoon.setData21(data2[20]);
	// customermeasuredatazoon.setData22(data2[21]);
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<CustomerMeasureDataZoon> flag = customerMeasureDataZoonService
	// .getCustomerMeasureDataZoon(customerid, style);
	// if (flag == null || flag.size() == 0) {
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerMeasureDataZoonService.addCustomerMeasureDataZoon(customermeasuredatazoon);
	// } else {
	// DynamicDataSource
	// .setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerMeasureDataZoonService.updateCustomerMeasureDataZoon(customermeasuredatazoon);
	// }
	//
	// addCustomerMeasureDataZoon++;
	//
	// // 新增产品详情到产品详情表中
	//
	// ProductDetail prodectdetail = new ProductDetail();
	//
	// String detai = orderdetaillist.get(i).get("details");
	// Map<String, String> detailmap = new HashMap<String, String>();
	// detailmap = JsonHelper.toMap(detai);
	// prodectdetail.setDetailcode(detailcode);
	// prodectdetail.setOrdercode(ordercode);
	// prodectdetail.setProductstyle(style);
	//
	// if ("西服".equalsIgnoreCase(style)) {
	// prodectdetail.setDetail1(detailmap.get("口袋"));
	// prodectdetail.setDetail2(detailmap.get("门襟扣型"));
	// prodectdetail.setDetail3(detailmap.get("领型"));
	// prodectdetail.setDetail4(detailmap.get("下摆"));
	// prodectdetail.setDetail5(detailmap.get("胸袋"));
	// prodectdetail.setDetail6(detailmap.get("后摆"));
	// prodectdetail.setDetail7(detailmap.get("袖口"));
	// } else if ("裤子".equalsIgnoreCase(style)) {
	// prodectdetail.setDetail1(detailmap.get("裤兜"));
	// prodectdetail.setDetail2(detailmap.get("裤褶"));
	// prodectdetail.setDetail3(detailmap.get("裤袋"));
	// prodectdetail.setDetail4(detailmap.get("裤扣"));
	// prodectdetail.setDetail5(detailmap.get("裤脚"));
	// prodectdetail.setDetail6(detailmap.get("裤腰"));
	// } else if ("长袖衬衫".equalsIgnoreCase(style)) {
	// prodectdetail.setDetail1(detailmap.get("领子"));
	// prodectdetail.setDetail2(detailmap.get("门襟"));
	// prodectdetail.setDetail3(detailmap.get("下摆"));
	// prodectdetail.setDetail4(detailmap.get("袖子"));
	// } else if ("马甲".equalsIgnoreCase(style)) {
	// prodectdetail.setDetail1(detailmap.get("下摆"));
	// prodectdetail.setDetail2(detailmap.get("扣子"));
	// prodectdetail.setDetail3(detailmap.get("领子"));
	// prodectdetail.setDetail4(detailmap.get("口袋"));
	// } else if ("短袖衬衫".equalsIgnoreCase(style)) {
	// prodectdetail.setDetail1(detailmap.get("领子"));
	// prodectdetail.setDetail2(detailmap.get("门襟"));
	// prodectdetail.setDetail3(detailmap.get("下摆"));
	// prodectdetail.setDetail4(detailmap.get("袖子"));
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.productDetailService.addProductDetail(prodectdetail);
	//
	// addProductDetail++;
	//
	// }
	//
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("ordercode", ordercode);
	// // map.put("addCustomer", String.valueOf(addCustomer));
	// map.put("addOrder", String.valueOf(addOrder));
	// map.put("addOrderDetail", String.valueOf(addOrderDetail));
	// map.put("addCustomerData", String.valueOf(addCustomerData));
	// map.put("addCustomerDataZoon", String.valueOf(addCustomerDataZoon));
	// map.put("addCustomerMeasureData",String.valueOf(addCustomerMeasureData));
	// map.put("addCustomerMeasureDataZoon",String.valueOf(addCustomerMeasureDataZoon));
	// map.put("addProdecuDetail", String.valueOf(addProductDetail));
	// jsonBean = new ResultJsonBean(true, map,"1","下单成功！");
	//
	// return jsonBean;
	//
	// }

	/**
	 * 
	 * 业  务: 下载模型图片 <br>
	 * 英文名: downloadImage 
	 * 功能号: TODO
	 * 时  间: 2016年8月30日 上午8:47:54
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
	@RequestMapping("/downloadImage")
	public String downloadImage(HttpServletRequest request,
			HttpServletResponse response) {
		// 项目名称
		String path = request.getContextPath();
		// 完整下载路径
		String downloadPath = request.getScheme() + "://" + serverIP + ":"
				+ request.getServerPort() + path + "/download/image.zip";
		return downloadPath;
	}

	/**
	 * 
	 * 业  务: 上传形体照 <br>
	 * 英文名: uploadPicture 
	 * 功能号: TODO
	 * 时  间: 2016年8月30日 下午3:06:20
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
	public void uploadPicture(HttpServletRequest request,
			HttpServletResponse response) {
		// 创建一个临时文件存放要上传的文件，第一个参数为上传文件大小，第二个参数为存放的临时目录
		DiskFileItemFactory factory = new DiskFileItemFactory(1024 * 1024 * 10,
				new File("D:\\uploadPictureTemp"));
		// 设置缓冲区大小为 10M
		factory.setSizeThreshold(1024 * 1024 * 10);
		// 创建一个文件上传的句柄
		ServletFileUpload upload = new ServletFileUpload(factory);

		// 设置上传文件的整个大小和上传的单个文件大小
		upload.setSizeMax(1024 * 1024 * 30);
		upload.setFileSizeMax(1024 * 1024 * 10);
		String[] fileExts = { "doc", "zip", "rar", "jpg", "txt", "png" };
		try { // 把页面表单中的每一个表单元素解析成一个FileItem
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem fileItem : items) {
				// 如果是一个普通的表单元素(type不是file的表单元素)
				if (fileItem.isFormField()) {
					log.warn(fileItem.getFieldName()
							+ "只是一个普通的表单元素，type不是file的表单元素！");
					// 得到对应表单元素的名字
					log.warn("表单元素的名字是：=========" + fileItem.getString());
					// 得到表单元素的值
				} else {
					// 得到文件的名字
					String fileName = fileItem.getName();
					String exFile = fileName.substring(0,
							fileName.lastIndexOf("."));
					// 获取文件的后缀名
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1, fileName.length());
					// 二分法验证上传文件是否符合要求
					if (Arrays.binarySearch(fileExts, fileExt) != -1) {
						try {
							// 上传形体照的路径
							File file = new File(uploadBasePath
									+ "UserFileStore/Order/" + exFile);
							// 创建目录
							file.mkdirs();
							// 写入上传的文件
							fileItem.write(new File(uploadBasePath
									+ "UserFileStore/Order/" + exFile + "/"
									+ UUID.randomUUID().toString() + "."
									+ fileExt));
							log.info("文件上传路径："
									+ request.getServletContext().getRealPath(
											"/upload/pictures") + "/"
									+ UUID.randomUUID().toString() + "."
									+ fileExt);
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						log.error("该文件类型不能够上传!!!");
					}
				}
			}
		} catch (FileUploadBase.SizeLimitExceededException e) {
			log.error("整个请求的大小超过了规定的大小...", e);
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			log.error("请求中一个上传文件的大小超过了规定的大小...", e);
		} catch (FileUploadException e) {
			log.error("上传形体照片失败！", e);
		}
	}

	@RequestMapping("/uploadPicture2")
	public void uploadPicture2(HttpServletRequest request,
			HttpServletResponse response) {
		// 定义变量存储图片地址
		String savePath = request.getServletContext().getRealPath(
				"/upload/pictures");
		// 接收图片数据 （base64）
		String image = request.getParameter("image");
		String fileName = UUID.randomUUID().toString();
		String url = savePath + "/" + fileName + ".png";
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File outFile = new File(url);
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(image);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
		} catch (Exception e) {
			log.error("Base64转换图片失败！", e);
		}
		log.info("Base64转换图片成功！");
	}

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
	public BigDecimal getPrice(SaleSetting salesetting, String bomcode,
			String ownerdeptid) {
		String percent = null;
		BigDecimal price = null;
		String basePrice = null;
		// 优先查询当前门店设置的价格折扣，如果没有设置，则查询SYS系统设置的折扣价格
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		SaleSetting salesetting1 = this.saleSettingService
				.getSaleSetting(salesetting);
		if (salesetting1 == null) {
			salesetting.setOwerdeptid("SYS");
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			salesetting1 = this.saleSettingService.getSaleSetting(salesetting);
			if (salesetting1 == null) {
				percent = "";
				log.error("SYS_SaleSetting表中未设置相关价格参数！");
			} else {
				percent = salesetting1.getValuei();
			}
		} else {
			percent = salesetting1.getValuei();
		}
		// 折扣
		Double discount = Calculate.div(Double.valueOf(percent), 100);
		// 确认价格
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		List<BomFabric> bomInfoList = this.bomInfoService.getBomInfo(bomcode,
				"", ownerdeptid, "", "1");
		if (bomInfoList != null && bomInfoList.size() != 0) {
			basePrice = bomInfoList.get(0).getSellprice();
		} else {
			log.error("查询不到匹配的物料信息！");
			return null;
		}
		price = BigDecimal.valueOf(Calculate.mul(Double.valueOf(basePrice),
				discount));

		return price;
	}

	// /**
	// *
	// * 业 务: 门店下面料订单 <br>
	// * 英文名: BomOrder
	// * 功能号: TODO
	// * 时 间: 2016年10月8日 下午2:41:03
	// * 应用项目: 中依睿晟新增订单APP后台管理系统
	// * 作者: 严昊 <br>
	// *
	// * 入参：TODO
	// * TODO TODO TODO
	// TODO TODO TODO
	//
	// *
	// * 出参：JSON
	// */
	// @ResponseBody
	// @RequestMapping("/addBomOrder")
	// public ResultJsonBean addBomOrder(HttpServletRequest request,
	// HttpServletResponse response) {
	// ResultJsonBean rjb = null;
	// BomOrder bomorder = new BomOrder();
	//
	// String ordercompany =
	// ParamsUtil.initFilter(request.getParameter("ordercompany"), null);
	// String address = ParamsUtil.initFilter(request.getParameter("address"),
	// null);
	// String tel = ParamsUtil.initFilter(request.getParameter("tel"), null);
	// String contacts = ParamsUtil.initFilter(request.getParameter("contacts"),
	// null);
	// String bomcode = ParamsUtil.initFilter(request.getParameter("bomcode"),
	// null);
	// String num = ParamsUtil.initFilter(request.getParameter("num"), null);
	//
	// if (ordercompany == null || address == null || tel == null || contacts ==
	// null || bomcode == null || num == null) {
	// log.error("参数不完整，请检查参数！");
	// rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数！");
	// return rjb;
	// }
	// String[] bomcodelist = bomcode.split(",");
	// String[] numlist = num.split(",");
	// if (bomcodelist.length != numlist.length) {
	// log.error("面料编码和面料数量参数个数不吻合，请检查参数！");
	// rjb = new ResultJsonBean(false, null, "-1",
	// "面料编码和面料数量参数个数不吻合，请检查参数！");
	// return rjb;
	// }
	// bomorder.setOrdercode(UUID.randomUUID().toString());
	// // bomorder.setBomcode(bomcode);
	// // bomorder.setNum(num);
	// bomorder.setAddress(address);
	// bomorder.setContacts(contacts);
	// bomorder.setOrdercompany(ordercompany);
	// bomorder.setTel(tel);
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
	// int res = orderService.addBomOrder(bomorder);
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
	// int res1 = orderService.addBomOrder1(bomorder);
	// int res2 = 0;
	// for (int i = 0; i < bomcodelist.length; i++) {
	// bomorder.setBomcode(bomcodelist[i]);
	// bomorder.setNum(numlist[i]);
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_2);
	// res2 = orderService.addBomOrder2(bomorder);
	// }
	// if (res >= 0 && res1 >= 0 && res2 >= 0) {
	// log.info("面料下单成功！");
	// rjb = new ResultJsonBean(true, res, "1", "面料下单成功！");
	// }
	// return rjb;
	//
	// }
	//
	// @ResponseBody
	// @RequestMapping("/addPreOrder")
	// public ResultJsonBean addPreOrder(HttpServletRequest request,
	// HttpServletResponse response) {
	// ResultJsonBean jsonBean = null;
	// SaleSetting saleSetting = new SaleSetting();
	// String customername =
	// ParamsUtil.initFilter(request.getParameter("customername"),null);
	// String tel = ParamsUtil.initFilter(request.getParameter("tel"),null);
	//
	// // BigDecimal height = BigDecimal.valueOf(Double.parseDouble(request
	// // .getParameter("height")));
	// // BigDecimal weight = BigDecimal.valueOf(Double.parseDouble(request
	// // .getParameter("weight")));
	// // Integer gender = Integer.valueOf(request.getParameter("gender"));
	// // String picture = request.getParameter("picture");
	// String productdetail =
	// ParamsUtil.initFilter(request.getParameter("productdetail"),null);
	//
	// //默认入参
	// Customer customer = new Customer();
	// customer.setTel(tel);
	//
	// if(customername==null||tel==null||productdetail==null){
	// log.error("参数不完整，请检查参数！");
	// jsonBean= new ResultJsonBean(false,null,"-1","参数不完整，请检查参数！");
	// return jsonBean;
	// }
	// UserLoginInfo uli = (UserLoginInfo)
	// request.getSession().getAttribute("loginUser");
	// if(uli==null){
	// log.error("尚未登录，请先登录！");
	// jsonBean = new ResultJsonBean(false, "ordercode", "-1", "尚未登录，请先登录！");
	// return jsonBean;
	//
	// }
	//
	// // 将orderDetail 数组转换成map型
	// // String[] arr = productdetail.split("},");
	// String[] arr = productdetail.split(",");
	// List<Map<String, String>> productdetaillist = new ArrayList<Map<String,
	// String>>(
	// arr.length);
	// try {
	// // if (arr.length == 1) {
	// // String demo = arr[0].replace("=", ":");
	// // Map<String, String> map = JsonHelper.toMap(demo);
	// // productdetaillist.add(map);
	// // } else if (arr.length > 1) {
	// for (int i = 0; i < arr.length; i++) {
	// // String demo = arr[i].replace("=", ":");
	// // if (i < arr.length - 1) {
	// // demo = demo + "}";
	// // }
	// Map<String, String> map = JsonHelper.toMap(arr[i]);
	// productdetaillist.add(map);
	// }
	// // }
	// } catch (Exception e) {
	// log.error("productdetaillist转换成map出错！");
	// jsonBean= new
	// ResultJsonBean(false,null,"-1","productdetaillist转换成map出错！");
	// return jsonBean;
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<CustomerBaseInfo> cl =
	// this.customerService.getCustomerInfoBase(customer,"1");
	// int addCustomer = 0;
	// String customerid=null;
	//
	// if (cl == null ||cl.size() == 0) {
	// // 新增客户信息到客户表中
	//
	// Customer customer1 = new Customer();
	// CustomerVIP vip = new CustomerVIP();
	//
	// customerid = UUID.randomUUID().toString();
	// customer1.setCustomerid(customerid);
	// customer1.setCustomername(customername);
	// customer1.setGender("1");// 默认设性别为1
	// customer1.setTel(tel);
	// customer1.setCustomertype("VIP0");
	// customer1.setIsvip("0");
	// // customer.setHeight(height);
	// // customer.setWeight(weight);
	// // customer.setPicture(picture);
	// customer1.setIsvalid("1");
	// customer1.setDelflag("0");
	//
	// vip.setId(UUID.randomUUID().toString());
	// vip.setCashback(BigDecimal.valueOf(0.00));
	// vip.setBalance(BigDecimal.valueOf(0.00));
	// vip.setType("VIP0");
	// vip.setServiceshop(uli.getDepartid());
	// vip.setScore(BigDecimal.valueOf(0.00));
	// vip.setIsvalid(1);
	// vip.setDelflag(0);
	// vip.setOwnerdeptid(uli.getOwnerdepartid());
	// vip.setCustomerid(customerid);
	// vip.setIsvalid(1);
	// vip.setDelflag(0);
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerService.addCustomer(customer1);
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.customerService.addCustomerVIP(vip);
	//
	// addCustomer++;
	//
	// }
	// // 新增订单到订单表中
	// String ordercode = null;
	// ordercode = OrderCodeFactory.makeOrderCode(uli.getDepartid());
	// if (ordercode == null || "".equalsIgnoreCase(ordercode)) {
	// jsonBean = new ResultJsonBean(false, "ordercode", "-1",
	// "ordercode生成失败！");
	// return jsonBean;
	// }
	// // UserLoginInfo loginInfo = (UserLoginInfo) request.getSession()
	// // .getAttribute("loginUser");
	// //
	// // String customerid = this.customerService.getCustomer(tel)
	// // .getCustomerid();
	//
	// BigDecimal orderamount =
	// BigDecimal.valueOf(Double.parseDouble(ParamsUtil.initFilter(request.getParameter("orderamount"),
	// "0")));
	//
	// Order order = new Order();
	//
	// order.setOrdercode(ordercode);
	// order.setCustomerid(customerid);
	// order.setCustomername(customername);
	// order.setOrderamount(orderamount);
	// order.setTel(tel);
	// order.setServicer(uli.getUserid());
	// order.setOrderstatus("0");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算
	// order.setOrderamount(orderamount);
	// order.setServiceshop(uli.getDepartid());
	// order.setOwnerdeptid(uli.getOwnerdepartid());
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// int addOrder = this.orderService.addOrder(order);
	//
	// int addOrderDetail = 0;
	// int addProductDetail = 0;
	//
	// for (int i = 0; i < productdetaillist.size(); i++) {
	// // 新增订单详情产品到订单详情表中
	//
	// String productstyle =
	// ParamsUtil.initFilter(productdetaillist.get(i).get("productstyle"), "");
	// String producttype = "";
	// BigDecimal count =
	// BigDecimal.valueOf(Double.parseDouble(ParamsUtil.initFilter(productdetaillist.get(i).get("count"),
	// "1")));
	// // 售价写死
	// // BigDecimal price =
	// // BigDecimal.valueOf(Double.parseDouble(ParamsUtil
	// // .initFilter(orderdetaillist.get(i).get("price"), "")));
	// saleSetting.setSalesettype("SALLPRICE");
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// String stylecode = bomInfoService.getStyleCode(productstyle);
	// if (stylecode == null) {
	// log.error("获取不到款式信息！");
	// jsonBean = new ResultJsonBean(false, null, "-1", "获取不到款式信息！");
	// return jsonBean;
	// }
	// saleSetting.setSalesetcode(stylecode);
	// saleSetting.setOwerdeptid(uli.getOwnerdepartid());
	// String bomcode =
	// ParamsUtil.initFilter(productdetaillist.get(i).get("fabriccode"), "");
	// // 获取售价
	// BigDecimal price = getPrice(
	// saleSetting,
	// bomcode,
	// uli.getOwnerdepartid());
	// String bomname =
	// ParamsUtil.initFilter(productdetaillist.get(i).get("fabricname"), "");
	// String remark =
	// ParamsUtil.initFilter(productdetaillist.get(i).get("remark"), "");
	// String isurgent =
	// ParamsUtil.initFilter(productdetaillist.get(i).get("isurgent"), "0");
	// String ismastermeasure =
	// ParamsUtil.initFilter(productdetaillist.get(i).get("master"), "0");
	// if ("商品".equals(productstyle)) {
	// productstyle = "商品";
	// producttype = "商品";
	// } else if ("长袖衬衫".equals(productstyle)
	// || "短袖衬衫".equals(productstyle) || "西服".equals(productstyle)
	// || "马甲".equals(productstyle) || "裤子".equals(productstyle)) {
	// producttype = "ML";// 面料
	// } else {
	// log.error("款式参数传递错误！");
	// jsonBean = new ResultJsonBean(true, null,"-1","款式参数传递错误！");
	//
	// return jsonBean;
	// }
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// List<OrderDetail> odl =
	// this.orderDetailService.getOrderDetaiByOrderCode(ordercode);
	// String exDetailCode = "";
	// if (odl != null && odl.size() != 0) {
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// exDetailCode =
	// this.orderDetailService.getOrderDetaiByOrderCode(ordercode).get(0).getDetailcode();
	// } else {
	// exDetailCode = ordercode + "-00";
	// }
	// String num =
	// String.valueOf(Integer.parseInt(exDetailCode.substring(exDetailCode.length()
	// - 2)) + 1);
	// if (num != null && num != "") {
	// if (num.length() == 1) {
	// num = "0" + num;
	// }
	// }
	// String detailcode = ordercode + "-" + num;
	// OrderDetail orderdetail1 = new OrderDetail();
	// orderdetail1.setDetailcode(detailcode);
	// orderdetail1.setOrdercode(ordercode);
	// orderdetail1.setProductstyle(stylecode);
	// orderdetail1.setProducttype(producttype);
	// orderdetail1.setCount(count);
	// orderdetail1.setBomcount(count);
	// orderdetail1.setPrice(price);
	// orderdetail1.setBatch("0");
	// orderdetail1.setBomcode(bomcode);
	// orderdetail1.setBomname(bomname);
	// orderdetail1.setIsurgent(isurgent);
	// orderdetail1.setIsmastermeasure(ismastermeasure);
	// orderdetail1.setRemark(remark);
	//
	// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
	// this.orderDetailService.addOrderDetail(orderdetail1);
	// addOrderDetail++;
	// }
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("ordercode", ordercode);
	// map.put("addCustomer", String.valueOf(addCustomer));
	// map.put("addOrder", String.valueOf(addOrder));
	// map.put("addOrderDetail", String.valueOf(addOrderDetail));
	// map.put("addProdecuDetail", String.valueOf(addProductDetail));
	// jsonBean = new ResultJsonBean(true, map,"1","下单成功！");
	//
	// return jsonBean;
	// }

	/**
	 * 
	 * 业  务: 计算产品详情价格 <br>
	 * 英文名: getPrice 
	 * 功能号: TODO
	 * 时  间: 2016年11月13日 下午4:28:03
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
	public ResultJsonBean getPrice(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String ps = request.getParameter("style");
		String bc = request.getParameter("bomcode");

		// 校验参数
		if (ps == null || bc == null) {
			log.error("参数不完整，请检查参数！");
			rjb = new ResultJsonBean(false, null, "-1", "参数不完整，请检查参数！");
			return rjb;
		}

		UserLoginInfo uli = (UserLoginInfo) request.getSession().getAttribute(
				"loginUser");
		// 验证登录
		if (uli == null) {
			log.error("尚未登录，请先登录！");
			rjb = new ResultJsonBean(false, null, "-1", "尚未登录，请先登录！");
			return rjb;
		}

		SaleSetting ss = new SaleSetting();
		ss.setSalesettype("SALLPRICE");
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		String stylecode = bomInfoService.getStyleCode(ps);
		if (stylecode == null) {
			log.error("获取不到款式信息！");
			rjb = new ResultJsonBean(false, null, "-1", "获取不到款式信息！");
			return rjb;
		}
		ss.setSalesetcode(stylecode);
		ss.setOwerdeptid(uli.getOwnerdepartid());
		String price = String.valueOf(getPrice(ss, bc, uli.getOwnerdepartid()));

		// 验证结果
		if ("null".equalsIgnoreCase(price)) {
			log.error("查询不到匹配的信息！");
			rjb = new ResultJsonBean(false, price, "-1", "查询不到匹配的信息！");
			return rjb;
		}
		rjb = new ResultJsonBean(true, price, "1", "获取价格成功！");
		return rjb;

	}

	/**
	 * 
	 * 业  务: 获取工艺信息 <br>
	 * 英文名: showCraft 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午7:00:41
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
	@RequestMapping("/showCraft")
	public ResultJsonBean showCraft(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String type = request.getParameter("type");

		// 验证参数
		if (di == null) {
			log.error("[获取工艺信息]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[获取工艺信息]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[获取工艺信息]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[获取工艺信息]===>缺少门店密钥参数！<===");
			return rjb;
		}

		// 解析购物车参数信息

		// 验证合法用户
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[获取工艺信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[获取工艺信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
			String stylecode = "";

			if ("suit".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("西服");
			} else if ("shirt".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("长袖衬衫");
			} else if ("trousers".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("裤子");
			} else if ("vest".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("马甲");
			} else if ("coat".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("大衣");
			}

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			List<Craft> cl = this.orderService.getCraft(stylecode);
			if (cl.size() == 0) {
				log.error("[获取工艺信息]===>获取不到匹配的工艺信息！<===");
				rjb = new ResultJsonBean(false, cl, "-1",
						"[获取工艺信息]===>获取不到匹配的工艺信息！<===");
				return rjb;
			}

			rjb = new ResultJsonBean(true, cl, "1", "[获取工艺信息]===>查询成功！<===");
		}
		return rjb;
	}

	/**
	 * 
	 * 业  务: 获取特殊工艺信息 <br>
	 * 英文名: showSpecialCraft 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午7:31:34
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
	@RequestMapping("/showSpecialCraft")
	public ResultJsonBean showSpecialCraft(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String type = request.getParameter("type");

		// 验证参数
		if (di == null) {
			log.error("[获取特殊工艺信息]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[获取特殊工艺信息]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[获取特殊工艺信息]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[获取特殊工艺信息]===>缺少门店密钥参数！<===");
			return rjb;
		}

		// 解析购物车参数信息

		// 验证合法用户
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[获取特殊工艺信息]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[获取特殊工艺信息]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
			String stylecode = "";

			if ("suit".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("西服");
			} else if ("shirt".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("长袖衬衫");
			} else if ("trousers".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("裤子");
			} else if ("vest".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("马甲");
			} else if ("coat".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				stylecode = this.bomInfoService.getStyleCode("大衣");
			}

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			List<SpecialCraft> cl = this.orderService
					.getSpecialCraft(stylecode);
			if (cl.size() == 0) {
				log.error("[获取特殊工艺信息]===>获取不到匹配的工艺信息！<===");
				rjb = new ResultJsonBean(false, cl, "-1",
						"[获取特殊工艺信息]===>获取不到匹配的工艺信息！<===");
				return rjb;
			}

			rjb = new ResultJsonBean(true, cl, "1", "[获取特殊工艺信息]===>查询成功！<===");
		}
		return rjb;
	}

	/**
	 * 
	 * 业  务: 新增订单信息到订单表中 <br>
	 * 英文名: addOrder 
	 * 功能号: TODO
	 * 时  间: 2017年5月15日 下午6:38:09
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public ResultJsonBean addOrder(String ordercode, String di, String si,
			String ci, String orderamount, String isurgent,
			DeptLoginInfo dli) {
		ResultJsonBean rjb = null;
		// 1、新增订单到订单表中
		// 获取客户id
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		Customer customer = this.customerService.getCustomerInfoDetail(ci);
		if (customer == null) {
			rjb = new ResultJsonBean(false, customer, "-1", "客户不存在！");
			return rjb;
		}

		Order order = new Order();

		order.setOrdercode(ordercode);
		order.setCustomerid(ci);
		order.setCustomername(customer.getCustomername());
		order.setIsurgent(isurgent);
		order.setTel(customer.getTel());
		// 营业员
		order.setServicer(si);
		order.setOrderstatus("0");// 订单状态-1:已作废 0：预录入 1：已下单 11：已付款 21：已结算 100：完结
		order.setOrderamount(orderamount);
		order.setServiceshop(di);
		order.setOwnerdeptid(dli.getOwnerdept());

		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		int addOrder = this.orderService.addOrder(order);

		return rjb = new ResultJsonBean(true, addOrder, "1", "新增订单成功！");

	}

}
