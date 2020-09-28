package org.whalefall.stack.common.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description Jackson工具封装
 * @create 2020/9/25 5:22 下午
 */
public class JsonUtil {
    // 实例化ObjectMapper对象
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // 赋值
    static {
        objectMapper
                // 设置允许序列化空的实体类（否则会抛出异常）
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                // 设置 把java.util.Date, Calendar输出为数字（时间戳）
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                // 设置在遇到未知属性的时候不抛出异常
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                // 强制JSON 空字符串("")转换为null对象值
                .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
                // 设置数字丢失精度问题
                .enable(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)
                // 设置没有引号的字段名
                .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
                // 设置允许单引号
                .enable(JsonParser.Feature.ALLOW_SINGLE_QUOTES)
                // 设置接受只有一个元素的数组的反序列化
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    }

    /**
     * 私有化构造器
     */
    private JsonUtil() {
    }

    /**
     * 对象转json字符串
     *
     * @param obj
     * @return
     * @throws JsonProcessingException
     */
    public static <T> String objToJson(T obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * json字符串转换bean
     *
     * @param clazz
     * @param jsonStr
     * @return
     * @throws JsonProcessingException
     */
    public static <T> T jsonToObj(Class<T> clazz, String jsonStr) throws JsonProcessingException {
        return objectMapper.readValue(jsonStr, clazz);
    }

    /**
     * json字符串转Map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> jsonToMap(String jsonStr) {
        return objectMapper.convertValue(jsonStr, Map.class);
    }

    /**
     * json字符串转对象集合
     *
     * @param jsonStr
     * @param clazz
     * @param <T>
     * @return
     * @throws JsonProcessingException
     */
    public static <T> List<T> jsonToList(String jsonStr, Class<T> clazz) throws JsonProcessingException {
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return objectMapper.readValue(jsonStr, javaType);
    }
}
