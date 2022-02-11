package com.bbx.shop.assigment.model.enums;

public enum ItemStateEnum {
    ACTIVE(1, "ACTIVE"),
    DISCONTINUED(0, "DISCONTINUED");

    private Integer code;
    private String value;

    ItemStateEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static ItemStateEnum getFromValue(String value){
        for(ItemStateEnum itemStateEnum : values()){
            if(itemStateEnum.getValue().equals(value)){
                return itemStateEnum;
            }
        }
        return null;
    }
}
