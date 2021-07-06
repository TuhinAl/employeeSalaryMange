package com.ibcs.primax.controller;

import com.ibcs.primax.dto.requestDto.CompanyDTO;
import com.ibcs.primax.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

@EnableTransactionManagement
@RestController
@RequestMapping("/company/v1/api/")

public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/deposit/{id}")
    public void deposit(@PathVariable("id") Long id, @RequestParam double amount) {
        companyService.depositAmount(amount, id);
    }


    @PostMapping("/transfer")
    void transfer(@RequestParam double amount, @RequestParam Long companyId,
                  @RequestParam Long employeeId) {

        companyService.transferAmount(amount, companyId, employeeId);
    }

    @PostMapping("/register")
    void registerCompany(@RequestBody CompanyDTO companyDTO) {

        companyService.registerCompanyToBank(companyDTO);
    }
}
