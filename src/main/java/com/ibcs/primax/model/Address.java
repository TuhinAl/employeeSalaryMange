package com.ibcs.primax.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String district;

    @Column
    private String division;

    @Column
    private String addressLine;

    @OneToOne
    private Employee employee;
}
