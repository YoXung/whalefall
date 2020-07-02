package org.whalefall.stack.dubbo.api.provider.query.facade;

import org.whalefall.stack.dubbo.api.provider.query.dto.DemoDTO;
import org.whalefall.stack.dubbo.api.provider.query.qry.DemoQry;

public interface DemoQueryService {
    DemoDTO queryDemo(DemoQry demoQry);
}
