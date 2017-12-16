package com.cn.zyrs.mapper;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.ProductDetail;

public interface ProductDetailMapper {
    int deleteByPrimaryKey(String detailcode);

    int insert(ProductDetail record);

    int addProductDetail(@Param("pd") ProductDetail pd);

    ProductDetail selectByPrimaryKey(String detailcode);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);
}