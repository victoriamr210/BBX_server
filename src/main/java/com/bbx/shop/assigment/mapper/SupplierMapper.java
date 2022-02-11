package com.bbx.shop.assigment.mapper;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.dto.SupplierDTO;
import com.bbx.shop.assigment.model.Supplier;

import java.util.List;
import java.util.stream.Collectors;

public class SupplierMapper {
    public static SupplierDTO pojo2Dto(Supplier supplier){
        return new SupplierDTO(supplier.getIdSupplier(), supplier.getName(), supplier.getCountry());
    }

    public static List<SupplierDTO> pojo2Dto(List<Supplier> supplierList){
        return supplierList.stream().map(supplier -> pojo2Dto(supplier)).collect(Collectors.toList());
    }
}
