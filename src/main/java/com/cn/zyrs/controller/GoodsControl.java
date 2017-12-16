package com.cn.zyrs.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.cn.zyrs.domain.GoodsParts;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.service.IParts;
import com.cn.zyrs.utils.DynamicDataSource;

@Controller
@RequestMapping("/goods")
public class GoodsControl {

	private static Logger log = Logger.getLogger(PartsController.class);

	@Resource(name = "partsService")
	private IParts partsService;

	@ResponseBody
	@RequestMapping("/addGoods")
	public ResultJsonBean addGoods(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String id = request.getParameter("id");
		// 如果没有传平面图，则生成一个随机数做主键
		if (id == null || "".equalsIgnoreCase(id)) {
			id = UUID.randomUUID().toString();
		}
		String style = request.getParameter("style");
		String brandNameEN = request.getParameter("brandNameEN");
		String brandNameCN = request.getParameter("brandNameCN");
		String bomName = request.getParameter("bomName");
		String bomCode = request.getParameter("bomCode");
		String remark = request.getParameter("remark");
		String smallimage = request.getParameter("smallimage");
		String modelname = request.getParameter("modelname");

		GoodsParts gp = new GoodsParts();

		gp.setId(id);
		gp.setStyle(style);
		gp.setEnglish_brand_name(brandNameEN);
		gp.setChina_brand_name(brandNameCN);
		gp.setName(bomName);
		gp.setCode(bomCode);
		gp.setRemark(remark);
		gp.setSmall_image(smallimage);
		gp.setModelname(modelname);

		int res = -1;
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		res = this.partsService.addGoods(gp);

		if (res == 1) {
			log.info("新增配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		} else {
			log.error("新增配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		}
		return rjb;

	}

	@ResponseBody
	@RequestMapping("/updateGoods")
	public ResultJsonBean updateGoods(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String id = request.getParameter("id");

		String style = request.getParameter("style");
		String brandNameEN = request.getParameter("brandNameEN");
		String brandNameCN = request.getParameter("brandNameCN");
		String bomName = request.getParameter("bomName");
		String bomCode = request.getParameter("bomCode");
		String remark = request.getParameter("remark");
		String smallimage = request.getParameter("smallimage");
		String modelname = request.getParameter("modelName");

		GoodsParts gp = new GoodsParts();

		gp.setId(id);
		gp.setStyle(style);
		gp.setEnglish_brand_name(brandNameEN);
		gp.setChina_brand_name(brandNameCN);
		gp.setName(bomName);
		gp.setCode(bomCode);
		gp.setRemark(remark);
		gp.setSmall_image(smallimage);
		gp.setModelname(modelname);

		int res = -1;
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		res = this.partsService.updateGoods(gp);

		if (res == 1) {
			log.info("修改配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "修改配件信息成功！");
		} else {
			log.error("修改配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "修改配件信息失败！");
		}
		return rjb;

	}

	@ResponseBody
	@RequestMapping("/getGoods")
	public ResultJsonBean getGoods(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String id = request.getParameter("id");
		String style = request.getParameter("enName");

		GoodsParts gp = new GoodsParts();

		gp.setId(id);
		gp.setStyle(style);

		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		List<GoodsParts> gpl = this.partsService.getGoodsParts(gp);

		if (gpl != null && gpl.size() > 0) {
			rjb = new ResultJsonBean(true, gpl, "1", "查询配件信息成功！");
			log.info("查询配件信息成功！");
		} else if (gpl != null && gpl.size() == 0) {
			rjb = new ResultJsonBean(false, gpl, "-1", "查询不到匹配信息！");
			log.error("查询不到匹配信息！");
		}

		return rjb;

	}

	@ResponseBody
	@RequestMapping("/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

		String type = request.getParameter("type");
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "Dress/data/Commodity/" + type + "_commodity";
		String name = UUID.randomUUID().toString() + ".jpg";

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("upfile");
		String fName = multipartFile.getOriginalFilename();
		File file = new File(rootPath, name);
		FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
		String filesize = multipartFile.getSize() / 1024L + "k";

		JSONObject res = new JSONObject();
		res.put("path", rootPath);
		res.put("exName", fName);
		res.put("name", name);
		res.put("filesize", filesize);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(res.toJSONString());

		log.info(fName + "上传成功！");
	}

	@ResponseBody
	@RequestMapping("/upload1")
	public void upload1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

		String type = request.getParameter("type");
		String fileName = request.getParameter("fileName");
		String id = request.getParameter("id");
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "Dress/data/Commodity/" + type + "_commodity";
		String name = "";// 生成文件名称
		if (fileName == null || "".equalsIgnoreCase(fileName)) {
			name = UUID.randomUUID().toString() + ".jpg";
		} else {
			name = fileName;
		}
		// 修改数据库数据
		GoodsParts gp = new GoodsParts();
		gp.setId(id);
		gp.setSmall_image(name);
		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		this.partsService.updateGoods(gp);

		// 上传文件
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("upfile");
		String fName = multipartFile.getOriginalFilename();
		File file = new File(rootPath, name);
		FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
		String filesize = multipartFile.getSize() / 1024L + "k";

		JSONObject res = new JSONObject();
		res.put("path", rootPath);
		res.put("exName", fName);
		res.put("name", name);
		res.put("filesize", filesize);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(res.toJSONString());

		log.info(fName + "上传成功！");

	}

	/**
	 * 
	 * 业  务: 检查数据库中是否已经存在该模型 <br>
	 * 英文名: checkModelName 
	 * 功能号: TODO
	 * 时  间: 2017年7月15日 下午2:00:02
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
	@RequestMapping("/checkModelName")
	public ResultJsonBean checkModelName(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String modelName = request.getParameter("modelName");

		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		int res = this.partsService.checkGoodsModelName(modelName);

		if (res != 0) {
			log.error("数据库中已存在该模型！");
			rjb = new ResultJsonBean(false, res, "-1", "数据库中已存在该模型！");
			return rjb;
		}
		rjb = new ResultJsonBean(true, res, "1", "该模型名称可用！");
		log.info("该模型名称可用！");
		return rjb;

	}

}
