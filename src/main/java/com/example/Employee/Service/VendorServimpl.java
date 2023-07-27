package com.example.Employee.Service;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Model.VendorDetails;
import com.example.Employee.Repo.VendorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class VendorServimpl implements VendoServ{

    @Autowired
    private VendorRepo vendorRepo;


    @Override
    public BaseResponse saveVendor(VendorDto ven) {

        VendorDetails vendorDetails = new VendorDetails();
        vendorDetails.setName(ven.getName());
        vendorDetails.setAddress(ven.getAddress());
        vendorDetails.setRating(ven.getRating());
        vendorRepo.save(vendorDetails);

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setStatus("Data saved Success");
        baseResponse.setMessage(HttpStatus.OK.name());
        baseResponse.setCode(HttpServletResponse.SC_ACCEPTED);
        return baseResponse;
    }
}
