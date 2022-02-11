package com.bbx.shop.assigment.restService;

import com.bbx.shop.assigment.dto.SupplierDTO;
import com.bbx.shop.assigment.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierRestController  {
    private final SupplierService supplierService;

    @Autowired
    public SupplierRestController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/list")
    List<SupplierDTO> listAll(){
        return supplierService.findAll();
    }
}
