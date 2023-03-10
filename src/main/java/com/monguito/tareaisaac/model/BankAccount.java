package com.monguito.tareaisaac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("Cuenta")
public class BankAccount {
    @Id
    String accountNumber;
    List<String> accountHolders;
    double balance;
    LocalDateTime date;
    boolean deleted;
    public BankAccount(){

    }
    public BankAccount(List<String> accountHolders) {
        this.accountHolders = accountHolders;
        this.balance = 0;
        this.deleted = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<String> getAccountHolders() {
        return accountHolders;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
