package com.example.Employee.Controller;

import com.example.Employee.BaseResponse.BaseResponse;
import com.example.Employee.DTO.VendorDto;
import com.example.Employee.Service.VendoServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Vendor")
public class VendorContrller {

    @Autowired
    private VendoServ vendoServ;


    @PostMapping(value = "/saveVendor")
    public ResponseEntity<BaseResponse> saveVendor(@RequestBody VendorDto ven) {
        System.out.println("124545y6t");

        return new ResponseEntity<>(vendoServ.saveVendor(ven), HttpStatus.OK);
    }
}
