package com.car.project.wx.car.service;


import com.car.project.wx.car.domain.WxArea;
import com.car.project.wx.car.domain.WxBrand;
import com.car.project.wx.car.domain.WxType;
import com.car.project.wx.car.domain.WxTypeBrand;

import java.util.List;

public interface WxCarService {

    /***
     * 获取车辆品牌
     * @param brand
     * @return
     */
    public List<WxBrand> getCarBrand(WxBrand brand);

    /***
     * 获取车辆类型
     * @param type
     * @return
     */
    List<WxType> getCarType(WxType type);

    /***
     *获取汽车类型和品牌关联
     * @param typeBrand
     * @return
     */
    List<WxTypeBrand> getCarTypeBrand(WxTypeBrand typeBrand);

    List<WxArea> getAreaInfo(WxArea area);
}
