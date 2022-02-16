package com.bbx.shop.assigment.dto;

import java.io.Serializable;

public class SupplierDTO implements Serializable {

    private final static Long serialVersionID = 1L;

    private Long idSupplier;
    private String name;
    private String country;

    public SupplierDTO() {
    }

    public SupplierDTO(Long idSupplier, String name, String country) {
        this.idSupplier = idSupplier;
        this.name = name;
        this.country = country;
    }

    public SupplierDTO(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Long getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Long idSupplier) {
        this.idSupplier = idSupplier;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SupplierDTO{");
        sb.append("idSupplier=").append(idSupplier);
        sb.append(", name='").append(name).append('\'');
        sb.append(", country='").append(country).append('\'');

        return sb.toString();
    }
}
