package org.whalefall.stack.framework.exception.ui;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.whalefall.stack.framework.exception.enums.CommonResponseEnum;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 成功返回
 * @create 2020/5/27 8:48 上午
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
public class R<T> extends BaseResponseVO {
    protected T data;

    public R(T data) {
        super(CommonResponseEnum.SUCCESS);
        this.data = data;
    }

    public R(String message, T data) {
        super(CommonResponseEnum.SUCCESS);
        this.message = message;
        this.data = data;
    }

    public R(Throwable e) {
        super(-1, e.getMessage());
    }
}
