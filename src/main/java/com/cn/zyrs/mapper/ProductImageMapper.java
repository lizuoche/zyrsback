package com.cn.zyrs.mapper;

import java.util.List;

import com.cn.zyrs.domain.ProductImage;

public interface ProductImageMapper {
    int deleteByPrimaryKey(String id);

    int insert(ProductImage record);

    int insertSelective(ProductImage record);

    ProductImage selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
    
    List<ProductImage> getImagesPath();
}