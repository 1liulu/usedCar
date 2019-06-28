package com.car.project.wx.car.service;


import com.car.project.module.brand.domain.Brand;
import com.car.project.wx.car.domain.*;

import java.util.List;
import java.util.Map;

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

    List<WxEngine> getCarEngine(WxEngine engine);

    List<WxArea> getAreaInfoDetail(WxArea area);

    WxArea getAreaInfoByCode(WxArea area);

    Map getDict(String type);
}
