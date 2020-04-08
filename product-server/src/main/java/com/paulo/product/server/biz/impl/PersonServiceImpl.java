package com.paulo.product.server.biz.impl;

import com.google.common.collect.Lists;
import com.paulo.common.exception.BizException;
import com.paulo.product.server.biz.PersonService;
import com.paulo.product.server.biz.model.PersonVO;
import com.paulo.product.server.dal.dao.PersonDO;
import com.paulo.product.server.dal.mapper.PersonDOMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
            BeanUtils.copyProperties(personDO,personVO);
            personList.add(personVO);
        }
        return personList;
    }
}
