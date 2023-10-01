package com.example.Employee.Model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "vendor")
@Data
public class VendorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vendorId;

    private String name;

    private String address;

    private int rating;


}
