package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;









import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.OrderDetail;
import com.cn.zyrs.mapper.OrderDetailMapper;
import com.cn.zyrs.service.IOrderDetail;

@Service("orderDetailService")
public class OrderDetailServiceImpl implements IOrderDetail {
	
	@Resource(name = "orderDetailMapper")
	private OrderDetailMapper orderDetailMapper;
	
	
	/**
	 * 
	 * 业  务: 获取订单详情 <br>
	 * 英文名: getOrderDetailByOrderCode 
	 * 功能号: TODO
	 * 时  间: 2016年8月10日 下午5:49:31
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：ordercode
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：List<OrderDetail>
	 */
	public List<OrderDetail> getOrderDetail(String ordercode,String odpid){
		
		return this.orderDetailMapper.getDetail(ordercode,odpid);
		
	}
	
	/**
	 * 
	 * 业  务: 根据订单详情号删除订单详情 <br>
	 * 英文名: deletdeOrderDetail 
	 * 功能号: TODO
	 * 时  间: 2016年8月17日 上午10:43:54
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：String orderdetailcode
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：int
	 */
	@Transactional
	public int deletdeOrderDetail(String detailcode){
		
		return this.orderDetailMapper.deleteByPrimaryKey(detailcode);
		
	}
	
	public int addOrderDetail(OrderDetail orderdetail){
		
		return this.orderDetailMapper.insertSelective(orderdetail);
	}
	
	public int selectDetailCountByOrderCode(String ordercode){
		
		return this.orderDetailMapper.selectDetailCountByOrderCode(ordercode);
		
	}
	
	public List<OrderDetail> getOrderDetaiByOrderCode(String ordercode){
		
		return this.orderDetailMapper.selectByOrderCode(ordercode);
		
	}

}
