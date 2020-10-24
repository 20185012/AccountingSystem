package com.AccountingSystem.Models;


import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    //int userId;
    protected String name;
    protected String email;
    protected String phone;
    protected String loginName;
    protected String loginPassword;
    //ArrayList<Category> categoriesResponsible;
    boolean active;

    public User(String name, String email, String phone, String loginName, String loginPassword) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }
}
