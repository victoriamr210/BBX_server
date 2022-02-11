package com.bbx.shop.assigment.repository;

import com.bbx.shop.assigment.model.Supplier;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    List<Supplier> findByName(String name);
    List<Supplier> findByIdSupplierIn(List<Long> supplierIdList);
}
