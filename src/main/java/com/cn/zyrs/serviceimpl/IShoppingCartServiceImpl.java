package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;




//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.ShoppingCart;
import com.cn.zyrs.domain.ShoppingCartBase;
import com.cn.zyrs.mapper.ShoppingCartMapper;
import com.cn.zyrs.service.IShoppingCart;

@Service("shoppingCartService")
public class IShoppingCartServiceImpl implements IShoppingCart {

//	private static Logger log = Logger.getLogger(IShoppingCartServiceImpl.class);
	
	@Resource(name = "shoppingCartMapper")
	private ShoppingCartMapper shoppingCartMapper;

	@Transactional
	@Override
	public int addShoppingCart(ShoppingCart sc) {
		return this.shoppingCartMapper.addShoppingCart(sc);
	}

	@Override
	public List<ShoppingCartBase> showShoppingCartBase(String di) {
		return this.shoppingCartMapper.showShoppingCartBase(di);
	}

	@Override
	public List<ShoppingCart> showShoppingCart(String scid) {
		return this.shoppingCartMapper.showShoppingCartDetail(scid);
	}
	
	@Transactional
	@Override
	public int deleteShoppingCart(String scid) {
		return this.shoppingCartMapper.deleteByPrimaryKey(scid);
	}


}
