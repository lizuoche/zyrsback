package com.cn.zyrs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.zyrs.domain.ShoppingCart;
import com.cn.zyrs.domain.ShoppingCartBase;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(String id);

    int addShoppingCart(@Param("sc") ShoppingCart sc);

    List<ShoppingCartBase> showShoppingCartBase(@Param("di") String di);
    
    List<ShoppingCart> showShoppingCartDetail(@Param("scid")String scid);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}