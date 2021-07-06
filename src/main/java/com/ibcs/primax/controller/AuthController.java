package com.ibcs.primax.controller;

import com.ibcs.primax.common.util.ApiResponse;
import com.ibcs.primax.dto.requestDto.EmployeeDTO;
import com.ibcs.primax.jwt.dto.AuthenticationResponse;
import com.ibcs.primax.jwt.dto.LoginRequest;
import com.ibcs.primax.jwt.jwtService.CustomEmployeeDetailsService;
import com.ibcs.primax.model.Employee;
import com.ibcs.primax.repository.EmployeeRepository;
import com.ibcs.primax.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author tuhin
 * @created_on 7/6/21 at 1:20 AM
 * @project primax
 **/

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CustomEmployeeDetailsService customEmployeeDetailsService;


    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService employeeService;



    @PostMapping("/api/login")
    public ResponseEntity<?> authenticateEmployee(@Valid @RequestBody LoginRequest loginRequest) {

        UserDetails userDetails = customEmployeeDetailsService.loadUserByUsername(loginRequest.getEmail());

        return ResponseEntity.ok(new AuthenticationResponse("ok"));
    }





    @PostMapping("/signup")
    public ResponseEntity<?> registerEmployee(@Valid @RequestBody EmployeeDTO signUpEmployee) {


        Employee employeeByEmail = employeeRepository.findEmployeeByEmail(signUpEmployee.getEmail());

        if(employeeByEmail != null) {
            return new ResponseEntity(new ApiResponse(false, "Employee with this email already registered "),
                    HttpStatus.BAD_REQUEST);
        }

        employeeService.saveEmployee(signUpEmployee);

        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
    }



}
