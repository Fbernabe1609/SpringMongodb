package com.monguito.tareaisaac.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("Cuenta")
public class BankAccount {
    @Id
    ObjectId id;
    long accountNumber;
    List<String> accountHolders;
    double balance;
    Date date;
    boolean deleted;

    public BankAccount(long accountNumber, List<String> accountHolders, double balance, Date date, boolean deleted) {
        this.accountNumber = accountNumber;
        this.accountHolders = accountHolders;
        this.balance = balance;
        this.date = date;
        this.deleted = deleted;
    }
}
