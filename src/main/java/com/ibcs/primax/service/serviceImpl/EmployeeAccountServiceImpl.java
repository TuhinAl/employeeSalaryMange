package com.ibcs.primax.service.serviceImpl;

import com.ibcs.primax.model.EmployeeAccount;
import com.ibcs.primax.repository.EmployeeAccountRepository;
import com.ibcs.primax.service.interfaces.EmployeeAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tuhin
 * @created_on 7/6/21 at 2:13 AM
 * @project primax
 **/
@Service
public class EmployeeAccountServiceImpl implements EmployeeAccountService {

    @Autowired
    EmployeeAccountRepository employeeAccountRepository;

    @Override
    public EmployeeAccount getAccountById(Long id) {

        EmployeeAccount account = employeeAccountRepository.getById(id);
        return account;
    }

    @Override
    public List<EmployeeAccount> getAllAccount() {
        List<EmployeeAccount> accountList = employeeAccountRepository.findAll();
        return accountList;
    }
}
