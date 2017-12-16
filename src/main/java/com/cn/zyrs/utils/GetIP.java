package com.cn.zyrs.utils;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class GetIP
{
  public static String getRemoteHost(HttpServletRequest request)
  {
    String ip = request.getHeader("x-forwarded-for");
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getRemoteAddr();
    }
    return ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip;
  }
  
  public static String createTextByTemplate(Map<String, String> parameters, String template)
  {
    String text = template;
    for (String k : parameters.keySet()) {
      text = text.replace(k, (CharSequence)parameters.get(k));
    }
    return text;
  }
}
