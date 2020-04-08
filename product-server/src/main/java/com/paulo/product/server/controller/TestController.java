package com.paulo.product.server.controller;

import com.paulo.common.model.BaseResponse;
import com.paulo.common.utils.BaseResponseUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.product.server.controller
 * @date:2020/4/8
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public BaseResponse<String> test(){
        return BaseResponseUtils.success("paulo");
    }
}
