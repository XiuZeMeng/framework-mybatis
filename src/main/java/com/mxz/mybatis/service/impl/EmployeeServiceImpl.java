package com.mxz.mybatis.service.impl;

import com.mxz.mybatis.domain.Employee;
import com.mxz.mybatis.mapper.EmployeeMapper;
import com.mxz.mybatis.query.QueryObject;
import com.mxz.mybatis.query.PageResult;
import com.mxz.mybatis.service.IEmployeeService;
import com.mxz.mybatis.util.MybatisUtil;

import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @Auther: mengxiuze
 * @Date: 2019/6/30 11:03
 */
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);

    public PageResult getEmployeePage(QueryObject qo) {
        int rows = employeeMapper.queryForCount(qo);
        if (rows == 0) {
            return new PageResult(Collections.EMPTY_LIST, 0, 1, qo.getPageSize());
        }
        List<Employee> employeeList = employeeMapper.queryForList(qo);
        return new PageResult(employeeList, rows, qo.getCurrentPage(), qo.getPageSize());
    }
}
