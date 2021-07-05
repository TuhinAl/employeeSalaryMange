package com.ibcs.primax.jwt.jwtService;

import com.ibcs.primax.model.Employee;
import com.ibcs.primax.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author tuhin
 * @created_on 7/6/21 at 12:15 AM
 * @project primax
 **/

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Employee employee = employeeRepository.findEmployeeByEmail(email);
        if (employee == null) {
            throw new UsernameNotFoundException("Employee email not found");

        }


        return new User(employee.getEmail(), employee.getPassword(), new ArrayList<>());
    }
}
