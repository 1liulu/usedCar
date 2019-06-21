package com.car.common.enums;

public enum OrderStatusEnum {

    UNPAIED(0),
    PAIED(1);

    private final int code;

    OrderStatusEnum(int code){
        this.code = code;
    }

    public int getValue(){
        return this.code;
    }
}
