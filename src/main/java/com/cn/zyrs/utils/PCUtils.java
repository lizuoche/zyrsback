package com.cn.zyrs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.log4j.Logger;

public class PCUtils {

	private static final Logger log = Logger.getLogger(PCUtils.class);

	/**
	 * 
	 * 业  务: 获取本机真实IP <br>
	 * 英文名: getRealIP 
	 * 功能号: TODO
	 * 时  间: 2016年8月29日 下午7:02:38
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public static String getRealIP() {

		StringBuilder realIP = new StringBuilder();
		try {
			for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
				NetworkInterface intf = en.nextElement();
				for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
					InetAddress inetAddress = enumIpAddr.nextElement();
					if (!inetAddress.isLoopbackAddress()&& !inetAddress.isLinkLocalAddress()&& inetAddress.isSiteLocalAddress()) {
						realIP.append(inetAddress.getHostAddress().toString());
					}
				}
			}
		} catch (SocketException ex) {
			log.error("获取本机真实IP错误！", ex);
		}
		log.info("本机真实IP为：----------------" + realIP);
		return realIP.toString();
	}

	/**
	 * 
	 * 业  务: 读取属性配置文件内容 <br>
	 * 英文名: getProperties 
	 * 功能号: TODO
	 * 时  间: 2016年8月31日 上午9:40:17
	 * 应用项目: 中依睿晟新增订单APP后台管理系统
	 * 作者: 严昊 <br>
	 *
	 * 入参：TODO
	 * TODO   TODO	TODO
		TODO	 TODO	TODO	
		
	 * 
	 * 出参：JSON
	 */
	public static Properties getProperties(String name) {

		Properties pro = new Properties();// 属性集合对象
		// 获取属性文件并转换成流
		InputStream in = null;
		in = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
		if (in != null) {
			try {
				// 将属性文件流装载到Properties对象中
				pro.load(in);
			} catch (IOException e) {
				log.error("加载属性文件失败！", e);
			}
			log.info("属性文件加载成功！");
			return pro;
		} else {
			log.error("指定位置读取不到属性文件！！");
			return null;
		}

	}

}
