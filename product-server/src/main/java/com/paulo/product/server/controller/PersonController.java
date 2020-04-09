package com.paulo.product.server.controller;

import com.paulo.common.exception.BizException;
import com.paulo.common.model.BaseResponse;
import com.paulo.common.utils.BaseResponseUtils;
import com.paulo.product.server.biz.PersonService;
import com.paulo.product.common.model.PersonVO;
import com.paulo.product.common.model.SinglePersonRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/getAllPerson")
    public BaseResponse<List<PersonVO>> getAllPerson() {
        try {
            return BaseResponseUtils.success(personService.getPersonList());
        } catch (BizException e) {
            return BaseResponseUtils.error(e.getErrCode(), e.getMessage());
        }
    }

    @PostMapping("/getSinglePerson")
    public BaseResponse<PersonVO> getSinglePerson(@RequestBody SinglePersonRequestVO singlePersonRequestVO) {
        try {
            return BaseResponseUtils.success(personService.getSinglePerson(singlePersonRequestVO));
        } catch (BizException e) {
            return BaseResponseUtils.error(e.getErrCode(), e.getMessage());
        }
    }
}
