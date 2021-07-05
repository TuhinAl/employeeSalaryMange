package com.ibcs.primax.service.serviceImpl;

import com.ibcs.primax.common.exception.EmployeeNotFoundException;
import com.ibcs.primax.dto.requestDto.BankInfoDTO;
import com.ibcs.primax.dto.requestDto.EmployeeAccountDTO;
import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.mapper.requestMapper.BankInfoRequestMapping;
import com.ibcs.primax.mapper.requestMapper.EmployeeAccountMapping;
import com.ibcs.primax.mapper.requestMapper.EmployeeRequestMapping;
import com.ibcs.primax.mapper.responseMapper.EmployeeResponseMapper;
import com.ibcs.primax.model.AccountType;
import com.ibcs.primax.model.Employee;
import com.ibcs.primax.model.SalaryGrade;
import com.ibcs.primax.repository.BankRepository;
import com.ibcs.primax.repository.EmployeeAccountRepository;
import com.ibcs.primax.repository.EmployeeRepository;
import com.ibcs.primax.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author tuhin
 * @created_on 7/5/21 at 12:40 AM
 * @project primax
 **/


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeRequestMapping employeeRequestMapper;

    @Autowired
    EmployeeAccountMapping employeeAccountRequestMapping;

    @Autowired
    BankInfoRequestMapping bankInfoRequestMapping;

    @Autowired
    BankRepository bankRepository;

    @Autowired
    EmployeeAccountRepository employeeAccountRepository;

    @Autowired
    EmployeeResponseMapper employeeResponseMapper;






    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employee) {

        if (employee == null) {
            throw new EmployeeNotFoundException("Empty employee received");
        }


        employeeRepository.save(employeeRequestMapper.employeeMap(employee));

        BankInfoDTO bankInfo = new BankInfoDTO();
        bankInfo.setBankName(employee.getBankName());
        bankInfo.setBranchName(employee.getBranchName());
        bankInfo.setAccountName(employee.getEmployeeName());
        bankInfo.setCurrentBalance(50000.00);

        bankRepository.save(bankInfoRequestMapping.bankMap(bankInfo));

        double calculateBasicSalary = calculateSalary(employee.getBasicSalary(),
                SalaryGrade.returnGradeStatus(employee.getGrade()));
        System.out.println("****calculateBasicSalary**: "+calculateBasicSalary);

        double homeRent = calculateHomeRent(employee.getBasicSalary());
        System.out.println("****homeRent**: "+homeRent);
        double medicalFess = calculateMedicalAllowance(employee.getBasicSalary());
        System.out.println("****medicalFess**: "+medicalFess);



        EmployeeAccountDTO employeeAccount = new EmployeeAccountDTO();
        employeeAccount.setAccountType(AccountType.CURRENT);
        employeeAccount.setBasicSalary(calculateBasicSalary);
        employeeAccount.setHomeRent(homeRent);
        employeeAccount.setMedicalAllowance(medicalFess);
        employeeAccount.setEmployeeId(employee.getId());

        employeeAccountRepository.save(employeeAccountRequestMapping
                .employeeAccountMap(employeeAccount));



        return null;
    }

    @Override
    public EmployeeDTO getEmployeeById(String email) {
       // System.out.println("Debug: inside 'get employee by id: " + id);
       /* if (id == null) {
            throw new IllegalArgumentException("Empty Employee id received");
        }*/
           // Optional<Employee> employee = employeeRepository.findById(id);
        //Employee employee = employeeRepository.getEmployeeById(id);
        Employee employee = employeeRepository.findByEmail(email);
        System.out.println("Debug: inside 'get employee by id: Employee: " + employee);
        return employeeResponseMapper.Map(employee);
    }

    @Override
    public String updateEmployee(Long Id, EmployeeDTO dto) {

        if (Id == null || dto == null) {
            throw new IllegalArgumentException("Empty Employee id and dto received");
        }

        Employee employee = employeeRepository.getEmployeeById(Id);

        employee.setId(employee.getId());

        employee.setEmployeeName(dto.getEmployeeName());
        employee.setEmail(dto.getEmail());
        employee.setMobile(dto.getMobile());
        employee.setPassword(employee.getPassword());
        employee.setGradeType(SalaryGrade.returnGradeStatus(dto.getGrade()));
        employee.setEmployeeCreateDate(employee.getEmployeeCreateDate());

        employeeRepository.save(employee);

        return "Employee added successfully";
    }

    @Override
    public String deleteEmployeeById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Empty Employee id received");
        }
        /*Employee employee = employeeRepository.getEmployeeById(id);
        employeeRepository.delete(employee);*/

        employeeRepository.deleteById(id);

        return "Employee Deleted successfully";
    }


    public double calculateSalary(double baseSalary, SalaryGrade grade) {

        // int gradeWiseSalaryIncrement = 5000;
        System.out.println("DEBUG: Inside Salary Calculate Method: "+baseSalary);
        System.out.println("DEBUG: Inside Salary Calculate Method: "+grade);


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

        System.out.println("DEBUG: Inside Salary Calculate Method: "+baseSalary);
        return baseSalary;
    }



    double calculateHomeRent(double baseSalary) {
        System.out.println("DEBUG: Inside Home Rent Calculate Method: "+baseSalary);
        double  homeRent = (baseSalary * 0.2);
        System.out.println("DEBUG: Inside HomeRent Calculate output: "+homeRent);
        return homeRent;

    }

    double calculateMedicalAllowance(double baseSalary) {
        System.out.println("DEBUG: Inside Medical Allowance Calculate Method: "+baseSalary);
        double medicalFees = (baseSalary * 0.15);
        System.out.println("DEBUG: Inside Medical Allowance Calculate output: "+medicalFees);
        return medicalFees;
    }
}
