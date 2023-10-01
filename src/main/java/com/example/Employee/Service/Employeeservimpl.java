package com.example.Employee.Service;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.EmployeeDTO;
import com.example.Employee.DTO.UpdateEmployeeDTO;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Model.Employee;
import com.example.Employee.Model.InterviewDeatils;
import com.example.Employee.Model.VendorDetails;
import com.example.Employee.Repo.Employeerepo;
import com.example.Employee.Repo.VendorRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Slf4j
@Service
public class Employeeservimpl implements EmployeServ {

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private VendorRepo vendorRepo;

    @Override
    public BaseResponse saveEmployee(EmployeeDTO emp, VendorDto vendorDto) throws RuntimeException {

        try {
            if (employeerepo.findByMail(emp.getMail()) == null) {
                throw new RuntimeException("Email Already Exists");

            }
            Employee employee1 = new Employee();
            employee1.setMail(emp.getMail());
            employee1.setName(emp.getName());
            employee1.setNumber(emp.getNumber());
            employee1.setCompanyName(emp.getCompanyName());
            employee1.setInterviewDetails(emp.getInterviewDetails());
            VendorDetails vendors = vendorRepo.findByName(emp.getCompanyName());
            employee1.setVendorId(vendors);

            employeerepo.save(employee1);
            log.info("New Employee Added Successfully");
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setStatus("Data saved Success");
            baseResponse.setMessage(HttpStatus.OK.name());
            baseResponse.setCode(HttpServletResponse.SC_ACCEPTED);

            return baseResponse;
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(HttpStatus.BAD_REQUEST.value());
        baseResponse.setCode(HttpServletResponse.SC_BAD_GATEWAY);
        baseResponse.setStatus(HttpStatus.BAD_REQUEST.name());
        return baseResponse;
    }

    @Override
    public List<Employee> listemplo() {
        return employeerepo.findAll();
    }


    @Override
    public BaseResponse update(UpdateEmployeeDTO emp, Long id) {

        Employee employee = employeerepo.findById(id).orElseThrow(() -> new RuntimeException("error occurred"));
        employee.setNumber(emp.getNumber());
        employee.setName(emp.getName());
        employee.setMail(emp.getMail());
        InterviewDeatils interviewDeatils = new InterviewDeatils();
        interviewDeatils.setStatus(emp.getStatus());
        employee.setInterviewDetails(interviewDeatils);
        log.info("Employee Updated Successfully");
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(200);
        baseResponse.setStatus("Success");
        baseResponse.setMessage("Employee updated Successfully");
        employeerepo.save(employee);
        return baseResponse;
    }

    @Override
    public void deleteemployebyid(Long id) {
        employeerepo.deleteById(id);
    }





}
