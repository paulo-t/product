package com.paulo.product.server.controller;

import com.paulo.common.exception.BizException;
import com.paulo.common.model.BaseResponse;
import com.paulo.common.utils.BaseResponseUtils;
import com.paulo.product.common.model.PersonDTO;
import com.paulo.product.common.model.SinglePersonRequestDTO;
import com.paulo.product.server.biz.PersonService;
import com.paulo.product.server.biz.model.PersonVO;
import com.paulo.product.server.controller.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;
    @Resource
    PersonMapper personMapper;

    @GetMapping("/getAllPerson")
    public BaseResponse<List<PersonDTO>> getAllPerson()
    {
        try {
            return BaseResponseUtils.success(personMapper.vos2dtos(personService.getPersonList()));
        }catch (BizException e){
            return BaseResponseUtils.error(e.getErrCode(),e.getMessage());
        }
    }

    @PostMapping("/getSinglePerson")
    public BaseResponse<PersonDTO> getSinglePerson(@RequestBody SinglePersonRequestDTO singlePersonRequestDTO){
        try {
            PersonVO singlePerson = personService.getSinglePerson(personMapper.dto2vo(singlePersonRequestDTO));
            return BaseResponseUtils.success(personMapper.vo2dto(singlePerson));
        }catch (BizException e){
            return BaseResponseUtils.error(e.getErrCode(),e.getMessage());
        }
    }
}
