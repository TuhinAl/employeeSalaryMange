package com.ibcs.primax.service.interfaces;

import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employee);

    Optional<Employee> getEmployeeById(Long id);

    String updateEmployee(Long Id, EmployeeDTO dto);

    String deleteEmployeeById(Long id);


}
