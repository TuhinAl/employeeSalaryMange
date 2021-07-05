package com.ibcs.primax.mapper.requestMapper;

import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.model.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeRequestMapping {


    public Employee employeeMap(EmployeeDTO employeeDTO) {

        System.out.println("DEBUG: Inside Employee Mapper: ");

        Employee employee = new Employee();

        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setMobile(employeeDTO.getMobile());
        employee.setEmployeeCreateDate(new Date());
        employee.setAddress(employeeDTO.getAddress());
        employee.setPassword(employeeDTO.getPassword());
        employee.setGradeType(SalaryGrade.returnGradeStatus(employeeDTO.getGrade()));

        System.out.println("DEBUG: Inside Employee Mapper DTO: " +employee);
        return employee;
    }


}
