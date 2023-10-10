package com.project.order.mapper;

import com.project.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {
    @Select("select * from tb_order where id = #{id}")
    Order findById(@Param("id") Long id);
}
