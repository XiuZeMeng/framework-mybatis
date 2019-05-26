package com.mxz.mybatis.domain;

import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * @Description: User实体类
 * @Auther: mengxiuze
 * @Date: 2019/5/4 10:29
 */
@Alias("User")
public class User {
    private Long id;
    private String name;
    private BigDecimal salary;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
