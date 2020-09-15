package org.whalefall.stack.dubbo.api.provider.query.qry;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
public class DemoQry implements Serializable {
    private String name;
}
