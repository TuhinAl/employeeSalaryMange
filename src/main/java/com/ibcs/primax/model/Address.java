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
    private Long id;

    @Column(name = "district")
    private String district;

    @Column(name = "division")
    private String division;

    @Column(name = "address_line")
    private String addressLine;

    @OneToOne(mappedBy = "address")
    private Employee employee;
}
