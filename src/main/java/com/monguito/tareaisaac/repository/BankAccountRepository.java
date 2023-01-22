package com.monguito.tareaisaac.repository;

import com.monguito.tareaisaac.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface BankAccountRepository extends MongoRepository<BankAccount, String> {
    @Query("{ 'deleted': false}")
    List<BankAccount> findAllAccounts();

    @Query("{ 'numeroCuenta': ?0 }")
    void softDeleteAccount(String numeroCuenta, boolean borrada);

    @Query("{ 'date': { $gte: ?0 ,$lte: ?1 }}")
    List<BankAccount> findAllByDates(Date date1, Date date2);
}
