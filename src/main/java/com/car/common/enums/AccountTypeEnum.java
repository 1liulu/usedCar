package com.car.common.enums;

public enum AccountTypeEnum {
    PHONE(1),
    WECHAT(2),
    QQ(3),
    WEIBO(4),
    ALIPAY(5);

    private final int code;

    AccountTypeEnum(int code){
        this.code = code;
    }

    public int getValue(){
        return this.code;
    }
}
