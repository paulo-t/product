package com.paulo.product.server.biz;

import com.paulo.common.exception.BizException;
import com.paulo.product.server.biz.model.PersonVO;

import java.util.List;

public interface PersonService {
    /**
     * 获取人员列表
     */
    List<PersonVO> getPersonList() throws BizException;
}
