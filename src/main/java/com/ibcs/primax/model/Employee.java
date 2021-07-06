package com.ibcs.primax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_infos")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employee_grade_type", nullable = false)
    @Enumerated
    private SalaryGrade gradeType;


    @Column()
    private Date employeeCreateDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adddress_id", referencedColumnName = "id")
    private Address address;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "em_ac_id", referencedColumnName = "id")
    private EmployeeAccount employeeAccount;


    @ManyToOne()
  /*  @JoinColumn(name = "emp_id", referencedColumnName = "id")*/
    private  Bank bank;



}
