package com.paulo.product.server.biz.mapper;

import com.paulo.product.common.model.PersonVO;
import com.paulo.product.common.model.SinglePersonRequestVO;
import com.paulo.product.server.dal.dao.PersonDO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PersonMapper {
    List<PersonVO> dos2vos(List<PersonDO> dos);
    PersonVO do2vo(PersonDO dao);
}
