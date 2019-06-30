package com.mxz.mybatis.query;

import java.math.BigDecimal;

/**
 * @Description: 封装员工的高级查询信息类
 * @Auther: mengxiuze
 * @Date: 2019/6/23 11:44
 */
public class EmployeeQueryObject extends QueryObject{
    private String keyword; // 关键字，员工的名字或员工的编号
    private BigDecimal minSalary; // 最低工资
    private BigDecimal maxSalary; // 最高工资
    private Integer deptId = -1; // 部门ID，缺省为1表示所有部门

    public String getKeyword() {
        return empty2null(keyword);
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public BigDecimal getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Integer getDeptId() {
        return this.deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }


}
