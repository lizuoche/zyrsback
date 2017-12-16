package com.cn.zyrs.controller;

import java.util.List;
import java.util.Map;
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
import com.cn.zyrs.domain.DesignBase;
import com.cn.zyrs.domain.DesignDetail;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.SuitParts;
import com.cn.zyrs.service.IDesign;
import com.cn.zyrs.service.IParts;
import com.cn.zyrs.service.IUser;
import com.cn.zyrs.utils.DynamicDataSource;
import com.cn.zyrs.utils.FileUtils;
import com.cn.zyrs.utils.JsonHelper;

@Controller
@RequestMapping("/design")
public class DesignController {

	private static Logger log = Logger.getLogger(DesignController.class);

	@Resource(name = "designService")
	private IDesign designService;

	@Resource(name = "userService")
	private IUser userService;

	@Resource(name = "partsService")
	private IParts partsService;

	/**
	 * 
	 * 业  务: 新增设计方案 <br>
	 * 英文名: showDpetInfo 
	 * 功能号: TODO
	 * 时  间: 2017年3月7日 下午1:55:51
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
	@RequestMapping("/addDesign")
	public ResultJsonBean addDesign(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;
		
		Design design = new Design();
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		// designImage
		String img = request.getParameter("picture");
		// 处理数据
		img = img.replace("_", "/");
		img = img.replace("-", "+");

		String ds = request.getParameter("ds");

		String name = "";
		
		// 验证参数
		if (di == null) {
			log.error("[新增设计方案]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增设计方案]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[新增设计方案]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增设计方案]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (ds == null) {
			log.error("[新增设计方案]===>缺少Json参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增设计方案]===>缺少Json参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[新增设计方案]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增设计方案]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {

			// 新增设计方案
			Map<String, String> jm = JsonHelper.toMap(ds);
			// 判断json字符串转换Map
			if (jm == null) {
				log.error("Json字符串转换Map出错！");
				rjb = new ResultJsonBean(false, null, "-1", "Json字符串转换Map出错");
				return rjb;
			}

			String id = jm.get("id");//主键
			// ID,
			if (id == null || "".equals(id)) {
				design.setId(id = UUID.randomUUID().toString());
				name = UUID.randomUUID().toString() + ".png";
			} else {
				design.setId(jm.get("id"));
				// 获取数据库中存储的图片名称
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<DesignDetail> ddl = this.designService.getDesignDetail(di,
						jm.get("type"), jm.get("id"));
				if (ddl == null || ddl.size() == 0) {
					log.error("查询不到指定的设计方案！");
					return rjb = new ResultJsonBean(false, ddl, "-1",
							"[更新设计方案]=====>查询不到指定的设计方案！<=====");
				}
				name = ddl.get(0).getPicture().split("/upload/designImage/")[1];
			}
			// 上传图片
			String savePath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/designImage/";
			FileUtils.uploadBase64(img, savePath, name);
			// 门店ID,
			design.setDeptid(di);
			// 设计名称,
			design.setDesignname(jm.get("designname"));
			// 创建日期,

			// 更新日期

			// 设计缩略图,
			if (jm.get("id") == null || "".equals(jm.get("id"))) {
				design.setPicture("/upload/designImage/" + name);
			}

			// 款式ID,

			// 款式名称,
			design.setTypename(jm.get("typename"));
			// 资源包,
			design.setAssetbundlename(jm.get("assetbundlename"));
			// json名称,
			design.setJsonurl(jm.get("jsonurl"));
			// 领子,
			if (jm.get("collar") != null && !"".equals(jm.get("collar"))) {
				design.setCollar(JsonHelper.toMap(jm.get("collar").toString())
						.get("id"));
			}
			// 前片,
			if (jm.get("font") != null && !"".equals(jm.get("font"))) {
				design.setFont(JsonHelper.toMap(jm.get("font").toString()).get(
						"id"));
			}
			// 后片,
			if (jm.get("back") != null && !"".equals(jm.get("back"))) {
				design.setBack(JsonHelper.toMap(jm.get("back").toString()).get(
						"id"));
			}
			// 袖子,
			if (jm.get("buff") != null && !"".equals(jm.get("buff"))) {
				design.setBuff(JsonHelper.toMap(jm.get("buff").toString())
						.get("id"));
			}
			// 胸袋,
			if (jm.get("breastpocket") != null
					&& !"".equals(jm.get("breastpocket"))) {
				design.setBreastpocket(JsonHelper.toMap(
						jm.get("breastpocket").toString()).get("id"));
			}
			// 扣眼,
			if (jm.get("buttoneye") != null && !"".equals(jm.get("buttoneye"))) {
				design.setButtoneye(JsonHelper.toMap(
						jm.get("buttoneye").toString()).get("id"));
			}
			// 前褶,
			if (jm.get("frontdart") != null && !"".equals(jm.get("frontdart"))) {
				design.setButtoneye(JsonHelper.toMap(
						jm.get("frontdart").toString()).get("id"));
			}
			// 口袋,
			if (jm.get("pocket") != null && !"".equals(jm.get("pocket"))) {
				design.setPocket(JsonHelper.toMap(jm.get("pocket").toString())
						.get("id"));
			}
			// 扣眼数,
			if (jm.get("buttonnum") != null && !"".equals(jm.get("buttonnum"))) {
				design.setButtonnum(JsonHelper.toMap(
						jm.get("buttonnum").toString()).get("id"));
			}
			// 门襟,
			if (jm.get("placket") != null && !"".equals(jm.get("placket"))) {
				design.setPlacket(JsonHelper
						.toMap(jm.get("placket").toString()).get("id"));
			}
			// 驳头眼,
			if (jm.get("botouyan") != null && !"".equals(jm.get("botouyan"))) {
				design.setBotouyan(JsonHelper.toMap(
						jm.get("botouyan").toString()).get("id"));
			}
			// 下摆,
			if (jm.get("xiabai") != null && !"".equals(jm.get("xiabai"))) {
				design.setXiabai(JsonHelper.toMap(jm.get("xiabai").toString())
						.get("id"));
			}
			// 腰头,
			if (jm.get("yaotou") != null && !"".equals(jm.get("yaotou"))) {
				design.setYaotou(JsonHelper.toMap(jm.get("yaotou").toString())
						.get("id"));
			}
			// 裤脚,
			if (jm.get("kujiao") != null && !"".equals(jm.get("kujiao"))) {
				design.setKujiao(JsonHelper.toMap(jm.get("kujiao").toString())
						.get("id"));
			}
			// 侧口袋,
			if (jm.get("cekoudai") != null && !"".equals(jm.get("cekoudai"))) {
				design.setCekoudai(JsonHelper.toMap(
						jm.get("cekoudai").toString()).get("id"));
			}
			// 后口袋,
			if (jm.get("houkoudai") != null && !"".equals(jm.get("houkoudai"))) {
				design.setHoukoudai(JsonHelper.toMap(
						jm.get("houkoudai").toString()).get("id"));
			}
			// 西服面料,
			if (jm.get("suitbom") != null && !"".equals(jm.get("suitbom"))) {
				design.setSuitbom(JsonHelper
						.toMap(jm.get("suitbom").toString()).get("id"));
			}
			// 里料,
			if (jm.get("insidebom") != null && !"".equals(jm.get("insidebom"))) {
				design.setInsidebom(JsonHelper.toMap(
						jm.get("insidebom").toString()).get("id"));
			}
			// 衬衫面料,
			if (jm.get("shirtbom") != null && !"".equals(jm.get("shirtbom"))) {
				design.setShirtbom(JsonHelper.toMap(
						jm.get("shirtbom").toString()).get("id"));
			}
			// 领带面料,
			if (jm.get("tiebom") != null && !"".equals(jm.get("tiebom"))) {
				design.setTiebom(JsonHelper.toMap(jm.get("tiebom").toString())
						.get("id"));
			}
			
			//扣眼面料,
			if (jm.get("kouyanbom") != null && !"".equals(jm.get("kouyanbom"))) {
				design.setKouyanbom(JsonHelper.toMap(jm.get("kouyanbom").toString())
						.get("id"));
			}
			
			// 西服扣,
			if (jm.get("suitbutton") != null
					&& !"".equals(jm.get("suitbutton"))) {
				design.setSuitbutton(JsonHelper.toMap(
						jm.get("suitbutton").toString()).get("id"));
			}
			// 领带,
			if (jm.get("tie") != null && !"".equals(jm.get("tie"))) {
				design.setTie(JsonHelper.toMap(jm.get("tie").toString()).get(
						"id"));
			}
			// 领结,
			if (jm.get("cravat") != null && !"".equals(jm.get("cravat"))) {
				design.setCravat(JsonHelper.toMap(jm.get("cravat").toString())
						.get("id"));
			}
			// 小图,
			if (jm.get("small_image") != null
					&& !"".equals(jm.get("small_image"))) {
				design.setSmallImage(JsonHelper.toMap(
						jm.get("small_image").toString()).get("id"));
			}
			// 大图,
			if (jm.get("big_image") != null && !"".equals(jm.get("big_image"))) {
				design.setBigImage(JsonHelper.toMap(
						jm.get("big_image").toString()).get("id"));
			}

			// 删除标志,

			// 是否有效

			// 新增设计
			// 款式类型
			String type = jm.get("type");

			int res = 0;
			// 已存在则更新 不存在则新增
			if ("suit".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				if (jm.get("id") == null || "".equals(jm.get("id"))) {
					res = this.designService.addDseignSuit(design);
				} else {
					// 查询数据库 是否存在此id 不存在则新增
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					List<Design> fl = this.designService.getDesign(di, type,
							jm.get("id"));
					if (fl == null || fl.size() == 0) {
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.addDseignSuit(design);
					} else {
						// 存在则更新
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.updateDesignSuit(design);
					}
				}
			} else if ("trousers".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				if (jm.get("id") == null || "".equals(jm.get("id"))) {
					res = this.designService.addDseignTrousers(design);
				} else {
					// 查询数据库 是否存在此id 不存在则新增
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					List<Design> fl = this.designService.getDesign(di, type,
							jm.get("id"));
					if (fl == null || fl.size() == 0) {
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.addDseignSuit(design);
					} else {
						// 存在则更新
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.updateDesignTrousers(design);
					}
				}
			} else if ("shirt".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				if (jm.get("id") == null || "".equals(jm.get("id"))) {
					res = this.designService.addDseignShirt(design);
				} else {
					// 查询数据库 是否存在此id 不存在则新增
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					List<Design> fl = this.designService.getDesign(di, type,
							jm.get("id"));
					if (fl == null || fl.size() == 0) {
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.addDseignSuit(design);
					} else {
						// 存在则更新
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.updateDesignShirt(design);
					}
				}
			} else if ("vest".equalsIgnoreCase(type)) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				if (jm.get("id") == null || "".equals(jm.get("id"))) {
					res = this.designService.addDseignVest(design);
				} else {
					// 查询数据库 是否存在此id 不存在则新增
					DynamicDataSource
							.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
					List<Design> fl = this.designService.getDesign(di, type,
							jm.get("id"));
					if (fl == null || fl.size() == 0) {
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.addDseignSuit(design);
					} else {
						// 存在则更新
						DynamicDataSource
								.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
						res = this.designService.updateDesignVest(design);
					}
				}
			}
			// 验证结果
			if (res == 1) {
				//查询信息
				DynamicDataSource
				.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				DesignDetail dd = this.designService.getDesignDetail(di, type, id).get(0);
				log.info("[新增设计方案]===>新增成功！<===");
				rjb = new ResultJsonBean(true, dd, "1",
						"[新增设计方案]===>新增成功！<===");
			} else {
				log.info("[新增设计方案]===>新增失败！<===");
				rjb = new ResultJsonBean(false, res, "-1",
						"[新增设计方案]===>新增成失败！<===");
			}

		} else {
			log.error("[新增设计方案]===>密钥不匹配,新增失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增设计方案]===>密钥不匹配,新增失败！<===");
		}

		return rjb;

	}

	/**
	 * 
	 * 业  务: 查询设计方案 <br>
	 * 英文名: showDesign 
	 * 功能号: TODO
	 * 时  间: 2016年8月24日 上午10:21:35
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
	@RequestMapping("/showDesign")
	public ResultJsonBean showDesign(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		String id = request.getParameter("id");
		String type = request.getParameter("type");

		// 验证参数
		if (di == null) {
			log.error("[查询设计方案]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询设计方案]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[查询设计方案]===>缺少密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询设计方案]===>缺少密钥参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[查询设计方案]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询设计方案]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {

			// 查询所有设计基本信息
			if (id == null) {
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<DesignBase> dsbl = this.designService.getDesignBase(di,
						type);
				for (int i = 0; i < dsbl.size(); i++) {
					dsbl.get(i).setJsonurl(dsbl.get(i).getJsonurl());
				}

				log.info("[查询所有设计方案]===>查询成功！<===");
				rjb = new ResultJsonBean(true, dsbl, "1",
						"[查询所有设计方案]===>查询成功！<===");
			} else {
				// 查询指定ID的设计方案详情：
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				List<Design> dsl = this.designService.getDesign(di, type, id);

				if (dsl.size() == 0) {
					log.error("[查询指定设计方案详情信息]===>查询不到指定的设计方案信息！<===");
					rjb = new ResultJsonBean(false, dsl, "-1",
							"[查询指定设计方案详情信息]===>查询不到指定的设计方案信息！<===");
					return rjb;
				}

				Design ds = dsl.get(0);
				BomParts bp = new BomParts();
				CommodityParts cp = new CommodityParts();
				DesignDetail dd = new DesignDetail();
				// 处理数据结果
				rjb = getSuitDesign(ds, bp, cp, dd, ds.getType());
			}
		} else {
			log.error("[查询门店设计方案]===>密钥不匹配,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[查询门店设计方案]===>密钥不匹配,查询失败！<===");
		}

		return rjb;

	}

	/**
	 * 
	 * 业  务: 获取指定的西服设计方案详情信息 <br>
	 * 英文名: getSuitDesign 
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
	public ResultJsonBean getSuitDesign(Design ds, BomParts bp, CommodityParts cp,
			DesignDetail dd, String type) {
		ResultJsonBean rjb = null;

		// 配件
		// collar
		SuitParts collar = new SuitParts();
		if (ds.getCollar() != null && !"".equals(ds.getCollar())) {
			collar = this.partsService.getparts(ds.getCollar());
			collar.setimage1("json/" + type + "/image/" + collar.getimage1());
		} else {
			collar = null;
		}
		// font
		SuitParts font = new SuitParts();
		if (ds.getFont() != null && !"".equals(ds.getFont())) {
			font = this.partsService.getparts(ds.getFont());
			font.setimage1("json/" + type + "/image/" + font.getimage1());
		} else {
			font = null;
		}
		// back
		SuitParts back = new SuitParts();
		if (ds.getBack() != null && !"".equals(ds.getBack())) {
			back = this.partsService.getparts(ds.getBack());
			back.setimage1("json/" + type + "/image/" + back.getimage1());
		} else {
			back = null;
		}
		// sleeve
		SuitParts sleeve = new SuitParts();
		if (ds.getBuff() != null && !"".equals(ds.getBuff())) {
			sleeve = this.partsService.getparts(ds.getBuff());
			sleeve.setimage1("json/" + type + "/image/" + sleeve.getimage1());
		} else {
			sleeve = null;
		}
		// breastpocket
		SuitParts breastpocket = new SuitParts();
		if (ds.getBreastpocket() != null && !"".equals(ds.getBreastpocket())) {
			breastpocket = this.partsService.getparts(ds.getBreastpocket());
			breastpocket.setimage1("json/" + type + "/image/"
					+ breastpocket.getimage1());
		} else {
			breastpocket = null;
		}
		// buttoneye
		SuitParts buttoneye = new SuitParts();
		if (ds.getButtoneye() != null && !"".equals(ds.getButtoneye())) {
			buttoneye = this.partsService.getparts(ds.getButtoneye());
			buttoneye.setimage1("json/" + type + "/image/"
					+ buttoneye.getimage1());
		} else {
			buttoneye = null;
		}
		// frontdart
		SuitParts frontdart = new SuitParts();
		if (ds.getFrontdart() != null && !"".equals(ds.getFrontdart())) {
			frontdart = this.partsService.getparts(ds.getFrontdart());
			frontdart.setimage1("json/" + type + "/image/"
					+ frontdart.getimage1());
		} else {
			frontdart = null;
		}
		// pocket
		SuitParts pocket = new SuitParts();
		if (ds.getPocket() != null && !"".equals(ds.getPocket())) {
			pocket = this.partsService.getparts(ds.getPocket());
			pocket.setimage1("json/" + type + "/image/" + pocket.getimage1());
		} else {
			pocket = null;
		}
		// placket
		SuitParts placket = new SuitParts();
		if (ds.getPlacket() != null && !"".equals(ds.getPlacket())) {
			placket = this.partsService.getparts(ds.getPlacket());
			placket.setimage1("json/" + type + "/image/" + placket.getimage1());
		} else {
			placket = null;
		}
		// botouyan
		SuitParts botouyan = new SuitParts();
		if (ds.getBotouyan() != null && !"".equals(ds.getBotouyan())) {
			botouyan = this.partsService.getparts(ds.getBotouyan());
			botouyan.setimage1("json/" + type + "/image/"
					+ botouyan.getimage1());
		} else {
			botouyan = null;
		}
		// xiabai
		SuitParts xiabai = new SuitParts();
		if (ds.getXiabai() != null && !"".equals(ds.getXiabai())) {
			xiabai = this.partsService.getparts(ds.getXiabai());
			xiabai.setimage1("json/" + type + "/image/" + xiabai.getimage1());
		} else {
			xiabai = null;
		}
		// yaotou
		SuitParts yaotou = new SuitParts();
		if (ds.getYaotou() != null && !"".equals(ds.getYaotou())) {
			yaotou = this.partsService.getparts(ds.getYaotou());
			yaotou.setimage1("json/" + type + "/image/" + yaotou.getimage1());
		} else {
			yaotou = null;
		}
		// kujiao
		SuitParts kujiao = new SuitParts();
		if (ds.getKujiao() != null && !"".equals(ds.getKujiao())) {
			kujiao = this.partsService.getparts(ds.getKujiao());
			kujiao.setimage1("json/" + type + "/image/" + kujiao.getimage1());
		} else {
			kujiao = null;
		}
		// cekoudai
		SuitParts cekoudai = new SuitParts();
		if (ds.getCekoudai() != null && !"".equals(ds.getCekoudai())) {
			cekoudai = this.partsService.getparts(ds.getCekoudai());
			cekoudai.setimage1("json/" + type + "/image/"
					+ cekoudai.getimage1());
		} else {
			cekoudai = null;
		}
		// houkoudai
		SuitParts houkoudai = new SuitParts();
		if (ds.getHoukoudai() != null && !"".equals(ds.getHoukoudai())) {
			houkoudai = this.partsService.getparts(ds.getHoukoudai());
			houkoudai.setimage1("json/" + type + "/image/"
					+ houkoudai.getimage1());
		} else {
			houkoudai = null;
		}
		// buttonnum
		SuitParts buttonnum = new SuitParts();
		if (ds.getButtonnum() != null && !"".equals(ds.getButtonnum())) {
			buttonnum = this.partsService.getparts(ds.getButtonnum());
			buttonnum.setimage1("json/" + type + "/image/"
					+ buttonnum.getimage1());
		} else {
			buttonnum = null;
		}

		// 布料
		// suitbom
		BomParts suitbom = new BomParts();
		bp.setId(ds.getSuitbom());
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
		bp.setId(ds.getInsidebom());
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
		bp.setId(ds.getShirtbom());
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
		bp.setId(ds.getKouyanbom());
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
		bp.setId(ds.getTiebom());
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
		cp.setId(ds.getSuitbutton());
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
		dd.setId(ds.getId());
		// StoreID
		dd.setDeptid(ds.getDeptid());
		// assetBundleName
		dd.setAssetbundlename(ds.getAssetbundlename());
		// type
		dd.setType(ds.getType());
		// DesignName
		dd.setDesignname(ds.getDesignname());
		// type_name
		dd.setTypename(ds.getTypename());
		// json_url
		dd.setJsonurl(ds.getJsonurl());
		// DesignImage
		dd.setPicture(ds.getPicture());
		// CreateTime
		dd.setCreatedate(ds.getCreatedate());
		// UpdateTime
		dd.setUpdatedate(ds.getUpdatedate());

		// collar
		dd.setCollar(collar);
		// font
		dd.setFont(font);
		// back
		dd.setBack(back);
		// sleeve
		dd.setBuff(sleeve);
		// breastpocket
		dd.setBreastpocket(breastpocket);
		// buttoneye
		dd.setButtoneye(buttoneye);
		// frontdart
		dd.setFrontdart(frontdart);
		// pocket
		dd.setPocket(pocket);
		// placket
		dd.setPlacket(placket);
		// botouyan
		dd.setBotouyan(botouyan);
		// xiabai
		dd.setXiabai(xiabai);
		// yaotou
		dd.setYaotou(yaotou);
		// kujiao
		dd.setKujiao(kujiao);
		// cekoudai
		dd.setCekoudai(cekoudai);
		// houkoudai
		dd.setHoukoudai(houkoudai);
		// buttonnum
		dd.setButtonnum(buttonnum);
		// suitbom
		dd.setSuitbom(suitbom);
		// insidebom
		dd.setInsidebom(insidebom);
		// shirtBom
		dd.setShirtbom(shirtbom);
		// kouyanBom
		dd.setKouyanbom(kouyanbom);
		// tieBom
		dd.setTiebom(tiebom);
		// suitbutton
		dd.setSuitbutton(suitbutton);
		log.info("[查询指定设计方案详情信息]===>查询成功！<===");
		rjb = new ResultJsonBean(true, dd, "1", "[查询指定设计方案详情信息]===>查询成功！<===");

		return rjb;
	}

	/**
	 * 
	 * 业  务: 删除设计方案并删除缩略图 <br>
	 * 英文名: deletDesign 
	 * 功能号: TODO
	 * 时  间: 2017年4月14日 下午5:38:15
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
	@RequestMapping("/deleteDesign")
	public ResultJsonBean deleteDesign(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 入参
		String di = request.getParameter("di");
		String key = request.getHeader("JSESSIONID");
		String id = request.getParameter("id");
		String type = request.getParameter("type");

		// 验证参数
		if (di == null) {
			log.error("[删除设计方案]===>缺少门店ID参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[删除设计方案]===>缺少门店ID参数！<===");
			return rjb;
		} else if (key == null) {
			log.error("[删除设计方案]===>缺少门店密钥参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[删除设计方案]===>缺少门店密钥参数！<===");
			return rjb;
		} else if (type == null) {
			log.error("[删除设计方案]===>缺少type参数！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[删除设计方案]===>缺少type参数！<===");
			return rjb;
		}

		// 验证合法用户
		String dk = this.userService.getDeptKey(di);

		if (dk == null || dk.equals("")) {
			log.error("[新增设计方案]===>获取不到密钥信息,查询失败！<===");
			rjb = new ResultJsonBean(false, null, "-1",
					"[新增设计方案]===>获取不到密钥信息,查询失败！<===");
			return rjb;
		}

		if (dk.equals(key)) {
		}

		int res = 0;
		if ("suit".equalsIgnoreCase(type)) {
//			// 获取数据库中存储的图片名称
//			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//			List<DesignDetail> ddl = this.designService.getDesignDetail(di,
//					type, id);
//			if (ddl == null || ddl.size() == 0) {
//				log.error("查询不到指定的设计方案！");
//				return rjb = new ResultJsonBean(false, ddl, "-1",
//						"[更新设计方案]=====>查询不到指定的设计方案！<=====");
//			}
//			String name = ddl.get(0).getPicture().split("/upload/designImage/")[1];
//
//			// 删除图片
//			if (FileUtils.deleteFile(request.getSession().getServletContext()
//					.getRealPath("/")
//					+ "upload/designImage/" + name)) {
//				log.info("图片删除成功！");
//			} else {
//				log.error("图片删除失败！");
//			}

			// 删除数据
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.designService.deleteDesignSuit(di, id);

		} else if ("trousers".equalsIgnoreCase(type)) {
//			// 获取数据库中存储的图片名称
//			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//			List<DesignDetail> ddl = this.designService.getDesignDetail(di,
//					type, id);
//			if (ddl == null || ddl.size() == 0) {
//				log.error("查询不到指定的设计方案！");
//				return rjb = new ResultJsonBean(false, ddl, "-1",
//						"[更新设计方案]=====>查询不到指定的设计方案！<=====");
//			}
//			String name = ddl.get(0).getPicture().split("/upload/designImage/")[1];
//
//			// 删除图片
//			if (FileUtils.deleteFile(request.getSession().getServletContext()
//					.getRealPath("/")
//					+ "upload/designImage/" + name)) {
//				log.info("图片删除成功！");
//			} else {
//				log.error("图片删除失败！");
//			}

			// 删除数据
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.designService.deleteDesignTrousers(di, id);

		} else if ("shirt".equalsIgnoreCase(type)) {

//			// 获取数据库中存储的图片名称
//			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//			List<DesignDetail> ddl = this.designService.getDesignDetail(di,
//					type, id);
//			if (ddl == null || ddl.size() == 0) {
//				log.error("查询不到指定的设计方案！");
//				return rjb = new ResultJsonBean(false, ddl, "-1",
//						"[更新设计方案]=====>查询不到指定的设计方案！<=====");
//			}
//			String name = ddl.get(0).getPicture().split("/upload/designImage/")[1];
//
//			// 删除图片
//			if (FileUtils.deleteFile(request.getSession().getServletContext()
//					.getRealPath("/")
//					+ "upload/designImage/" + name)) {
//				log.info("图片删除成功！");
//			} else {
//				log.error("图片删除失败！");
//			}

			// 删除数据
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.designService.deleteDesignShirt(di, id);

		} else if ("vest".equalsIgnoreCase(type)) {
//			// 获取数据库中存储的图片名称
//			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
//			List<DesignDetail> ddl = this.designService.getDesignDetail(di,
//					type, id);
//			if (ddl == null || ddl.size() == 0) {
//				log.error("查询不到指定的设计方案！");
//				return rjb = new ResultJsonBean(false, ddl, "-1",
//						"[更新设计方案]=====>查询不到指定的设计方案！<=====");
//			}
//			String name = ddl.get(0).getPicture().split("/upload/designImage/")[1];
//
//			// 删除图片
//			if (FileUtils.deleteFile(request.getSession().getServletContext()
//					.getRealPath("/")
//					+ "upload/designImage/" + name)) {
//				log.info("图片删除成功！");
//			} else {
//				log.error("图片删除失败！");
//			}

			// 删除数据
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.designService.deleteDesignVest(di, id);

		}
		// 验证结果
		if (res == 1) {
			log.info("[删除设计方案]===>删除成功！<===");
			rjb = new ResultJsonBean(true, res, "1", "[删除设计方案]===>删除成功！<===");
		} else {
			log.info("[删除设计方案]===>删除失败！<===");
			rjb = new ResultJsonBean(false, res, "-1", "[删除设计方案]===>删除成失败！<===");
		}

		return rjb;

	}

}
