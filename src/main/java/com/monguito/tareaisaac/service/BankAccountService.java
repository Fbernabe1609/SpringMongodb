package com.monguito.tareaisaac.service;

import com.monguito.tareaisaac.model.BankAccount;
import com.monguito.tareaisaac.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    public String update(BankAccount cuentaBancaria) {
        String message = "";
        boolean result = false;
        if(repository.existsById(cuentaBancaria.getAccountNumber())) {
            repository.save(cuentaBancaria);
            result = true;
        }
        if(result) {
            message = "Cuenta bancaria actualizada";
        } else {
            message = "La cuenta bancaria no existe";
        }
        return message;
    }

    public List<BankAccount> findAccountByDates(Date fechaIni, Date fechaFin) {
        return repository.findAllByDates(fechaIni, fechaFin);
    }

    public String insertMoneyInAccount(String numeroCuenta, double ingreso) {
        String message = "";
        if (ingreso <= 0) {
            message = "El ingreso debe ser positivo y mayor que 0";
        } else {
            Optional<BankAccount> cuenta = repository.findById(numeroCuenta);
            if (cuenta.isEmpty() || cuenta.get().isDeleted()){
                message = "La cuenta no existe";
            } else {
                double saldoAnterior = cuenta.get().getBalance();
                cuenta.get().setBalance(cuenta.get().getBalance() + ingreso);
                repository.save(cuenta.get());
                message = "Saldo anterior: " + saldoAnterior + " - Ingresado: " + ingreso + " - Saldo nuevo: " + cuenta.get().getBalance();
            }
        }
        return message;
    }

    public String withdrawMoneyInAccount(String numeroCuenta, double retiro) {
        String message = "";
        if (retiro <= 0) {
            message = "El retiro debe ser positivo y mayor que 0";
        } else {
            Optional<BankAccount> cuenta = repository.findById(numeroCuenta);
            if (cuenta.isEmpty() || cuenta.get().isDeleted()){
                message = "La cuenta no existe";
            } else {
                if (cuenta.get().getBalance() < retiro) {
                    retiro = cuenta.get().getBalance();
                }
                double saldoAnterior = cuenta.get().getBalance();
                cuenta.get().setBalance(cuenta.get().getBalance() - retiro);
                repository.save(cuenta.get());
                message = "Saldo anterior: " + saldoAnterior + " - Retirado: " + retiro + " - Saldo nuevo: " + cuenta.get().getBalance();
            }
        }
        return message;
    }
}
