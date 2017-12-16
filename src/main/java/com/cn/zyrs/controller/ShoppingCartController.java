package com.cn.zyrs.controller;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.CommodityParts;
import com.cn.zyrs.domain.Design;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.ShoppingCart;
import com.cn.zyrs.domain.ShoppingCartBase;
import com.cn.zyrs.domain.ShoppingCartDetail;
import com.cn.zyrs.domain.SuitParts;
import com.cn.zyrs.service.IDesign;
import com.cn.zyrs.service.IParts;
import com.cn.zyrs.service.IShoppingCart;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.DynamicDataSource;

@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	private static Logger log = Logger.getLogger(ShoppingCartController.class);
	
	@Resource(name = "shoppingCartService")
	private IShoppingCart shoppingCartService;
	
	@Resource(name = "userService")
	private IUser userService;
	
	@Resource(name = "designService")
	private IDesign designService;
	
	@Resource(name = "partsService")
	private IParts partsService;

	
	/**
	 * 
	 * 业  务: 加入购物车 <br>
	 * 英文名: addDesign 
	 * 功能号: TODO
	 * 时  间: 2017年4月26日 下午5:01:36
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/addShoppingCart")
	public ResultJsonBean addShoppingCart(HttpServletRequest request,	HttpServletResponse response) {
		ResultJsonBean rjb = null;
		
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");

		String dsid = request.getParameter("designid");

		// 验证参数
		if (di == null) {
			log.error("[加入购物车]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[加入购物车]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[加入购物车]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[加入购物车]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (dsid == null) {
			log.error("[加入购物车]===>缺少设计方案ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[加入购物车]===>缺少设计方案ID参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[加入购物车]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[加入购物车]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
			//查询指定设计方案
			List<Design> dl = this.designService.getDesign(di, null, dsid);
			Design d = dl.get(0);
			
			// 加入购物车
			ShoppingCart sc = new ShoppingCart();
			
			// ID,
			sc.setId(UUID.randomUUID().toString());
			//DesignID
			sc.setDesignid(d .getId());
			// 门店ID,
			sc.setDeptid(d.getDeptid());
			// 设计名称,
			sc.setDesignname(d.getDesignname());
			//加入购物车日期
			
			// 创建日期,
			sc.setCreatedate(d.getCreatedate());
			// 更新日期
			sc.setUpdatedate(d.getUpdatedate());
			// 设计缩略图,
			sc.setPicture(d.getPicture());
			// 款式,
			sc.setType(d.getType());
			// 款式名称,
			sc.setTypename(d.getTypename());
			// 资源包,
			sc.setAssetbundlename(d.getAssetbundlename());
			
			// 领子,
			sc.setCollar(d.getCollar());
			// 前片,
			sc.setFont(d.getFont());
			// 后片,
			sc.setBack(d.getBack());
			// 袖子,
			sc.setBuff(d.getBuff());
			// 胸袋,
			sc.setBreastpocket(d.getBreastpocket());
			// 扣眼,
			sc.setButtoneye(d.getButtoneye());
			// 前褶,
			sc.setFrontdart(d.getFrontdart());
			// 口袋,
			sc.setPocket(d.getPocket());
			// 扣眼数,
			sc.setButtonnum(d.getButtonnum());
			// 门襟,
			sc.setPlacket(d.getPlacket());
			// 驳头眼,
			sc.setBotouyan(d.getBotouyan());
			// 下摆,
			sc.setXiabai(d.getXiabai());
			// 腰头,
			sc.setYaotou(d.getYaotou());
			// 裤脚,
			sc.setKujiao(d.getKujiao());
			// 侧口袋,
			sc.setCekoudai(d.getCekoudai());
			// 后口袋,
			sc.setHoukoudai(d.getHoukoudai());
			
			// 西服面料,
			sc.setSuitbom(d.getSuitbom());
			// 里料,
			sc.setInsidebom(d.getInsidebom());
			// 衬衫面料,
			sc.setShirtbom(d.getShirtbom());
			// 领带面料,
			sc.setTiebom(d.getTiebom());
			//扣眼面料,
			sc.setKouyanbom(d.getKouyanbom());
			// 西服扣,
			sc.setSuitbutton(d.getSuitbutton());
			// 领带,
			sc.setTie(d.getTie());
			// 领结,
			sc.setCravat(d.getCravat());
			// 小图,
//			sc.setSmallImage(d.get);(d.getCollar());
			// 大图,
			sc.setBigImage(d.getBigImage());
			// json名称,
			sc.setJsonurl(d.getJsonurl());
			// 删除标志,
			sc.setDelflag("0");
			// 是否有效
			sc.setIsvalid("1");
			
			//加入购物车
			int res = this.shoppingCartService.addShoppingCart(sc);
			
			// 验证结果
			if (res == 1) {
				log.info("[加入购物车]===>加入购物车成功！<===");
				rjb = new ResultJsonBean(true, sc, "1","[加入购物车]===>加入购物车成功！<===");
			} else {
				log.info("[加入购物车]===>加入购物车失败！<===");
				rjb = new ResultJsonBean(false, sc, "-1","[加入购物车]===>加入购物失败！<===");
			}

		} else {
			log.error("[加入购物车]===>密钥不匹配,新增失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[加入购物车]===>密钥不匹配,新增失败！<===");
		}

		return rjb;

	}


	/**
	 * 
	 * 业  务: 查询购物车信息 <br>
	 * 英文名: showShoppingCart 
	 * 功能号: TODO
	 * 时  间: 2017年4月27日 上午11:00:40
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/showShoppingCart")
	public ResultJsonBean showShoppingCart(HttpServletRequest request,HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		String scid = request.getParameter("scid");

		// 验证参数
		if (di == null) {
			log.error("[查询购物车]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询购物车]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[查询购物车]===>缺少密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询购物车]===>缺少密钥参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[查询购物车]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询购物车]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {

			// 查询购物车里所有基本信息
			if (scid == null) {
				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<ShoppingCartBase> scbl = this.shoppingCartService.showShoppingCartBase(di);
//				for (int i = 0; i < scbl.size(); i++) {
//					scbl.get(i).setPicture(scbl.get(i).getPicture().sp);
//				}

				log.info("[查询购物车基本信息]===>查询成功！<===");
				rjb = new ResultJsonBean(true, scbl, "1",
						"[查询购物车基本信息]===>查询成功！<===");
			} else {
				// 查询指定ID的购物车详情：
				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<ShoppingCart> scl = this.shoppingCartService.showShoppingCart(scid);

				if (scl.size() == 0) {
					log.error("[查询指定购物车详情信息]===>查询不到指定的购物车信息！<===");
					rjb = new ResultJsonBean(false, scl, "-1","[查询指定购物车详情信息]===>查询不到指定的购物车信息！<===");
					return rjb;
				}else{
					ShoppingCart sc = scl.get(0);
					BomParts bp = new BomParts();
					CommodityParts cp = new CommodityParts();
					ShoppingCartDetail scd = new ShoppingCartDetail();
					// 处理数据结果
					rjb = getShoppingCartDetail(sc, bp, cp, scd, sc.getType());
				}
			}
		} else {
			log.error("[查询购物车]===>密钥不匹配,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",	"[查询购物车]===>密钥不匹配,查询失败！<===");
		}

		return rjb;

	}
	
	/**
	 * 
	 * 业  务: 获取指定的购物车设计方案详情信息 <br>
	 * 英文名: getShoppingCartDetail 
	 * 功能号: TODO
	 * 时  间: 2017年4月12日 上午10:13:39
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public ResultJsonBean getShoppingCartDetail(ShoppingCart sc, BomParts bp, CommodityParts cp,
			ShoppingCartDetail scd, String type) {
		ResultJsonBean rjb = null;

		// 配件
		// collar
		SuitParts collar = new SuitParts();
		if (sc.getCollar() != null && !"".equals(sc.getCollar())) {
			collar = this.partsService.getparts(sc.getCollar());
			collar.setimage1("json/" + type + "/image/" + collar.getimage1());
		} else {
			collar = null;
		}
		// font
		SuitParts font = new SuitParts();
		if (sc.getFont() != null && !"".equals(sc.getFont())) {
			font = this.partsService.getparts(sc.getFont());
			font.setimage1("json/" + type + "/image/" + font.getimage1());
		} else {
			font = null;
		}
		// back
		SuitParts back = new SuitParts();
		if (sc.getBack() != null && !"".equals(sc.getBack())) {
			back = this.partsService.getparts(sc.getBack());
			back.setimage1("json/" + type + "/image/" + back.getimage1());
		} else {
			back = null;
		}
		// sleeve
		SuitParts sleeve = new SuitParts();
		if (sc.getBuff() != null && !"".equals(sc.getBuff())) {
			sleeve = this.partsService.getparts(sc.getBuff());
			sleeve.setimage1("json/" + type + "/image/" + sleeve.getimage1());
		} else {
			sleeve = null;
		}
		// breastpocket
		SuitParts breastpocket = new SuitParts();
		if (sc.getBreastpocket() != null && !"".equals(sc.getBreastpocket())) {
			breastpocket = this.partsService.getparts(sc.getBreastpocket());
			breastpocket.setimage1("json/" + type + "/image/"
					+ breastpocket.getimage1());
		} else {
			breastpocket = null;
		}
		// buttoneye
		SuitParts buttoneye = new SuitParts();
		if (sc.getButtoneye() != null && !"".equals(sc.getButtoneye())) {
			buttoneye = this.partsService.getparts(sc.getButtoneye());
			buttoneye.setimage1("json/" + type + "/image/"
					+ buttoneye.getimage1());
		} else {
			buttoneye = null;
		}
		// frontdart
		SuitParts frontdart = new SuitParts();
		if (sc.getFrontdart() != null && !"".equals(sc.getFrontdart())) {
			frontdart = this.partsService.getparts(sc.getFrontdart());
			frontdart.setimage1("json/" + type + "/image/"
					+ frontdart.getimage1());
		} else {
			frontdart = null;
		}
		// pocket
		SuitParts pocket = new SuitParts();
		if (sc.getPocket() != null && !"".equals(sc.getPocket())) {
			pocket = this.partsService.getparts(sc.getPocket());
			pocket.setimage1("json/" + type + "/image/" + pocket.getimage1());
		} else {
			pocket = null;
		}
		// placket
		SuitParts placket = new SuitParts();
		if (sc.getPlacket() != null && !"".equals(sc.getPlacket())) {
			placket = this.partsService.getparts(sc.getPlacket());
			placket.setimage1("json/" + type + "/image/" + placket.getimage1());
		} else {
			placket = null;
		}
		// botouyan
		SuitParts botouyan = new SuitParts();
		if (sc.getBotouyan() != null && !"".equals(sc.getBotouyan())) {
			botouyan = this.partsService.getparts(sc.getBotouyan());
			botouyan.setimage1("json/" + type + "/image/"
					+ botouyan.getimage1());
		} else {
			botouyan = null;
		}
		// xiabai
		SuitParts xiabai = new SuitParts();
		if (sc.getXiabai() != null && !"".equals(sc.getXiabai())) {
			xiabai = this.partsService.getparts(sc.getXiabai());
			xiabai.setimage1("json/" + type + "/image/" + xiabai.getimage1());
		} else {
			xiabai = null;
		}
		// yaotou
		SuitParts yaotou = new SuitParts();
		if (sc.getYaotou() != null && !"".equals(sc.getYaotou())) {
			yaotou = this.partsService.getparts(sc.getYaotou());
			yaotou.setimage1("json/" + type + "/image/" + yaotou.getimage1());
		} else {
			yaotou = null;
		}
		// kujiao
		SuitParts kujiao = new SuitParts();
		if (sc.getKujiao() != null && !"".equals(sc.getKujiao())) {
			kujiao = this.partsService.getparts(sc.getKujiao());
			kujiao.setimage1("json/" + type + "/image/" + kujiao.getimage1());
		} else {
			kujiao = null;
		}
		// cekoudai
		SuitParts cekoudai = new SuitParts();
		if (sc.getCekoudai() != null && !"".equals(sc.getCekoudai())) {
			cekoudai = this.partsService.getparts(sc.getCekoudai());
			cekoudai.setimage1("json/" + type + "/image/"
					+ cekoudai.getimage1());
		} else {
			cekoudai = null;
		}
		// houkoudai
		SuitParts houkoudai = new SuitParts();
		if (sc.getHoukoudai() != null && !"".equals(sc.getHoukoudai())) {
			houkoudai = this.partsService.getparts(sc.getHoukoudai());
			houkoudai.setimage1("json/" + type + "/image/"
					+ houkoudai.getimage1());
		} else {
			houkoudai = null;
		}
		// buttonnum
		SuitParts buttonnum = new SuitParts();
		if (sc.getButtonnum() != null && !"".equals(sc.getButtonnum())) {
			buttonnum = this.partsService.getparts(sc.getButtonnum());
			buttonnum.setimage1("json/" + type + "/image/"
					+ buttonnum.getimage1());
		} else {
			buttonnum = null;
		}

		// 布料
		// suitbom
		BomParts suitbom = new BomParts();
		bp.setId(sc.getSuitbom());
		if (bp.getId() != null) {
			List<BomParts> sbl = this.partsService.getBomParts(bp);
			if (sbl.size() != 0) {
				suitbom = sbl.get(0);
				// small_image
				
				if (suitbom.getSmall_image() != null
						&& !"".equals(suitbom.getSmall_image())) {
					suitbom.setSmall_image("TextureMaterial/suit_texture/"
							+ suitbom.getSmall_image());
				} else {
					suitbom.setSmall_image("TextureMaterial/suit_texture/");
				}
				// nomal_image
				if (suitbom.getNormal_image() != null
						&& !"".equals(suitbom.getNormal_image())) {
					suitbom.setNormal_image("TextureMaterial/suit_texture/"
							+ suitbom.getNormal_image());
				} else {
					suitbom.setNormal_image("TextureMaterial/suit_texture/");
				}
				// big_Image
				if (suitbom.getBig_image() != null
						&& !"".equals(suitbom.getBig_image())) {
					suitbom.setBig_image("TextureMaterial/suit_texture/"
							+ suitbom.getBig_image());
				} else {
					suitbom.setBig_image("TextureMaterial/suit_texture/");
				}
			} else {
				suitbom = null;
			}
		} else {
			suitbom = null;
		}

		// insidebom
		BomParts insidebom = new BomParts();
		bp.setId(sc.getInsidebom());
		if (bp.getId() != null) {
			List<BomParts> ibl = this.partsService.getBomParts(bp);
			if (ibl.size() != 0) {
				insidebom = ibl.get(0);
				// small_image
				if (insidebom.getSmall_image() != null
						&& !"".equals(insidebom.getSmall_image())) {
					insidebom.setSmall_image("TextureMaterial/inside_texture/"
							+ insidebom.getSmall_image());
				} else {
					insidebom.setSmall_image("TextureMaterial/inside_texture/");
				}
				// nomal_image
				if (insidebom.getNormal_image() != null
						&& !"".equals(insidebom.getNormal_image())) {
					insidebom.setNormal_image("TextureMaterial/inside_texture/"
							+ insidebom.getNormal_image());
				} else {
					insidebom
							.setNormal_image("TextureMaterial/inside_texture/");
				}
				// big_Image 
				if (insidebom.getBig_image() != null
						&& !"".equals(insidebom.getBig_image())) {
					insidebom.setBig_image("TextureMaterial/inside_texture/"
							+ insidebom.getBig_image());
				} else {
					insidebom.setBig_image("TextureMaterial/inside_texture/");
				}
			} else {
				insidebom = null;
			}
		} else {
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  		insidebom = null;
		}

		// shirtBom
		BomParts shirtbom = new BomParts();
		bp.setId(sc.getShirtbom());
		if (bp.getId() != null) {
			List<BomParts> shbl = this.partsService.getBomParts(bp);
			if (shbl.size() != 0) {
				shirtbom = shbl.get(0);
				// small_image
				if (shirtbom.getSmall_image() != null
						&& !"".equals(shirtbom.getSmall_image())) { 
					shirtbom.setSmall_image("TextureMaterial/shirt_texture/"
							+ shirtbom.getSmall_image());
				} else {
					shirtbom.setSmall_image("TextureMaterial/shirt_texture/");
				}
				// nomal_image
				if (shirtbom.getNormal_image() != null
						&& !"".equals(shirtbom.getNormal_image())) {
					shirtbom.setNormal_image("TextureMaterial/shirt_texture/"
							+ shirtbom.getNormal_image());
				} else {
					shirtbom.setNormal_image("TextureMaterial/shirt_texture/");
				}
				// big_Image
				if (shirtbom.getBig_image() != null
						&& !"".equals(shirtbom.getBig_image())) {
					shirtbom.setBig_image("TextureMaterial/shirt_texture/"
							+ shirtbom.getBig_image());
				} else {
					shirtbom.setBig_image("TextureMaterial/shirt_texture/");
				}
			} else {
				shirtbom = null;
			}
		} else {
			shirtbom = null;
		}

		// kouyanBom
		BomParts kouyanbom = new BomParts();
		bp.setId(sc.getKouyanbom());
		if (bp.getId() != null) {
			List<BomParts> kybl = this.partsService.getBomParts(bp);
			if (kybl.size() != 0) {
				kouyanbom = kybl.get(0);
				// small_image
				if (kouyanbom.getSmall_image() != null
						&& !"".equals(kouyanbom.getSmall_image())) {
					kouyanbom.setSmall_image("TextureMaterial/kouyan_texture/"
							+ kouyanbom.getSmall_image());
				} else {
					kouyanbom.setSmall_image("TextureMaterial/kouyan_texture/");
				}
				// nomal_image
				if (kouyanbom.getNormal_image() != null
						&& !"".equals(kouyanbom.getNormal_image())) {
					kouyanbom.setNormal_image("TextureMaterial/kouyan_texture/"
							+ kouyanbom.getNormal_image());
				} else {
					kouyanbom
							.setNormal_image("TextureMaterial/kouyan_texture/");
				}
				// big_Image
				if (kouyanbom.getBig_image() != null
						&& !"".equals(kouyanbom.getBig_image())) {
					kouyanbom.setBig_image("TextureMaterial/kouyan_texture/"
							+ kouyanbom.getBig_image());
				} else {
					kouyanbom.setBig_image("TextureMaterial/kouyan_texture/");
				}
			} else {
				kouyanbom = null;
			}
		} else {
			kouyanbom = null;
		}

		// tieBom
		BomParts tiebom = new BomParts();
		bp.setId(sc.getTiebom());
		if (bp.getId() != null) {
			List<BomParts> tbl = this.partsService.getBomParts(bp);
			if (tbl.size() != 0) {
				tiebom = tbl.get(0);
				// small_image
				if (tiebom.getSmall_image() != null
						&& !"".equals(tiebom.getSmall_image())) {
					tiebom.setSmall_image("TextureMaterial/tie_texture/"
							+ tiebom.getSmall_image());
				} else {
					tiebom.setSmall_image("TextureMaterial/tie_texture/");
				}
				// nomal_image
				if (tiebom.getNormal_image() != null
						&& !"".equals(tiebom.getNormal_image())) {
					tiebom.setNormal_image("TextureMaterial/tie_texture/"
							+ tiebom.getNormal_image());
				} else {
					tiebom.setNormal_image("TextureMaterial/tie_texture/");
				}
				// big_Image
				if (tiebom.getBig_image() != null
						&& !"".equals(tiebom.getBig_image())) {
					tiebom.setBig_image("TextureMaterial/tie_texture/"
							+ tiebom.getBig_image());
				} else {
					tiebom.setBig_image("TextureMaterial/tie_texture/");
				}
			} else {
				tiebom = null;
			}
		} else {
			tiebom = null;
		}

		// suitbutton
		CommodityParts suitbutton = new CommodityParts();
		cp.setId(sc.getSuitbutton());
		if (cp.getId() != null) {
			List<CommodityParts> sbul = this.partsService.getCommodityParts(cp);
			if (sbul.size() != 0) {
				suitbutton = sbul.get(0);
				// small_image
				if (suitbutton.getSmall_image() != null
						&& !"".equals(suitbutton.getSmall_image())) {
					suitbutton
							.setSmall_image("TextureMaterial/suitbutton_texture/"
									+ suitbutton.getSmall_image());
				} else {
					suitbutton
							.setSmall_image("TextureMaterial/suitbutton_texture/");
				}
			} else {
				suitbutton = null;
			}
		} else {
			suitbutton = null;
		}

		// ID
		scd.setId(sc.getId());
		// StoreID
		scd.setDeptid(sc.getDeptid());
		// assetBundleName
		scd.setAssetbundlename(sc.getAssetbundlename());
		// type
		scd.setType(sc.getType());
		// DesignName
		scd.setDesignname(sc.getDesignname());
		// type_name
		scd.setTypename(sc.getTypename());
		// json_url
		scd.setJsonurl(sc.getJsonurl());
		// DesignImage
		scd.setPicture(sc.getPicture());
		// CreateTime
		scd.setCreatedate(sc.getCreatedate());
		// UpdateTime
		scd.setUpdatedate(sc.getUpdatedate());

		// collar
		scd.setCollar(collar);
		// font
		scd.setFont(font);
		// back
		scd.setBack(back);
		// sleeve
		scd.setBuff(sleeve);
		// breastpocket
		scd.setBreastpocket(breastpocket);
		// buttoneye
		scd.setButtoneye(buttoneye);
		// frontdart
		scd.setFrontdart(frontdart);
		// pocket
		scd.setPocket(pocket);
		// placket
		scd.setPlacket(placket);
		// botouyan
		scd.setBotouyan(botouyan);
		// xiabai
		scd.setXiabai(xiabai);
		// yaotou
		scd.setYaotou(yaotou);
		// kujiao
		scd.setKujiao(kujiao);
		// cekoudai
		scd.setCekoudai(cekoudai);
		// houkoudai
		scd.setHoukoudai(houkoudai);
		// buttonnum
		scd.setButtonnum(buttonnum);
		// suitbom
		scd.setSuitbom(suitbom);
		// insidebom
		scd.setInsidebom(insidebom);
		// shirtBom
		scd.setShirtbom(shirtbom);
		// kouyanBom
		scd.setKouyanbom(kouyanbom);
		// tieBom
		scd.setTiebom(tiebom);
		// suitbutton
		scd.setSuitbutton(suitbutton);
		log.info("[查询指定购物车详情信息]===>查询成功！<===");
		rjb = new ResultJsonBean(true, scd, "1", "[查询指定购物车详情信息]===>查询成功！<===");

		return rjb;
	}
	
	
	/**
	 * 
	 * 业  务: 删除指定购物车信息 <br>
	 * 英文名: deleteShoppingCart 
	 * 功能号: TODO
	 * 时  间: 2017年4月27日 上午11:01:30
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/deleteShoppingCart")
	public ResultJsonBean deleteShoppingCart(HttpServletRequest request,HttpServletResponse response) {
		
		ResultJsonBean rjb = null;

		// 入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		String scid = request.getParameter("scid");

		// 验证参数
		if (di == null) {
			log.error("[删除购物车]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",	"[删除购物车]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[删除购物车]===>缺少密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",	"[删除购物车]===>缺少密钥参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[删除购物车]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",	"[删除购物车]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
			//删除购物车
			int res = this.shoppingCartService.deleteShoppingCart(scid);
			
			if(res == 1){
				log.info("删除指定购物车信息成功!");
				rjb = new ResultJsonBean(true, scid, "1","[删除购物车]===>删除指定购物车信息成功!<===");
			}else{
				log.error("删除指定购物车信息失败!");
				rjb = new ResultJsonBean(true, scid, "-1","[删除购物车]===>删除指定购物车信息失败!<===");
			}
		}
		return rjb;
	}
}
