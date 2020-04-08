package com.paulo.product.server.dal.dao;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PersonDO implements Serializable {
    /**
     * id
     */
    private long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
}
