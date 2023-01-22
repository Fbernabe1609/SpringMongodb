package com.monguito.tareaisaac.controller;

import com.monguito.tareaisaac.model.BankAccount;
import com.monguito.tareaisaac.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountRepository repository;

    @GetMapping("/banco/cuentas")
    public List<BankAccount> getAllCuentas() {
        return repository.findAll();
    }

//    @GetMapping("/banco/cuentas")
//    public List<BankAccount> getAllCuentas() {
//        return repository.findAllAccounts();
//    }

    @GetMapping("/banco/cuentas/{nro_cuenta}")
    public Optional<BankAccount> getCuentaByNumeroCuenta(@PathVariable String nro_cuenta) {
        return repository.findById(nro_cuenta);
    }

//    @GetMapping("/banco/cuentas/{nro_cuenta}")
//    public BankAccount getCuentaByNumeroCuenta(@PathVariable String nro_cuenta) {
//        return repository.findByNumeroCuenta(nro_cuenta);
//    }

    @PostMapping("/banco/cuentas/new")
    public String insertCuenta(@RequestBody BankAccount cuentaBancaria) {
        repository.insert(cuentaBancaria);
        return "La cuenta bancaria ha sido creada con éxito.";
    }

    @PutMapping("/banco/cuentas/update")
    public String updateCuenta(@RequestBody BankAccount cuentaBancaria) {
        repository.save(cuentaBancaria);
        return "La cuenta bancaria ha sido actualizada con éxito.";
    }

    @DeleteMapping("/banco/cuentas/{numeroCuenta}")
    public String deleteCuenta(@PathVariable String numeroCuenta) {
//        repository.findById();
        repository.softDeleteAccount(numeroCuenta,true);
        return "La cuenta bancaria eliminada.";
    }
}
