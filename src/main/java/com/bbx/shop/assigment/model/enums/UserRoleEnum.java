package com.bbx.shop.assigment.model.enums;

public enum UserRoleEnum {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");

    private Integer code;
    private String value;

    UserRoleEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UserRoleEnum getByValue(String value){
        for(UserRoleEnum userRoleEnum : values()){
            if(userRoleEnum.getValue().equals(value)){
                return userRoleEnum;
            }
        }
        return null;
    }
}
