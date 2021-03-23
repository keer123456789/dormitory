package com.keer.dormitory.dto;

/**
 * url ：/user/registerReq 请求对象
 */
public class RegisterReq {
    private String username;
    private String password;

    public RegisterReq() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "RegisterReq{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
