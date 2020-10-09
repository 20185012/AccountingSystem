package com.AccountingSystem.Models;


import java.util.Scanner;

public class Money {
    private float amount;



    public Money(Float amount) {
        this.amount = amount;
    }

    public Money() {
        this.amount = (float) 0;
    }

    public float getAmount() {
        return amount;
    }



    public static float ConvertToMoney(String text)
    {
        return MakeMonetaryFormat(text);
    }

    private static float MakeMonetaryFormat(String text) {
        try {

            float amount = Float.parseFloat(text);
            amount = SetFloatPrecision(amount, 2);
            return amount;

        } catch (NumberFormatException e) {
            System.out.println("What you entered is not a valid number. Try again.");
            return SpecifyPrice();
        }

    }

    private static float SetFloatPrecision(float floatNumber, int decimalPlaces) {
        float multiplier = (float) Math.pow(10,decimalPlaces);
        floatNumber = (Math.round(floatNumber * multiplier) / multiplier);
        return floatNumber;
    }




    public static float SpecifyPrice()
    {
        Scanner scanner = new Scanner(System.in);
        String price = scanner.next();
        return ConvertToMoney(price);
    }

    public void AddMoney(Money money)
    {
        this.amount += SetFloatPrecision(money.getAmount(),2);
    }
}
