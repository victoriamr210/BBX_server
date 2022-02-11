package com.bbx.shop.assigment.dto;

import com.bbx.shop.assigment.model.enums.ItemStateEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ItemDTO implements Serializable {
    private static final Long serialVersionID = 1L;

    private Long idItem;
    private String itemCode;
    private String description;
    private Double price;
    private ItemStateEnum state;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;
    private List<SupplierDTO> supplierDTOList;
    private List<PriceReductionDTO> priceReductionDTOS;
    private UserDTO creator;

    public ItemDTO() {
    }

    public ItemDTO(Long idItem, String itemCode, String description, Double price, ItemStateEnum state,
                   LocalDateTime creationDate, List<SupplierDTO> supplierDTOList, List<PriceReductionDTO> priceReductionDTOS) {
        this.idItem = idItem;
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.creationDate = creationDate;
        this.supplierDTOList = supplierDTOList;
        this.priceReductionDTOS = priceReductionDTOS;
    }

    public ItemDTO(String itemCode, String description, Double price, ItemStateEnum state, LocalDateTime creationDate,
                   List<SupplierDTO> supplierDTOList, List<PriceReductionDTO> priceReductionDTOList) {
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.creationDate = creationDate;
        this.supplierDTOList = supplierDTOList;
        this.priceReductionDTOS = priceReductionDTOList;
    }

    public static Long getSerialVersionID() {
        return serialVersionID;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ItemStateEnum getState() {
        return state;
    }

    public void setState(ItemStateEnum state) {
        this.state = state;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<SupplierDTO> getSupplierDTOList() {
        return supplierDTOList;
    }

    public void setSupplierDTOList(List<SupplierDTO> supplierDTOList) {
        this.supplierDTOList = supplierDTOList;
    }

    public List<PriceReductionDTO> getPriceReductionDTOS() {
        return priceReductionDTOS;
    }

    public void setPriceReductionDTOS(List<PriceReductionDTO> priceReductionDTOS) {
        this.priceReductionDTOS = priceReductionDTOS;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ItemDTO{");
        sb.append("idItem=").append(idItem);
        sb.append(", itemCode='").append(itemCode).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", state=").append(state);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", supplierDTOList=").append(supplierDTOList);
        sb.append(", priceReductionDTOS=").append(priceReductionDTOS);
        sb.append('}');
        return sb.toString();
    }
}
