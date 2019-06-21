package com.car.project.wx.car.controller;

import com.car.common.entity.BaseResponse;
import com.car.project.wx.car.domain.WxArea;
import com.car.project.wx.car.domain.WxBrand;
import com.car.project.wx.car.domain.WxType;
import com.car.project.wx.car.domain.WxTypeBrand;
import com.car.project.wx.car.service.WxCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/car")
public class WxCarController{

    @Autowired
    private WxCarService wxCarService;

    /***
     * 获取汽车品牌
     */
    @RequestMapping("/getCarBrand")
//    @PostMapping("/getCarBrand")
    @ResponseBody
    public BaseResponse getCarBrand(WxBrand brand){
        return BaseResponse.of(wxCarService.getCarBrand(brand));
    }

    /***
     *获取汽车类型
     * @param type
     * @return
     */
    @RequestMapping("/getCarType")
    @ResponseBody
    public BaseResponse getCarType(WxType type){
        return BaseResponse.of(wxCarService.getCarType(type));
    }

    /***
     *获取汽车类型和品牌关联
     * @param typeBrand
     * @return
     */
    @RequestMapping("/getCarTypeBrand")
    @ResponseBody
    public BaseResponse getCarTypeBrand(WxTypeBrand typeBrand){
        return BaseResponse.of(wxCarService.getCarTypeBrand(typeBrand));
    }

    /***
     *获取行政区域
     * @param area
     * @return
     */
    @RequestMapping("/getAreaInfo")
    @ResponseBody
    public BaseResponse getAreaInfo(WxArea area){
        return BaseResponse.of(wxCarService.getAreaInfo(area));
    }

}
