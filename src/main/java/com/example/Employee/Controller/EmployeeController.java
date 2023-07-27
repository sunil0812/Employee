package com.example.Employee.Controller;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.EmployeeDTO;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Model.Employee;
import com.example.Employee.Service.EmployeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeServ employeServ;

    @PostMapping(value = "/saveEmployee")
    public ResponseEntity<BaseResponse> saveemployee(@RequestBody EmployeeDTO emp, VendorDto vendorDto) {
    return new ResponseEntity<>(employeServ.saveEmployee(emp,vendorDto),HttpStatus.OK);
    }
    @GetMapping(value="/getemployee")
    public List<Employee> listallemployee(){
        return employeServ.listemplo();
    }

    @PutMapping(value = "/updateemploye/{sno}")
    public Employee updateemploy( @RequestBody EmployeeDTO emp,@PathVariable("sno")Long id){
        return employeServ.update(emp,id);
    }

    @DeleteMapping(value = "/deleteemploy/{sno}")
        public void deleteemploy(@PathVariable("sno")Long id){
             employeServ.deleteemployebyid(id);
        System.out.println("1234rfdcxz");
        }



}
