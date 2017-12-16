package com.cn.zyrs.serviceimpl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;














//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.CommodityParts;
import com.cn.zyrs.domain.GoodsParts;
import com.cn.zyrs.domain.ShirtStyle;
import com.cn.zyrs.domain.SuitParts;
import com.cn.zyrs.domain.SuitStyle;
import com.cn.zyrs.domain.TrousersStyle;
import com.cn.zyrs.domain.VestStyle;
import com.cn.zyrs.mapper.SuitPartsMapper;
import com.cn.zyrs.service.IParts;

@Service("partsService")
public class PartsServiceImpl implements IParts {

//	private static Logger log = Logger.getLogger(IParts.class);
	
	@Resource(name = "suitPartsMapper")
	private SuitPartsMapper suitPartsMapper;
	
	@Override
	public int checkSuitModelName(String modelName) {
		return this.suitPartsMapper.checkSuitModelName(modelName);
	}
	
	@Override
	public int checkTrousersModelName(String modelName) {
		return this.suitPartsMapper.checkTrousersModelName(modelName);
	}
	
	@Override
	public int checkShirtModelName(String modelName) {
		return this.suitPartsMapper.checkShirtModelName(modelName);
	}
	
	@Override
	public int checkVestModelName(String modelName) {
		return this.suitPartsMapper.checkVestModelName(modelName);
	}
	
	@Override
	public int checkBomCode(String bomCode) {
		return this.suitPartsMapper.checkBomCode(bomCode);
	}
	
	@Override
	public int checkGoodsModelName(String modelName) {
		return this.suitPartsMapper.checkGoodsModelName(modelName);
	}
	
	@Override
	public List<SuitParts> getSuitParts(SuitParts sp) {
		return this.suitPartsMapper.getSuitPartsBySelective(sp);
	}
	
	@Override
	@Transactional
	public int addSuitParts(SuitParts sp) {
		return this.suitPartsMapper.insertSelective(sp);
	}
	
	@Transactional
	public int addSuitStyle(SuitStyle ss) {
		return this.suitPartsMapper.addSuitStyle(ss);
	}
	
	@Override
	@Transactional
	public int addTrousersStyle(TrousersStyle ts) {
		return this.suitPartsMapper.addTrousersStyle(ts);
	}
	
	@Override
	@Transactional
	public int addShirtStyle(ShirtStyle ss) {
		return this.suitPartsMapper.addShirtStyle(ss);
	}
	
	@Override
	@Transactional
	public int addVestStyle(VestStyle vs) {
		return this.suitPartsMapper.addVestStyle(vs);
	}

	@Override
	@Transactional
	public int updateSuitCollar(SuitParts sp) {
		return this.suitPartsMapper.updateByPrimaryKeySelective(sp);
	}

	@Override
	public List<SuitParts> getTrousersParts(SuitParts sp) {
		return this.suitPartsMapper.getTrousersPartsBySelective(sp);
	}

	@Override
	@Transactional
	public int addTrousersParts(SuitParts sp) {
		return this.suitPartsMapper.insertTrousersSelective(sp);
	}

	@Override
	@Transactional
	public int updateTrousersCollar(SuitParts sp) {
		return this.suitPartsMapper.updateTrousersByPrimaryKeySelective(sp);
	}

	@Override
	public List<SuitParts> getShirtParts(SuitParts sp) {
		return this.suitPartsMapper.getShirtPartsBySelective(sp);
	}

	@Override
	public List<SuitParts> getVestParts(SuitParts sp) {
		return this.suitPartsMapper.getVestPartsBySelective(sp);
	}
	
	@Override
	public List<BomParts> getBomParts(BomParts bp) {
		return this.suitPartsMapper.getBomPartsBySelective(bp);
	}
	
	@Override
	public List<CommodityParts> getCommodityParts(CommodityParts cp) {
		return this.suitPartsMapper.getCommodityParts(cp);
	}
	
	@Override
	public List<String> getBomBrand(String type) {
		return this.suitPartsMapper.getBomBrand(type);
	}
	
	@Override
	public List<String> getGoodsBrand(String type) {
		return this.suitPartsMapper.getGoodsBrand(type);
	}
	
	@Override
	public List<GoodsParts> getGoodsParts(GoodsParts gp) {
		return this.suitPartsMapper.getGoodsPartsBySelective(gp);
	}

	@Transactional
	@Override
	public int addShirtParts(SuitParts sp) {
		return this.suitPartsMapper.insertShirtSelective(sp);
	}

