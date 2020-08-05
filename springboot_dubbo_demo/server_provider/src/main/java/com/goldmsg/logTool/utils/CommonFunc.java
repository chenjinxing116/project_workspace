//package com.goldmsg.logTool.utils;
//
//import com.goldmsg.levam.base.tools.utils.DateUtils;
//import com.google.common.base.Splitter;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.Modifier;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author Chen
// */
//public class CommonFunc {
//    /**
//     * list数组对应的索引 orgCode，1
//     */
//    public static Map<String, Integer> depFieldIndexMap = new HashMap<>();
//    public static Map<String, Integer> userFieldIndexMap = new HashMap<>();
//
//    static {
//        depFieldIndexMap.put("orgCode", 0);
//        depFieldIndexMap.put("orgName", 1);
//        depFieldIndexMap.put("parentOrgCode", 2);
//
//        userFieldIndexMap.put("orgCode", 0);
//        userFieldIndexMap.put("userName", 1);
//        userFieldIndexMap.put("userCode", 2);
//        userFieldIndexMap.put("account", 3);
//        userFieldIndexMap.put("gender", 4);
//        userFieldIndexMap.put("idCard", 5);
//        userFieldIndexMap.put("policeType", 6);
//        userFieldIndexMap.put("accountExpireDate", 7);
//        userFieldIndexMap.put("mobelPhone", 8);
//        userFieldIndexMap.put("email", 9);
//        userFieldIndexMap.put("extend", 10);
//    }
//
//
//    /**
//     * list 数组转实体类
//     */
//    public static Object listToObject(Map<String, Integer> depFieldIndexMap, List<Object> data, Class<?> beanClass) {
//        Object obj = null;
//        try {
//            obj = beanClass.newInstance();
//            Field[] fields = obj.getClass().getDeclaredFields();
//            for (Field field : fields) {
//                int mod = field.getModifiers();
//                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
//                    continue;
//                }
//
//                Integer fieldIndex = depFieldIndexMap.get(field.getName());
//                if (null == fieldIndex) {
//                    continue;
//                }
//
//                if (fieldIndex <= data.size() - 1) {
//                    field.setAccessible(true);
//                    Object o = data.get(fieldIndex);
//                    if ("accountExpireDate".equals(field.getName())) {
//                        Date date;
//                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                        try {
//                            date = sdf.parse(o.toString());
//                        } catch (Exception var4) {
//                            date = DateUtils.parseDate("2049-01-01", "yyyy-MM-dd");
//                        }
//
//                        field.set(obj, date);
//                    } else {
//                        field.set(obj, null == o ? "" : o.toString().trim());
//                    }
//                }
//            }
//        } catch (InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        return obj;
//    }
//
//    public static String getParam(String url, String name) {
//        String params = url.substring(url.indexOf("?") + 1, url.length());
//        Map<String, String> split = Splitter.on("&").withKeyValueSeparator("=").split(params);
//        return split.get(name);
//    }
//
//    public static String encodeParam(String url) {
//        String resultUrl = "";
//        String params = url.substring(url.indexOf("?") + 1, url.length());
//        String baseUrl = url.substring(0, url.indexOf("?") + 1);
//        resultUrl = baseUrl;
//        Map<String, String> split = Splitter.on("&").withKeyValueSeparator("=").split(params);
//        for (Map.Entry entry : split.entrySet()) {
//            String name = entry.getKey().toString();
//            String value = entry.getValue().toString();
//            resultUrl = resultUrl + name + "=" + URLEncoder.encode(value) + "&";
//
//        }
//        resultUrl= resultUrl.substring(0, resultUrl.length() - 1);
//
//
//        return resultUrl;
//    }
//}
