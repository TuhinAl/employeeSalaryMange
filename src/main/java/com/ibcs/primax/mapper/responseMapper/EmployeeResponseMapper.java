package com.ibcs.primax.mapper.responseMapper;

import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.model.Employee;
import com.ibcs.primax.model.SalaryGrade;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author tuhin
 * @created_on 7/5/21 at 8:17 PM
 * @project primax
 **/

@Service
public class EmployeeResponseMapper {

    public EmployeeDTO Map(Employee employee) {

        System.out.println("DEBUG: Inside Employee Mapper: ");

        EmployeeDTO dto = new EmployeeDTO();

        dto.setEmployeeName(employee.getEmployeeName());
        dto.setEmail(employee.getEmail());
        dto.setMobile(employee.getMobile());
        dto.setAddress(employee.getAddress());
        dto.setPassword(employee.getPassword());

        System.out.println("DEBUG: Inside Employee Mapper DTO: " +employee);
        return dto;
    }
}
