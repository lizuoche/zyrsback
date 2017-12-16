package com.cn.zyrs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	 public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	  public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	  public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	  public static final String YYYY_MM_DD = "yyyy-MM-dd";
	  public static final String YYYY_MM = "yyyy-MM";
	  public static final String YYYYMMDD = "yyyyMMdd";
	  public static final String YYYYMMDDHH = "yyyyMMddHH";
	  public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	  public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	  public static final String YYYYMMDDHHMM = "yyyyMMddHHmm";
	  public static final String MM_DD = "MM-dd";
	  
	
	public static String dateToStr(Date date, String formatStr)
	  {
	    String result = null;
	    if (date != null)
	    {
	      SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
	      result = sdf.format(date);
	    }
	    return result;
	  }

	/**
	 * unix时间戳转换为dateFormat
	 * 
	 * @param beginDate
	 * @return
	 */
	public static String timestampToDate(String beginDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sd = sdf.format(new Date(Long.parseLong(beginDate)));
		return sd;
	}

	/**
	 * 自定义格式时间戳转换
	 * 
	 * @param beginDate
	 * @return
	 */
	public static String timestampToDate(String beginDate, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String sd = sdf.format(new Date(Long.parseLong(beginDate)));
		return sd;
	}

	/**
	 * 将字符串转为时间戳
	 * 
	 * @param user_time
	 * @return
	 */
	public static String dateToTimestamp(String user_time) {
		String re_time = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d;
		try {
			d = sdf.parse(user_time);
			long l = d.getTime();
			String str = String.valueOf(l);
			re_time = str.substring(0, 10);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return re_time;
	}

}
