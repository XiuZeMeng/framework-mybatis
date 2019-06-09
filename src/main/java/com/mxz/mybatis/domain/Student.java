package com.mxz.mybatis.domain;

/**
 * @Description: 学生信息实体类
 * @Auther: mengxiuze
 * @Date: 2019/6/9 10:37
 */
public class Student {
    private Long id;
    private String name;
    private int sex;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
