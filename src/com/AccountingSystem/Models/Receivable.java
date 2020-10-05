package com.AccountingSystem.Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Receivable implements Serializable {
    //int receivableId;
    float receivableSum;
    LocalDate receivableDate;
    //String receivableDescription;
    //String remitterName;
    //String remitterAccountNumber;


    public Receivable(float receivableSum, LocalDate receivableDate) {
        this.receivableSum = receivableSum;
        this.receivableDate = receivableDate;
    }

    public float getReceivableSum() {
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
