package com.AccountingSystem.Models;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Payment implements Serializable {
    //int paymentId;
    Money paymentSum;
    LocalDate paymentDate;
    //String paymentDescription;
    //String paymentBeneficiary;
    //String paymentBeneficiaryNumber;


    public Payment(Money amount) {
        this.paymentSum = amount;
        this.paymentDate = LocalDate.now();
    }

    public static Payment MakeNewPayment(Money amount)
    {
        return new Payment(amount);
    }

    public void ShowPaymentDetails()
    {
        System.out.println("Sum: " + this.paymentSum.getAmount() + "  Transaction Date: " + this.paymentDate);
    }
}
