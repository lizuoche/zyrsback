///**
// * feiniu.com Inc.
// * Copyright (c) 2013-2015 All Rights Reserved.
// */
//package com.cn.zyrs.utils;
//
//
///**
// * <B>Description:</B> <br>
// * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
// *
// * @author Hale.Chen
// * @version 1.0
// */
//public class DebugUtil {
//    //存放当前的DebugInfo
//    private static ThreadLocal<DebugInfo> debugInfoLocalInfo = new ThreadLocal<DebugInfo>() {
//                                                                 @Override
//                                                                 protected DebugInfo initialValue() {
//                                                                     return new DebugInfo();
//                                                                 };
//                                                             };
//
//    /**
//     * 
//     * <B>Description:</B> 新增调试信息 <br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     *
//     * @param info 
//     * @author Hale.Chen
//     */
//    public static void addDebugInfo(String info) {
//        if (!debugInfoLocalInfo.get().isEnable()) {
//            return;
//        }
//        debugInfoLocalInfo.get().addInfo(info);
//    }
//
//    public static void reset() {
//        debugInfoLocalInfo.set(new DebugInfo());
//    }
//
//    /**
//     * 
//     * <B>Description:</B> 清除<br>
//     * <B>Create on:</B> 2015年11月15日 下午10:00:00<br>
//     * 
//     * @author Hale.Chen
//     */
//    public static void clear() {
//        if (!debugInfoLocalInfo.get().isEnable()) {
//            return;
//        }
//
//        debugInfoLocalInfo.get().getInfos().clear();
//    }
//
//    public static DebugInfo getDebugInfo() {
//        return debugInfoLocalInfo.get();
//    }
//
//}
