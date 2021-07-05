package com.ibcs.primax.dto.requestDto;

import com.ibcs.primax.model.Address;
import com.ibcs.primax.model.Bank;
import com.ibcs.primax.model.EmployeeAccount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    private Integer id;
    private Long employeeId;
    private String employeeName;
    private String email;
    private String mobile;
    private Address address;
    private EmployeeAccount employeeAccount;
    private Bank bank;

}
