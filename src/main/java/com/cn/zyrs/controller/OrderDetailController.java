//package com.cn.zyrs.controller;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.cn.zyrs.domain.OrderDetail;
//import com.cn.zyrs.domain.UserLoginInfo;
//import com.cn.zyrs.service.IOrder;
//import com.cn.zyrs.service.IOrderDetail;
//import com.cn.zyrs.utils.ParamsUtil;
//
//@Controller
//@RequestMapping("/orderDetail")
//public class OrderDetailController {
//
//	@Resource(name = "orderDetailService")
//	private IOrderDetail orderDetailService;
//
//	@Resource(name = "orderService")
//	private IOrder orderService;
//
//	@ResponseBody
//	@RequestMapping("/showOrderDetail")
//	public List<OrderDetail> showOrderDetail(HttpServletRequest request,
//			HttpServletResponse response) {
//		String ordercode = ParamsUtil.initFilter(
//				request.getParameter("ordercode"), null);
//		String odpid = ((UserLoginInfo)request.getSession().getAttribute("loginUser")).getOwnerdepartid();
//		return this.orderDetailService.getOrderDetail(ordercode, odpid);
//
//	}
//
//	/**
//	 * 
//	 * 业  务: 删除订单详情 <br>
//	 * 英文名: deleteOrderDetail 
//	 * 功能号: TODO
//	 * 时  间: 2016年8月17日 下午1:25:26
//	 * 应用项目: 中依睿晟新增订单APP后台管理系统
//	 * 作者: 严昊 <br>
//	 *
//	 * 入参：String detailcode
//	 * TODO   TODO	TODO
//		TODO	 TODO	TODO	
//		
//	 * 
//	 * 出参：int
//	 */
//	@ResponseBody
//	@RequestMapping("/deleteOrderDetail")
//	public int deleteOrderDetail(HttpServletRequest request,
//			HttpServletResponse response) {
//		String detailcode = ParamsUtil.initFilter(
//				request.getParameter("detailcode"), null);
//		return this.orderDetailService.deletdeOrderDetail(detailcode);
//
//	}
//
//	/**
//	 * 
//	 * 业  务: 新增订单详情产品 <br>
//	 * 英文名: addOrderDetail 
//	 * 功能号: TODO
//	 * 时  间: 2016年8月17日 下午3:43:00
//	 * 应用项目: 中依睿晟新增订单APP后台管理系统
//	 * 作者: 严昊 <br>
//	 *
//	 * 入参：TODO
//	 * TODO   TODO	TODO
//		TODO	 TODO	TODO	
//		
//	 * 
//	 * 出参：JSON
//	 */
//	@ResponseBody
//	@RequestMapping("/addOrderDetail")
//	public int addOrderDetail(HttpServletRequest request,
//			HttpServletResponse response) {
//
//		String ordercode = ParamsUtil.initFilter(request.getParameter("ordercode"), null);
//		String productstyle = ParamsUtil.initFilter(
//				request.getParameter("productstyle"), null);
//		String producttype = "";
//		BigDecimal count = BigDecimal.valueOf(Double.parseDouble(ParamsUtil
//				.initFilter(request.getParameter("count"), null)));
//		BigDecimal price = BigDecimal.valueOf(Double.parseDouble(ParamsUtil
//				.initFilter(request.getParameter("price"), null)));
//		String bomcode = ParamsUtil.initFilter(request.getParameter("bomcode"),
//				null);
//		String bomname = ParamsUtil.initFilter(request.getParameter("bomname"),
//				null);
//		if ("商品".equals(productstyle)) {
//			productstyle = "商品";
//			producttype = "商品";
//		} else if ("男衬衫".equals(productstyle) || "男马甲".equals(productstyle)
//				|| "大衣".equals(productstyle) || "女衬衫".equals(productstyle)
//				|| "上衣".equals(productstyle) || "男裤".equals(productstyle)) {
//			producttype = "面料";
//		} else {
//			System.err.println("款式参数传递错误！");
//		}
//		String exDetailCode = this.orderDetailService
//				.getOrderDetaiByOrderCode(ordercode).get(0).getDetailcode();
//		String num = String.valueOf(Integer.parseInt(exDetailCode
//				.substring(exDetailCode.length() - 2)) + 1);
//		if (num != null && num != "") {
//			if(num.length()==1){
//				num="0"+num;
//			}
//		}
//		String detailcode = ordercode + "-" + num;
//		OrderDetail orderdetail = new OrderDetail();
//		orderdetail.setDetailcode(detailcode);
//		orderdetail.setOrdercode(ordercode);
//		orderdetail.setProductstyle(productstyle);
//		orderdetail.setProducttype(producttype);
//		orderdetail.setCount(count);
//		orderdetail.setBomcount(count);
//		orderdetail.setPrice(price);
//		orderdetail.setBatch("0");
//		orderdetail.setBomcode(bomcode);
//		orderdetail.setBomname(bomname);
//		return this.orderDetailService.addOrderDetail(orderdetail);
//
//	}
//}
