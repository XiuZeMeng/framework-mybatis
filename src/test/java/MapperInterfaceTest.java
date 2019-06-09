import com.mxz.mybatis.domain.Student;
import com.mxz.mybatis.mapper.StudentMapper;
import com.mxz.mybatis.proxy.MyMapperProxy;
import com.mxz.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description: Mapper接口测试类
 * @Auther: mengxiuze
 * @Date: 2019/6/9 10:54
 */
public class MapperInterfaceTest {

    /**
     * @description: 测试保存
     * @auther: mengxiuze
     * @date: 2019/6/9 10:59
     */
    @Test
    void testSave(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student form = new Student();
        form.setName("学生2");
        form.setSex(2);
        studentMapper.save(form);
        session.commit();
        session.close();
    }

    /**
     * @description: 测试查询
     * @auther: mengxiuze
     * @date: 2019/6/9 10:58
     */
    @Test
    void testGet(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.get(1L);
        session.close();
        System.out.println(student);
    }

    /**
     * @description: 测试Mapper接口的原理
     * @auther: mengxiuze
     * @date: 2019/6/9 11:03
     */
    @Test
    void test(){
        SqlSession session = MybatisUtil.getSession();
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        System.out.println(studentMapper.getClass());// Mapper接口的原理：动态代理，代理对象：class com.sun.proxy.$Proxy11
        Student student = studentMapper.get(1L);
        session.close();
        System.out.println(student);
    }

    @Test
    void testMockMybatisProxy(){
        SqlSession session = MybatisUtil.getSession();
        MyMapperProxy<StudentMapper> myMapperProxy = new MyMapperProxy<StudentMapper>();
        myMapperProxy.setMapperInterface(StudentMapper.class);
        myMapperProxy.setSqlSession(session);
        StudentMapper proxy = myMapperProxy.getProxyObject();
        System.out.println(proxy.getClass());// class com.sun.proxy.$Proxy11

        Student student1 = proxy.get(1L);
        System.out.println(student1);

//        List<Student> students = proxy.listAll();
//        for (Student student : students){
//            System.out.println(student);
//        }
    }
}
