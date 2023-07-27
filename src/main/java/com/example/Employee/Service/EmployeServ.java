package com.example.Employee.Service;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.EmployeeDTO;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Model.Employee;

import java.util.List;

public interface EmployeServ {
    public BaseResponse saveEmployee(EmployeeDTO emp, VendorDto vendorDto);

   public List<Employee> listemplo();

  public Employee update(EmployeeDTO emp,Long id);

   public void deleteemployebyid(Long id);

}
