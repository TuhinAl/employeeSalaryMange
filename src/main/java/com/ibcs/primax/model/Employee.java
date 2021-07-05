package com.ibcs.primax.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
    private Long employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "employee_grade_type", nullable = false)
    private String gradeType;


    @Column()
    private Date employeeCreateDate;


    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "employee",orphanRemoval = true,
            optional = false,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "add_id_fk", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
    mappedBy = "employee", orphanRemoval = true,
    fetch = FetchType.LAZY
    )
    private EmployeeAccount employeeAccount;


    @ManyToOne
    @MapsId("bankId")
    @JoinColumn(name = "bank_id",
    foreignKey = @ForeignKey(
            name = "bank_employee_id_fk"
    )
    )
    private  Bank bank;



}
