package org.whalefall.stack.dubbo.consumer.applicaiton.service;

import org.springframework.stereotype.Service;
import org.whalefall.stack.dubbo.consumer.applicaiton.api.ConsumerApplicationService;
import org.whalefall.stack.dubbo.consumer.ui.vo.ConsumerVO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/6/28 3:59 下午
 */
@Service
public class ConsumerApplicationServiceImpl implements ConsumerApplicationService {
    @Override
    public int createDemo(ConsumerVO consumerVO) {
        return 0;
    }
}
