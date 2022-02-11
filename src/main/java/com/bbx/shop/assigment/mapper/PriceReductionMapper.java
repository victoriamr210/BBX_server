package com.bbx.shop.assigment.mapper;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.dto.PriceReductionDTO;
import com.bbx.shop.assigment.model.PriceReduction;

import java.util.List;
import java.util.stream.Collectors;

public class PriceReductionMapper {
    public static PriceReductionDTO pojo2Dto(PriceReduction priceReduction){
        return new PriceReductionDTO(priceReduction.getIdPriceReduction(), priceReduction.getReducedPrice(),
                priceReduction.getStartDate(), priceReduction.getEndDate());
    }

    public static List<PriceReductionDTO> pojo2Dto(List<PriceReduction> priceReductionList){
        return priceReductionList.stream().map(priceReduction -> pojo2Dto(priceReduction)).collect(Collectors.toList());
    }
}
