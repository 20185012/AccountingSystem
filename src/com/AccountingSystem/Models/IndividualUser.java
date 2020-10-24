package com.AccountingSystem.Models;

public class IndividualUser extends User{
    String surname;
    String userType = "IndividualUser";

    public IndividualUser(String name, String surname, String email, String phone, String loginName, String loginPassword) {
        super(name, email, phone, loginName, loginPassword);
        this.surname = surname;

        active = true;
    }


    public void ShowUserDetails()
    {
        System.out.println("Name: " + this.name + " " + this.surname + " Username: " + this.loginName + " User Type: " + this.userType);
    }
}
