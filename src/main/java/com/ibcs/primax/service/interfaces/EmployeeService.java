package com.ibcs.primax.service.interfaces;

import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDTO saveEmployee(EmployeeDTO employee);


}
