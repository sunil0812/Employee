package com.example.Employee.DTO;

import lombok.Data;

@Data
public class UpdateEmployeeDTO {
    private String name;
    private Long number;
    private String mail;
    private String status;

}
