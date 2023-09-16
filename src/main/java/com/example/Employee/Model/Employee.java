package com.example.Employee.Model;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "employee")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sno;

    private String name;

    private Long number;

    private String mail;

    private String companyName;

    @Column(name = "interviewDetails", columnDefinition = "json")
    @Type(type = "json")
    private InterviewDeatils interviewDetails;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private VendorDetails vendorId;





}

