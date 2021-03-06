package com.paulo.product.client;

import com.paulo.common.model.BaseResponse;
import com.paulo.product.common.model.PersonVO;
import com.paulo.product.common.model.SinglePersonRequestVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.product.client
 * @date:2020/4/9
 */
@FeignClient(name = "product")
public interface ProductClient {
    @GetMapping("/getAllPerson")
    BaseResponse<List<PersonVO>> getAllPerson();
    @PostMapping("/getSinglePerson")
    BaseResponse<PersonVO> getSinglePerson(@RequestBody SinglePersonRequestVO requestVO);
}
