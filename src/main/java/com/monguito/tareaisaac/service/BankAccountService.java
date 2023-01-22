package com.monguito.tareaisaac.service;

import com.monguito.tareaisaac.model.BankAccount;
import com.monguito.tareaisaac.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BankAccountService {
    @Autowired
    private BankAccountRepository repository;
    public String insert(BankAccount bankAccount) {
        String message = "";
        if (bankAccount.getAccountHolders() == null || bankAccount.getAccountHolders().size() == 0) {
            message = "Necesita un titular como mínimo para crear una cuenta.";
        } else {
            if (bankAccount.isDeleted()) {
                message = "Ha ocurrido un error: no es posible crear una cuenta indicando que está eliminada.";
            } else {
                bankAccount.setDate(LocalDateTime.now());
                message = "La cuenta bancaria ha sido creada con éxito.";
                repository.insert(bankAccount);
            }
        }
        return message;
    }

    public List<BankAccount> findAll() {
        return repository.findAllAccounts();
    }

    public String deleteAccount(String numeroCuenta) {
        String message = "";
        if (repository.findById(numeroCuenta).isEmpty()){
            message = "No existe ninguna cuenta con esos datos.";
        } else {
            message = "La cuenta bancaria eliminada.";
            repository.softDeleteAccount(numeroCuenta,true);
        }

        return message;
    }

    public Optional<BankAccount> findAccountById(String nro_cuenta) {
        return repository.findById(nro_cuenta);
    }

    public String save(BankAccount cuentaBancaria) {
        repository.save(cuentaBancaria);
        return "La cuenta bancaria ha sido actualizada con éxito.";
    }
}
