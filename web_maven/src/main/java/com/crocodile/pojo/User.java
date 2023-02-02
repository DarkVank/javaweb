package com.crocodile.pojo;
/**
 * @version v1.0
 * @ClassName：OrderCommand
 * @Description: user基类
 *
 * @Author：crocodilePole
 */
public class User {
    String username;
    int password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
