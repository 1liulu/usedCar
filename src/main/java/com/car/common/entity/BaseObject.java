package com.car.common.entity;

import com.car.common.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class BaseObject implements Serializable {


    private static final long uid = 1234567876543456765L;

    public static final BaseObject DUMMY = new BaseObject();


    @Override
    public String toString(){
        try{
            return JsonUtils.toJson(this);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }


}
