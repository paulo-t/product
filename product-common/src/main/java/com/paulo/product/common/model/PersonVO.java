package com.paulo.product.common.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class PersonVO implements Serializable {
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
