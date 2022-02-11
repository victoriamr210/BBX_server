package com.bbx.shop.assigment.repository;

import com.bbx.shop.assigment.model.PriceReduction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PriceReductionRepository extends CrudRepository<PriceReduction, Long> {
    List<PriceReduction> findByIdPriceReductionIn(List<Long> priceReductionIdList);

}
