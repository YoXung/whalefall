package org.whalefall.stack.dubbo.provider.infrastructure.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.whalefall.stack.dubbo.provider.infrastructure.repository.persistence.DemoPO;

/**
 * Copyright © 2020 Whale Fall All Rights Reserved
 *
 * @author YaoXiang
 * @description
 * @create 2020/7/3 9:09 上午
 */
@Mapper
public interface DemoMapper {
    @Select("select * from whalefall.demo where name=#{name}")
    DemoPO selectByName(@Param("name") String name);
}
