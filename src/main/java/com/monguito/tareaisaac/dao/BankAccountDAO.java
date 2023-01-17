package com.monguito.tareaisaac.dao;

import com.monguito.tareaisaac.model.BankAccount;

import java.util.Date;
import java.util.List;

public interface BankAccountDAO {
    List<BankAccount> findAll();
    BankAccount findByAccountNumber(long accountNumber);
    BankAccount findByDates(Date createdDate,Date deletedDate);
    void save(BankAccount bankAccount);
    void update(BankAccount bankAccount);
    void deleteByAccountNumber(long accountNumber);
}
