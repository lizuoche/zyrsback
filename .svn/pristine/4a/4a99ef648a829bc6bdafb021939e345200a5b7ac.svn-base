///**
// * feiniu.com Inc.
// * Copyright (c) 2013-2014 All Rights Reserved.
// */
//package com.cn.zyrs.utils;
//
//import com.feiniu.soa.categoryAdmin.common.support.ErrorCodeConstants;
//
///**
// * <B>Description:</B> 业务异常处理类<br>
// * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
// *
// * @author yuan.qin
// * @author Hale.Chen
// * @version 1.0
// */
//public class BusinessExceptionHandle {
//    static ThreadLocal<IExceptionHandler> exceptionHandlerLocal = new ThreadLocal<IExceptionHandler>() {
//                                                                };
//
//    /**
//     * <B>Description:</B> 设置异常处理器<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param exceptionHandler
//     * @author Hale.Chen
//     */
//    public static void setExceptionHandler(IExceptionHandler exceptionHandler) {
//        exceptionHandlerLocal.set(exceptionHandler);
//    }
//
//    /**
//     * <B>Description:</B> 获取异常处理器 <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @return
//     * @author Hale.Chen
//     */
//    static IExceptionHandler getExceptionHandler() {
//        return exceptionHandlerLocal.get();
//    }
//
//    public static void handleError(Exception ex, CodeDesc codeDesc) {
//        if (ex instanceof BusinessException) {
//            throw ((BusinessException) ex);
//        }
//        handleError(codeDesc);
//    }
//
//    public static void handleError(Exception ex, CodeDesc codeDesc, String msg) {
//        if (ex instanceof BusinessException) {
//            throw ((BusinessException) ex);
//        }
//        handleError(codeDesc, msg);
//    }
//
//    /**
//     * <B>Description:</B> 抛出指定业务编码的错误<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param codeDesc
//     * @author Hale.Chen
//     */
//    public static void handleError(CodeDesc codeDesc) {
//        if (codeDesc == null)
//            codeDesc = ErrorCodeConstants.SYS_UNKNOWN_ERROR;
//        handleError(codeDesc.getCode(), codeDesc.getMsg());
//    }
//
//    /**
//     * <B>Description:</B> <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param codeDesc
//     * @param msg
//     * @author Hale.Chen
//     */
//    public static void handleError(CodeDesc codeDesc, String msg) {
//        if (codeDesc == null)
//            codeDesc = ErrorCodeConstants.SYS_UNKNOWN_ERROR;
//        //String s = StringUtils.joinErrorMessages(codeDesc.getMsg(), msg);
//        String s = msg;
//        handleError(codeDesc.getCode(), s);
//    }
//
//    /**
//     * <B>Description:</B> 抛出自定义错误<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param code
//     * @param msg
//     * @param t
//     * @author Hale.Chen
//     */
//    public static void handleError(String code, String msg, Throwable t) {
//        if (t instanceof BusinessException) {
//            throw (BusinessException) t;
//        }
//        throw new BusinessException(code, msg, t);
//    }
//
//    /**
//     * <B>Description:</B>  抛出自定义错误,指定错误信息<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param msg
//     * @param t
//     * @author Hale.Chen
//     */
//    public static void handleErrorWithMessage(String msg, Throwable t) {
//        if (t instanceof BusinessException) {
//            throw (BusinessException) t;
//        }
//        throw new BusinessException(msg, t);
//    }
//
//    /**
//     * <B>Description:</B> 抛出自定义错误,指定编码<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param msg
//     * @param t
//     * @author Hale.Chen
//     */
//    public static void handleErrorWithCode(String code, Throwable t) {
//        if (t instanceof BusinessException) {
//            throw (BusinessException) t;
//        }
//        throw new BusinessException(code, null, t);
//    }
//
//    /**
//     * <B>Description:</B> 抛出自定义错误,指定编码和错误信息<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param code
//     * @param msg
//     * @author Hale.Chen
//     */
//    public static void handleError(String code, String msg) {
//        throw new BusinessException(code, msg);
//    }
//
//}
