package org.whalefall.stack.dubbo.api.provider.query.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
public class DemoDTO implements Serializable {
    private long id;
    private String name;
}
