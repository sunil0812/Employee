package com.example.Employee.Repo;

import com.example.Employee.Model.VendorDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendorRepo extends JpaRepository<VendorDetails,Long> {
    @Query(value = "select * from vendor where vendor_id = 1",nativeQuery = true)
    public VendorDetails findByVendorId(Long id);

    @Query(value = "select * from vendor where name = :name",nativeQuery = true)
    public VendorDetails findByName(@Param("name") String name);
}
