package com.goosying.cucumber.utils;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class ObjectToMapConverter {

    // 将Object转为Map
    public static <T> Map<String, String> objectToMap(T object) {
        // 获取成员变量名
        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, String> map = new HashMap<>();
        for (Field field : fields) {
            try {
                // 获取私有变量值，需要解除访问权限
                field.setAccessible(true);
                // 从指定对象中获取成员变量的值
                Object fieldValue = field.get(object);
                // 额外处理LocalDateTime
                if(fieldValue instanceof LocalDateTime){
                    fieldValue = ((LocalDateTime) fieldValue).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                }
                String value = fieldValue != null ? String.valueOf(fieldValue) : null;
                map.put(field.getName(), value);
            } catch (IllegalAccessException e) {
                System.err.println(e.getMessage());
            }
        }
        return map;
    }

    // 将List<Object>转为List<Map>
    public static <T> List<Map<String, String>> objectToMap(List<T> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>();
        }
        return list.stream().map(ObjectToMapConverter::objectToMap).collect(Collectors.toList());
    }

}
