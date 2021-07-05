package com.ibcs.primax.model;

import javax.persistence.*;

/*@Entity
@Table(name = "employee_login_info")*/
public class EmployeeLoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

   /* @OneToOne(cascade = CascadeType.ALL, mappedBy = "employeeLoginInfo")
    @JoinColumn(
            name = "employee_id",
            foreignKey = @ForeignKey(name = "emp_id_fk")

    )
    private Employee employee;*/


}

