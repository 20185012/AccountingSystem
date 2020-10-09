package com.AccountingSystem.Models;

import java.io.Serializable;
import java.sql.SQLOutput;
import java.time.LocalDate;

public class Receivable implements Serializable {
    Money receivableSum;
    LocalDate receivableDate;
    //String receivableDescription;
    //String remitterName;
    //String remitterAccountNumber;


    public Receivable(Money amount) {
        this.receivableSum = amount;
        this.receivableDate = LocalDate.now();
    }

    public Money getReceivableSum() {
        return receivableSum;
    }

    public LocalDate getReceivableDate() {
        return receivableDate;
    }

    public void ShowReceivableDetails()
    {
        System.out.println("Sum: " + this.receivableSum.getAmount() + " Transaction date: " + this.receivableDate);
    }
}
