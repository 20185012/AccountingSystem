package com.AccountingSystem.Models;

public class LegalUser extends User {

    String address;
    String companyCode;
    String userType = "LegalUser";

    public LegalUser(String name, String address, String email, String phone, String companyCode, String loginName, String loginPassword) {
        super(name, email, phone, loginName, loginPassword);
        this.address = address;
        this.companyCode = companyCode;
    }


    public void ShowUserDetails()
    {
        System.out.println("Company Name: " + this.name + " Username: " + this.loginName + " User Type: " + this.userType);
    }
}
