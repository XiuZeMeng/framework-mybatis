package com.mxz.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: mybatis 工具类
 * @Auther: mengxiuze
 * @Date: 2019/5/17 10:04
 */
public class MybatisUtil {

    private static SqlSessionFactory factory;

    static {
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory = new SqlSessionFactoryBuilder().build(in);
    }

    // 返回一个SqlSession对象
    public static SqlSession getSession(){
        return factory.openSession();
    }

    // 返回一个mapper接口对象
    public static <T> T getMapper(Class<T> mapperClass){
        return getSession().getMapper(mapperClass);
    }
}
