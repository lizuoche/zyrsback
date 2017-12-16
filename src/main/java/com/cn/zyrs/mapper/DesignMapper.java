package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.Design;
import com.cn.zyrs.domain.DesignBase;
import com.cn.zyrs.domain.DesignDetail;

public interface DesignMapper {
    int insert(Design record);

    int addDesignSuit(@Param("design") Design design);
    
    int addDesignShirt(@Param("design") Design design);
    
    int addDesignTrousers(@Param("design") Design design);
    
    int addDesignVest(@Param("design") Design design);
    
    int updateDesignSuit(@Param("design") Design design);
    
    int updateDesignShirt(@Param("design") Design design);
    
    int updateDesignTrousers(@Param("design") Design design);
    
    int updateDesignVest(@Param("design") Design design);
    
    int deleteDesignSuit(@Param("di") String di, @Param("id") String id);
    
    int deleteDesignTrousers(@Param("di") String di, @Param("id") String id);
    
    int deleteDesignShirt(@Param("di") String di, @Param("id") String id);
    
    int deleteDesignVest(@Param("di") String di, @Param("id") String id);
    
    List<DesignBase> getDesignBase(@Param("di") String di, @Param("type") String type);
    
    List<DesignDetail> getDesignDetail(@Param("di") String di, @Param("type") String type, @Param("id") String id);
    
    List<Design> getDesign(@Param("di") String di, @Param("type") String type, @Param("id") String id);
}