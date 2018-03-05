package com.ceco.yovo_38;

/**
 * Created by Student_10 on 26/02/2018.
 */

public class User {
    private int  id;
    private String  userName;
    private String  password;
    private String  phoneNumber;
    private String  email;

    public User(String userName, String password) {
        userName = userName;
        this.password = password;
    }

    public User(int id, String userName, String password, String phoneNumber, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public User(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
