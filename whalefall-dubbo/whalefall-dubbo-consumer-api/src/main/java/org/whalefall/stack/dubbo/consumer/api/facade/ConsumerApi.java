package org.whalefall.stack.dubbo.consumer.api.facade;

import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.framework.ui.vo.R;

//@Path("/consumer")
public interface ConsumerApi {
    //@GET
    //@Path("/dubbo/demos/{name}")
    R<DemoDTO> testGet(long id);
}
