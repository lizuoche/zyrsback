package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.ProductImage;
import com.cn.zyrs.mapper.ProductImageMapper;
import com.cn.zyrs.service.IProductImage;

@Service("productImageService")
public class ProductImageServiceImpl implements IProductImage {

	@Resource(name="productImageMapper")
	private ProductImageMapper productImageMapper;
	
	public List<ProductImage> getImagesPath() {
		return this.productImageMapper.getImagesPath();
	}

}
