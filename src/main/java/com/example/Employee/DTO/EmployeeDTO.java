package com.example.Employee.DTO;

import com.example.Employee.Model.InterviewDeatils;
import com.example.Employee.Model.VendorDetails;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private String name;
    private Long number;
    private String mail;
    private String companyName;
    private InterviewDeatils interviewDetails;




}
