package com.bbx.shop.assigment.service;

import com.bbx.shop.assigment.dto.SupplierDTO;

import java.util.List;

public interface SupplierService {
    SupplierDTO createSupplier(SupplierDTO supplierDTO) throws Exception;
    SupplierDTO updateSupplier(SupplierDTO supplierDTO) throws Exception;
    void deleteSupplier(Long idSupplier) throws Exception;
    List<SupplierDTO> findByName(String name);
    List<SupplierDTO> findAll();
}
