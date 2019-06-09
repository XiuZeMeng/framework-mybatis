package com.mxz.mybatis.proxy;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 模拟Mybatis的动态代理
 * @Auther: mengxiuze
 * @Date: 2019/6/9 11:08
 */
public class MyMapperProxy<T> implements InvocationHandler {

    private Class<T> mapperInterface;// 对哪个接口做代理

    private SqlSession sqlSession;

    // 创建代理对象
    public T getProxyObject(){
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[] {mapperInterface}, this);
    }

    // 具体怎么增强
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Mapper接口的全限定名称（Mapper.xml的命名空间）
        String namespece = mapperInterface.getName();
        // Mapper接口的方法名称（Mapper.xml的执行操作的id的属性值）
        String methodName = method.getName();
        String statement = namespece + "." + methodName;

        // 这里应该根据不同的Mapper方法调用SQLSession的不同方法，可参考MapperProxy类
        return sqlSession.selectOne(statement, args[0]);
//        return sqlSession.selectList(statement);
    }


    public Class getMapperInterface() {
        return this.mapperInterface;
    }

    public void setMapperInterface(Class mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public SqlSession getSqlSession() {
        return this.sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}
