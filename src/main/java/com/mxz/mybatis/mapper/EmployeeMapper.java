package com.mxz.mybatis.mapper;

import com.mxz.mybatis.domain.Employee;
import com.mxz.mybatis.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description: 员工信息接口类
 * @Auther: mengxiuze
 * @Date: 2019/6/22 10:36
 */
public interface EmployeeMapper {


    List<Employee> selectByMinSally(@Param("minSalary")BigDecimal minSalary);

    List<Employee> selectByMinMaxSally(@Param("minSalary")BigDecimal minSalary,
                                       @Param("maxSalary")BigDecimal maxSalary);

    List<Employee> selectByDeptId(@Param("deptId")Integer deptId);
}
