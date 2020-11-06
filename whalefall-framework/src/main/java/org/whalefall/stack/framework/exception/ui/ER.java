package org.whalefall.stack.framework.exception.ui;

import lombok.NoArgsConstructor;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description 错误返回
 * @create 2020/5/27 8:48 上午
 */
@NoArgsConstructor
public class ER extends BaseResponseVO {
    public ER(int code, String message) {
        super(code, message);
    }
}
