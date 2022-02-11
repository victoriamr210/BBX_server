package com.bbx.shop.assigment.service.impl;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.dto.PriceReductionDTO;
import com.bbx.shop.assigment.dto.SupplierDTO;
import com.bbx.shop.assigment.mapper.ItemMapper;
import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.model.PriceReduction;
import com.bbx.shop.assigment.model.Supplier;
import com.bbx.shop.assigment.repository.ItemRepository;
import com.bbx.shop.assigment.repository.PriceReductionRepository;
import com.bbx.shop.assigment.repository.SupplierRepository;
import com.bbx.shop.assigment.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final SupplierRepository supplierRepository;
    private final PriceReductionRepository priceReductionRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository, SupplierRepository supplierRepository, PriceReductionRepository priceReductionRepository) {
        this.itemRepository = itemRepository;
        this.supplierRepository = supplierRepository;
        this.priceReductionRepository = priceReductionRepository;
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) throws Exception {
        if(itemDTO == null){
            throw new Exception("The ItemDTO cannot be null");
        }
        Item item = new Item(itemDTO.getItemCode(), itemDTO.getDescription(), itemDTO.getPrice(), itemDTO.getState(),
                LocalDateTime.now());
        List<Supplier> supplierList = getSupplierList(itemDTO.getSupplierDTOList());
        item.setSupplierList(supplierList);
        List<PriceReduction> priceReductions = getPriceReductions(itemDTO.getPriceReductionDTOS());
        item.setPriceReductionList(priceReductions);
        itemRepository.save(item);
        return ItemMapper.pojo2Dto(item);
    }

    @Override
    public ItemDTO updateItem(ItemDTO itemDTO) throws Exception {
        if(itemDTO == null){
            throw new Exception("The ItemDTO cannot be null");
        }

        Optional<Item> itemOptional = itemRepository.findById(itemDTO.getIdItem());
        if(!itemOptional.isPresent()){
            throw new Exception("The Item with ID: " + itemDTO.getIdItem() + " does not exist");
        }

        Item item = itemOptional.get();
        item.setDescription(itemDTO.getDescription());
        item.setPrice(itemDTO.getPrice());
        item.setState(itemDTO.getState());
        item.setSupplierList(getSupplierList(itemDTO.getSupplierDTOList()));
        item.setPriceReductionList(getPriceReductions(itemDTO.getPriceReductionDTOS()));
        itemRepository.save(item);
        return ItemMapper.pojo2Dto(item);
    }

    @Override
    public void deteleItem(Long idItem) throws Exception {
        if(idItem == null){
            throw new Exception("The Item ID cannot be null");
        }

        Optional<Item> itemOptional = itemRepository.findById(idItem);
        if(!itemOptional.isPresent()){
            throw new Exception("The Item with ID: " +idItem + " does not exist");
        }
        itemRepository.delete(itemOptional.get());
    }

    @Override
    public List<ItemDTO> findAll() {
        return ItemMapper.pojo2Dto((List<Item>) itemRepository.findAll());
    }

    @Override
    public ItemDTO getItem(Long idItem) throws Exception {
        if(idItem == null){
            throw new Exception("The Item ID cannot be null");
        }
        Optional<Item> itemOptional = itemRepository.findById(idItem);
        if(!itemOptional.isPresent()){
            throw new Exception("The Item with ID: " +idItem + " does not exist");
        }
        return ItemMapper.pojo2Dto((itemOptional.get()));
    }

    private List<Supplier> getSupplierList(List<SupplierDTO> supplierDTOList){
        List<Long> supplierIdList = supplierDTOList.stream().map(supplierDTO -> supplierDTO.getIdSupplier()).collect(Collectors.toList());
        return (List<Supplier>) supplierRepository.findAllById(supplierIdList);
    }


    private List<PriceReduction> getPriceReductions(List<PriceReductionDTO> priceReductionDTOS){
        List<Long> priceReductionIdList = priceReductionDTOS.stream().map(priceReductionDTO -> priceReductionDTO.getIdPriceReduction()).collect(Collectors.toList());
        return (List<PriceReduction>) priceReductionRepository.findAllById(priceReductionIdList);
    }
}
