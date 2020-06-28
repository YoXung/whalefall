package org.whalefall.stack.framework.infrastructure.enums;

import java.io.Serializable;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 返回枚举基类接口
 * @create 2020/5/27 9:09 上午
 */
public interface BaseResponseEnum extends Serializable {
    int getCode();
    String getMessage();
}
