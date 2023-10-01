package com.example.Employee.Model;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@Entity
@Data
@Table(name = "employee", schema = "public")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    @Column(name = "name")
    private String name;

    @NotNull(message = "Number should not be empty")
    @Column(name = "number")
    private Long number;

    @Email
    @Column(name = "mail")
    @Pattern(regexp = "^.*[A-Za-z0-9.@-]*$")
    private String mail;
    private String companyName;


    @Column(name = "interviewDetails", columnDefinition = "jsonb")
    @Type(type = "jsonb")
    private InterviewDeatils interviewDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendorId")
    private VendorDetails vendorId;
}

