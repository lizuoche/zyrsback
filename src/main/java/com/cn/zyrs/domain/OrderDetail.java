package com.cn.zyrs.domain;

import java.math.BigDecimal;
import java.util.List;

public class OrderDetail {
	private String detailcode;

	private String ordercode;

	private String producttype;

	private String productstyle;

	private String count;

	private String bomcount;

	private String bomcode;

	private String isgift;

	private String batch;

	private String isurgent;

	private String ismastermeasure;

	private String price;

	private String discount;
	
	private String manorwormen;
	
	private String processors;
	

	private List<CustomerMeasureData> customerMeasureData;

	private String remark;

	public String getDetailcode() {
		return detailcode;
	}

	public void setDetailcode(String detailcode) {
		this.detailcode = detailcode == null ? null : detailcode.trim();
	}

	public String getOrdercode() {
		return ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode == null ? null : ordercode.trim();
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype == null ? null : producttype.trim();
	}

	public String getProductstyle() {
		return productstyle;
	}

	public void setProductstyle(String productstyle) {
		this.productstyle = productstyle == null ? null : productstyle.trim();
	}

	public String getBomcode() {
		return bomcode;
	}

	public void setBomcode(String bomcode) {
		this.bomcode = bomcode == null ? null : bomcode.trim();
	}

	public String getManorwormen() {
		return manorwormen;
	}

	public void setManorwormen(String manorwormen) {
		this.manorwormen = manorwormen;
	}

	public String getProcessors() {
		return processors;
	}

	public void setProcessors(String processors) {
		this.processors = processors;
	}

	public List<CustomerMeasureData> getCustomerMeasureData() {
		return customerMeasureData;
	}

	public void setCustomerMeasureData(
			List<CustomerMeasureData> customerMeasureData) {
		this.customerMeasureData = customerMeasureData;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getIsgift() {
		return isgift;
	}

	public void setIsgift(String isgift) {
		this.isgift = isgift;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getIsurgent() {
		return isurgent;
	}

	public void setIsurgent(String isurgent) {
		this.isurgent = isurgent;
	}

	public String getIsmastermeasure() {
		return ismastermeasure;
	}

	public void setIsmastermeasure(String ismastermeasure) {
		this.ismastermeasure = ismastermeasure;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getBomcount() {
		return bomcount;
	}

	public void setBomcount(String bomcount) {
		this.bomcount = bomcount;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}