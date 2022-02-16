package com.bbx.shop.assigment.model.enums;

import com.bbx.shop.assigment.model.User;

import java.util.List;

public enum UserRoleEnum {
    ROLE_ADMIN(1, "ROLE_ADMIN"),
    ROLE_USER(2, "ROLE_USER");

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

    public static UserRoleEnum getByValue(String value){
        for(UserRoleEnum userRoleEnum : values()){
            if(userRoleEnum.getValue().equals(value)){
                return userRoleEnum;
            }
        }
        return null;
    }

    public static String getStringFromEnum(List<UserRoleEnum> userRoleEnums){
        final StringBuffer sb = new StringBuffer();
        userRoleEnums.forEach(userRoleEnum -> {
            sb.append(userRoleEnum.getValue() + ",");
        });
        return sb.toString();
    }
}
