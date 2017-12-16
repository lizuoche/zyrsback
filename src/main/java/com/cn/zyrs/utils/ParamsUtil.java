package com.cn.zyrs.utils;

public class ParamsUtil
{
  public static String initFilter(Object value, String defaultValue)
  {
    if (value == null) {
      return defaultValue;
    }
    String foo = String.valueOf(value).trim();
    return !foo.equals("") ? foo : defaultValue;
  }
  
  public static boolean isNotNull(String... params)
  {
    if ((params == null) || (params.length < 1)) {
      return false;
    }
    String[] arrayOfString = params;int j = params.length;
    for (int i = 0; i < j; i++)
    {
      String param = arrayOfString[i];
      if ((param == null) || ("".equals(param.trim()))) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean isNotNull(Object... params)
  {
    if ((params == null) || (params.length < 1)) {
      return false;
    }
    Object[] arrayOfObject = params;int j = params.length;
    for (int i = 0; i < j; i++)
    {
      Object param = arrayOfObject[i];
      if (param == null) {
        return false;
      }
      if ((param instanceof String)) {
        if ("".equals(String.valueOf(param).trim())) {
          return false;
        }
      }
    }
    return true;
  }
}
