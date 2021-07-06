package com.ibcs.primax.service.serviceImpl;

import com.ibcs.primax.common.exception.InsufficientBalanceException;
import com.ibcs.primax.dto.requestDto.CompanyDTO;
import com.ibcs.primax.mapper.requestMapper.CompanyRequestMapping;
import com.ibcs.primax.model.Company;
import com.ibcs.primax.model.Employee;
import com.ibcs.primax.model.EmployeeAccount;
import com.ibcs.primax.repository.CompanyRepository;
import com.ibcs.primax.repository.EmployeeAccountRepository;
import com.ibcs.primax.repository.EmployeeRepository;
import com.ibcs.primax.service.interfaces.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

/**
 * @author tuhin
 * @created_on 7/6/21 at 9:36 AM
 * @project primax
 **/
@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRequestMapping companyRequestMapping;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeAccountRepository employeeAccountRepository;


    @Override
    public void registerCompanyToBank(CompanyDTO companyDTO) {

        if (companyDTO == null) {
            throw new EntityNotFoundException("empty company value received");
        }

        companyRepository.save(companyRequestMapping.map(companyDTO));

    }

    /**
     *
     * @param amount
     * @param id
     * @Description: Deposit money to company account
     * Retrieve company from DB, update currentBalance by adding newly deposit money
     */

    @Override
    public void depositAmount(double amount, Long id) {

        Company company = companyRepository.getById(id);
        double currentBalance = company.getCompanyCurrentBalance();
        currentBalance += amount;
        company.setId(company.getId());
        company.setCompanyCurrentBalance(currentBalance);

        companyRepository.save(company);
    }


    /**
     *
     * @param amount
     * @param companyId
     * @param employeeId
     * @Description Retrieve company balance, employee balance
     * amount added to employee balance and deducted from company balance
     * saved updated entity
     */

    @Override
    public void transferAmount(double amount, Long companyId, Long employeeId) {

        EmployeeAccount employeeAccount = employeeAccountRepository.getById(employeeId);
        Company company = companyRepository.getById(companyId);

        if (company.getCompanyCurrentBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance..");
        }
        double employeeBalance = employeeAccount.getAccountBalance();
        employeeBalance += amount;

        double companyBalance = company.getCompanyCurrentBalance();
        companyBalance -= amount;

        employeeAccount.setId(employeeAccount.getId());
        employeeAccount.setAccountBalance(employeeBalance);

        company.setId(company.getId());
        company.setCompanyCurrentBalance(companyBalance);

        employeeAccountRepository.save(employeeAccount);
        companyRepository.save(company);
    }
}
