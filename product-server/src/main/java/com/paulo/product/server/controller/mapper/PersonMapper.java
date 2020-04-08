package com.paulo.product.server.controller.mapper;

import com.paulo.product.common.model.PersonDTO;
import com.paulo.product.server.biz.model.PersonVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PersonMapper {
    List<PersonDTO> vos2dtos(List<PersonVO> vos);
}
