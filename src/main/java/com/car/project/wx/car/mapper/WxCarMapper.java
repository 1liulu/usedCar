package com.car.project.wx.car.mapper;

import com.car.project.module.brand.domain.Brand;
import com.car.project.wx.car.domain.*;

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

    List<WxEngine> getCarEngine(WxEngine engine);

    List<WxArea> getAreaInfoDetail(WxArea area);

    WxArea getAreaInfoByCode(WxArea area);

    String getDictByString(String key);

//    List<WxBrand> getCarBrandByTypeId(WxBrand brand);
}