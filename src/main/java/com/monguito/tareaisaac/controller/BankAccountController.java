package com.monguito.tareaisaac.controller;

import com.monguito.tareaisaac.model.BankAccount;
import com.monguito.tareaisaac.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BankAccountController {
    @Autowired
    private BankAccountService service;

    @GetMapping("/banco/cuentas")
    public List<BankAccount> getAllCuentas() {
        return service.findAll();
    }

    @GetMapping("/banco/cuentas/{nro_cuenta}")
    public Optional<BankAccount> getCuentaByNumeroCuenta(@PathVariable String nro_cuenta) {
        return service.findAccountById(nro_cuenta);
    }

    @PostMapping("/banco/cuentas/new")
    public String insertCuenta(@RequestBody BankAccount cuentaBancaria) {
        return service.insert(cuentaBancaria);
    }

    @PutMapping("/banco/cuentas/update")
    public String updateCuenta(@RequestBody BankAccount cuentaBancaria) {
        return service.save(cuentaBancaria);
    }

    @DeleteMapping("/banco/cuentas/{nro_cuenta}")
    public String deleteCuenta(@PathVariable String nro_cuenta) {
        return service.deleteAccount(nro_cuenta);
    }
}
