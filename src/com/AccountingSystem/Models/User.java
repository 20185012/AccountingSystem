package com.AccountingSystem.Models;


import java.io.Serializable;

public class User implements Serializable {
    //int userId;
    //String name;
    //String email;
    //String phone;
    public String loginName;
    private String loginPassword;
    //ArrayList<Category> categoriesResponsible;
    //boolean active;

    public User(String loginName, String loginPassword) {
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
