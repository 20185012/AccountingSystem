package com.AccountingSystem.Models;

import java.io.Serializable;
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

    @Override
    public String toString() {
        return "ReceivedMoney: " + this.receivableSum + " " + " Date: " + this.receivableDate + "\n";
    }
}
