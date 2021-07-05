package com.ibcs.primax.service.interfaces;

import com.ibcs.primax.model.EmployeeAccount;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeAccountService {

    EmployeeAccount getAccountById(Long id);

    List<EmployeeAccount> getAllAccount();
}
