package com.mxz.mybatis.domain;

/**
 * @Description: 客户信息实体类
 * @Auther: mengxiuze
 * @Date: 2019/6/14 09:36
 */
public class Client {

    private int id;

    private String username;

    private String password;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
