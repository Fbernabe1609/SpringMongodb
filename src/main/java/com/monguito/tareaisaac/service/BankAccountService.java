package com.monguito.tareaisaac.service;

import com.monguito.tareaisaac.model.BankAccount;
import com.monguito.tareaisaac.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;
    public String insert(BankAccount bankAccount) {
        repository.save(bankAccount);
        return "La cuenta bancaria ha sido creada con éxito.";
    }

    public List<BankAccount> findAll() {
        return repository.findAllAccounts();
    }

    public String deleteCuenta(String numeroCuenta) {
        repository.softDeleteAccount(numeroCuenta,true);
        return "La cuenta bancaria eliminada.";
    }

    public Optional<BankAccount> findById(String nro_cuenta) {
        return repository.findById(nro_cuenta);
    }
}
