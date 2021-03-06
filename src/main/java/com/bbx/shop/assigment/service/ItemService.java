package com.bbx.shop.assigment.service;

import com.bbx.shop.assigment.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO createItem(ItemDTO itemDTO) throws Exception;
    ItemDTO updateItem(ItemDTO itemDTO) throws Exception;
    void deteleItem(Long idItem) throws Exception;
    List<ItemDTO> findAll();
    ItemDTO getItem(Long idItem) throws Exception;
    ItemDTO getItemByCode(String itemCode) throws Exception;
    ItemDTO deactivateItem(Long idItem, String reasonDeactivation) throws Exception;
    Boolean isCodeAvailable(String itemCode) throws Exception;
    boolean isPricesValid(ItemDTO itemDTO) throws Exception;
}
