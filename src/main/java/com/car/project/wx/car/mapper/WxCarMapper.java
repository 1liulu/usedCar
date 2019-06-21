package com.car.project.wx.car.mapper;

import com.car.project.wx.car.domain.WxArea;
import com.car.project.wx.car.domain.WxBrand;
import com.car.project.wx.car.domain.WxType;
import com.car.project.wx.car.domain.WxTypeBrand;

import java.util.List;

/**
 * 车辆品牌 数据层
 * 
 * @author wangben
 * @date 2019-05-25
 */
public interface WxCarMapper
{

    /***
     * 获取汽车品牌
     * @param brand
     * @return
     */
    List<WxBrand> getCarBrand(WxBrand brand);

    /***
     * 获取汽车类型
     * @param type
     * @return
     */
    List<WxType> getCarType(WxType type);

    List<WxTypeBrand> getCarTypeBrand(WxTypeBrand typeBrand);

    List<WxArea> getAreaInfo(WxArea area);
}