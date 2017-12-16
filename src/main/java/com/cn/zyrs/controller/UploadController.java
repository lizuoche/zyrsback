package com.cn.zyrs.controller;

import java.io.File;
import java.io.IOException;
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
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.service.ImageCode;
import com.cn.zyrs.utils.ParamsUtil;

@Controller
@RequestMapping("/upload")
public class UploadController {

	Logger log = Logger.getLogger(UploadController.class);

	@Resource(name = "imageCodeService")
	private ImageCode imageCodeService;

	@ResponseBody
	@RequestMapping("/uploadImage")
	public void upLoad(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String rootPath = "D:/upload";

		JSONObject res = new JSONObject();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		for (int i = 1; i < 4; i++) {
			MultipartFile multipartFile = multipartRequest
					.getFile("upfile" + i);
			if (multipartFile.getOriginalFilename() != null
					&& !"".equals(multipartFile.getOriginalFilename())) {

				// 上传路径
				// String rootPath =
				// request.getSession().getServletContext().getRealPath("/upload");

				String fName = UUID.randomUUID().toString() + ".jpg";
				// if (multipartFile.getOriginalFilename() != null &&
				// !"".equals(multipartFile.getOriginalFilename())) {
				// fName = DateUtils.dateToStr(time,
				// DateUtils.YYYYMMDDHHMMSSSSS) + "+"
				// + multipartFile.getOriginalFilename();
				// }
				File file = new File(rootPath, fName);
				FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),
						file);
			}
		}
		res.put("info", "上传成功！！！");
		response.getWriter().println(res);
	}

	@ResponseBody
	@RequestMapping("/getImageName")
	public ResultJsonBean getImageName(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		ResultJsonBean rjb = null;

		String unitycode = ParamsUtil.initFilter(
				request.getParameter("unitycode"), null);

		if (unitycode == null) {
			log.error("缺少unitycode参数,无法查询!");
			rjb = new ResultJsonBean(false, null, "-1", "缺少unitycode参数,无法查询!");
			return rjb;
		}

		String imageName = this.imageCodeService.getImageName(unitycode);
		if (imageName == null || "".endsWith(imageName)) {
			rjb = new ResultJsonBean(false, imageName, "-1", "查询不到匹配信息！");
		} else {
			rjb = new ResultJsonBean(true, imageName, "1", "查询成功！");
		}
		return rjb;
	}

}
