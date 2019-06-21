package com.car.project.wx.car.service;

import com.car.project.wx.car.domain.WxArea;
import com.car.project.wx.car.domain.WxBrand;
import com.car.project.wx.car.domain.WxType;
import com.car.project.wx.car.domain.WxTypeBrand;
import com.car.project.wx.car.mapper.WxCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxCarServiceImpl implements WxCarService {
    @Autowired
    private WxCarMapper wxCarMapper;


    /***
     * 获取车辆品牌
     * @param brand
     * @return
     */
    @Override
    public List<WxBrand> getCarBrand(WxBrand brand) {
        List<WxBrand> wxBrandList=wxCarMapper.getCarBrand(brand);
        return wxBrandList;
    }

    /***
     * 获取车辆类型
     * @param type
     * @return
     */
    @Override
    public List<WxType> getCarType(WxType type) {
        return wxCarMapper.getCarType(type);
    }
    /***
     * 获取车辆类型
     * @param type
     * @return
     */
    @Override
    public List<WxTypeBrand> getCarTypeBrand(WxTypeBrand typeBrand) {
        return wxCarMapper.getCarTypeBrand(typeBrand);
    }

    @Override
    public List<WxArea> getAreaInfo(WxArea area) {
        return wxCarMapper.getAreaInfo(area);
    }
}
