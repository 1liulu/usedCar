package com.car.common.entity;


import com.car.common.enums.StatusCodeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class BaseResponse<T> extends BaseObject {

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("result")
    private T result;


    public static <T> BaseResponse ok(String message) {
        return of(message, "");
    }

    public static <T> BaseResponse error(String message) {
        return of(StatusCodeEnum.ERROR,message, "");
    }

    public static <T> BaseResponse of(T t) {
        return of("", t);
    }

    public static <T> BaseResponse of(String message, T t) {

        return of(StatusCodeEnum.SUCCESS, message, t);
    }

    public static <T> BaseResponse<T> of(StatusCodeEnum statusCodeEnum, T result) {
        return of(statusCodeEnum, "", result);
    }

    public static <T> BaseResponse<T> of(StatusCodeEnum statusCodeEnum, String message, T result) {
        BaseResponse response = null;
        if (result == null || Objects.equals("", result)) {
//            response = new BaseResponse(statusCodeEnum.getValue(), message, BaseObject.DUMMY);
            response = new BaseResponse(statusCodeEnum.getValue(), message, result);
        } else {
            response = new BaseResponse(statusCodeEnum.getValue(), message, result);
        }
        return response;
    }
}
