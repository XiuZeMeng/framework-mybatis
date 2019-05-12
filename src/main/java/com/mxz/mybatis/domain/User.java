package com.mxz.mybatis.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description: User实体类
 * @Auther: mengxiuze
 * @Date: 2019/5/4 10:29
 */
@Data
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;
}
