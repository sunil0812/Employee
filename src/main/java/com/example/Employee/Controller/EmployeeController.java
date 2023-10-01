package com.example.Employee.Controller;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.EmployeeDTO;
import com.example.Employee.DTO.UpdateEmployeeDTO;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Model.Employee;
import com.example.Employee.Repo.Employeerepo;
import com.example.Employee.Service.EmployeServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    @Autowired
    private EmployeServ employeServ;

    @Autowired
    private Employeerepo employeerepo;

    @PostMapping(value = "/saveEmployee")
    public BaseResponse saveemployee(@Valid @RequestBody EmployeeDTO emp, VendorDto vendorDto) {
    return (employeServ.saveEmployee(emp,vendorDto));

    }
    @GetMapping(value="/getemployee")
    public List<Employee> listallemployee(){
        return employeServ.listemplo();
    }

    @PutMapping(value = "/updateemploye/{sno}")
    public BaseResponse updateemploy( @RequestBody UpdateEmployeeDTO emp, @PathVariable("sno")Long id){
        return employeServ.update(emp, id);
    }

    @DeleteMapping(value = "/deleteemploy/{sno}")
        public void deleteemploy(@PathVariable("sno")Long id){
             employeServ.deleteemployebyid(id);
        }

//    @GetMapping("/{id}")
//    public Mono<Employee> getEmployeeById(@PathVariable Long id) {
//        return employeerepo.findBySno(id);
//    }



}
