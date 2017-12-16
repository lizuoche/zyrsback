package com.cn.zyrs.mapper;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.ImageCode;

public interface ImageCodeMapper {
    int deleteByPrimaryKey(String id);

    int insert(ImageCode record);

    int insertSelective(ImageCode record);

    ImageCode selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ImageCode record);

    int updateByPrimaryKey(ImageCode record);
    
    String getImageName(@Param("unitycode") String unitycode);
}