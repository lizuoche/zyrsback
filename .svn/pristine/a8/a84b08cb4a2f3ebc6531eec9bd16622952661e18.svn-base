package com.cn.zyrs.utils;

import java.io.PrintStream;
import java.security.MessageDigest;
import sun.misc.BASE64Encoder;

public final class EncodeByMd5
{
  public static String MD5(String str)
  {
    String newstr = null;
    try
    {
      MessageDigest md5 = MessageDigest.getInstance("MD5");
      BASE64Encoder base64en = new BASE64Encoder();
      
      newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return newstr;
  }
  
  public static final String encode(String s)
  {
    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    try
    {
      byte[] strTemp = s.getBytes();
      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
      mdTemp.update(strTemp);
      byte[] md = mdTemp.digest();
      int j = md.length;
      char[] str = new char[j * 2];
      int k = 0;
      for (int i = 0; i < j; i++)
      {
        byte b = md[i];
        str[(k++)] = hexDigits[(b >> 4 & 0xF)];
        str[(k++)] = hexDigits[(b & 0xF)];
      }
      return new String(str);
    }
    catch (Exception e) {}
    return null;
  }
  
  public static void main(String[] args)
  {
    System.out.println(encode("123123"));
    System.out.println(MD5("123123"));
  }
}
