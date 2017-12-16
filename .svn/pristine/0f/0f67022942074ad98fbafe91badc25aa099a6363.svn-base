///**
// * feiniu.com Inc.
// * Copyright (c) 2013-2015 All Rights Reserved.
// */
//package com.cn.zyrs.utils;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Vector;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//import com.feiniu.soa.categoryAdmin.common.exception.BusinessExceptionHandle;
//import com.feiniu.soa.categoryAdmin.common.utils.StringUtils;
//
///**
// * <B>Description:</B> <br>
// * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
// *
// * @author Hale.Chen
// * @version 1.0
// */
//public class JsonParam {
//
//    public static JsonParam newInstance(String json) {
//        return new JsonParam(json);
//    }
//
//    public static JsonParam newInstance(JSONObject jsonObject) {
//        return new JsonParam(jsonObject);
//    }
//
//    /**
//     * 构造JsonParam对象
//     * @param json
//     */
//    private JsonParam(String json) {
//        if (StringUtils.isNotBlank(json)) {
//            try {
//                this.jsonObject = JSONObject.parseObject(json.trim());
//            } catch (JSONException e) {
//                BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                    "json转换错误,请检查json格式是否正确");
//            } catch (Exception e) {
//                BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                    "获取参数信息失败," + e.getMessage());
//            }
//        }
//    }
//
//    private JsonParam(JSONObject jsonObject) {
//        super();
//        this.jsonObject = jsonObject;
//    }
//
//    private JSONObject jsonObject = null;
//
//    /**
//     * 
//     * <B>Description:</B> 返回根节点JSONObject<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @return 
//     * @author Hale.Chen
//     */
//    public JSONObject getRootJsonObject() {
//        return jsonObject;
//    }
//
//    /**
//     * 
//     * <B>Description:</B><br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public Long getParameter_Long(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getLong(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    
//    public Integer getParameter_Integer(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getInteger(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//    /**
//     * 
//     * <B>Description:</B>获取Double类型值 <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public Double getParameter_Double(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getDouble(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> 获取String类型值<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public String getParameter_String(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getString(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> 获取JSONObject值<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public JSONObject getParameter_JSONObejct(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getJSONObject(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B>获取JSONArray值 <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public JSONArray getParameter_JSONArray(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getJSONArray(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public List<JSONArray> getParameter_JSONArrayList(String name) {
//        if (jsonObject == null)
//            return new Vector<JSONArray>();
//        try {
//            JSONArray jsonArray = jsonObject.getJSONArray(name);
//            List<JSONArray> fields = new Vector();
//            if (jsonArray != null) {
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    fields.add(jsonArray.getJSONArray(i));
//                }
//            }
//            return fields;
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public List<JSONObject> getParameter_JSONObjectList(String name) {
//        if (jsonObject == null)
//            return new Vector<JSONObject>();
//        try {
//            JSONArray jsonArray = jsonObject.getJSONArray(name);
//            List<JSONObject> fields = new Vector();
//            if (jsonArray != null) {
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    fields.add(jsonArray.getJSONObject(i));
//                }
//            }
//            return fields;
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public List<Double> getParameter_DoubleList(String name) {
//        if (jsonObject == null)
//            return new Vector<Double>();
//        try {
//            JSONArray jsonArray = jsonObject.getJSONArray(name);
//            List<Double> fields = new Vector();
//            if (jsonArray != null) {
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    fields.add(jsonArray.getDouble(i));
//                }
//            }
//            return fields;
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public List<Long> getParameter_LongList(String name) {
//        if (jsonObject == null)
//            return new Vector<Long>();
//
//        try {
//            JSONArray jsonArray = jsonObject.getJSONArray(name);
//            List<Long> fields = new Vector();
//            if (jsonArray != null) {
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    fields.add(jsonArray.getLong(i));
//                }
//            }
//            return fields;
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//
//    /**
//     * 
//     * <B>Description:</B> <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param name
//     * @return 
//     * @author Hale.Chen
//     */
//    public List<String> getParameter_StringList(String name) {
//        if (jsonObject == null)
//            return new Vector<String>();
//
//        try {
//            JSONArray jsonArray = jsonObject.getJSONArray(name);
//            List<String> fields = new Vector();
//            if (jsonArray != null) {
//                for (int i = 0; i < jsonArray.size(); i++) {
//                    fields.add(jsonArray.getString(i));
//                }
//            }
//            return fields;
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//    
//    public Date getParameter_Date(String name) {
//        try {
//            return jsonObject == null ? null : jsonObject.getDate(name);
//        } catch (Exception e) {
//            BusinessExceptionHandle.handleError(ErrorCodeConstants.SYS_INVALIDATE_PARAMETER,
//                "获取参数[" + name + "]信息失败," + e.getMessage());
//        }
//        return null;
//    }
//    
//
//}
