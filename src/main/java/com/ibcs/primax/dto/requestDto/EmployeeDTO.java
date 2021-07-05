package com.ibcs.primax.dto.requestDto;

import com.ibcs.primax.model.Address;
import com.ibcs.primax.model.Bank;
import com.ibcs.primax.model.EmployeeAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {


    private Long  id;
    private String employeeName;
    private String email;
    private String mobile;
    private String password;
    private String grade;
    private Enum accountType;
    private Address address;
    private Double basicSalary;
    private String branchName;
    private String bankName;
    private Date createDate;



}
