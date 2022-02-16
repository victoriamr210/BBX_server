package com.bbx.shop.assigment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PriceReduction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idPriceReduction;
    private Double reducedPrice;
    private LocalDate startDate;
    private LocalDate endDate;

    public PriceReduction() {
    }

    public PriceReduction(Double reducedPrice, LocalDate startDate, LocalDate endDate) {
        this.reducedPrice = reducedPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdPriceReduction() {
        return idPriceReduction;
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
        final StringBuffer sb = new StringBuffer("PriceReduction{");
        sb.append("idPriceReduction=").append(idPriceReduction);
        sb.append(", reducedPrice=").append(reducedPrice);
        sb.append(", startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append('}');
        return sb.toString();
    }
}
