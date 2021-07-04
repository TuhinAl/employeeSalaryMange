package com.ibcs.primax.model;

import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String employeeId;
    private String employeeName;
    private String email;
    private String mobile;
    private Address address;

}
