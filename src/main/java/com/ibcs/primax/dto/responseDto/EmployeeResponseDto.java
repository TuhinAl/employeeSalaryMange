package com.ibcs.primax.dto.responseDto;

import com.ibcs.primax.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author tuhin
 * @created_on 7/6/21 at 2:08 AM
 * @project primax
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDto {

    private Long  id;
    private String employeeName;
    private String email;
    private String mobile;
    private Address address;
    private String branchName;

}
