/**
 * feiniu.com Inc.
 * Copyright (c) 2013-2014 All Rights Reserved.
 */
package com.cn.zyrs.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * <B>Description:</B> 扩展org.apache.commons.lang3.StringUtils <br>
 * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
 *
 * @author yuan.qin
 * @version 1.0
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
	
	private static Logger log = Logger.getLogger(StringUtils.class);

    /**
     * Description: 将两端的空格去掉 中间的多个空格替换为一个空格
     *
     * @param str 字符串
     * @return
     */
    public static String replaceExtraBlank(String str) {
        if (isBlank(str)) {
            return EMPTY;
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        str = str.trim();
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                flag = false;
                result.append(str.charAt(i));
            } else if (!flag) {
                flag = true;
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }

    /**
     * Description:判断是否为null或""
     *
     * @param o
     * @return
     */
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        return isEmpty(o.toString());
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }

    /**
     * Description:判断是否为null或空串
     *
     * @param o
     * @return
     */
    public static boolean isBlank(Object o) {
        if (o == null) {
            return true;
        }
        return isBlank(o.toString());
    }

    public static boolean isNotBlank(Object o) {
        return !isBlank(o);
    }

    public static String toStringIgnoreNull(Object o) {
        if (o == null) {
            return "";
        }
        return o.toString();
    }

    /**
     * <B>Description:</B> 布尔值转换为0或1 <br>
     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
     *
     * @param bool
     * @return
     * @author yuan.qin
     */
    public static String getBoolean(Boolean bool) {
        if (bool == null) {
            return null;
        } else if (bool) {
            return "1";
        } else {
            return "0";
        }
    }

    /**
     * <B>Description:</B> 0和1转换为布尔类型(非0和1返回null) <br>
     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
     *
     * @param bool
     * @return
     * @author yuan.qin
     */
    public static Boolean getBoolean(String bool) {
        if (isEmpty(bool)) {
            return null;
        } else if ("1".equals(bool)) {
            return true;
        } else if ("0".equals(bool)) {
            return false;
        }
        return null;
    }

    /**
     * <B>Description:</B> 删除末尾某个字符<br>
     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
     *
     * @param str
     * @return
     * @author xiaojun.song
     */
    public static String trimEnd(String str, String end) {
        if (isBlank(str)) {
            return EMPTY;
        }
        str = str.trim();
        String endStr = str.substring(str.length() - 1);
        if (endStr.equals(end)) {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }

    /**
     * 将错误信息分行连接在一起
     *
     * @param errorMessage
     * @return
     */
    public static String joinErrorMessages(String... errorMessage) {
        List<String> list = new ArrayList();
        for (String s : errorMessage) {
            if (isNotBlank(s))
                list.add(s);
        }
        if (list.isEmpty())
            return "";
        return StringUtils.join(list, "\t");
    }

    /**
     * 
     * <B>Description:</B> 等于其中一个(注意:单个为null,直接返回false;数组中如果有null会被忽略)<br>
     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
     *
     * @param str
     * @param args 不能为null
     * @return 
     * @author yuan.qin
     */
    public static boolean equalsOne(String str, String... args) {
        if (str != null) {
            for (String arg : args) {
                if (arg != null && arg.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    
    //截取指定长度
    public static String subStrLen(String str, int len) {
        if (isBlank(str)) {
            return EMPTY;
        }
        str = str.trim();
        int totalLen=str.length();
        if(len>totalLen){
            return str;
        }
        return str.substring(0, len-1);
    }
    
    /**
     * 
     * <B>Description:是否是数字</B> <br>
     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
     *
     * @param str
     * @return 
     * @author xiaojun.song
     */
    public static boolean isNumeric(String str){ 
        Pattern pattern = Pattern.compile("[0-9]*"); 
        return pattern.matcher(str).matches();    
     } 
    
    public static String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        return result.toString();
    }

    
    
    public static void main(String[] agrs) {
        List<String> list = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
            add("4");
        }};
//        String str = "123,1,";
//        DevLog.log(trimEnd(str, ","));
//        DevLog.log("str=========" + str);
        log.info(listToString(list));

    }
    
    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。
     * @param name 转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String camelName(String name) {
        StringBuilder result = new StringBuilder();
        if (name == null || name.isEmpty()) {
            return "";
        } else if (!name.contains("_")) {
            return name.toLowerCase();
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel :  camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                result.append(camel.toLowerCase());
            } else {
     
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

}
