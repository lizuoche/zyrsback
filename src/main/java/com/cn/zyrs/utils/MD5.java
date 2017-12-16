package com.cn.zyrs.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class MD5 {
	
	/**
	 * 和.net md5加密 统一
	 * 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	 public  static String  MD5Secret(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException
     {
     	//确定计算方法
     	MessageDigest md5=MessageDigest.getInstance("MD5");
     	BASE64Encoder base64en = new BASE64Encoder();
     	//加密后的字符串
     	String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
     	return newstr;

     }
	 
	 
	 /** 
	   * 传入文件名以及字符串, 将字符串信息保存到文件中 
	   *  
	   * @param strFilename 
	   * @param strBuffer 
	   */  
	  public static void TextToFile(final String rootPath, final String strFilename, final String strBuffer)  
	  {  
	    try  
	    {      
	      // 创建文件对象  
	      File fileText = new File(rootPath,strFilename);  
	      // 向文件写入对象写入信息  
	      FileWriter fileWriter = new FileWriter(fileText);  
	  
	      // 写文件        
	      fileWriter.write(strBuffer);  
	      // 关闭  
	      fileWriter.close();  
	    }  
	    catch (IOException e)  
	    {  
	      //  
	      e.printStackTrace();  
	    }  
	  }  

}
