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


    /**
     *
     * @param employee
     * @return
     * @Comment Before Inject Model class Data into DB,  I used a MAPPER layer,
     * here i mapped Entity to DTO & DTO to Entity, I have use DTO for transfer object
     * between different layer, I never want to expose my DB column that is why i used DTO
     *
     */


    /**
     *
     * @param employee
     * @return
     * @COmment The Scenario behind how I inject my data into different table, I have create more than one
     *  table to normalize data,
     *  _________________________ Table and data
     *  Employee - contains user basic information like email, pass
     *  EmployeeAccount - this table contains Account related information of an Employee
     *  Address - addresses of Employee
     *  Bank - all bank related information like bankName, branchName
     *  Company - this table used for put data about a company
     *
     *  Relation between Table
     *
     *      Address 1------------1 Employee 1------------- 1 EmployeeAccount
     *                                M
     *                                '
     *                                '
     *                                1
     *                                Bank 1 -------------- M Company
     *
     *
     *
     *
     */

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employee) {

        if (employee == null) {
            throw new EmployeeNotFoundException("Empty employee received");
        }

        /**
         * though Employee table primary key use as FK in Bank and AccountInfo table
         *  to i save Employee first
         */

        employeeRepository.save(employeeRequestMapper.employeeMap(employee));

        /**
         *  here i hard-code for initial current balance
         *  then save Bank Table data
         *
         */

        BankInfoDTO bankInfo = new BankInfoDTO();
        bankInfo.setBankName(employee.getBankName());
        bankInfo.setBranchName(employee.getBranchName());
        bankInfo.setAccountName(employee.getEmployeeName());
        bankInfo.setCurrentBalance(50000.00);

        bankRepository.save(bankInfoRequestMapping.bankMap(bankInfo));


        /**
         * before save Employee Account Information i calculated GRADE wise basic salary, home rent feees,
         *  medical allowance fees as requirements
         */

        double calculateBasicSalary = calculateSalary(employee.getBasicSalary(),
                SalaryGrade.returnGradeStatus(employee.getGrade()));
        System.out.println("**** calculateBasicSalary**: "+calculateBasicSalary);

        double homeRent = calculateHomeRent(employee.getBasicSalary());
        System.out.println("**** homeRent**: "+homeRent);

        double medicalFess = calculateMedicalAllowance(employee.getBasicSalary());
        System.out.println("**** medicalFess**: "+medicalFess);



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
    public EmployeeDTO getEmployeeById(Long id) {
       // System.out.println("Debug: inside 'get employee by id: " + id);
       /* if (id == null) {
            throw new IllegalArgumentException("Empty Employee id received");
        }*/
           // Optional<Employee> employee = employeeRepository.findById(id);
        Employee employee = employeeRepository.getById(id);

        //Employee employee = employeeRepository.findByEmail(email);
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


    /**
     *
     *
     * @param baseSalary
     * @param grade
     * @return base salary
     * @Comment calculate basic salalry
     */

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


    /**
     *
     * @param baseSalary
     * @return homeRent
     * calculate home rent
     */
    double calculateHomeRent(double baseSalary) {
        System.out.println("DEBUG: Inside Home Rent Calculate Method: "+baseSalary);
        double  homeRent = (baseSalary * 0.2);
        System.out.println("DEBUG: Inside HomeRent Calculate output: "+homeRent);
        return homeRent;

    }

    /**
     *
     * @param baseSalary
     * @return medicalFees
     * calculate medicalFees
     */

    double calculateMedicalAllowance(double baseSalary) {
        System.out.println("DEBUG: Inside Medical Allowance Calculate Method: "+baseSalary);
        double medicalFees = (baseSalary * 0.15);
        System.out.println("DEBUG: Inside Medical Allowance Calculate output: "+medicalFees);
        return medicalFees;
    }
}
