package com.ibcs.primax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "employee",orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Address address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
    mappedBy = "employee", orphanRemoval = true,
    fetch = FetchType.LAZY
    )
    private EmployeeAccount employeeAccount;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private  Bank bank;

/*
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        mappedBy = "employee" , orphanRemoval = true,
            fetch = FetchType.LAZY

    )
    private EmployeeLoginInfo employeeLoginInfo;


*/


}
