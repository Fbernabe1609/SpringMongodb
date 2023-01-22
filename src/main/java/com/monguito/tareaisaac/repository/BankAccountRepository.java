package com.monguito.tareaisaac.repository;

import com.monguito.tareaisaac.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.sql.Date;
import java.util.List;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    @Query("{ 'deleted': false}")
    List<BankAccount> findAllAccounts();

    @Query("{ 'numeroCuenta': ?0 }{ 'deleted': false}")
    void softDeleteAccount(String numeroCuenta, boolean borrada);

//    @Query("{ 'numeroCuenta': ?0 }")
//    List<BankAccount> findAllByDates(Date date1, Date date2);
}
