package com.paulo.product.server.dal.mapper;

import com.paulo.product.server.dal.dao.PersonDO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonDOMapper {
    @Select("SELECT id,name,age FROM person")
    List<PersonDO> findAll();
}
