package com.cn.zyrs.mapper;

import com.cn.zyrs.domain.Version;

public interface VersionMapper {
    int insert(Version record);

    int insertSelective(Version record);
    
}