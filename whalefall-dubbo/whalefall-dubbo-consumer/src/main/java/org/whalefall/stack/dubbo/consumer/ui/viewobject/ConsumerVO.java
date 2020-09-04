package org.whalefall.stack.dubbo.consumer.ui.viewobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.whalefall.stack.framework.annotations.ddd.ui.ViewObject;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description 视图对象
 * @create 2020/6/28 3:07 下午
 */
@ApiModel(value = "创建对象VO",description = "创建视图对象")
@ViewObject
@Data
public class ConsumerVO {
    @ApiModelProperty("最小为666")
    @Min(666L)
    private long id;
    @ApiModelProperty("名称去掉空格后输入不可以为空")
    @NotBlank(message = "名称不可为空")
    private String name;
}
