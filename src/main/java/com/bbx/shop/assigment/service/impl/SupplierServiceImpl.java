package com.bbx.shop.assigment.service.impl;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.mapper.SupplierMapper;
import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.repository.ItemRepository;
import com.bbx.shop.assigment.service.SupplierService;
import com.bbx.shop.assigment.dto.SupplierDTO;
import com.bbx.shop.assigment.model.Supplier;
import com.bbx.shop.assigment.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository, ItemRepository itemRepository) {
        this.supplierRepository = supplierRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) throws Exception {
        if(supplierDTO == null){
            throw new Exception("The SupplierDTO cannot be null");
        }
        Supplier supplier = new Supplier(supplierDTO.getName(), supplierDTO.getCountry());
        supplierRepository.save(supplier);
        return SupplierMapper.pojo2Dto(supplier);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplierDTO) throws Exception {
        if(supplierDTO == null){
            throw new Exception("The SupplierDTO cannot be null");
        }

        Optional<Supplier> supplierOptional = supplierRepository.findById(supplierDTO.getIdSupplier());
        if(supplierOptional == null){
            throw new Exception("The Supplier with ID: " + supplierDTO.getIdSupplier() + "does not exist");
        }
        Supplier supplier = supplierOptional.get();
        supplier.setName(supplierDTO.getName());
        supplier.setCountry(supplierDTO.getCountry());
        supplierRepository.save(supplier);
        return SupplierMapper.pojo2Dto(supplier);
    }

    @Override
    public void deleteSupplier(Long idSupplier) throws Exception {

        Optional<Supplier> supplierOptional= supplierRepository.findById(idSupplier);
        if(!supplierOptional.isPresent()){
            throw new Exception("The Supplier with ID: " + idSupplier + "does not exist");
        }
        supplierRepository.delete(supplierOptional.get());
    }

    @Override
    public List<SupplierDTO> findByName(String name) {
        return SupplierMapper.pojo2Dto(supplierRepository.findByName(name));
    }

    @Override
    public List<SupplierDTO> findAll() {
        return SupplierMapper.pojo2Dto((List<Supplier>) supplierRepository.findAll());
    }

    private List<Item> getItemList(List<ItemDTO> itemDTOList){
        List<Long> itemIdList = itemDTOList.stream().map(item -> item.getIdItem()).collect(Collectors.toList());
        return (List<Item>) itemRepository.findAllById(itemIdList);
    }


}
