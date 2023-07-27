package com.example.Employee.Service;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.EmployeeDTO;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Model.Employee;
import com.example.Employee.Model.VendorDetails;
import com.example.Employee.Repo.Employeerepo;
import com.example.Employee.Repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class Employeeservimpl implements EmployeServ{

    @Autowired
    private Employeerepo employeerepo;

    @Autowired
    private VendorRepo vendorRepo;

    @Override
    public BaseResponse saveEmployee(EmployeeDTO emp,VendorDto vendorDto) {

//
//if (employeerepo.findByMail(emp.getMail()) != null){
//
//    BaseResponse baseResponse = new BaseResponse();
//    baseResponse.setStatus("Data not Saved");
//    baseResponse.setMessage(HttpStatus.BAD_REQUEST.name());
//    baseResponse.setCode(HttpServletResponse.SC_BAD_GATEWAY);
//    throw new RuntimeException(HttpStatus.BAD_REQUEST.name());
//}



        Employee employee1 = new Employee();

        employee1.setMail(emp.getMail());
        employee1.setName(emp.getName());
        employee1.setNumber(emp.getNumber());
        employee1.setCompanyName(emp.getCompanyName());
        VendorDetails vendors = vendorRepo.findByName(emp.getCompanyName());
        System.out.println(vendors);
        employee1.setVendorId(vendors);
//
//        System.out.println(vendor);



//
//        System.out.println(vendor);
//        vendorRepo.save(vendor);

employeerepo.save(employee1);
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(List.of(employee1));
        baseResponse.setStatus("Data saved Success");
        baseResponse.setMessage(HttpStatus.OK.name());
        baseResponse.setCode(HttpServletResponse.SC_ACCEPTED);
        return baseResponse;
    }

    @Override
    public List<Employee> listemplo() {
        return employeerepo.findAll();
    }

    @Override
    public Employee update(EmployeeDTO emp,Long id) {

        Employee employee  = employeerepo.findById(id).orElseThrow(()->new RuntimeException());
        employee.setNumber(emp.getNumber());
        employee.setName(emp.getName());
        employee.setMail(emp.getMail());

        return employeerepo.save(employee);
    }

    @Override
    public void deleteemployebyid(Long id) {
        employeerepo.deleteById(id);
    }
}
