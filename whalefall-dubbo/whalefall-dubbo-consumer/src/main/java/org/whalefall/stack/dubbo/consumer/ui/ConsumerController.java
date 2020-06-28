package org.whalefall.stack.dubbo.consumer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.whalefall.stack.dubbo.consumer.applicaiton.api.ConsumerApplicationService;
import org.whalefall.stack.dubbo.consumer.ui.vo.ConsumerVO;
import org.whalefall.stack.framework.ui.vo.R;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/28 3:09 下午
 */
@RestController
@RequestMapping("/dubbo")
@Validated
public class ConsumerController {
    @Autowired
    private ConsumerApplicationService consumerApplicationService;

    @PostMapping("/demos")
    public R<Integer> createDemo(@RequestBody @Validated ConsumerVO consumerVO) {
        return new R<>(Integer.valueOf(consumerApplicationService.createDemo(consumerVO)));
    }
}
