package com.ibcs.primax.model;

public class EmployeeLoginInfo {

    private Integer id;
    private String email;
    private String password;
    private Role role;

}

 enum Role{
    EMPLOYEE,COMPANY_ADMIN
}
