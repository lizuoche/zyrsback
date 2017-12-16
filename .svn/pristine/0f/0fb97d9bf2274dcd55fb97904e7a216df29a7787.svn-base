package com.cn.zyrs.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class FileUtils {

	private static Logger log = Logger.getLogger(FileUtils.class);

	/**
	 * 
	 * 业  务: 获取目录下所有png文件名称 <br>
	 * 英文名: showAllFiles 
	 * 功能号: TODO
	 * 时  间: 2016年8月29日 下午2:08:10
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public final static List<String> getPNGeNames(File root) {
		File[] fs = root.listFiles();
		List<String> fileNamesList = new ArrayList<String>(fs.length);
		if (fs != null && fs.length != 0) {
			for (int i = 0; i < fs.length; i++) {
				// System.out.println(fs[i].getAbsolutePath());
				//文件名是否是以png结尾;是则生成下载url;否则继续找png格式的文件
				if ("png".equalsIgnoreCase(fs[i].getName().substring(fs[i].getName().length() - 3))) {
					fileNamesList.add(fs[i].getName());
				}
			}
		}
		return fileNamesList;
	}
	
	/**
	 * 图片转Base64格式字符串
	 */
	
    @SuppressWarnings("restriction")
	public static String GetImageStr()  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        String imgFile = "C://Users/Administrator/Desktop/xxx.png";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }    
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
	
	/**
	 * 接受并保存以base64格式上传的文件
	 */
	@SuppressWarnings("restriction")
	public static String uploadBase64(String base64Data,String savePath,String fileName) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			File parFile = new File(savePath);
            if (!parFile.exists()) {  
                // 如果路径不存在,则创建  
            	parFile.mkdirs();  
            }  
			File outFile = new File(savePath+fileName);
			OutputStream ro = new FileOutputStream(outFile);
			byte[] b = decoder.decodeBuffer(base64Data);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
			ro.write(b);
			ro.flush();
			ro.close();
		} catch (Exception e) {
			log.error("图片上传失败！", e);
			return null;
		}
		log.info("图片上传成功！");
		return fileName;
	}
	
	
	/** 
	 * 删除单个文件 
	 * @param   sPath    被删除文件的文件名 
	 * @return 单个文件删除成功返回true，否则返回false 
	 */  
	public static boolean deleteFile(String sPath) {  
		boolean  flag = false;  
		File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
	
}