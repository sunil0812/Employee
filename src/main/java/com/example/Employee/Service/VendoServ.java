package com.example.Employee.Service;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.VendorDto;

public interface VendoServ {

    public BaseResponse saveVendor(VendorDto ven);
}
