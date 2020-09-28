package org.whalefall.stack.common.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description Base64工具类
 * @create 2020/9/25 5:21 下午
 */
public class Base64Utils {
    static final Base64.Encoder encoder = Base64.getEncoder();
    static final Base64.Decoder decoder = Base64.getDecoder();

    public static String encode(String src) {
        return encoder.encodeToString(src.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String src) {
        return new String(decoder.decode(src), StandardCharsets.UTF_8);
    }
}
