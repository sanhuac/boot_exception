package com.hc.boot_exception_email.model;

import javax.validation.constraints.NotNull;

/**
 * @Author hucong
 * @Description //TODO $
 * @Date $ $
 **/
public class User {

    @NotNull(message = "用户名不能为空")
    private String userName;

    private  int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
