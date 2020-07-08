package org.whalefall.stack.dubbo.consumer.ui;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.dubbo.consumer.api.facade.ConsumerApi;
import org.whalefall.stack.dubbo.consumer.applicaiton.api.ConsumerApplicationService;
import org.whalefall.stack.dubbo.consumer.infrastructure.exception.ConsumerDubboException;
import org.whalefall.stack.dubbo.consumer.ui.vo.ConsumerVO;
import org.whalefall.stack.framework.ui.vo.R;

import javax.validation.constraints.NotBlank;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/28 3:09 下午
 */
@Service(interfaceClass = ConsumerApi.class, protocol = {"dubbo", "rest"})
@RestController
@RequestMapping("/consumer/dubbo")
@Validated
public class ConsumerController implements ConsumerApi {
    @Autowired
    private ConsumerApplicationService consumerApplicationService;

    @PostMapping("/demos")
    public R<Integer> createDemo(@RequestBody @Validated ConsumerVO consumerVO) {
        return new R<>(Integer.valueOf(consumerApplicationService.createDemo(consumerVO)));
    }

    @GetMapping({"/demos/{name}","/demos"})
    public R<DemoDTO> queryByName(@PathVariable(value = "name", required = false) @NotBlank(message = "GET参数不可以为空") String name) {
        checkParam(name);
        System.out.println("=========消费端进来了");
        return new R<>(consumerApplicationService.queryByName(name));
    }

    private void checkParam(String param) {
        if (param.equals("abc"))
        ConsumerDubboException.CONSUMER_DUBBO_EXCEPTION_TEST.assertFail();
    }

}
