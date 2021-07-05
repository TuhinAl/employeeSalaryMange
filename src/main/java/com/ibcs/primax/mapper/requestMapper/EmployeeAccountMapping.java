package com.ibcs.primax.mapper.requestMapper;

import com.ibcs.primax.dto.requestDto.BankInfoDTO;
import com.ibcs.primax.dto.requestDto.EmployeeAccountDTO;
import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.model.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAccountMapping {


    public EmployeeAccount employeeAccountMap(EmployeeAccountDTO dto) {
        System.out.println("DEBUG: Inside EmployeeAccount Mapper: ");

        EmployeeAccount employee = new EmployeeAccount();

        employee.setAccountType(dto.getAccountType());
        employee.setBasicSalary(dto.getBasicSalary());
        employee.setHomeRent(dto.getHomeRent());
        employee.setMedicalAllowance(dto.getMedicalAllowance());

        System.out.println("DEBUG: Inside EmployeeAccount Mapper output: "+employee);

        return employee;
    }



}
