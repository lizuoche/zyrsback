package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.BomFabric;
import com.cn.zyrs.domain.Fabric;

public interface BomInfoMapper {
    int deleteByPrimaryKey(String bomid);

    int insert(BomFabric record);

    int insertSelective(BomFabric record);

    BomFabric selectByPrimaryKey(String bomid);

    int updateByPrimaryKeySelective(BomFabric record);

    int updateByPrimaryKey(BomFabric record);
    
    List<BomFabric> getBomInfo(@Param ("fabriccode") String bomcode, @Param ("type") String type, @Param ("ownerdeptid") String ownerdeptid, @Param ("style")String style,@Param ("num")int num) ;
    
    List<BomFabric> getBomInfo1(@Param ("fabriccode") String bomcode, @Param ("type") String type, @Param ("style")String style) ;
    
    List<Fabric> getFabricInfo(@Param ("fabriccode") String bomcode, @Param ("type") String type, @Param ("ownerdeptid") String ownerdeptid, @Param ("style")String style,@Param ("num")int num) ;
    
    List<Fabric> getFbaricInfo1(@Param ("fabriccode") String bomcode, @Param ("type") String type, @Param ("style")String style) ;
    
    List<String> getStyle ();
    
    String getStyleCode(@Param ("stylename") String stylename);
    
    String getSort(@Param ("stylecode") String stylecode);
    
    BomFabric getBomInfoByID(@Param ("fabricid") String fabriccoid, @Param ("di") String di);
}