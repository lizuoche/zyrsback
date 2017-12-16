package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.zyrs.domain.Design;
import com.cn.zyrs.domain.DesignBase;
import com.cn.zyrs.domain.DesignDetail;
import com.cn.zyrs.mapper.DesignMapper;
import com.cn.zyrs.service.IDesign;

@Service("designService")
public class DesignServiceImpl implements IDesign {

	@Resource(name = "designMapper")
	private DesignMapper designMapper;
	
	@Transactional
	@Override
	public int addDseignSuit(Design design) {
		return this.designMapper.addDesignSuit(design);
	}
	
	@Transactional
	@Override
	public int addDseignShirt(Design design) {
		return this.designMapper.addDesignShirt(design);
	}
	
	@Transactional
	@Override
	public int addDseignTrousers(Design design) {
		return this.designMapper.addDesignTrousers(design);
	}
	
	@Transactional
	@Override
	public int addDseignVest(Design design) {
		return this.designMapper.addDesignVest(design);
	}

	@Override
	public List<DesignBase> getDesignBase(String di, String type) {
		return this.designMapper.getDesignBase(di, type);
	}

	@Override
	public List<DesignDetail> getDesignDetail(String di, String type, String id) {
		return this.designMapper.getDesignDetail(di, type, id);
	}
	
	@Override
	public List<Design> getDesign(String di, String type, String id) {
		return this.designMapper.getDesign(di, type, id);
	}

	@Override
	public int updateDesignSuit(Design ds) {
		return this.designMapper.updateDesignSuit(ds);
	}

	@Override
	public int updateDesignTrousers(Design ds) {
		return this.designMapper.updateDesignTrousers(ds);
	}

	@Override
	public int updateDesignShirt(Design ds) {
		return this.designMapper.updateDesignShirt(ds);
	}

	@Override
	public int updateDesignVest(Design ds) {
		return this.designMapper.updateDesignVest(ds);
	}

	@Override
	public int deleteDesignSuit(String di, String id) {
		return this.designMapper.deleteDesignSuit(di, id);
	}

	@Override
	public int deleteDesignTrousers(String di, String id) {
		return this.designMapper.deleteDesignTrousers(di, id);
	}

	@Override
	public int deleteDesignShirt(String di, String id) {
		return this.designMapper.deleteDesignShirt(di, id);
	}

	@Override
	public int deleteDesignVest(String di, String id) {
		return this.designMapper.deleteDesignVest(di, id);
	}
}
