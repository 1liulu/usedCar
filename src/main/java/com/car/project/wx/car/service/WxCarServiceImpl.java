package com.car.project.wx.car.service;

import com.car.project.module.brand.domain.Brand;
import com.car.project.module.brand.mapper.BrandMapper;
import com.car.project.wx.car.domain.*;
import com.car.project.wx.car.mapper.WxCarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<WxBrand> wxBrandList=new ArrayList<>();
        if (brand.getTypeId()!=null){
            wxBrandList=wxCarMapper.getCarBrand(brand);
        }else{
            wxBrandList=wxCarMapper.getCarBrand(brand);
        }

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

    @Override
    public List<WxEngine> getCarEngine(WxEngine engine) {
        return wxCarMapper.getCarEngine(engine);
    }

    @Override
    public List<WxArea> getAreaInfoDetail(WxArea area) {
        return wxCarMapper.getAreaInfoDetail(area);
    }

    @Override
    public WxArea getAreaInfoByCode(WxArea area) {
        return wxCarMapper.getAreaInfoByCode(area);
    }

    @Override
    public Map getDict(String type) {
        String[] array=type.split(",");
        Map<String,Object> map=new HashMap<>();
        for (String key:array){
            map.put(key,wxCarMapper.getDictByString(key).split(","));
        }
        return map;
    }
}
