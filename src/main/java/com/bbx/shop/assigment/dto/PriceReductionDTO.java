package com.bbx.shop.assigment.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PriceReductionDTO implements Serializable {
    private final static Long serialVersionID = 1L;

    private Long idPriceReduction;
    private Double reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public PriceReductionDTO() {
    }

    public PriceReductionDTO(Long idPriceReduction, Double reducedPrice, LocalDate startDate, LocalDate endDate) {
        this.idPriceReduction = idPriceReduction;
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public PriceReductionDTO(Double reducedPrice, LocalDate startDate, LocalDate endDate, ItemDTO itemDTO) {
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdPriceReduction() {
        return idPriceReduction;
    }

    public void setIdPriceReduction(Long idPriceReduction) {
        this.idPriceReduction = idPriceReduction;
    }

    public Double getReducedPrice() {
        return reducedPrice;
    }

    public void setReducedPrice(Double reducedPrice) {
        this.reducedPrice = reducedPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PriceReductionDTO{");
        sb.append("idPriceReduction=").append(idPriceReduction);
        sb.append(", reducedPrice=").append(reducedPrice);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
}
