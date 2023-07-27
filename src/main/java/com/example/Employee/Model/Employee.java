package com.example.Employee.Model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String name;

    private Long number;

    private String mail;

    private String companyName;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendorId" , referencedColumnName = "vendorId")
    private VendorDetails vendorId;



}

