package com.car.common.enums;

public enum SmsTypeEnum {
//（1.注册 2.绑定手机 3.修改登陆密码 4.修改支付密码 5.忘记密码）
    REGISTER(1),
    BIND_PHONE(2),
    EDIT_LOGIN_PWD(3),
    EDIT_PAY_PWD(4),
    FORGET_PWD(5);

    private final int code;

    SmsTypeEnum(int code){
        this.code = code;
    }

    public int getValue(){
        return this.code;
    }
}
