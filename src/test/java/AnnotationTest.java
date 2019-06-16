import com.mxz.mybatis.domain.Student;
import com.mxz.mybatis.mapper.StudentAnnotationMapper;
import com.mxz.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description: Mybatis注解开发测试
 * @Auther: mengxiuze
 * @Date: 2019/6/16 10:31
 */
public class AnnotationTest {

    @Test
    void testInsert(){
        SqlSession session = MybatisUtil.getSession();
        StudentAnnotationMapper annotationMapper = session.getMapper(StudentAnnotationMapper.class);
        Student student = new Student();
        student.setName("注解开发学生一");
        student.setSex(1);
        annotationMapper.insert(student);
        session.commit();
        session.close();
        System.out.println(student);
    }

    @Test
    void testUpdate(){
        SqlSession session = MybatisUtil.getSession();
        StudentAnnotationMapper annotationMapper = session.getMapper(StudentAnnotationMapper.class);
        Student student = new Student();
        student.setId(6L);
        student.setName("修改注解开发学生一");
        student.setSex(2);
        annotationMapper.update(student);
        session.commit();
        session.close();
        System.out.println(student);
    }

    @Test
    void testDelete(){
        SqlSession session = MybatisUtil.getSession();
        StudentAnnotationMapper annotationMapper = session.getMapper(StudentAnnotationMapper.class);
        annotationMapper.delete(8L);
        session.commit();
        session.close();
    }

    @Test
    void testGet(){
        SqlSession session = MybatisUtil.getSession();
        StudentAnnotationMapper annotationMapper = session.getMapper(StudentAnnotationMapper.class);
        Student student = annotationMapper.get(1L);
        session.close();
        System.out.println(student);
    }

    @Test
    void testListAll(){
        SqlSession session = MybatisUtil.getSession();
        StudentAnnotationMapper annotationMapper = session.getMapper(StudentAnnotationMapper.class);
        List<Student> studentList = annotationMapper.listAll();
        session.close();
        for (Student student: studentList) {
            System.out.println(student);
        }
    }

}
