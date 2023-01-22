package com.monguito.tareaisaac.repository;

import com.monguito.tareaisaac.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    @Query("{ 'deleted': false}")
    List<BankAccount> findAllAccounts();

    @Query("{ 'numeroCuenta': ?0 }")
    void softDeleteAccount(String numeroCuenta, boolean borrada);
}