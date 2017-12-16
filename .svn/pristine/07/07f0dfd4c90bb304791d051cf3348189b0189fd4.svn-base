package com.cn.zyrs.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cn.zyrs.domain.BomFabric;
import com.cn.zyrs.domain.Fabric;
import com.cn.zyrs.mapper.BomInfoMapper;
import com.cn.zyrs.service.IBomInfo;

@Service("bomInfoService")
public class BomInfoServiceImpl implements IBomInfo {

	private static Logger log = Logger.getLogger(BomInfoServiceImpl.class);
	
	@Resource(name = "bomInfoMapper")
	private BomInfoMapper bomInfoMapper;

	public List<BomFabric> getBomInfo(String fabriccode, String type,String ownerdeptid, String style,
			String page) {
		int num = 0;
		if(page!=null&&page!=""){
			num = (Integer.valueOf(page) - 1) * 13;
			return this.bomInfoMapper.getBomInfo(fabriccode, type, ownerdeptid, style, num);
		}else{
			log.error("缺少page参数！");
			return null;
//			return this.bomInfoMapper.getBomInfo1(bomcode, type, style);
		}
	}
	
	/**
	 * 
	 * 业  务: 获取面料系统面料信息 <br>
	 * 英文名: getFabricInfo 
	 * 功能号: TODO
	 * 时  间: 2016年11月11日 下午6:51:50
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public List<Fabric> getFabricInfo(String fabriccode, String type,String ownerdeptid, String style,
			String page) {
		int num = 0;
		if(page!=null&&page!=""){
			num = (Integer.valueOf(page) - 1) * 13;
			return this.bomInfoMapper.getFabricInfo(fabriccode, type, ownerdeptid, style, num);
		}else{
			log.error("缺少page参数！");
			return null;
//			return this.bomInfoMapper.getBomInfo1(bomcode, type, style);
		}
	}

	public List<String> getStyle() {
		return this.bomInfoMapper.getStyle();
	}

	@Override
	public String getStyleCode(String stylename) {
		return bomInfoMapper.getStyleCode(stylename);
	}

	@Override
	public String getSort(String stylecode) {
		return bomInfoMapper.getSort(stylecode);
	}

	@Override
	public BomFabric getBomInfoByID(String farbricid, String di) {
		return this.bomInfoMapper.getBomInfoByID(farbricid, di);
	}

}
