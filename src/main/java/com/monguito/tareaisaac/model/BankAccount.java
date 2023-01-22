package com.monguito.tareaisaac.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document("Cuenta")
public class BankAccount {
    @Id
    String accountNumber;
    List<String> accountHolders;
    double balance;
    LocalDate date;
    boolean deleted;
    public BankAccount(){

    }
    public BankAccount(List<String> accountHolders) {
        this.accountHolders = accountHolders;
        this.balance = 0;
        this.date = LocalDate.now();
        this.deleted = false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public List<String> getAccountHolders() {
        return accountHolders;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
