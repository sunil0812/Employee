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
import com.example.Employee.exception.EmailAlreadyExists;
import com.example.Employee.utility.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class Employeeservimpl implements EmployeServ {

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private VendorRepo vendorRepo;


    @Autowired
    private EmailService emailService;

    @Override
    public BaseResponse saveEmployee(EmployeeDTO emp, VendorDto vendorDto){

        try {
            Employee employee = employeerepo.findByMail(emp.getMail());

            if ( employee != null) {
                throw new EmailAlreadyExists("Email Already Exists",409);

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
            emailService.EmailSend(emp.getMail(),"Employee Added","Your welcome");
        } catch (RuntimeException e) {
            e.printStackTrace();
        } catch (EmailAlreadyExists e) {
            throw new RuntimeException(e);
        }

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("Data saved Success");
        baseResponse.setMessage(HttpStatus.ACCEPTED.name());
        baseResponse.setCode(HttpStatus.ACCEPTED.value());

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
