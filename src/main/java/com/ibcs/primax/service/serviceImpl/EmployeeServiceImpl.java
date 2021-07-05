package com.ibcs.primax.service.serviceImpl;

import com.ibcs.primax.common.exception.EmployeeNotFoundException;
import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.mapper.requestMapper.EmployeeRequestMapping;
import com.ibcs.primax.repository.EmployeeRepository;
import com.ibcs.primax.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employee) {

        if (employee == null) {
            throw new EmployeeNotFoundException("Empty employee received");
        }

         employeeRepository.save(employeeRequestMapper.employeeMap(employee));

        return null;
    }
}
