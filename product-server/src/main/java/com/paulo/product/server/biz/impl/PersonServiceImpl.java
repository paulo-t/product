package com.paulo.product.server.biz.impl;

import com.paulo.common.enums.ResponseStatus;
import com.paulo.common.exception.BizException;
import com.paulo.product.common.model.PersonVO;
import com.paulo.product.common.model.SinglePersonRequestVO;
import com.paulo.product.server.biz.PersonService;
import com.paulo.product.server.biz.mapper.PersonMapper;
import com.paulo.product.server.dal.dao.PersonDO;
import com.paulo.product.server.dal.mapper.PersonDOMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    PersonDOMapper personDOMapper;
    @Resource
    PersonMapper personMapper;

    @Override
    public List<PersonVO> getPersonList() throws BizException {
        List<PersonDO> allPersonDOS = personDOMapper.findAll();
        return personMapper.dos2vos(allPersonDOS);
    }

    @Override
    public PersonVO getSinglePerson(SinglePersonRequestVO requestVO) throws BizException {
        if (Objects.isNull(requestVO)) {
            throw new BizException(ResponseStatus.INVALID_PARAM.getCode(), "请求参数为空");
        }
        if (requestVO.getId() < 0) {
            throw new BizException(ResponseStatus.INVALID_PARAM.getCode() + 1, "id错误");
        }
        if (StringUtils.isEmpty(requestVO.getName())) {
            throw new BizException(ResponseStatus.INVALID_PARAM.getCode() + 2, "用户名为空");
        }

        List<PersonDO> allPersonDOS = personDOMapper.findAll();
        Optional<PersonDO> pFirst = allPersonDOS.stream().filter(p -> p.getId() == requestVO.getId() && p.getName().endsWith(requestVO.getName())).findFirst();
        if (!pFirst.isPresent()) {
            return null;
        }

        return personMapper.do2vo(pFirst.get());
    }

}
