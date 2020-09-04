package org.whalefall.stack.dubbo.consumer.ui.viewobject;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(title = "创建对象VO")
@ViewObject
@Data
public class ConsumerVO {
    @Schema(minimum = "666L",description = "最小为666")
    @Min(666L)
    private long id;
    @Schema(required = true, description = "名称去掉空格后输入不可以为空")
    @NotBlank(message = "名称不可为空")
    private String name;
}
