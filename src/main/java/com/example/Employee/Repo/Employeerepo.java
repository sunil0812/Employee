package com.example.Employee.Repo;

import com.example.Employee.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Employeerepo extends JpaRepository<Employee,Long> {


//    public VendorDetails findByVendorId(Long vendorId);



    public Employee findByMail(String mail);

//    Mono<Employee> findBySno(Long id);
}
