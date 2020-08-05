package org.whalefall.stack.framework.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.whalefall.stack.framework.exception.assertion.ArgumentExceptionAssert;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 参数校验异常枚举
 * @create 2020/8/5 10:58 上午
 */
@Getter
@AllArgsConstructor
public enum  ArgumentResponseEnum implements ArgumentExceptionAssert {
    VALID_ERROR(10050, "参数校验异常"),
    // Time
    DATE_NOT_NULL(10051, "日期不能为空"),
    TIME_NOT_NULL(10052, "时间不能为空"),
    DATE_PATTERN_MISMATCH(10053, "日期[%s]与格式[%s]不匹配，无法解析"),
    PATTERN_NOT_NULL(10054, "日期格式不能为空"),
    PATTERN_INVALID(10055, "日期格式[%s]无法识别"),
    ;

    private int code;
    private String message;
}
