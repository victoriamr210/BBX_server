package com.bbx.shop.assigment.service;

import com.bbx.shop.assigment.dto.PriceReductionDTO;
import com.bbx.shop.assigment.model.PriceReduction;

import java.util.List;

public interface PriceReductionService {
    PriceReductionDTO createPriceReduction(PriceReductionDTO priceReductionDTO) throws Exception;
    PriceReductionDTO updatePriceReduction(PriceReductionDTO priceReductionDTO) throws Exception;
    void deletePriceReduction(Long idPriceRedcution) throws Exception;
    List<PriceReductionDTO> findAll();
}
