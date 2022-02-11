package com.bbx.shop.assigment.restService;

import com.bbx.shop.assigment.dto.PriceReductionDTO;
import com.bbx.shop.assigment.service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/priceReduction")
public class PriceReductionRestController {

    private final PriceReductionService priceReductionService;

    @Autowired
    public PriceReductionRestController(PriceReductionService priceReductionService) {
        this.priceReductionService = priceReductionService;
    }

    @GetMapping("/list")
    List<PriceReductionDTO> findAll(){
        return priceReductionService.findAll();
    }
}
