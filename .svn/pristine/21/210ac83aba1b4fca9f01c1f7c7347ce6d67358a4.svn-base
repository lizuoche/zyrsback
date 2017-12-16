package com.cn.zyrs.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.ProductDetail;
import com.cn.zyrs.mapper.ProductDetailMapper;
import com.cn.zyrs.service.IProductDetail;

@Service("productDetailService")
public class ProductDetailServiceImpl implements IProductDetail {

	@Resource(name = "productDetailMapper")
	private ProductDetailMapper productDetailMapper;
	
	@Transactional
	public int addProductDetail(ProductDetail productdetail) {
		return this.productDetailMapper.addProductDetail(productdetail);
	}

}
