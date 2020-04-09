package com.paulo.product.server.biz.impl;

import com.google.common.collect.Lists;
import com.paulo.common.enums.ResponseStatus;
import com.paulo.common.exception.BizException;
import com.paulo.product.server.biz.PersonService;
import com.paulo.product.server.biz.model.PersonVO;
import com.paulo.product.server.biz.model.SinglePersonRequestVO;
import com.paulo.product.server.dal.dao.PersonDO;
import com.paulo.product.server.dal.mapper.PersonDOMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    @Resource
    PersonDOMapper personDOMapper;

    @Override
    public List<PersonVO> getPersonList() throws BizException {
        List<PersonVO> personList = Lists.newArrayList();
        List<PersonDO> allPersonDOS = personDOMapper.findAll();
        for (PersonDO personDO : allPersonDOS) {
            PersonVO personVO = new PersonVO();
            BeanUtils.copyProperties(personDO, personVO);
            personList.add(personVO);
        }
        return personList;
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
        PersonVO personVO = new PersonVO();
        BeanUtils.copyProperties(pFirst.get(), personVO);
        return personVO;
    }

}
