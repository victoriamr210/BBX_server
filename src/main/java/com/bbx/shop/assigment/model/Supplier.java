package com.bbx.shop.assigment.model;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "supplier_id_seq")
    @SequenceGenerator(name = "supplier_id_seq" ,sequenceName ="supplier_id_seq", allocationSize = 1)
    @Column(name = "idsupplier")
    private Long idSupplier;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @ManyToMany( mappedBy = "supplierList")
    private List<Item> itemList = new ArrayList<>();

    public Supplier() {
    }

    public Supplier(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Supplier(String name, String country, List<Item> itemList) {
        this.name = name;
        this.country = country;
        this.itemList = itemList;
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Supplier{");
        sb.append("idSupplier=").append(idSupplier);
        sb.append(", name='").append(name).append('\'');
        sb.append(", country='").append(country).append('\'');
//        sb.append(", itemList=").append(itemList);
        sb.append('}');
        return sb.toString();
    }
}
