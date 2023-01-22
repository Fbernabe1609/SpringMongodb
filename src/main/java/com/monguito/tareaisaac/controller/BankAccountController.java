package com.monguito.tareaisaac.controller;

import com.monguito.tareaisaac.model.BankAccount;
import com.monguito.tareaisaac.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
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

    @DeleteMapping("/banco/cuentas/{nro_cuenta}")
    public String deleteCuenta(@PathVariable String nro_cuenta) {
        return service.deleteAccount(nro_cuenta);
    }

    @GetMapping("/banco/cuentas/{fecha_ini}/{fecha_fin}")
    public List<BankAccount> getAccountByDates(@PathVariable Date fecha_ini, @PathVariable Date fecha_fin) {
        return service.findAccountByDates(fecha_ini, fecha_fin);
    }

    @GetMapping("/banco/cuentas/ingresar/{nro_cuenta}/{ingreso}")
    public String insertMoney(String numeroCuenta, double ingreso) {
        return service.insertMoneyInAccount(numeroCuenta, ingreso);
    }

    @GetMapping("/banco/cuentas/retirar/{nro_cuenta}/{retiro}")
    public String withdrawMoney(String numeroCuenta, double retiro) {
        return service.withdrawMoneyInAccount(numeroCuenta, retiro);
    }

    @PutMapping("/banco/cuentas/update")
    public String updateCuenta(@RequestBody BankAccount cuentaBancaria) {
        return service.update(cuentaBancaria);
    }
}
