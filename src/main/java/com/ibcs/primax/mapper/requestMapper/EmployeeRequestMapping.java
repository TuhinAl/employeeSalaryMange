package com.ibcs.primax.mapper.requestMapper;

import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.model.Employee;
import com.ibcs.primax.model.SalaryGrade;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmployeeRequestMapping {


    public Employee employeeMap(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setEmployeeName(employeeDTO.getEmployeeName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setMobile(employeeDTO.getMobile());
        employee.setEmployeeCreateDate(new Date());
        employee.setAddress(employeeDTO.getAddress());
        employee.setAddress( employeeDTO.getAddress());

        return employee;
    }

    public double calculateSalary(double baseSalary, SalaryGrade grade) {

            // int gradeWiseSalaryIncrement = 5000;


        if (SalaryGrade.GRADE_SIX == grade) {
            return baseSalary;
        }
        if (SalaryGrade.GRADE_FIVE == grade) {
            baseSalary += 5000;
            return baseSalary;
        }

        if (SalaryGrade.GRADE_FOUR == grade) {
            baseSalary += (5000 * 2);
            return baseSalary;

        }
        if (SalaryGrade.GRADE_THREE == grade) {
            baseSalary += (5000 * 3);
            return baseSalary;
        }
        if (SalaryGrade.GRADE_TWO == grade) {
            baseSalary += (5000 * 4);
            return baseSalary;
        }
        if (SalaryGrade.GRADE_ONE == grade) {
            baseSalary += (5000 * 5);
            return baseSalary;
        }
        return baseSalary;
    }

    double calculateHomeRent(double baseSalary) {
        double  homeRent = (baseSalary * 0.2);
        return homeRent;
    }

    double calculateMedicalAllowance(double baseSalary) {
        double medicalFees = (baseSalary * 0.15);
        return medicalFees;
    }
}
