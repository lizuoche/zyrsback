package com.cn.zyrs.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.CommodityParts;
import com.cn.zyrs.domain.GoodsParts;
import com.cn.zyrs.domain.ShirtStyle;
import com.cn.zyrs.domain.SuitParts;
import com.cn.zyrs.domain.SuitStyle;
import com.cn.zyrs.domain.TrousersStyle;
import com.cn.zyrs.domain.VestStyle;

public interface SuitPartsMapper {
    int deleteByPrimaryKey(String id);

    int addSuitStyle(@Param("ss") SuitStyle ss);
    
    int addTrousersStyle(@Param("ts") TrousersStyle ts);
    
    int addShirtStyle(@Param("ss") ShirtStyle ss);
    
    int addVestStyle(@Param("vs") VestStyle vs);
    
    int insertSelective(@Param("sp") SuitParts sp);
    
    int insertTrousersSelective(@Param("sp") SuitParts sp);
    
    int insertShirtSelective(@Param("sp") SuitParts sp);
    
    int insertVestSelective(@Param("sp") SuitParts sp);
    
    int insertSuitBomSelective(@Param("bp") BomParts bp);
    
    int insertGoodsSelective(@Param("gp") GoodsParts gp);

    int updateByPrimaryKeySelective(@Param("sp") SuitParts sp);
    
    int updateTrousersByPrimaryKeySelective(@Param("sp") SuitParts sp);
    
    int updateShirtByPrimaryKeySelective(@Param("sp") SuitParts sp);
    
    int updateVestByPrimaryKeySelective(@Param("sp") SuitParts sp);
    
    int updateBomByPrimaryKeySelective(@Param("bp") BomParts bp);
    
    int updateGoodsByPrimaryKeySelective(@Param("gp") GoodsParts gp);
    
    int updateSuitStyleBySelective(@Param("ss") SuitStyle ss);
    
    int updateTrousersStyleBySelective(@Param("ts") TrousersStyle ts);
    
    int updateShirtStyleBySelective(@Param("ss") ShirtStyle ss);
    
    int updateVestStyleBySelective(@Param("vs") VestStyle vs);
    
    int deleteSuitByPrimartKey(@Param("ids") String[] ids);
    
    int deleteTrousersByPrimartKey(@Param("ids") String[] ids);
    
    int deleteShirtByPrimartKey(@Param("ids") String[] ids);
    
    int deleteVestByPrimartKey(@Param("ids") String[] ids);
    
    int deleteBomByPrimartKey(@Param("ids") String[] ids);
    
    int deleteGoodsByPrimartKey(@Param("ids") String[] ids);
    
    int deleteSuitStyleByPrimartKey(@Param("ids") String[] ids);
    
    int deleteTrousersStyleByPrimartKey(@Param("ids") String[] ids);
    
    int deleteShirtStyleByPrimartKey(@Param("ids") String[] ids);
    
    int deleteVestStyleByPrimartKey(@Param("ids") String[] ids);

    SuitParts getParts(@Param("id") String id);
    
    List<SuitParts> getSuitPartsBySelective(@Param("sp") SuitParts sp);
    
    List<SuitParts> getTrousersPartsBySelective(@Param("sp") SuitParts sp);
    
    List<SuitParts> getShirtPartsBySelective(@Param("sp") SuitParts sp);
    
    List<SuitParts> getVestPartsBySelective(@Param("sp") SuitParts sp);
    
    List<BomParts> getBomPartsBySelective(@Param("bp") BomParts bp);
    
    List<CommodityParts> getCommodityParts(@Param("cp") CommodityParts cp);
    
    List<String> getBomBrand(@Param("type") String type);
    
    List<String> getGoodsBrand(@Param("type") String type);
    
    List<GoodsParts> getGoodsPartsBySelective(@Param("gp") GoodsParts gp);
    
    List<SuitStyle> getSuitStyleBySelective(@Param("map") Map<String, String> map);
    
    List<TrousersStyle> getTrousersStyleBySelective(@Param("map") Map<String, String> map);
    
    List<ShirtStyle> getShirtStyleBySelective(@Param("map") Map<String, String> map);
    
    List<VestStyle> getVestStyleBySelective(@Param("map") Map<String, String> map);
    
    int checkSuitModelName(@Param("mn") String modelName);
    
    int checkTrousersModelName(@Param("mn") String modelName);
    
    int checkShirtModelName(@Param("mn") String modelName);
    
    int checkVestModelName(@Param("mn") String modelName);
    
    int checkBomCode(@Param("bomcode") String bomCode);
    
    int checkGoodsModelName(@Param("mn") String modelName);
    
}