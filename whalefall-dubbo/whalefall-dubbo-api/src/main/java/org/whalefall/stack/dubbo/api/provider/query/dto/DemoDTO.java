package org.whalefall.stack.dubbo.api.provider.query.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DemoDTO implements Serializable {
    private long id;
    private String name;
}
