package com.cn.zyrs.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.GoodsParts;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.service.IParts;
import com.cn.zyrs.utils.JsonHelper;
import com.cn.zyrs.utils.MD5;

@Controller
@RequestMapping("/json")
public class JsonController {

	private static Logger log = Logger.getLogger(JsonController.class);

	@Resource(name = "partsService")
	private IParts partsService;

	/**
	 * 
	 * 业 务: 面料品牌生成JSON <br>
	 * 英文名: bomToJson 功能号: TODO 时 间: 2016年12月9日 下午5:33:37 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/bomToJson")
	public ResultJsonBean bomToJson(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");

		// 定义根目录
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		if ("suitbom".equals(type)) {
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			for (int i = 0; i < brands.size(); i++) {
				JSONObject js = new JSONObject();
				// 查询品牌名的英文名称
				bp.setChina_brand_name(brands.get(i));
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();

				js.put("name", brands.get(i));
				js.put("json", "TextureMaterial/suit_texture_" + brandEN
						+ ".json");
				jsonValues.put(js);
			}
			json.put("content", jsonValues);

			try {
				JsonHelper.writeToJson(
						rootPath + "Dress/data/TextureMaterial/",
						"suitBom.json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>"
						+ "suitBom.json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + "suitBom.json" + "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>"
						+ "suitBom.json" + "<<-----生成失败！");
				return rjb;
			}

		}

		if ("insidebom".equals(type)) {
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			for (int i = 0; i < brands.size(); i++) {
				JSONObject js = new JSONObject();
				// 查询品牌名的英文名称
				bp.setChina_brand_name(brands.get(i));
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();

				js.put("name", brands.get(i));
				js.put("json", "TextureMaterial/inside_texture_" + brandEN
						+ ".json");
				jsonValues.put(js);
			}
			json.put("content", jsonValues);

			try {
				JsonHelper.writeToJson(
						rootPath + "Dress/data/TextureMaterial/",
						"insideBom.json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>"
						+ "insideBom.json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + "insideBom.json" + "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>"
						+ "insideBom.json" + "<<-----生成失败！");
				return rjb;
			}

		}

		if ("shirtbom".equals(type)) {
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			for (int i = 0; i < brands.size(); i++) {
				JSONObject js = new JSONObject();
				// 查询品牌名的英文名称
				bp.setChina_brand_name(brands.get(i));
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();

				js.put("name", brands.get(i));
				js.put("json", "TextureMaterial/shirt_texture_" + brandEN
						+ ".json");
				jsonValues.put(js);
			}
			json.put("content", jsonValues);

			try {
				JsonHelper.writeToJson(
						rootPath + "Dress/data/TextureMaterial/",
						"shirtBom.json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>"
						+ "shirtBom.json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + "shirtBom.json" + "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>"
						+ "shirtBom.json" + "<<-----生成失败！");
				return rjb;
			}

		}

		if ("tiebom".equals(type)) {
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			for (int i = 0; i < brands.size(); i++) {
				JSONObject js = new JSONObject();
				// 查询品牌名的英文名称
				bp.setChina_brand_name(brands.get(i));
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();

				js.put("name", brands.get(i));
				js.put("json", "TextureMaterial/tie_texture_" + brandEN
						+ ".json");
				jsonValues.put(js);
			}
			json.put("content", jsonValues);

			try {
				JsonHelper.writeToJson(
						rootPath + "Dress/data/TextureMaterial/",
						"tieBom.json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>"
						+ "tieBom.json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + "tieBom.json" + "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>"
						+ "tieBom.json" + "<<-----生成失败！");
				return rjb;
			}

		}

		if ("botouyanbom".equals(type)) {
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			for (int i = 0; i < brands.size(); i++) {
				JSONObject js = new JSONObject();
				// 查询品牌名的英文名称
				bp.setChina_brand_name(brands.get(i));
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();

				js.put("name", brands.get(i));
				js.put("json", "TextureMaterial/botouyan_texture_" + brandEN
						+ ".json");
				jsonValues.put(js);
			}
			json.put("content", jsonValues);

			try {
				JsonHelper.writeToJson(
						rootPath + "Dress/data/TextureMaterial/",
						"botouyanBom.json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>"
						+ "botouyanBom.json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + "botouyanBom.json" + "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>"
						+ "botouyanBom.json" + "<<-----生成失败！");
				return rjb;
			}

		}

		if ("kouyanbom".equals(type)) {
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			for (int i = 0; i < brands.size(); i++) {
				JSONObject js = new JSONObject();
				// 查询品牌名的英文名称
				bp.setChina_brand_name(brands.get(i));
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();

				js.put("name", brands.get(i));
				js.put("json", "TextureMaterial/kouyan_texture_" + brandEN
						+ ".json");
				jsonValues.put(js);
			}
			json.put("content", jsonValues);

			try {
				JsonHelper.writeToJson(
						rootPath + "Dress/data/TextureMaterial/",
						"kouyanBom.json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>"
						+ "kouyanBom.json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + "kouyanBom.json" + "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>"
						+ "kouyanBom.json" + "<<-----生成失败！");
				return rjb;
			}

		}
		return rjb;
	}

	/**
	 * 
	 * 业 务: 生成面料品牌详情JSON文件 <br>
	 * 英文名: detailToJson 功能号: TODO 时 间: 2016年12月9日 下午7:02:57 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/detailToJson")
	public ResultJsonBean detailToJson(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");

		// 定义根目录
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		if ("suitbom".equals(type)) {
			// 获取所有的西服面料品牌名称
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			for (int i = 0; i < brands.size(); i++) {
				JSONObject json = new JSONObject();
				JSONArray jsonValues = new JSONArray();
				// 查询各个品牌的所有信息
				bp.setChina_brand_name(brands.get(i));
				bp.setStyle(type);
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();
				// 遍历结果，生成JSON
				for (int j = 0; j < bpl.size(); j++) {
					JSONObject js = new JSONObject();
					js.put("id", bpl.get(j).getId() == null ? "" : bpl.get(j).getId());
					js.put("style", bpl.get(j).getStyle() == null ? "" : bpl.get(j).getStyle());
					js.put("english_brand_name", bpl.get(j)
							.getEnglish_brand_name() == null ? "" : bpl.get(j).getEnglish_brand_name());
					js.put("china_brand_name", bpl.get(j).getChina_brand_name() == null ? "" : bpl.get(j).getChina_brand_name());
					js.put("name", bpl.get(j).getName() == null ? "" : bpl.get(j).getName());
					js.put("code", bpl.get(j).getCode() == null ? "" : bpl.get(j).getCode());
					js.put("small_image", "TextureMaterial/suit_texture/"+ (bpl.get(j).getSmall_image() == null ? "" : bpl.get(j).getSmall_image()));
					js.put("big_image", "TextureMaterial/suit_texture/"	+ (bpl.get(j).getBig_image() == null ? "" : bpl.get(j).getBig_image()));
					js.put("normal_image", "TextureMaterial/suit_texture/"+ (bpl.get(j).getNormal_image() == null ? "" : bpl.get(j).getNormal_image()));
					js.put("salecode", bpl.get(j).getSalecode() == null ? "" : bpl.get(j).getSalecode());
					js.put("remark", bpl.get(j).getRemark() == null ? "" : bpl.get(j).getRemark());
					// JSON数据存储到JSON数组中
					jsonValues.put(js);
				}
				json.put("brand", brands.get(i));
				json.put("content", jsonValues);

				// 将一组品牌的详情JSON数据写入对应的文件
				try {
					JsonHelper.writeToJson(rootPath
							+ "Dress/data/TextureMaterial/", "suit_texture_"
							+ brandEN + ".json", json);
					rjb = new ResultJsonBean(true, null, "1", "----->>"
							+ "suit_texture_" + brandEN + ".json"
							+ "<<-----生成成功！");
				} catch (IOException e) {
					e.printStackTrace();
					log.error("----->>" + "suit_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					rjb = new ResultJsonBean(false, null, "-1", "----->>"
							+ "suit_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					return rjb;
				}

			}
		}

		if ("shirtbom".equals(type)) {
			// 获取所有的西服面料品牌名称
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			for (int i = 0; i < brands.size(); i++) {
				JSONObject json = new JSONObject();
				JSONArray jsonValues = new JSONArray();
				// 查询各个品牌的所有信息
				bp.setChina_brand_name(brands.get(i));
				bp.setStyle(type);
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();
				// 遍历结果，生成JSON
				for (int j = 0; j < bpl.size(); j++) {
					JSONObject js = new JSONObject();
					js.put("id", bpl.get(j).getId() == null ? "" : bpl.get(j).getId());
					js.put("style", bpl.get(j).getStyle() == null ? "" : bpl.get(j).getStyle());
					js.put("english_brand_name", bpl.get(j)
							.getEnglish_brand_name() == null ? "" : bpl.get(j).getEnglish_brand_name());
					js.put("china_brand_name", bpl.get(j).getChina_brand_name() == null ? "" : bpl.get(j).getChina_brand_name());
					js.put("name", bpl.get(j).getName() == null ? "" : bpl.get(j).getName());
					js.put("code", bpl.get(j).getCode() == null ? "" : bpl.get(j).getCode());
					js.put("small_image", "TextureMaterial/shirt_texture/"+ (bpl.get(j).getSmall_image() == null ? "" : bpl.get(j).getSmall_image()));
					js.put("big_image", "TextureMaterial/shirt_texture/"	+ (bpl.get(j).getBig_image() == null ? "" : bpl.get(j).getBig_image()));
					js.put("normal_image", "TextureMaterial/shirt_texture/"+ (bpl.get(j).getNormal_image() == null ? "" : bpl.get(j).getNormal_image()));
					js.put("salecode", bpl.get(j).getSalecode() == null ? "" : bpl.get(j).getSalecode());
					js.put("remark", bpl.get(j).getRemark() == null ? "" : bpl.get(j).getRemark());
					// JSON数据存储到JSON数组中
					jsonValues.put(js);
				}
				json.put("brand", brands.get(i));
				json.put("content", jsonValues);

				// 将一组品牌的详情JSON数据写入对应的文件
				try {
					JsonHelper.writeToJson(rootPath
							+ "Dress/data/TextureMaterial/", "shirt_texture_"
							+ brandEN + ".json", json);
					rjb = new ResultJsonBean(true, null, "1", "----->>"
							+ "shirt_texture_" + brandEN + ".json"
							+ "<<-----生成成功！");
				} catch (IOException e) {
					e.printStackTrace();
					log.error("----->>" + "shirt_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					rjb = new ResultJsonBean(false, null, "-1", "----->>"
							+ "shirt_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					return rjb;
				}

			}
		}

		if ("insidebom".equals(type)) {
			// 获取所有的西服面料品牌名称
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			for (int i = 0; i < brands.size(); i++) {
				JSONObject json = new JSONObject();
				JSONArray jsonValues = new JSONArray();
				// 查询各个品牌的所有信息
				bp.setChina_brand_name(brands.get(i));
				bp.setStyle(type);
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();
				// 遍历结果，生成JSON
				for (int j = 0; j < bpl.size(); j++) {
					JSONObject js = new JSONObject();
					js.put("id", bpl.get(j).getId() == null ? "" : bpl.get(j).getId());
					js.put("style", bpl.get(j).getStyle() == null ? "" : bpl.get(j).getStyle());
					js.put("english_brand_name", bpl.get(j)
							.getEnglish_brand_name() == null ? "" : bpl.get(j).getEnglish_brand_name());
					js.put("china_brand_name", bpl.get(j).getChina_brand_name() == null ? "" : bpl.get(j).getChina_brand_name());
					js.put("name", bpl.get(j).getName() == null ? "" : bpl.get(j).getName());
					js.put("code", bpl.get(j).getCode() == null ? "" : bpl.get(j).getCode());
					js.put("small_image", "TextureMaterial/inside_texture/"+ (bpl.get(j).getSmall_image() == null ? "" : bpl.get(j).getSmall_image()));
					js.put("big_image", "TextureMaterial/inside_texture/"	+ (bpl.get(j).getBig_image() == null ? "" : bpl.get(j).getBig_image()));
					js.put("normal_image", "TextureMaterial/inside_texture/"+ (bpl.get(j).getNormal_image() == null ? "" : bpl.get(j).getNormal_image()));
					js.put("salecode", bpl.get(j).getSalecode() == null ? "" : bpl.get(j).getSalecode());
					js.put("remark", bpl.get(j).getRemark() == null ? "" : bpl.get(j).getRemark());
					// JSON数据存储到JSON数组中
					jsonValues.put(js);
				}
				json.put("brand", brands.get(i));
				json.put("content", jsonValues);

				// 将一组品牌的详情JSON数据写入对应的文件
				try {
					JsonHelper.writeToJson(rootPath
							+ "Dress/data/TextureMaterial/", "inside_texture_"
							+ brandEN + ".json", json);
					rjb = new ResultJsonBean(true, null, "1", "----->>"
							+ "inside_texture_" + brandEN + ".json"
							+ "<<-----生成成功！");
				} catch (IOException e) {
					e.printStackTrace();
					log.error("----->>" + "inside_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					rjb = new ResultJsonBean(false, null, "-1", "----->>"
							+ "inside_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					return rjb;
				}

			}
		}

		if ("tiebom".equals(type)) {
			// 获取所有的西服面料品牌名称
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			for (int i = 0; i < brands.size(); i++) {
				JSONObject json = new JSONObject();
				JSONArray jsonValues = new JSONArray();
				// 查询各个品牌的所有信息
				bp.setChina_brand_name(brands.get(i));
				bp.setStyle(type);
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();
				// 遍历结果，生成JSON
				for (int j = 0; j < bpl.size(); j++) {
					JSONObject js = new JSONObject();
					js.put("id", bpl.get(j).getId() == null ? "" : bpl.get(j).getId());
					js.put("style", bpl.get(j).getStyle() == null ? "" : bpl.get(j).getStyle());
					js.put("english_brand_name", bpl.get(j)
							.getEnglish_brand_name() == null ? "" : bpl.get(j).getEnglish_brand_name());
					js.put("china_brand_name", bpl.get(j).getChina_brand_name() == null ? "" : bpl.get(j).getChina_brand_name());
					js.put("name", bpl.get(j).getName() == null ? "" : bpl.get(j).getName());
					js.put("code", bpl.get(j).getCode() == null ? "" : bpl.get(j).getCode());
					js.put("small_image", "TextureMaterial/tie_texture/"+ (bpl.get(j).getSmall_image() == null ? "" : bpl.get(j).getSmall_image()));
					js.put("big_image", "TextureMaterial/tie_texture/"	+ (bpl.get(j).getBig_image() == null ? "" : bpl.get(j).getBig_image()));
					js.put("normal_image", "TextureMaterial/tie_texture/"+ (bpl.get(j).getNormal_image() == null ? "" : bpl.get(j).getNormal_image()));
					js.put("salecode", bpl.get(j).getSalecode() == null ? "" : bpl.get(j).getSalecode());
					js.put("remark", bpl.get(j).getRemark() == null ? "" : bpl.get(j).getRemark());
					// JSON数据存储到JSON数组中
					jsonValues.put(js);
				}
				json.put("brand", brands.get(i));
				json.put("content", jsonValues);

				// 将一组品牌的详情JSON数据写入对应的文件
				try {
					JsonHelper.writeToJson(rootPath
							+ "Dress/data/TextureMaterial/", "tie_texture_"
							+ brandEN + ".json", json);
					rjb = new ResultJsonBean(true, null, "1", "----->>"
							+ "tie_texture_" + brandEN + ".json"
							+ "<<-----生成成功！");
				} catch (IOException e) {
					e.printStackTrace();
					log.error("----->>" + "tie_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					rjb = new ResultJsonBean(false, null, "-1", "----->>"
							+ "tie_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					return rjb;
				}

			}
		}

		if ("botouyanbom".equals(type)) {
			// 获取所有的西服面料品牌名称
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			for (int i = 0; i < brands.size(); i++) {
				JSONObject json = new JSONObject();
				JSONArray jsonValues = new JSONArray();
				// 查询各个品牌的所有信息
				bp.setChina_brand_name(brands.get(i));
				bp.setStyle(type);
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();
				// 遍历结果，生成JSON
				for (int j = 0; j < bpl.size(); j++) {
					JSONObject js = new JSONObject();
					js.put("id", bpl.get(j).getId() == null ? "" : bpl.get(j).getId());
					js.put("style", bpl.get(j).getStyle() == null ? "" : bpl.get(j).getStyle());
					js.put("english_brand_name", bpl.get(j)
							.getEnglish_brand_name() == null ? "" : bpl.get(j).getEnglish_brand_name());
					js.put("china_brand_name", bpl.get(j).getChina_brand_name() == null ? "" : bpl.get(j).getChina_brand_name());
					js.put("name", bpl.get(j).getName() == null ? "" : bpl.get(j).getName());
					js.put("code", bpl.get(j).getCode() == null ? "" : bpl.get(j).getCode());
					js.put("small_image", "TextureMaterial/botouyan_texture/"+ (bpl.get(j).getSmall_image() == null ? "" : bpl.get(j).getSmall_image()));
					js.put("big_image", "TextureMaterial/botouyan_texture/"	+ (bpl.get(j).getBig_image() == null ? "" : bpl.get(j).getBig_image()));
					js.put("normal_image", "TextureMaterial/botouyan_texture/"+ (bpl.get(j).getNormal_image() == null ? "" : bpl.get(j).getNormal_image()));
					js.put("salecode", bpl.get(j).getSalecode() == null ? "" : bpl.get(j).getSalecode());
					js.put("remark", bpl.get(j).getRemark() == null ? "" : bpl.get(j).getRemark());
					// JSON数据存储到JSON数组中
					jsonValues.put(js);
				}
				json.put("brand", brands.get(i));
				json.put("content", jsonValues);

				// 将一组品牌的详情JSON数据写入对应的文件
				try {
					JsonHelper.writeToJson(rootPath
							+ "Dress/data/TextureMaterial/",
							"botouyan_texture_" + brandEN + ".json", json);
					rjb = new ResultJsonBean(true, null, "1", "----->>"
							+ "botouyan_texture_" + brandEN + ".json"
							+ "<<-----生成成功！");
				} catch (IOException e) {
					e.printStackTrace();
					log.error("----->>" + "botouyan_texture_" + brandEN
							+ ".json" + "<<-----生成失败！");
					rjb = new ResultJsonBean(false, null, "-1", "----->>"
							+ "botouyan_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					return rjb;
				}

			}
		}

		if ("kouyanbom".equals(type)) {
			// 获取所有的西服面料品牌名称
			List<String> brands = this.partsService.getBomBrand(type);

			BomParts bp = new BomParts();
			List<BomParts> bpl = null;
			String brandEN = "";

			for (int i = 0; i < brands.size(); i++) {
				JSONObject json = new JSONObject();
				JSONArray jsonValues = new JSONArray();
				// 查询各个品牌的所有信息
				bp.setChina_brand_name(brands.get(i));
				bp.setStyle(type);
				bpl = this.partsService.getBomParts(bp);
				brandEN = bpl.get(0).getEnglish_brand_name();
				// 遍历结果，生成JSON
				for (int j = 0; j < bpl.size(); j++) {
					JSONObject js = new JSONObject();
					js.put("id", bpl.get(j).getId() == null ? "" : bpl.get(j).getId());
					js.put("style", bpl.get(j).getStyle() == null ? "" : bpl.get(j).getStyle());
					js.put("english_brand_name", bpl.get(j)
							.getEnglish_brand_name() == null ? "" : bpl.get(j).getEnglish_brand_name());
					js.put("china_brand_name", bpl.get(j).getChina_brand_name() == null ? "" : bpl.get(j).getChina_brand_name());
					js.put("name", bpl.get(j).getName() == null ? "" : bpl.get(j).getName());
					js.put("code", bpl.get(j).getCode() == null ? "" : bpl.get(j).getCode());
					js.put("small_image", "TextureMaterial/kouyan_texture/"+ (bpl.get(j).getSmall_image() == null ? "" : bpl.get(j).getSmall_image()));
					js.put("big_image", "TextureMaterial/kouyan_texture/"	+ (bpl.get(j).getBig_image() == null ? "" : bpl.get(j).getBig_image()));
					js.put("normal_image", "TextureMaterial/kouyan_texture/"+ (bpl.get(j).getNormal_image() == null ? "" : bpl.get(j).getNormal_image()));
					js.put("salecode", bpl.get(j).getSalecode() == null ? "" : bpl.get(j).getSalecode());
					js.put("remark", bpl.get(j).getRemark() == null ? "" : bpl.get(j).getRemark());
					// JSON数据存储到JSON数组中
					jsonValues.put(js);
				}
				json.put("brand", brands.get(i));
				json.put("content", jsonValues);

				// 将一组品牌的详情JSON数据写入对应的文件
				try {
					JsonHelper.writeToJson(rootPath
							+ "Dress/data/TextureMaterial/", "kouyan_texture_"
							+ brandEN + ".json", json);
					rjb = new ResultJsonBean(true, null, "1", "----->>"
							+ "kouyan_texture_" + brandEN + ".json"
							+ "<<-----生成成功！");
				} catch (IOException e) {
					e.printStackTrace();
					log.error("----->>" + "kouyan_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					rjb = new ResultJsonBean(false, null, "-1", "----->>"
							+ "kouyan_texture_" + brandEN + ".json"
							+ "<<-----生成失败！");
					return rjb;
				}

			}
		}
		return rjb;
	}

	/**
	 * 
	 * 业  务: 商品生成JSON文件 <br>
	 * 英文名: goodsToJson 
	 * 功能号: TODO
	 * 时  间: 2016年12月13日 下午5:02:10
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
	@RequestMapping("/goodsToJson")
	public ResultJsonBean goodsToJson(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");

		// 定义根目录
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		if ("tie".equals(type)) {
			List<String> brands = this.partsService.getGoodsBrand(type);
			rjb = toJson(brands, type, rootPath);
		}

		if ("cravat".equals(type)) {
			List<String> brands = this.partsService.getGoodsBrand(type);
			rjb = toJson(brands, type, rootPath);
		}

		if ("shirtbutton".equals(type)) {
			List<String> brands = this.partsService.getGoodsBrand(type);
			rjb = toJson(brands, type, rootPath);
		}

		if ("suitbutton".equals(type)) {
			List<String> brands = this.partsService.getGoodsBrand(type);
			rjb = toJson(brands, type, rootPath);
		}

		if ("vestbutton".equals(type)) {
			List<String> brands = this.partsService.getGoodsBrand(type);
			rjb = toJson(brands, type, rootPath);
		}

		if ("trousersbutton".equals(type)) {
			List<String> brands = this.partsService.getGoodsBrand(type);
			rjb = toJson(brands, type, rootPath);
		}

		return rjb;
	}

	/**
	 * 
	 * 业  务: 商品详情生成JSON文件 <br>
	 * 英文名: goodsDetailToJson 
	 * 功能号: TODO
	 * 时  间: 2016年12月13日 下午5:01:48
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
	@RequestMapping("/goodsDetailToJson")
	public ResultJsonBean goodsDetailToJson(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");

		// 定义根目录
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		if ("tie".equals(type)) {
			rjb = detailToJson(rootPath, type);
		}

		if ("cravat".equals(type)) {
			rjb = detailToJson(rootPath, type);
		}

		if ("shirtbutton".equals(type)) {
			rjb = detailToJson(rootPath, type);
		}

		if ("suitbutton".equals(type)) {
			rjb = detailToJson(rootPath, type);
		}

		if ("vestbutton".equals(type)) {
			rjb = detailToJson(rootPath, type);
		}

		if ("trousersbutton".equals(type)) {
			rjb = detailToJson(rootPath, type);
		}

		return rjb;
	}

	/**
	 * 
	 * 业  务: 生成MD5版本比对文件 <br>
	 * 英文名: versionToTxt 
	 * 功能号: TODO
	 * 时  间: 2016年12月13日 下午5:01:23
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
	@RequestMapping("/versionToTxt")
	public ResultJsonBean versionToTxt(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// 定义根目录
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		//生成文件内容
		String version = "";
		try {
			version = DirToMD5(rootPath+"Dress/data");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("version.txt生成失败！");
			rjb = new ResultJsonBean(false,null,"-1","version.txt生成失败！");
			return rjb;
		}
		//文件内容写到指定位置
		MD5.TextToFile(rootPath+"Dress","version.txt",version);
		rjb = new ResultJsonBean(true, null, "1", "version.txt生成成功！");
		log.info("version.txt生成成功！");
		
		return rjb;
	}

	
	public ResultJsonBean toJson(List<String> brands, String type,
			String rootPath) {
		ResultJsonBean rjb = null;

		GoodsParts gp = new GoodsParts();
		List<GoodsParts> gpl = null;
		String brandEN = "";

		JSONObject json = new JSONObject();
		JSONArray jsonValues = new JSONArray();
		for (int i = 0; i < brands.size(); i++) {
			JSONObject js = new JSONObject();
			// 查询品牌名的英文名称
			gp.setChina_brand_name(brands.get(i));
			gpl = partsService.getGoodsParts(gp);
			brandEN = gpl.get(0).getEnglish_brand_name();

			js.put("name", brands.get(i));
			js.put("json", "Commodity/" + type + "_commodity_" + brandEN
					+ ".json");
			jsonValues.put(js);
		}
		json.put("content", jsonValues);

		try {
			JsonHelper.writeToJson(rootPath + "Dress/data/Commodity/", type
					+ ".json", json);
			rjb = new ResultJsonBean(true, null, "1", "----->>" + type
					+ ".json" + "<<-----生成成功！");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("----->>" + type + ".json" + "<<-----生成失败！");
			rjb = new ResultJsonBean(false, null, "-1", "----->>" + type
					+ ".json" + "<<-----生成失败！");
			return rjb;
		}

		return rjb;

	}

	public ResultJsonBean detailToJson(String rootPath, String type) {
		ResultJsonBean rjb = null;
		// 获取所有的西服面料品牌名称
		List<String> brands = this.partsService.getGoodsBrand(type);

		GoodsParts gp = new GoodsParts();
		List<GoodsParts> gpl = null;
		String brandEN = "";

		for (int i = 0; i < brands.size(); i++) {
			JSONObject json = new JSONObject();
			JSONArray jsonValues = new JSONArray();
			// 查询各个品牌的所有信息
			gp.setChina_brand_name(brands.get(i));
			gp.setStyle(type);
			gpl = this.partsService.getGoodsParts(gp);
			brandEN = gpl.get(0).getEnglish_brand_name();
			// 遍历结果，生成JSON
			for (int j = 0; j < gpl.size(); j++) {
				JSONObject js = new JSONObject();
				js.put("id", gpl.get(j).getId() == null ? "" : gpl.get(j).getId());
				js.put("style", gpl.get(j).getStyle() == null ? "" : gpl.get(j).getStyle());
				js.put("english_brand_name", gpl.get(j).getEnglish_brand_name() == null ? "" : gpl.get(j).getEnglish_brand_name());
				js.put("china_brand_name", gpl.get(j).getChina_brand_name() == null ? "" : gpl.get(j).getChina_brand_name());
				js.put("name", gpl.get(j).getName() == null ? "" : gpl.get(j).getName());
				js.put("code", gpl.get(j).getCode() == null ? "" : gpl.get(j).getCode());
				js.put("small_image", "Commodity/" + type + "_commodity/"
						+ (gpl.get(j).getSmall_image() == null ? "" : gpl.get(j).getSmall_image()));
				js.put("modelname", gpl.get(j).getModelname() == null ? "" : gpl.get(j).getModelname());
				js.put("salecode", gpl.get(j).getSalecode() == null ? "" : gpl.get(j).getSalecode());
				js.put("remark", gpl.get(j).getRemark() == null ? "" : gpl.get(j).getRemark());
				// JSON数据存储到JSON数组中
				jsonValues.put(js);
			}
			json.put("brand", brands.get(i));
			json.put("content", jsonValues);

			// 将一组品牌的详情JSON数据写入对应的文件
			try {
				JsonHelper.writeToJson(rootPath + "Dress/data/Commodity/", type
						+ "_commodity_" + brandEN + ".json", json);
				rjb = new ResultJsonBean(true, null, "1", "----->>" + type
						+ "_commodity_" + brandEN + ".json" + "<<-----生成成功！");
			} catch (IOException e) {
				e.printStackTrace();
				log.error("----->>" + type + "_commodity_" + brandEN + ".json"
						+ "<<-----生成失败！");
				rjb = new ResultJsonBean(false, null, "-1", "----->>" + type
						+ "_commodity_" + brandEN + ".json" + "<<-----生成失败！");
				return rjb;
			}

		}
		return rjb;

	}
	
	/**
	 * 
	 * 业  务: 生成Md5文件比对内容 <br>
	 * 英文名: DirToMD5 
	 * 功能号: TODO
	 * 时  间: 2016年12月13日 下午5:03:04
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public String DirToMD5(String rootPath) throws FileNotFoundException, IOException{
		
		//获取根目录
		File dir = new File(rootPath);
		//创建根目录路径
		dir.mkdirs();
		
		File[] files = dir.listFiles();
		
		StringBuffer sb = new StringBuffer();
		String str = "";
		//遍历文件夹路径下的所有文件，并生成与其对应的MD5编码  并将文件名与对应的MD5码组合
		for(int i=0;i<files.length;i++){
			String fn = files[i].getName();
			if(files[i].isDirectory()){
				  str = DirToMD5(rootPath+"/"+fn);
			}else{
				File file = new File(rootPath,fn);
				String md5 = DigestUtils.md5Hex(new FileInputStream(file));
				String exstr= files[i].getPath().replaceAll("\\\\", "/").replaceFirst("Dress/data/", "&")+","+md5+"\r\n";
				int flag = exstr.indexOf("&") + 1 ;
				str = exstr.substring(flag);
			}
			sb.append(str);
		}
		return sb.toString();
		
	}

}
