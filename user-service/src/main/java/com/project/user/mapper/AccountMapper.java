package com.project.user.mapper;

import com.project.user.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper {
    @Select("select * from tb_account where id = #{id}")
    Account findById(@Param("id") Long id);
}
