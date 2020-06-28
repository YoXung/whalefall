package org.whalefall.stack.framework.ui.vo;

import org.whalefall.stack.framework.infrastructure.enums.BaseResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description View Object基类
 * @create 2020/5/27 8:47 上午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponseVO implements Serializable {
    // 返回码
    protected int code;
    // 返回信息
    protected String message;

    public BaseResponseVO(BaseResponseEnum baseResponseEnum) {
        this(baseResponseEnum.getCode(), baseResponseEnum.getMessage());
    }
}
