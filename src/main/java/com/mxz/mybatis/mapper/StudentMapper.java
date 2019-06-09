package com.mxz.mybatis.mapper;

import com.mxz.mybatis.domain.Student;

import java.util.List;

/**
 * @Description: 学生信息接口类
 * @Auther: mengxiuze
 * @Date: 2019/6/9 10:36
 */
public interface StudentMapper {

    // 方法的全限定名称为：com.mxz.mybatis.mapper.StudentMapper.save
    // 对应mapper.xml文件的namespace + id -> com.mxz.mybatis.mapper.StudentMapper.save
    void save(Student student);

    void update(Student student);

    void delete(Student student);

    Student get(Long id);

    List<Student> listAll();
}
