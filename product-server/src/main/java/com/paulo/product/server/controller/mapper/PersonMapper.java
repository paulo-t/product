package com.paulo.product.server.controller.mapper;

import com.paulo.product.common.model.PersonDTO;
import com.paulo.product.common.model.SinglePersonRequestDTO;
import com.paulo.product.server.biz.model.PersonVO;
import com.paulo.product.server.biz.model.SinglePersonRequestVO;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface PersonMapper {
    List<PersonDTO> vos2dtos(List<PersonVO> vos);
    SinglePersonRequestVO dto2vo(SinglePersonRequestDTO dto);
    PersonDTO vo2dto(PersonVO vo);
}
