package com.paulo.product.server.biz.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: create by paulo
 * @version: v1.0
 * @description: com.paulo.product.server.biz.model
 * @date:2020/4/9
 */
@Data
@ToString
public class SinglePersonRequestVO implements Serializable {
    private static final long serialVersionUID = -7557668571772691003L;
    /**
     * id
     */
    private long id;
    /**
     * 姓名
     */
    private String name;
}
