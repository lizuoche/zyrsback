///**
// * feiniu.com Inc.
// * Copyright (c) 2013-2015 All Rights Reserved.
// */
//package com.cn.zyrs.utils;
//
//import javax.ws.rs.FormParam;
//import javax.ws.rs.QueryParam;
//
//import com.feiniu.soa.categoryAdmin.common.support.DebugUtil;
//
///**
// * <B>Description:</B>  接收REST请求时 自动注入数据载体类  <br>
// * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
// *
// * @author yuan.qin
// * @author Hale.Chen
// * @version 1.0
// */
//public class QueryParamVO extends BaseVO {
//
//    public QueryParamVO() {
//        super();
//        DebugUtil.reset();
//    }
//
//    /**
//     * GET方式请求时 会将URL中的对应参数注入 
//     */
//    @QueryParam("token")
//    private String queryToken;
//
//    /**
//     * GET方式请求时 会URL中的对应参数注入 
//     */
//    @QueryParam("data")
//    private String queryData;
//
//    /**
//     * POST方式请求时 会将form表单中的对应参数注入
//     */
//    @FormParam("token")
//    private String formToken;
//
//    /**
//     * POST方式请求时 会将form表单中的对应参数注入
//     */
//    @FormParam("data")
//    private String formData;
//
//    @FormParam("_debug")
//    public void setDebugGet(String debug) {
//        setDebugPost(debug);
//    }
//
//    @QueryParam("_debug")
//    public void setDebugPost(String debug) {
//        if ("true".equals(debug)) {
//            DebugUtil.getDebugInfo().setEnable(true);
//        }
//    }
//
//    @FormParam("_showDebugTime")
//    public void setShowDebugTimeGet(String showDebugTime) {
//        setShowDebugTimePost(showDebugTime);
//    }
//
//    @QueryParam("_showDebugTime")
//    public void setShowDebugTimePost(String showDebugTime) {
//        if ("true".equals(showDebugTime)) {
//            DebugUtil.getDebugInfo().setShowDebugTime(true);
//        }
//    }
//
//    /**
//     * 
//     * <B>Description:</B> 获取token <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @return 
//     * @author yuan.qin
//     */
//    public String getToken() {
//        if (queryToken != null) {
//            return queryToken;
//        } else if (formToken != null) {
//            return formToken;
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> 获取data <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @return 
//     * @author yuan.qin
//     */
//    public String getData() {
//        if (queryData != null) {
//            return queryData;
//        } else if (formData != null) {
//            return formData;
//        }
//        return null;
//    }
//
//    /**
//     * Getter method for property <tt>queryData</tt>.
//     * 
//     * @return property value of queryData
//     */
//    public String getQueryData() {
//        return queryData;
//    }
//
//    /**
//     * Setter method for property <tt>queryData</tt>.
//     * 
//     * @param queryData value to be assigned to property queryData
//     */
//    public void setQueryData(String queryData) {
//        this.queryData = queryData;
//    }
//
//}