	@Transactional
	@Override
	public int addVestParts(SuitParts sp) {
		return this.suitPartsMapper.insertVestSelective(sp);
	}
	
	@Transactional
	@Override
	public int addSuitBomParts(BomParts bp) {
		return this.suitPartsMapper.insertSuitBomSelective(bp);
	}
	
	@Transactional
	@Override
	public int addGoods(GoodsParts gp) {
		return this.suitPartsMapper.insertGoodsSelective(gp);
	}
	

	@Override
	@Transactional
	public int updateShirtCollar(SuitParts sp) {
		return this.suitPartsMapper.updateShirtByPrimaryKeySelective(sp);
	}

	@Override
	@Transactional
	public int updateVestCollar(SuitParts sp) {
		return this.suitPartsMapper.updateVestByPrimaryKeySelective(sp);
	}
	
	@Override
	@Transactional
	public int updateBomCollar(BomParts bp) {
		return this.suitPartsMapper.updateBomByPrimaryKeySelective(bp);
	}
	
	
	@Override
	@Transactional
	public int updateGoods(GoodsParts gp ) {
		return this.suitPartsMapper.updateGoodsByPrimaryKeySelective(gp);
	}


	@Override
	@Transactional
	public int deleteSuitParts(String[] ids) {
		return this.suitPartsMapper.deleteSuitByPrimartKey(ids);
	}
	
	@Override
	@Transactional
	public int deleteTrousersParts(String[] ids) {
		return this.suitPartsMapper.deleteTrousersByPrimartKey(ids);
	}
	
	@Override
	@Transactional
	public int deleteShirtParts(String[] ids) {
		return this.suitPartsMapper.deleteShirtByPrimartKey(ids);
	}
	
	@Override
	@Transactional
	public int deleteVestParts(String[] ids) {
		return this.suitPartsMapper.deleteVestByPrimartKey(ids);
	}
	
	@Override
	@Transactional
	public int deleteBomParts(String[] ids) {
		return this.suitPartsMapper.deleteBomByPrimartKey(ids);
	}
	
	@Override
	@Transactional
	public int deleteGoods(String[] ids) {
		return this.suitPartsMapper.deleteGoodsByPrimartKey(ids);
	}

	@Override
	public List<SuitStyle> getSuitStyle(Map<String, String> map) {
		return this.suitPartsMapper.getSuitStyleBySelective(map);
	}

	@Override
	public List<TrousersStyle> getTrousersStyle(Map<String, String> map) {
		return this.suitPartsMapper.getTrousersStyleBySelective(map);
	}

	@Override
	public List<ShirtStyle> getShirtStyle(Map<String, String> map) {
		return this.suitPartsMapper.getShirtStyleBySelective(map);
	}

	@Override
	public List<VestStyle> getVestStyle(Map<String, String> map) {
		return this.suitPartsMapper.getVestStyleBySelective(map);
	}

	@Transactional
	@Override
	public int updateSuitStyle(SuitStyle ss) {
		return this.suitPartsMapper.updateSuitStyleBySelective(ss);
	}

	@Transactional
	@Override
	public int updateTrousersStyle(TrousersStyle ts) {
		return this.suitPartsMapper.updateTrousersStyleBySelective(ts);
	}

	@Transactional
	@Override
	public int updateShirtStyle(ShirtStyle ss) {
		return this.suitPartsMapper.updateShirtStyleBySelective(ss);
	}

	@Transactional
	@Override
	public int updateVestStyle(VestStyle vs) {
		return this.suitPartsMapper.updateVestStyleBySelective(vs);
	}
	
	@Transactional
	@Override
	public int deleteSuitStyle(String[] ids) {
		return this.suitPartsMapper.deleteSuitStyleByPrimartKey(ids);
	}
	
	@Transactional
	@Override
	public int deleteTrousersStyle(String[] ids) {
		return this.suitPartsMapper.deleteTrousersStyleByPrimartKey(ids);
	}

	@Transactional
	@Override
	public int deleteShirtStyle(String[] ids) {
		return this.suitPartsMapper.deleteShirtStyleByPrimartKey(ids);
	}

	@Transactional
	@Override
	public int deleteVestStyle(String[] ids) {
		return this.suitPartsMapper.deleteVestStyleByPrimartKey(ids);
	}

	@Override
	public SuitParts getparts(String id) {
		return this.suitPartsMapper.getParts(id);
	}
	
	

}
