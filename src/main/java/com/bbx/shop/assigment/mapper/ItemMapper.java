package com.bbx.shop.assigment.mapper;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.dto.PriceReductionDTO;
import com.bbx.shop.assigment.dto.SupplierDTO;
import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.model.PriceReduction;
import com.bbx.shop.assigment.model.Supplier;

import java.util.List;
import java.util.stream.Collectors;

public class ItemMapper {
    public static ItemDTO pojo2Dto(Item item){
        List<SupplierDTO> supplierDTOList = SupplierMapper.pojo2Dto(item.getSupplierList());
        List<PriceReductionDTO> priceReductionDTOList = PriceReductionMapper.pojo2Dto(item.getPriceReductionList());
        return new ItemDTO(item.getIdItem(), item.getItemCode(), item.getDescription(), item.getPrice(), item.getState(),
                item.getCreationDate(), supplierDTOList, priceReductionDTOList);
    }

    public static List<ItemDTO> pojo2Dto(List<Item> itemList){
        return itemList.stream().map(item -> pojo2Dto(item)).collect(Collectors.toList());
    }
}
