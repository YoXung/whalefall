package org.whalefall.stack.dubbo.consumer.ui.vo;

import lombok.Data;
import org.whalefall.stack.framework.annotations.ddd.ui.ViewObject;

import javax.validation.constraints.NotBlank;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 视图对象
 * @create 2020/6/28 3:07 下午
 */
@ViewObject
@Data
public class ConsumerVO {
    private int id;
    @NotBlank(message = "名称不可为空")
    private String name;
}
