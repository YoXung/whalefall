package org.whalefall.stack.framework.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.whalefall.stack.framework.exception.assertion.CommonExceptionAssert;
import org.whalefall.stack.framework.exception.core.BaseException;
import org.whalefall.stack.framework.exception.ui.BaseResponseVO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 通用异常枚举
 * @create 2020/8/5 10:57 上午
 */
@Getter
@AllArgsConstructor
public enum CommonResponseEnum implements CommonExceptionAssert {
    // 成功
    SUCCESS(10000, "SUCCESS"),
    // 服务器繁忙，请稍后重试
    SERVER_BUSY(10001, "服务器繁忙"),
    // 服务器异常，无法识别的异常，尽可能对通过判断减少未定义异常抛出
    SERVER_ERROR(10002, "网络异常"),
    ;

    private int code;
    private String message;

    /**
     * 校验返回结果是否成功
     * @param baseResponseVO 远程调用的响应
     */
    public static void assertSuccess(BaseResponseVO baseResponseVO) {
        SERVER_ERROR.assertNotNull(baseResponseVO);
        int code = baseResponseVO.getCode();
        if (CommonResponseEnum.SUCCESS.getCode() != code) {
            String msg = baseResponseVO.getMessage();
            throw new BaseException(code, msg);
        }
    }
}
