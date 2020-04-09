package com.paulo.product.server.biz;

import com.paulo.common.exception.BizException;
import com.paulo.product.server.biz.model.PersonVO;
import com.paulo.product.server.biz.model.SinglePersonRequestVO;

import java.util.List;

public interface PersonService {
    /**
     * 获取人员列表
     */
    List<PersonVO> getPersonList() throws BizException;
    /**
     * 获取单个人员信息
     */
    PersonVO getSinglePerson(SinglePersonRequestVO requestVO) throws BizException;
}
