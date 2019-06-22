package com.mxz.mybatis.domain;

import java.math.BigDecimal;

/**
 * @Description: 员工信息类
 * @Auther: mengxiuze
 * @Date: 2019/6/22 10:24
 */
public class Employee {

    private Integer id;

    private String name;

    private String sn;

    private BigDecimal salary;

    private Integer deptId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sn='" + sn + '\'' +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }
}
