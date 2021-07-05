package com.ibcs.primax.controller;

import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee/v1/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    /**
     *
     * @param employeeDTO
     * @return
     * @comment Return Type I used here is mostly that is very practice
     * but i know how implement Generic response and handle error in spring boot
     */

    @PostMapping("/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
        return "employee Saved successfully";
    }

    @GetMapping("/get/by/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable  Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public String updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        employeeService.updateEmployee(id, dto);
        return "Employee Update successful";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "Employee Delete successful";
    }
}
