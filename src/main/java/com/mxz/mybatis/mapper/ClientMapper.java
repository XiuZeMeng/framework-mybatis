package com.mxz.mybatis.mapper;

import com.mxz.mybatis.domain.Client;
import com.mxz.mybatis.vo.ClientVO;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @Description: 客户信息接口类
 * @Auther: mengxiuze
 * @Date: 2019/6/14 09:38
 */
public interface ClientMapper {
    //解决Mybatis只能接收一个参数的问题

    // 方式一：把多个参数封装成JavaBean
    Client getByVO(ClientVO vo);

    // 方式二：使用Map对象封装多个参数
    Client getByMap(Map map);

    // 方式三：使用Param注解，底层原理是方式二
    Client getByParam(@Param("username")String username, @Param("password")String password);
}
