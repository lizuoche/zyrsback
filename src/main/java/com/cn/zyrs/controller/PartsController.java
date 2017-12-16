package com.cn.zyrs.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.cn.zyrs.domain.BomParts;
import com.cn.zyrs.domain.ResultJsonBean;
import com.cn.zyrs.domain.ShirtStyle;
import com.cn.zyrs.domain.SuitParts;
import com.cn.zyrs.domain.SuitStyle;
import com.cn.zyrs.domain.TrousersStyle;
import com.cn.zyrs.domain.VestStyle;
import com.cn.zyrs.service.IParts;
import com.cn.zyrs.utils.DynamicDataSource;
import com.cn.zyrs.utils.JsonHelper;

@Controller
@RequestMapping("/parts")
public class PartsController {

	private static Logger log = Logger.getLogger(PartsController.class);

	@Resource(name = "partsService")
	private IParts partsService;

	/**
	 * 
	 * 业 务: 上传配件图片 <br>
	 * 英文名: upload 功能号: TODO 时 间: 2016年11月17日 下午3:48:12 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

		String type = request.getParameter("type");
		String fileName = request.getParameter("fileName");
		String rootPath = null;
		String name = "";// 生成文件名称
		if (fileName == null || "".equalsIgnoreCase(fileName)) {
			name = UUID.randomUUID().toString() + ".jpg";
		} else {
			name = fileName;
		}
		if ("平面图".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/平面图";
		}
		if ("Unity缩略图".equalsIgnoreCase(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/json/" + type + "/image";
		}
		if ("PC版缩略图".equalsIgnoreCase(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/PC版缩略图";
		}
		if ("备用图".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/备用图";
		}
		 if ("smallimage".equals(type)) {
			 rootPath = request.getSession().getServletContext()
			 .getRealPath("/")
			 + "upload/SmallImage";
		 }
		 if ("bigimage".equals(type)) {
			 rootPath = request.getSession().getServletContext()
			 .getRealPath("/")
			 + "upload/BigImage";
		}
			// if ("normalimage".equals(type)) {
			// rootPath = request.getSession().getServletContext()
			// .getRealPath("/")
			// + "upload/NormalImage";
			// }
		if ("suitbom".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/TextureMaterial/suit_texture";
		}
		if ("insidebom".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/TextureMaterial/inside_texture";
		}
		if ("shirtbom".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/TextureMaterial/shirt_texture";
		}
		if ("tiebom".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/TextureMaterial/tie_texture";
		}
		if ("botouyanbom".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/TextureMaterial/botouyan_texture";
		}
		if ("kouyanbom".equals(type)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/TextureMaterial/kouyan_texture";
		}
		

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
	 * 业 务: 更新信息时候调用的上传接口 <br>
	 * 英文名: upload1 功能号: TODO 时 间: 2016年12月2日 下午1:37:23 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/upload1")
	public void upload1(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		response.setContentType("textml");
		response.setCharacterEncoding("utf-8");

		String type = request.getParameter("type");
		String fileName = request.getParameter("fileName");
		String flag = request.getParameter("flag");
		String id = request.getParameter("id");
		String rootPath = null;
		String name = "";// 生成文件名称
		if (fileName == null || "".equalsIgnoreCase(fileName)) {
			name = UUID.randomUUID().toString() + ".jpg";
		} else {
			name = fileName;
		}
		if ("平面图".equals(flag)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/平面图";
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setImage(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitCollar(sp);
			} else if ("trousers".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setImage(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersCollar(sp);
			} else if ("shirt".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setImage(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtCollar(sp);
			} else if ("vest".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setImage(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestCollar(sp);
			}
		}
		if ("Unity缩略图".equalsIgnoreCase(flag)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "Dress/data/json/" + type + "/image";
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage1(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitCollar(sp);
			} else if ("trousers".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage1(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersCollar(sp);
			} else if ("shirt".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage1(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtCollar(sp);
			} else if ("vest".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage1(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestCollar(sp);
			}
		}
		if ("PC版缩略图".equalsIgnoreCase(flag)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/PC版缩略图";
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage2(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitCollar(sp);
			} else if ("trousers".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage2(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersCollar(sp);
			} else if ("shirt".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage2(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtCollar(sp);
			} else if ("vest".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage2(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestCollar(sp);
			}
		}
		if ("备用图".equals(flag)) {
			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/备用图";
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage3(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitCollar(sp);
			} else if ("trousers".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage3(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersCollar(sp);
			} else if ("shirt".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage3(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtCollar(sp);
			} else if ("vest".equalsIgnoreCase(type)) {
				SuitParts sp = new SuitParts();
				sp.setId(id);
				sp.setimage3(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestCollar(sp);
			}
		}
		if ("smallimage".equals(flag)) {
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/suit";
				SuitStyle ss = new SuitStyle();
				ss.setId(id);
				ss.setSmall_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitStyle(ss);
			} else if ("trousers".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/trousers";
				TrousersStyle ts = new TrousersStyle();
				ts.setId(id);
				ts.setSmall_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersStyle(ts);
			} else if ("shirt".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/shirt";
				ShirtStyle ss = new ShirtStyle();
				ss.setId(id);
				ss.setSmall_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtStyle(ss);
			} else if ("vest".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/vest";
				VestStyle vs = new VestStyle();
				vs.setId(id);
				vs.setSmall_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestStyle(vs);
			} else if ("suitBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/suit_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setSmall_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("shirtBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/shirt_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setSmall_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("insideBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/inside_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setSmall_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("tieBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/tie_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setSmall_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("botouyanBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/botouyan_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setSmall_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("kouyanBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/kouyan_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setSmall_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			}
		}
		if ("bigimage".equals(flag)) {
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/suit";
				SuitStyle ss = new SuitStyle();
				ss.setId(id);
				ss.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitStyle(ss);
			} else if ("trousers".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/trousers";
				TrousersStyle ts = new TrousersStyle();
				ts.setId(id);
				ts.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersStyle(ts);
			} else if ("shirt".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/shirt";
				ShirtStyle ss = new ShirtStyle();
				ss.setId(id);
				ss.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtStyle(ss);
			} else if ("vest".equalsIgnoreCase(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/json/vest";
				VestStyle vs = new VestStyle();
				vs.setId(id);
				vs.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestStyle(vs);
			} else if ("suitBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/suit_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setBig_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("shirtBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/shirt_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setBig_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("insideBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/inside_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setBig_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("tieBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/tie_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setBig_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("botouyanBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/botouyan_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setBig_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("kouyanBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/kouyan_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setBig_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			}

		}
		if ("normalimage".equals(flag)) {

			rootPath = request.getSession().getServletContext()
					.getRealPath("/")
					+ "upload/NormalImage";
			// 匹配款式型号
			if ("suit".equalsIgnoreCase(type)) {
				SuitStyle ss = new SuitStyle();
				ss.setId(id);
				ss.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateSuitStyle(ss);
			} else if ("trousers".equalsIgnoreCase(type)) {
				TrousersStyle ts = new TrousersStyle();
				ts.setId(id);
				ts.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateTrousersStyle(ts);
			} else if ("shirt".equalsIgnoreCase(type)) {
				ShirtStyle ss = new ShirtStyle();
				ss.setId(id);
				ss.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateShirtStyle(ss);
			} else if ("vest".equalsIgnoreCase(type)) {
				VestStyle vs = new VestStyle();
				vs.setId(id);
				vs.setBig_image(name);

				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateVestStyle(vs);
			} else if ("suitbom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/suit_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setNormal_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("shirtbom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/shirt_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setNormal_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("insidebom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/inside_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setNormal_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("tieBom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/tie_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setNormal_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("botouyanbom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/botouyan_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setNormal_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			} else if ("kouyanbom".equals(type)) {
				rootPath = request.getSession().getServletContext()
						.getRealPath("/")
						+ "Dress/data/TextureMaterial/kouyan_texture";
				BomParts bp = new BomParts();
				bp.setId(id);
				bp.setNormal_image(name);
				DynamicDataSource
						.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				this.partsService.updateBomCollar(bp);
			}

		}

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
	 * 业 务: 查询配件信息 <br>
	 * 英文名: getParts 功能号: TODO 时 间: 2016年11月18日 下午2:28:22 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/getParts")
	public ResultJsonBean getParts(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String id = request.getParameter("id");
		String style = request.getParameter("enName");
		String type = request.getParameter("type");

		SuitParts sp = new SuitParts();
		sp.setId(id);
		sp.setStyle(style);

		List<SuitParts> spl = null;
		List<BomParts> bpl = null;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			spl = this.partsService.getSuitParts(sp);
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			spl = this.partsService.getTrousersParts(sp);
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			spl = this.partsService.getShirtParts(sp);
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			spl = this.partsService.getVestParts(sp);
			// } else if("coat".equalsIgnoreCase(type)){
			//
		} else if ("bom".equalsIgnoreCase(type.substring(type.length() - 3))) {
			BomParts bp = new BomParts();
			bp.setId(id);
			bp.setStyle(style);
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			bpl = this.partsService.getBomParts(bp);
		}

		if (spl != null && spl.size() > 0) {
			rjb = new ResultJsonBean(true, spl, "1", "查询配件信息成功！");
			log.info("查询配件信息成功！");
		} else if (spl != null && spl.size() == 0) {
			rjb = new ResultJsonBean(false, spl, "-1", "查询不到匹配信息！");
			log.error("查询不到匹配信息！");
		}

		if (bpl != null && bpl.size() > 0) {
			rjb = new ResultJsonBean(true, bpl, "1", "查询配件信息成功！");
			log.info("查询配件信息成功！");
		} else if (bpl != null && bpl.size() == 0) {
			rjb = new ResultJsonBean(false, bpl, "-1", "查询不到匹配信息！");
			log.error("查询不到匹配信息！");
		}

		return rjb;

	}

	/**
	 * 
	 * 业 务: 获取款式信息 <br>
	 * 英文名: getStyle 功能号: TODO 时 间: 2016年12月1日 上午10:38:37 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/getStyle")
	public ResultJsonBean getStyle(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String id = request.getParameter("id");
		// String style = request.getParameter("enName");
		String type = request.getParameter("type");
		//
		// SuitParts sp = new SuitParts();
		// sp.setId(id);
		// sp.setStyle(style);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("type", type);

		List<SuitStyle> ssl = null;
		List<TrousersStyle> tsl = null;
		List<ShirtStyle> ssl1 = null;
		List<VestStyle> vsl = null;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			ssl = this.partsService.getSuitStyle(map);
			if (ssl.size() > 0) {
				rjb = new ResultJsonBean(true, ssl, "1", "查询西服配件信息成功！");
				log.info("查询西服配件信息成功！");
			} else {
				rjb = new ResultJsonBean(false, ssl, "-1", "查询不到匹配西服信息！");
				log.error("查询不到匹配西服信息！");
			}
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			tsl = this.partsService.getTrousersStyle(map);
			if (tsl.size() > 0) {
				rjb = new ResultJsonBean(true, tsl, "1", "查询裤子配件信息成功！");
				log.info("查询裤子配件信息成功！");
			} else {
				rjb = new ResultJsonBean(false, tsl, "-1", "查询不到匹配裤子信息！");
				log.error("查询不到匹配裤子信息！");
			}
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			ssl1 = this.partsService.getShirtStyle(map);
			if (ssl1.size() > 0) {
				rjb = new ResultJsonBean(true, ssl1, "1", "查询衬衫配件信息成功！");
				log.info("查询衬衫配件信息成功！");
			} else {
				rjb = new ResultJsonBean(false, ssl1, "-1", "查询不到匹配衬衫信息！");
				log.error("查询不到匹配衬衫信息！");
			}
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			vsl = this.partsService.getVestStyle(map);
			if (vsl.size() > 0) {
				rjb = new ResultJsonBean(true, vsl, "1", "查询马甲配件信息成功！");
				log.info("查询马甲配件信息成功！");
			} else {
				rjb = new ResultJsonBean(false, vsl, "-1", "查询不到匹配马甲信息！");
				log.error("查询不到匹配马甲信息！");
			}
		}
		// else if("coat".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }

		return rjb;

	}

	/**
	 * 
	 * 业 务: 新增配件信息 <br>
	 * 英文名: addParts 功能号: TODO 时 间: 2016年11月17日 下午3:14:05 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/addParts")
	public ResultJsonBean addParts(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");
		String id = request.getParameter("id");
		// 如果没有传平面图，则生成一个随机数做主键
		if (id == null || "".equalsIgnoreCase(id)) {
			id = UUID.randomUUID().toString();
		}
		String enName = request.getParameter("enName");
		String productStyle = request.getParameter("productStyle");
		String cnName = request.getParameter("cnName");
		String wsName = request.getParameter("wsName");
		String modelName = request.getParameter("modelName");
		String remark = request.getParameter("remark");
		String image = request.getParameter("image");
		String image1 = request.getParameter("image1");
		String image2 = request.getParameter("image2");
		String image3 = request.getParameter("image3");

		SuitParts sp = new SuitParts();

		sp.setId(id);
		sp.setStyle(enName);
		sp.setType(productStyle);
		sp.setName(cnName);
		sp.setWorkshopname(wsName);
		sp.setRemark(remark);
		sp.setModelname(modelName);
		sp.setImage(image);
		sp.setimage1(image1);
		sp.setimage2(image2);
		sp.setimage3(image3);

		int res = 0;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addSuitParts(sp);
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addTrousersParts(sp);
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addShirtParts(sp);
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addVestParts(sp);
			// } else if("coat".equalsIgnoreCase(type)){
			//
		} else if ("bom".equalsIgnoreCase(type)) {
			String style = request.getParameter("style");
			String brandNameEN = request.getParameter("brandNameEN");
			String brandNameCN = request.getParameter("brandNameCN");
			String bomName = request.getParameter("bomName");
			String bomCode = request.getParameter("bomCode");
			// String remark = request.getParameter("remark");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");
			String normalimage = request.getParameter("normalimage");

			BomParts bp = new BomParts();
			bp.setId(id);
			bp.setStyle(style);
			bp.setEnglish_brand_name(brandNameEN);
			bp.setChina_brand_name(brandNameCN);
			bp.setName(bomName);
			bp.setCode(bomCode);
			bp.setRemark(remark);
			bp.setSmall_image(smallimage);
			bp.setBig_image(bigimage);
			bp.setNormal_image(normalimage);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addSuitBomParts(bp);
		}

		if (res == 1) {
			log.info("新增配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		} else {
			log.error("新增配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		}
		return rjb;

	}

	/**
	 * 
	 * 业 务: 新增款式配置信息 <br>
	 * 英文名: addStyle 功能号: TODO 时 间: 2016年12月1日 下午3:21:14 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/addStyle")
	public ResultJsonBean addStyle(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type"); // 款式型号
		String id = UUID.randomUUID().toString(); // 主键 ID

		int res = 0;
		String suitbom = request.getParameter("suitbom");
		String insidebom = request.getParameter("insidebom");
		String shirtbom = request.getParameter("shirtbom");
		String tiebom = request.getParameter("tiebom");
		String kouyanbom = request.getParameter("kouyanbom");
		String botouyanbom = request.getParameter("botouyanbom");
		String suitbutton = request.getParameter("suitbutton");
		String shirtbutton = request.getParameter("shirtbutton");
		String vestbutton = request.getParameter("vestbutton");
		String trousersbutton = request.getParameter("trousersbutton");
		String tie = request.getParameter("tie");
		String cravat = request.getParameter("cravat");
		// 匹配款式型号
		if ("suit".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String collar = request.getParameter("collar");
			String breastPocket = request.getParameter("breastPocket");
			String pocket = request.getParameter("pocket");
			String sleeve = request.getParameter("sleeve");
			String buttonNum = request.getParameter("buttonNum");
			String placket = request.getParameter("placket");
			String back = request.getParameter("back");
			String botouyan = request.getParameter("botouyan");
			String buttonEye = request.getParameter("buttonEye");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			SuitStyle ss = new SuitStyle();
			ss.setId(id);
			ss.setStylename(styleName);
			ss.setAssetbundle(assetBundle);
			ss.setCollar(collar);
			ss.setBreastpocket(breastPocket);
			ss.setPocket(pocket);
			ss.setSleeve(sleeve);
			ss.setButtonnum(buttonNum);
			ss.setPlacket(placket);
			ss.setBack(back);
			ss.setBotouyan(botouyan);
			ss.setButtoneye(buttonEye);
			ss.setSmall_image(smallimage);
			ss.setBig_image(bigimage);

			ss.setSuitbom(suitbom);
			ss.setInsidebom(insidebom);
			ss.setShirtbom(shirtbom);
			ss.setTiebom(tiebom);
			ss.setKouyanbom(kouyanbom);
			ss.setBotouyanbom(botouyanbom);
			ss.setSuitbutton(suitbutton);
			ss.setShirtbutton(shirtbutton);
			ss.setVestbutton(vestbutton);
			ss.setTrousersbutton(trousersbutton);
			ss.setTie(tie);
			ss.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addSuitStyle(ss);
		} else if ("trousers".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String yaotou = request.getParameter("yaotou");
			String kujiao = request.getParameter("kujiao");
			String frontdart = request.getParameter("frontdart");
			String cekoudai = request.getParameter("cekoudai");
			String houkoudai = request.getParameter("houkoudai");
			String kouyan = request.getParameter("kouyan");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			TrousersStyle ts = new TrousersStyle();
			ts.setId(id);
			ts.setStylename(styleName);
			ts.setAssetbundle(assetBundle);
			ts.setYaotou(yaotou);
			ts.setKujiao(kujiao);
			ts.setFrontdart(frontdart);
			ts.setCekoudai(cekoudai);
			ts.setHoukoudai(houkoudai);
			ts.setKouyan(kouyan);
			ts.setSmall_image(smallimage);
			ts.setBig_image(bigimage);

			ts.setSuitbom(suitbom);
			ts.setInsidebom(insidebom);
			ts.setShirtbom(shirtbom);
			ts.setTiebom(tiebom);
			ts.setKouyanbom(kouyanbom);
			ts.setBotouyanbom(botouyanbom);
			ts.setSuitbutton(suitbutton);
			ts.setShirtbutton(shirtbutton);
			ts.setVestbutton(vestbutton);
			ts.setTrousersbutton(trousersbutton);
			ts.setTie(tie);
			ts.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addTrousersStyle(ts);
		} else if ("shirt".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String collar = request.getParameter("collar");
			String font = request.getParameter("font");
			String back = request.getParameter("back");
			String sleeve = request.getParameter("sleeve");
			String breastPocket = request.getParameter("breastPocket");
			String kouyan = request.getParameter("kouyan");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			ShirtStyle ss = new ShirtStyle();
			ss.setId(id);
			ss.setStylename(styleName);
			ss.setAssetbundle(assetBundle);
			ss.setCollar(collar);
			ss.setFont(font);
			ss.setBack(back);
			ss.setSleeve(sleeve);
			ss.setBreastpocket(breastPocket);
			ss.setButtoneye(kouyan);
			ss.setSmall_image(smallimage);
			ss.setBig_image(bigimage);

			ss.setSuitbom(suitbom);
			ss.setInsidebom(insidebom);
			ss.setShirtbom(shirtbom);
			ss.setTiebom(tiebom);
			ss.setKouyanbom(kouyanbom);
			ss.setBotouyanbom(botouyanbom);
			ss.setSuitbutton(suitbutton);
			ss.setShirtbutton(shirtbutton);
			ss.setVestbutton(vestbutton);
			ss.setTrousersbutton(trousersbutton);
			ss.setTie(tie);
			ss.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addShirtStyle(ss);
		} else if ("vest".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String collar = request.getParameter("collar");
			String breastPocket = request.getParameter("breastPocket");
			String pocket = request.getParameter("pocket");
			String xiabai = request.getParameter("xiabai");
			String kouyan = request.getParameter("kouyan");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			VestStyle vs = new VestStyle();
			vs.setId(id);
			vs.setStylename(styleName);
			vs.setAssetbundle(assetBundle);
			vs.setCollar(collar);
			vs.setBreastpocket(breastPocket);
			vs.setPocket(pocket);
			vs.setXiabai(xiabai);
			vs.setKouyan(kouyan);
			vs.setSmall_image(smallimage);
			vs.setBig_image(bigimage);

			vs.setSuitbom(suitbom);
			vs.setInsidebom(insidebom);
			vs.setShirtbom(shirtbom);
			vs.setTiebom(tiebom);
			vs.setKouyanbom(kouyanbom);
			vs.setBotouyanbom(botouyanbom);
			vs.setSuitbutton(suitbutton);
			vs.setShirtbutton(shirtbutton);
			vs.setVestbutton(vestbutton);
			vs.setTrousersbutton(trousersbutton);
			vs.setTie(tie);
			vs.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.addVestStyle(vs);
		}
		// else if("coat".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }

		if (res == 1) {
			log.info("新增配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		} else {
			log.error("新增配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		}
		return rjb;

	}

	/**
	 * 
	 * 业 务: 修改配件信息 <br>
	 * 英文名: updateParts 功能号: TODO 时 间: 2016年12月1日 下午3:20:34 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/updateParts")
	public ResultJsonBean updateParts(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String id = request.getParameter("id");
		String type = request.getParameter("type");

		String enName = request.getParameter("enName");
		String productStyle = request.getParameter("productStyle");
		String cnName = request.getParameter("cnName");
		String wsName = request.getParameter("wsName");
		String modelName = request.getParameter("modelName");
		String remark = request.getParameter("remark");
		String image = request.getParameter("image");
		String image1 = request.getParameter("image1");
		String image2 = request.getParameter("image2");
		String image3 = request.getParameter("image3");

		SuitParts sp = new SuitParts();

		sp.setId(id);
		sp.setStyle(enName);
		sp.setType(productStyle);
		sp.setName(cnName);
		sp.setWorkshopname(wsName);
		sp.setRemark(remark);
		sp.setModelname(modelName);
		sp.setImage(image);
		sp.setimage1(image1);
		sp.setimage2(image2);
		sp.setimage3(image3);

		int res = 0;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateSuitCollar(sp);
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateTrousersCollar(sp);
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateShirtCollar(sp);
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateVestCollar(sp);
		} else if ("bom".equalsIgnoreCase(type.substring(type.length() - 3))) {
			String style = request.getParameter("style");
			String brandNameEN = request.getParameter("brandNameEN");
			String brandNameCN = request.getParameter("brandNameCN");
			String bomName = request.getParameter("bomName");
			String bomCode = request.getParameter("bomCode");
			// String remark = request.getParameter("remark");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");
			String normalimage = request.getParameter("normalimage");

			BomParts bp = new BomParts();
			bp.setId(id);
			bp.setStyle(style);
			bp.setEnglish_brand_name(brandNameEN);
			bp.setChina_brand_name(brandNameCN);
			bp.setName(bomName);
			bp.setCode(bomCode);
			bp.setRemark(remark);
			bp.setSmall_image(smallimage);
			bp.setBig_image(bigimage);
			bp.setNormal_image(normalimage);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateBomCollar(bp);
		}

		if (res == 1) {
			log.info("修改配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "修改配件信息成功！");
		} else {
			log.error("修改配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "修改配件信息失败！");
		}
		return rjb;

	}

	/**
	 * 
	 * 业 务: 更新款式信息 <br>
	 * 英文名: updateStyle 功能号: TODO 时 间: 2016年12月2日 上午9:48:55 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/updateStyle")
	public ResultJsonBean updateStyle(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type"); // 款式型号
		String id = request.getParameter("id"); // 主键 ID

		int res = 0;
		String suitbom = request.getParameter("suitbom");
		String insidebom = request.getParameter("insidebom");
		String shirtbom = request.getParameter("shirtbom");
		String tiebom = request.getParameter("tiebom");
		String kouyanbom = request.getParameter("kouyanbom");
		String botouyanbom = request.getParameter("botouyanbom");
		String suitbutton = request.getParameter("suitbutton");
		String shirtbutton = request.getParameter("shirtbutton");
		String vestbutton = request.getParameter("vestbutton");
		String trousersbutton = request.getParameter("trousersbutton");
		String tie = request.getParameter("tie");
		String cravat = request.getParameter("cravat");
		// 匹配款式型号
		if ("suit".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String collar = request.getParameter("collar");
			String breastPocket = request.getParameter("breastPocket");
			String pocket = request.getParameter("pocket");
			String sleeve = request.getParameter("sleeve");
			String buttonNum = request.getParameter("buttonNum");
			String placket = request.getParameter("placket");
			String back = request.getParameter("back");
			String botouyan = request.getParameter("botouyan");
			String buttonEye = request.getParameter("buttonEye");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			SuitStyle ss = new SuitStyle();
			ss.setId(id);
			ss.setStylename(styleName);
			ss.setAssetbundle(assetBundle);
			ss.setCollar(collar);
			ss.setBreastpocket(breastPocket);
			ss.setPocket(pocket);
			ss.setSleeve(sleeve);
			ss.setButtonnum(buttonNum);
			ss.setPlacket(placket);
			ss.setBack(back);
			ss.setBotouyan(botouyan);
			ss.setButtoneye(buttonEye);
			ss.setSmall_image(smallimage);
			ss.setBig_image(bigimage);

			ss.setSuitbom(suitbom);
			ss.setInsidebom(insidebom);
			ss.setShirtbom(shirtbom);
			ss.setTiebom(tiebom);
			ss.setKouyanbom(kouyanbom);
			ss.setBotouyanbom(botouyanbom);
			ss.setSuitbutton(suitbutton);
			ss.setShirtbutton(shirtbutton);
			ss.setVestbutton(vestbutton);
			ss.setTrousersbutton(trousersbutton);
			ss.setTie(tie);
			ss.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateSuitStyle(ss);
		} else if ("trousers".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String yaotou = request.getParameter("yaotou");
			String kujiao = request.getParameter("kujiao");
			String frontdart = request.getParameter("frontdart");
			String cekoudai = request.getParameter("cekoudai");
			String houkoudai = request.getParameter("houkoudai");
			String kouyan = request.getParameter("kouyan");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			TrousersStyle ts = new TrousersStyle();
			ts.setId(id);
			ts.setStylename(styleName);
			ts.setAssetbundle(assetBundle);
			ts.setYaotou(yaotou);
			ts.setKujiao(kujiao);
			ts.setFrontdart(frontdart);
			ts.setCekoudai(cekoudai);
			ts.setHoukoudai(houkoudai);
			ts.setKouyan(kouyan);
			ts.setSmall_image(smallimage);
			ts.setBig_image(bigimage);

			ts.setSuitbom(suitbom);
			ts.setInsidebom(insidebom);
			ts.setShirtbom(shirtbom);
			ts.setTiebom(tiebom);
			ts.setKouyanbom(kouyanbom);
			ts.setBotouyanbom(botouyanbom);
			ts.setSuitbutton(suitbutton);
			ts.setShirtbutton(shirtbutton);
			ts.setVestbutton(vestbutton);
			ts.setTrousersbutton(trousersbutton);
			ts.setTie(tie);
			ts.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateTrousersStyle(ts);
		} else if ("shirt".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String collar = request.getParameter("collar");
			String font = request.getParameter("font");
			String back = request.getParameter("back");
			String sleeve = request.getParameter("sleeve");
			String breastPocket = request.getParameter("breastPocket");
			String kouyan = request.getParameter("kouyan");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			ShirtStyle ss = new ShirtStyle();
			ss.setId(id);
			ss.setStylename(styleName);
			ss.setAssetbundle(assetBundle);
			ss.setCollar(collar);
			ss.setFont(font);
			ss.setBack(back);
			ss.setSleeve(sleeve);
			ss.setBreastpocket(breastPocket);
			ss.setButtoneye(kouyan);
			ss.setSmall_image(smallimage);
			ss.setBig_image(bigimage);

			ss.setSuitbom(suitbom);
			ss.setInsidebom(insidebom);
			ss.setShirtbom(shirtbom);
			ss.setTiebom(tiebom);
			ss.setKouyanbom(kouyanbom);
			ss.setBotouyanbom(botouyanbom);
			ss.setSuitbutton(suitbutton);
			ss.setShirtbutton(shirtbutton);
			ss.setVestbutton(vestbutton);
			ss.setTrousersbutton(trousersbutton);
			ss.setTie(tie);
			ss.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateShirtStyle(ss);
		} else if ("vest".equalsIgnoreCase(type)) {
			// 接收参数
			String styleName = request.getParameter("styleName");
			String assetBundle = request.getParameter("assetbundle");
			String collar = request.getParameter("collar");
			String breastPocket = request.getParameter("breastPocket");
			String pocket = request.getParameter("pocket");
			String kouyan = request.getParameter("kouyan");
			String xiabai = request.getParameter("xiabai");
			String smallimage = request.getParameter("smallimage");
			String bigimage = request.getParameter("bigimage");

			VestStyle vs = new VestStyle();
			vs.setId(id);
			vs.setStylename(styleName);
			vs.setAssetbundle(assetBundle);
			vs.setCollar(collar);
			vs.setBreastpocket(breastPocket);
			vs.setPocket(pocket);
			vs.setKouyan(kouyan);
			vs.setXiabai(xiabai);
			vs.setSmall_image(smallimage);
			vs.setBig_image(bigimage);

			vs.setSuitbom(suitbom);
			vs.setInsidebom(insidebom);
			vs.setShirtbom(shirtbom);
			vs.setTiebom(tiebom);
			vs.setKouyanbom(kouyanbom);
			vs.setBotouyanbom(botouyanbom);
			vs.setSuitbutton(suitbutton);
			vs.setShirtbutton(shirtbutton);
			vs.setVestbutton(vestbutton);
			vs.setTrousersbutton(trousersbutton);
			vs.setTie(tie);
			vs.setCravat(cravat);

			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.updateVestStyle(vs);
		}
		// else if("coat".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }

		if (res == 1) {
			log.info("修改配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "修改配件信息成功！");
		} else {
			log.error("修改配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "修改配件信息失败！");
		}
		return rjb;

	}

	/**
	 * 
	 * 业 务: 删除配件信息 <br>
	 * 英文名: deleteParts 功能号: TODO 时 间: 2016年11月29日 下午12:32:40 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/deleteParts")
	public ResultJsonBean deleteParts(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");
		String ids = request.getParameter("ids");
		String[] ids1 = ids.split(",");

		int res = 0;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteSuitParts(ids1);
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteTrousersParts(ids1);
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteShirtParts(ids1);
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteVestParts(ids1);
			// } else if("coat".equalsIgnoreCase(type)){
			//
		} else if ("bom".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteBomParts(ids1);
		} else if ("goods".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteGoods(ids1);
		}

		if (res > 0) {
			log.info("删除配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		} else {
			log.error("删除配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		}
		return rjb;

	}

	@ResponseBody
	@RequestMapping("/deleteStyle")
	public ResultJsonBean deleteStyle(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");
		String ids = request.getParameter("ids");
		String[] ids1 = ids.split(",");

		int res = 0;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteSuitStyle(ids1);
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteTrousersStyle(ids1);
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteShirtStyle(ids1);
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.deleteVestStyle(ids1);
		}
		// else if("coat".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }else if("vest".equalsIgnoreCase(type)){
		//
		// }

		if (res > 0) {
			log.info("删除配件信息成功！");
			rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		} else {
			log.error("删除配件信息失败！");
			rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		}
		return rjb;

	}

	/**
	 * 
	 * 业 务: 检查模型名称是否可用 <br>
	 * 英文名: checkModelName 功能号: TODO 时 间: 2016年11月18日 下午2:58:33 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/checkModelName")
	public ResultJsonBean checkModelName(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");
		String modelName = request.getParameter("modelName");

		if (type == null) {
			log.error("您已掉线，请重新登录！");
			rjb = new ResultJsonBean(false, null, "-1", "您已掉线，请重新登录！");
			return rjb;
		}
		int res = -1;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.checkSuitModelName(modelName);
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.checkTrousersModelName(modelName);
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.checkShirtModelName(modelName);
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			res = this.partsService.checkVestModelName(modelName);
		}
		// else if ("bom".equalsIgnoreCase(type)) {
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// res = this.partsService.checkBomModelName(modelName);
		// }

		if (res != 0) {
			log.error("数据库中已存在该模型！");
			rjb = new ResultJsonBean(false, res, "-1", "数据库中已存在该模型！");
			return rjb;
		}
		rjb = new ResultJsonBean(true, res, "1", "该模型名称可用！");
		log.info("该模型名称可用！");
		return rjb;

	}

	/**
	 * 
	 * 业 务: 验证面料编码是否已存在 <br>
	 * 英文名: checkBomCode 功能号: TODO 时 间: 2016年12月9日 上午8:51:51 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/checkBomCode")
	public ResultJsonBean checkBomCode(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		// String type = request.getParameter("type");
		String bomCode = request.getParameter("bomcode");

		// if (type == null) {
		// log.error("您已掉线，请重新登录！");
		// rjb = new ResultJsonBean(false, null, "-1", "您已掉线，请重新登录！");
		// return rjb;
		// }

		DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		int res = this.partsService.checkBomCode(bomCode);

		if (res != 0) {
			log.error("数据库中已存在该模型！");
			rjb = new ResultJsonBean(false, res, "-1", "数据库中已存在该模型！");
			return rjb;
		}
		rjb = new ResultJsonBean(true, res, "1", "该模型名称可用！");
		log.info("该模型名称可用！");
		return rjb;

	}

	/**
	 * 
	 * 业 务: 款式配置生成JSON文件 <br>
	 * 英文名: styleToJson 功能号: TODO 时 间: 2016年12月6日 下午7:06:43 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	@ResponseBody
	@RequestMapping("/styleToJson")
	public ResultJsonBean styleToJson(HttpServletRequest request,
			HttpServletResponse response) {
		ResultJsonBean rjb = null;

		String type = request.getParameter("type");

		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		Map<String, String> map = new HashMap<String, String>();
		map.put("type", type);

		List<SuitStyle> ssl = null;
		List<TrousersStyle> tsl = null;
		List<ShirtStyle> ssl1 = null;
		List<VestStyle> vsl = null;
		if ("suit".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			ssl = this.partsService.getSuitStyle(map);
			rjb = SuitStyleToJson(ssl, rootPath, "suit.json");
		} else if ("trousers".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			tsl = this.partsService.getTrousersStyle(map);
			rjb = TrousersStyleToJson(tsl, rootPath, "trousers.json");
		} else if ("shirt".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			ssl1 = this.partsService.getShirtStyle(map);
			rjb = ShirtStyleToJson(ssl1, rootPath, "shirt.json");
		} else if ("vest".equalsIgnoreCase(type)) {
			DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
			vsl = this.partsService.getVestStyle(map);
			rjb = VestStyleToJson(vsl, rootPath, "vest.json");
		}
		// else if("coat".equalsIgnoreCase(type)){
		// }
		// else if("bom".equalsIgnoreCase(type)){
		// String issell = request.getParameter("issell");
		// sp.setIssell(issell);
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// res = this.partsService.addSuitBomParts(sp);
		// }
		// else if("goods".equalsIgnoreCase(type)){
		// String issell = request.getParameter("issell");
		// sp.setIssell(issell);
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// res = this.partsService.addGoods(sp);
		// }

		// if (res == 1) {
		// log.info("新增配件信息成功！");
		// rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		// } else {
		// log.error("新增配件信息失败！");
		// rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		// }
		return rjb;

	}

	/**
	 * 
	 * 业 务: 款式配置详情生成JSON文件 <br>
	 * 英文名: detailToJson 功能号: TODO 时 间: 2016年12月7日 下午1:43:43 应用项目:
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

		// 获取入参
		String type = request.getParameter("type");
		String styleName = request.getParameter("styleName");
		String assetbundle = request.getParameter("assetbundle");

		String suitbom = request.getParameter("suitbom");
		String insidebom = request.getParameter("insidebom");
		String shirtbom = request.getParameter("shirtbom");
		String tiebom = request.getParameter("tiebom");
		String kouyanbom = request.getParameter("kouyanbom");
		String botouyanbom = request.getParameter("botouyanbom");
		String suitbutton = request.getParameter("suitbutton");
		String shirtbutton = request.getParameter("shirtbutton");
		String vestbutton = request.getParameter("vestbutton");
		String trousersbutton = request.getParameter("trousersbutton");
		String tie = request.getParameter("tie");
		String cravat = request.getParameter("cravat");

		// 定义根目录
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/");

		// 定义JSON文件根节点
		org.json.JSONObject stylejson = new org.json.JSONObject();
		stylejson.put("type", type);
		stylejson.put("type_name", styleName);

		// 新建“commodity”嵌套Json层
		org.json.JSONObject commodityjson = new org.json.JSONObject();
		if ("1".equals(suitbom)) {
			commodityjson.put("suitbom", "TextureMaterial/suitBom.json");
		}
		if ("1".equals(insidebom)) {
			commodityjson.put("insidebom", "TextureMaterial/insideBom.json");
		}
		if ("1".equals(shirtbom)) {
			commodityjson.put("shirtbom", "TextureMaterial/shirtBom.json");
		}
		if ("1".equals(tiebom)) {
			commodityjson.put("tiebom", "TextureMaterial/tieBom.json");
		}
		if ("1".equals(kouyanbom)) {
			commodityjson.put("kouyanbom", "TextureMaterial/kouyanBom.json");
		}
		if ("1".equals(botouyanbom)) {
			commodityjson
					.put("botouyanbom", "TextureMaterial/botouyanBom.json");
		}
		if ("1".equals(tie)) {
			commodityjson.put("tie", "Commodity/tie.json");
		}
		if ("1".equals(cravat)) {
			commodityjson.put("cravat", "Commodity/cravat.json");
		}
		if ("1".equals(suitbutton)) {
			commodityjson.put("suitbutton", "Commodity/suitbutton.json");
		}
		if ("1".equals(shirtbutton)) {
			commodityjson.put("shirtbutton", "Commodity/shirtbutton.json");
		}
		if ("1".equals(vestbutton)) {
			commodityjson.put("vestbutton", "Commodity/vestbutton.json");
		}
		if ("1".equals(trousersbutton)) {
			commodityjson
					.put("trousersbutton", "Commodity/trousersbutton.json");
		}
		// commodityjson.put("suitButton",
		// "TextureMaterial/suitButton.json");
		// commodityjson.put("shirtButton",
		// "TextureMaterial/shirtButton.json");
		// commodityjson.put("trousersButton",
		// "TextureMaterial/trousersButton.json");
		// commodityjson.put("vestButton",
		// "TextureMaterial/vestButton.json");

		stylejson.put("commodity", commodityjson);

		// 获取参数
		// 验证款式
		if ("suit".equalsIgnoreCase(type)) {
			String collar = request.getParameter("collar");
			styleDetailToJson(type, "collar", collar, stylejson);

			String breastPocket = request.getParameter("breastpocket");
			styleDetailToJson(type, "breastpocket", breastPocket, stylejson);

			String pocket = request.getParameter("pocket");
			styleDetailToJson(type, "pocket", pocket, stylejson);

			String sleeve = request.getParameter("sleeve");
			styleDetailToJson(type, "buff", sleeve, stylejson);

			String buttonnum = request.getParameter("buttonnum");
			styleDetailToJson(type, "buttonnum", buttonnum, stylejson);

			String placket = request.getParameter("placket");
			styleDetailToJson(type, "placket", placket, stylejson);

			String back = request.getParameter("back");
			styleDetailToJson(type, "back", back, stylejson);

			String botouyan = request.getParameter("botouyan");
			styleDetailToJson(type, "botouyan", botouyan, stylejson);

			String buttoneye = request.getParameter("buttoneye");
			styleDetailToJson(type, "buttoneye", buttoneye, stylejson);
		}else if ("trousers".equalsIgnoreCase(type)) {
			String yaotou = request.getParameter("yaotou");
			styleDetailToJson(type, "yaotou", yaotou, stylejson);

			String frontdart = request.getParameter("frontdart");
			styleDetailToJson(type, "frontdart", frontdart, stylejson);

			String kujiao = request.getParameter("kujiao");
			styleDetailToJson(type, "kujiao", kujiao, stylejson);

			String cekoudai = request.getParameter("cekoudai");
			styleDetailToJson(type, "cekoudai", cekoudai, stylejson);

			String houkoudai = request.getParameter("houkoudai");
			styleDetailToJson(type, "houkoudai", houkoudai, stylejson);

			String kouyan = request.getParameter("kouyan");
			styleDetailToJson(type, "kouyan", kouyan, stylejson);
		}else if ("shirt".equalsIgnoreCase(type)) {
			String collar = request.getParameter("collar");
			styleDetailToJson(type, "collar", collar, stylejson);

			String breastPocket = request.getParameter("breastpocket");
			styleDetailToJson(type, "breastpocket", breastPocket, stylejson);

			String buff = request.getParameter("buff");
			styleDetailToJson(type, "buff", buff, stylejson);

			String back = request.getParameter("back");
			styleDetailToJson(type, "back", back, stylejson);

			String kouyan = request.getParameter("kouyan");
			styleDetailToJson(type, "kouyan", kouyan, stylejson);

			String font = request.getParameter("font");
			styleDetailToJson(type, "font", font, stylejson);
		}else if ("vest".equalsIgnoreCase(type)) {
			String collar = request.getParameter("collar");
			styleDetailToJson(type, "collar", collar, stylejson);

			String breastPocket = request.getParameter("breastpocket");
			styleDetailToJson(type, "breastpocket", breastPocket, stylejson);
			
			String pocket = request.getParameter("pocket");
			styleDetailToJson(type, "pocket", pocket, stylejson);
			
			String xiabai = request.getParameter("xiabai");
			styleDetailToJson(type, "xiabai", xiabai, stylejson);
			
			String kouyan = request.getParameter("kouyan");
			styleDetailToJson(type, "kouyan", kouyan, stylejson);
			
		}
		
		// JSON数据写入文件
		try {
			JsonHelper.writeToJson(rootPath + "Dress/data/json/" + type + "/",
					assetbundle + ".json", stylejson);
		} catch (IOException e) {
			log.error("=====>>" + assetbundle + ".json<<=====生成失败!");
			e.printStackTrace();
			rjb = new ResultJsonBean(false, null, "-1", "=====>>" + assetbundle
					+ ".json<<=====生成失败!");
			return rjb;
		}
		log.info("=====>>" + assetbundle + ".json<<=====生成成功!");
		rjb = new ResultJsonBean(true, null, "1", "=====>>" + assetbundle
				+ ".json<<=====生成成功!");

		// else if ("trousers".equalsIgnoreCase(type)) {
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// ssl = this.partsService.getTrousersStyle(map);
		// rjb = ToJson(ssl, rootPath, "trousers.json");
		// } else if ("shirt".equalsIgnoreCase(type)) {
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// ssl = this.partsService.getTrousersStyle(map);
		// rjb = ToJson(ssl, rootPath, "shirt.json");
		// } else if ("vest".equalsIgnoreCase(type)) {
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// ssl = this.partsService.getTrousersStyle(map);
		// rjb = ToJson(ssl, rootPath, "vest.json");
		// }
		// else if("coat".equalsIgnoreCase(type)){
		// }
		// else if("bom".equalsIgnoreCase(type)){
		// String issell = request.getParameter("issell");
		// sp.setIssell(issell);
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// res = this.partsService.addSuitBomParts(sp);
		// }
		// else if("goods".equalsIgnoreCase(type)){
		// String issell = request.getParameter("issell");
		// sp.setIssell(issell);
		// DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
		// res = this.partsService.addGoods(sp);
		// }

		// if (res == 1) {
		// log.info("新增配件信息成功！");
		// rjb = new ResultJsonBean(true, res, "1", "新增配件信息成功！");
		// } else {
		// log.error("新增配件信息失败！");
		// rjb = new ResultJsonBean(false, res, "-1", "新增配件信息失败！");
		// }

		return rjb;

	}

	/**
	 * 
	 * 业 务: 款式配置表JSON数据写入文件 <br>
	 * 英文名: ToJson 功能号: TODO 时 间: 2016年12月6日 下午8:29:13 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	public ResultJsonBean SuitStyleToJson(List<SuitStyle> ssl, String rootPath,
			String fileName) {
		ResultJsonBean rjb = null;
		org.json.JSONObject json = new org.json.JSONObject();
		JSONArray jsonValues = new JSONArray();

		// 遍历查询结果,填写json内容
		for (int i = 0; i < ssl.size(); i++) {
			JSONObject js = new JSONObject();
			js.put("name", ssl.get(i).getStylename());
			js.put("small_img", "json/suit/" + ssl.get(i).getSmall_image());
			js.put("big_img", "json/suit/" + ssl.get(i).getBig_image());
			js.put("assetbundle", ssl.get(i).getAssetbundle());
			js.put("json", "json/suit/" + ssl.get(i).getAssetbundle() + ".json");
			jsonValues.put(js);
		}
		json.put("content", jsonValues);
		try {
			JsonHelper.writeToJson(rootPath + "Dress/data/json/", fileName,
					json);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("----->>" + fileName + "<<-----生成失败！");
			rjb = new ResultJsonBean(false, null, "-1", "----->>" + fileName
					+ "<<-----生成失败！");
			return rjb;
		}

		rjb = new ResultJsonBean(true, null, "1", "----->>" + fileName
				+ "<<-----生成成功！");
		return rjb;
	}

	public ResultJsonBean TrousersStyleToJson(List<TrousersStyle> ssl,
			String rootPath, String fileName) {
		ResultJsonBean rjb = null;
		org.json.JSONObject json = new org.json.JSONObject();
		JSONArray jsonValues = new JSONArray();

		// 遍历查询结果,填写json内容
		for (int i = 0; i < ssl.size(); i++) {
			JSONObject js = new JSONObject();
			js.put("name", ssl.get(i).getStylename());
			js.put("small_img", "json/trousers/" + ssl.get(i).getSmall_image());
			js.put("big_img", "json/trousers/" + ssl.get(i).getBig_image());
			js.put("assetbundle", ssl.get(i).getAssetbundle());
			js.put("json", "json/trousers/" + ssl.get(i).getAssetbundle() + ".json");
			jsonValues.put(js);
		}
		json.put("content", jsonValues);
		try {
			JsonHelper.writeToJson(rootPath + "Dress/data/json/", fileName,
					json);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("----->>" + fileName + "<<-----生成失败！");
			rjb = new ResultJsonBean(false, null, "-1", "----->>" + fileName
					+ "<<-----生成失败！");
			return rjb;
		}

		rjb = new ResultJsonBean(true, null, "1", "----->>" + fileName
				+ "<<-----生成成功！");
		return rjb;
	}

	public ResultJsonBean ShirtStyleToJson(List<ShirtStyle> ssl,
			String rootPath, String fileName) {
		ResultJsonBean rjb = null;
		org.json.JSONObject json = new org.json.JSONObject();
		JSONArray jsonValues = new JSONArray();

		// 遍历查询结果,填写json内容
		for (int i = 0; i < ssl.size(); i++) {
			JSONObject js = new JSONObject();
			js.put("name", ssl.get(i).getStylename());
			js.put("small_img", "json/shirt/" + ssl.get(i).getSmall_image());
			js.put("big_img", "json/shirt/" + ssl.get(i).getBig_image());
			js.put("assetbundle", ssl.get(i).getAssetbundle());
			js.put("json", "json/shirt/" + ssl.get(i).getAssetbundle() + ".json");
			jsonValues.put(js);
		}
		json.put("content", jsonValues);
		try {
			JsonHelper.writeToJson(rootPath + "Dress/data/json/", fileName,
					json);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("----->>" + fileName + "<<-----生成失败！");
			rjb = new ResultJsonBean(false, null, "-1", "----->>" + fileName
					+ "<<-----生成失败！");
			return rjb;
		}

		rjb = new ResultJsonBean(true, null, "1", "----->>" + fileName
				+ "<<-----生成成功！");
		return rjb;
	}

	public ResultJsonBean VestStyleToJson(List<VestStyle> ssl, String rootPath,
			String fileName) {
		ResultJsonBean rjb = null;
		org.json.JSONObject json = new org.json.JSONObject();
		JSONArray jsonValues = new JSONArray();

		// 遍历查询结果,填写json内容
		for (int i = 0; i < ssl.size(); i++) {
			JSONObject js = new JSONObject();
			js.put("name", ssl.get(i).getStylename());
			js.put("small_img", "json/vest/" + ssl.get(i).getSmall_image());
			js.put("big_img", "json/vest/" + ssl.get(i).getBig_image());
			js.put("assetbundle", ssl.get(i).getAssetbundle());
			js.put("json", "json/vest/" + ssl.get(i).getAssetbundle() + ".json");
			jsonValues.put(js);
		}
		json.put("content", jsonValues);
		try {
			JsonHelper.writeToJson(rootPath + "Dress/data/json/", fileName,
					json);
		} catch (IOException e) {
			e.printStackTrace();
			log.error("----->>" + fileName + "<<-----生成失败！");
			rjb = new ResultJsonBean(false, null, "-1", "----->>" + fileName
					+ "<<-----生成失败！");
			return rjb;
		}

		rjb = new ResultJsonBean(true, null, "1", "----->>" + fileName
				+ "<<-----生成成功！");
		return rjb;
	}

	/**
	 * 
	 * 业 务: 款式配置里 各部件详情生成json格式数据 <br>
	 * 英文名: styleDetailToJson 功能号: TODO 时 间: 2016年12月7日 下午2:33:38 应用项目:
	 * 中依睿晟新增订单APP后台管理系统 作者: 严昊 <br>
	 *
	 * 入参：TODO TODO TODO TODO TODO TODO TODO
	 * 
	 * 
	 * 出参：JSON
	 */
	public void styleDetailToJson(String type, String style, String styleID,
			org.json.JSONObject stylejson) {
		SuitParts sp = new SuitParts();
		if (styleID != null && styleID.contains(",")) {
			JSONArray jsonValues = new JSONArray();
			String[] styleIDs = styleID.split(",");
			// 遍历领子ID
			for (int i = 0; i < styleIDs.length; i++) {
				sp.setId(styleIDs[i]);
				List<SuitParts> spl = null;
				DynamicDataSource.setCustomerType(DynamicDataSource.DATA_SOURCE_1);
				if("suit".equalsIgnoreCase(type)){
				spl= this.partsService.getSuitParts(sp);
				}else if("shirt".equalsIgnoreCase(type)){
				spl = this.partsService.getShirtParts(sp);
				}else if("trousers".equalsIgnoreCase(type)){
				spl = this.partsService.getTrousersParts(sp);
				}else if("vest".equalsIgnoreCase(type)){
				spl = this.partsService.getVestParts(sp);
				}
				JSONObject js = new JSONObject();
				js.put("id", spl.get(0).getId());
				js.put("style", spl.get(0).getStyle());
				js.put("type", spl.get(0).getType());
				js.put("name", spl.get(0).getName());
				js.put("workshopname", spl.get(0).getWorkshopname());
				js.put("remark", spl.get(0).getRemark());
				js.put("modelname", spl.get(0).getModelname());
				js.put("image", spl.get(0).getImage());
				js.put("image1", "json/" + type + "/image/"
						+ spl.get(0).getimage1());
				js.put("image2", "upload/PC版缩略图/" + spl.get(0).getimage2());
				js.put("image3", "upload/备用图/" + spl.get(0).getimage3());
				jsonValues.put(js);
			}
			stylejson.put(style, jsonValues);
		} else {
			stylejson.put(style, "");
		}
	}

}
