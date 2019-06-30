package com.mxz.mybatis.service;

import com.mxz.mybatis.query.QueryObject;
import com.mxz.mybatis.query.PageResult;

/**
 * @Description: 员工信息service类
 * @Auther: mengxiuze
 * @Date: 2019/6/30 11:01
 */
public interface IEmployeeService {

    PageResult getEmployeePage(QueryObject qo);
}
