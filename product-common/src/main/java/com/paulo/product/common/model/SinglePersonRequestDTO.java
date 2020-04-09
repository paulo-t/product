package com.paulo.product.common.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.product.common.model
 * @date:2020/4/9
 */
@Data
@ToString
public class SinglePersonRequestDTO implements Serializable {
    private static final long serialVersionUID = 5859819592142656589L;
    /**
     * id
     */
    private long id;
    /**
     * 姓名
     */
    private String name;
}
