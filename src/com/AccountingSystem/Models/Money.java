package com.AccountingSystem.Models;


public class Money {

    public static float ConvertToMoney(String text)
    {
       float amount = Float.parseFloat(text);
       amount = (float) (Math.round(amount * 100.0) / 100.0);

       return amount;
    }
}
