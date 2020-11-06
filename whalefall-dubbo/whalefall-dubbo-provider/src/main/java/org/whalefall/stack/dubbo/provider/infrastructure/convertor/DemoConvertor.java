package org.whalefall.stack.dubbo.provider.infrastructure.convertor;

import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.dubbo.provider.infrastructure.repository.persistence.DemoPO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YoXung
 * @description
 * @create 2020/9/15 10:31 上午
 */
public class DemoConvertor {
    public static DemoDTO toDemoDTO(DemoPO demoPO) {
        return new DemoDTO().setId(demoPO.getId()).setName(demoPO.getName());
    }
}
