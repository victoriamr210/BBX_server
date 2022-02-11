package com.bbx.shop.assigment.service.impl;

import com.bbx.shop.assigment.dto.ItemDTO;
import com.bbx.shop.assigment.dto.PriceReductionDTO;
import com.bbx.shop.assigment.mapper.PriceReductionMapper;
import com.bbx.shop.assigment.model.Item;
import com.bbx.shop.assigment.model.PriceReduction;
import com.bbx.shop.assigment.repository.ItemRepository;
import com.bbx.shop.assigment.repository.PriceReductionRepository;
import com.bbx.shop.assigment.service.PriceReductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceReductionServiceImpl implements PriceReductionService {

    private final PriceReductionRepository priceReductionRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public PriceReductionServiceImpl(PriceReductionRepository priceReductionRepository, ItemRepository itemRepository) {
        this.priceReductionRepository = priceReductionRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public PriceReductionDTO createPriceReduction(PriceReductionDTO priceReductionDTO) throws Exception {
        if(priceReductionDTO == null){
            throw new Exception("The PriceReductionDTO cannot be null");
        }
        PriceReduction priceReduction = new PriceReduction(priceReductionDTO.getReducedPrice(),
                priceReductionDTO.getStartDate(), priceReductionDTO.getEndDate());
        priceReductionRepository.save(priceReduction);
        return PriceReductionMapper.pojo2Dto(priceReduction);
    }

    @Override
    public PriceReductionDTO updatePriceReduction(PriceReductionDTO priceReductionDTO) throws Exception {
        if(priceReductionDTO == null){
            throw new Exception("The PriceReductionDTO cannot be null");
        }

        Optional<PriceReduction> priceReductionOptional = priceReductionRepository.findById(priceReductionDTO.getIdPriceReduction());
        if(!priceReductionOptional.isPresent()){
            throw new Exception("The Price Reduction with ID: " + priceReductionDTO.getIdPriceReduction() + " does not exist");
        }
        PriceReduction priceReduction = priceReductionOptional.get();
        priceReduction.setReducedPrice(priceReductionDTO.getReducedPrice());
        priceReduction.setStartDate(priceReductionDTO.getStartDate());
        priceReduction.setEndDate(priceReductionDTO.getEndDate());
        priceReductionRepository.save(priceReduction);
        return PriceReductionMapper.pojo2Dto(priceReduction);
    }

    @Override
    public void deletePriceReduction(Long idPriceRedcution) throws Exception {
        Optional<PriceReduction> priceReductionOptional = priceReductionRepository.findById(idPriceRedcution);
        if(!priceReductionOptional.isPresent()){
            throw new Exception("The Price Reduction with ID: " + idPriceRedcution + " does not exist");
        }
        priceReductionRepository.delete(priceReductionOptional.get());
    }

    @Override
    public List<PriceReductionDTO> findAll() {
       return PriceReductionMapper.pojo2Dto((List<PriceReduction>) priceReductionRepository.findAll());
    }

    private Item getItem(ItemDTO itemDTO){
        return itemRepository.findById(itemDTO.getIdItem()).get();
    }
}
