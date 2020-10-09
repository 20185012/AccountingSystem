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

    public Money getPaymentSum() {
        return paymentSum;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void ShowPaymentDetails()
    {
        System.out.println("Sum: " + paymentSum.getAmount() + "  Transaction Date: " + paymentDate);
    }
}
