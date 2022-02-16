package com.bbx.shop.assigment.model;

import com.bbx.shop.assigment.model.enums.ItemStateEnum;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq" ,sequenceName ="item_id_seq", allocationSize = 1)
    @Column(name = "iditem")
    private Long idItem;

    @Column(name="itemcode", unique = true, nullable = false)
    private String itemCode;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price")
    private Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private ItemStateEnum state;

    @Column(name = "creationDate")
    private LocalDateTime creationDate;
//
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "creator_id", referencedColumnName = "idUser")
    private User creator;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "item_supplier",
            joinColumns =  @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id")
    )
    private List<Supplier> supplierList;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name="pricereduction_id")
    private List<PriceReduction> priceReductionList;

    protected Item() {
    }

    public Item(String itemCode, String description, Double price, ItemStateEnum state, LocalDateTime creationDate
            , List<Supplier> supplierList) {
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.creationDate = creationDate;
        this.supplierList = supplierList;
        this.priceReductionList = new ArrayList<>();
    }

    public Item(String itemCode, String description, Double price, ItemStateEnum state, LocalDateTime creationDate) {
        this.itemCode = itemCode;
        this.description = description;
        this.price = price;
        this.state = state;
        this.creationDate = creationDate;
        this.supplierList = new ArrayList<>();
        this.priceReductionList = new ArrayList<>();
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


    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Supplier> getSupplierList() {
        return supplierList;
    }

    public void setSupplierList(List<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addSupplier(Supplier supplier){
        if(supplier != null && !supplierList.contains(supplier))
            supplierList.add(supplier);
    }

    public List<PriceReduction> getPriceReductionList() {
        return priceReductionList;
    }

    public void setPriceReductionList(List<PriceReduction> priceReductionList) {
        this.priceReductionList = priceReductionList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("idItem=").append(idItem);
        sb.append(", itemCode='").append(itemCode).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", price=").append(price);
        sb.append(", state=").append(state);
        sb.append(", creationDate=").append(creationDate);
        sb.append(", supplierList=").append(supplierList);
        sb.append(", priceReductionList=").append(priceReductionList);
        sb.append('}');
        return sb.toString();
    }
}
