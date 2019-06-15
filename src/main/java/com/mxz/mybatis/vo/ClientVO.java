package com.mxz.mybatis.vo;

/**
 * @Description: 封装客户信息值对象的实体类
 * @Auther: mengxiuze
 * @Date: 2019/6/14 10:05
 */
public class ClientVO {

    private String username;

    private String password;

    public ClientVO() {
    }

    public ClientVO(String username, String password) {
        this.username = username;
        this.password = password;
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
}
