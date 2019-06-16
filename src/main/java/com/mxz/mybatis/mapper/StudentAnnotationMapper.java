package com.mxz.mybatis.mapper;

import com.mxz.mybatis.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description: 学生信息接口类-基于注解开发
 * @Auther: mengxiuze
 * @Date: 2019/6/16 10:32
 */
public interface StudentAnnotationMapper {

//    @Insert("insert into t_student (name, sex) values (#{name}, #{sex})")
    @Insert({"insert into t_student (name, sex)", "values (#{name}, #{sex})"})// SQL太长的话，可以传递String数组
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Student student);

    @Update("update t_student set name = #{name}, sex = #{sex} where id = #{id}")
    void update(Student student);

    @Delete("delete from t_student where id = #{id}")
    void delete(Long id);

    @Select("select id as s_id, name as s_name, sex as s_sex from t_student where id = #{id}")
    // 如果表列名与属性名不一致，则使用Results
    @Results(id = "BaseResultMap", value = {
            @Result(column = "s_id", property = "id"),
            @Result(column = "s_name", property = "name"),
            @Result(column = "s_sex", property = "sex")
    })
    Student get(Long id);

    @Select("select id as s_id, name as s_name, sex as s_sex from t_student")
    @ResultMap("BaseResultMap")
    List<Student> listAll();
}
