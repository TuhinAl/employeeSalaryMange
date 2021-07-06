package com.ibcs.primax.controller;

import com.ibcs.primax.model.Bank;
import com.ibcs.primax.service.interfaces.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableTransactionManagement
@RestController
@RequestMapping("/api/bank/v1")
public class BankController {

    @Autowired
    BankService bankService;


    @GetMapping("/all")
    public List<Bank> allBank() {

        List<Bank> bankListInfos = bankService.getAllBank();

        return bankListInfos;
    }


}
