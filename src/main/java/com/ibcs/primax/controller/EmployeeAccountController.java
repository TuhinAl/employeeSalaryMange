package com.ibcs.primax.controller;

import com.ibcs.primax.model.EmployeeAccount;
import com.ibcs.primax.service.interfaces.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee/account/v1/api")
public class EmployeeAccountController {

    @Autowired
    EmployeeAccountService employeeAccountService;


    @GetMapping("/by/{id}")
    public EmployeeAccount getAccountById(@PathVariable Long id) {

        EmployeeAccount account = employeeAccountService.getAccountById(id);
        return account;
    }

    @GetMapping("/all")
    public List<EmployeeAccount> getAllAccount() {

        List<EmployeeAccount> accountList = employeeAccountService.getAllAccount();

        return accountList;
    }



}
