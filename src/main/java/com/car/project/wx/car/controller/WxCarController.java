package com.car.project.wx.car.controller;

import com.car.common.entity.BaseResponse;
import com.car.common.utils.StringUtils;
import com.car.framework.web.service.DictService;
import com.car.project.module.brand.domain.Brand;
import com.car.project.wx.car.domain.*;
import com.car.project.wx.car.service.WxCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/wx/car")
public class WxCarController{

    @Autowired
    private WxCarService wxCarService;

    @Autowired
    private DictService dictService;

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
     *获取发动机品牌
     * @param engine
     * @return
     */
    @RequestMapping("/getCarEngine")
    @ResponseBody
    public BaseResponse getCarEngine(WxEngine engine){
        return BaseResponse.of(wxCarService.getCarEngine(engine));
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

    /***
     *查询下一级行政区域
     * @param area
     * @return
     */
    @RequestMapping("/getAreaInfoDetail")
    @ResponseBody
    public BaseResponse getAreaInfoDetail(WxArea area){
        if (area.getPcode()==null){
            return BaseResponse.error("上级区域code不能为空");
        }
        return BaseResponse.of(wxCarService.getAreaInfoDetail(area));
    }

    /***
     *根据code查询区域名称
     * @param area
     * @return
     */
    @RequestMapping("/getAreaInfoByCode")
    @ResponseBody
    public BaseResponse getAreaInfoByCode(WxArea area){
        if (StringUtils.isEmpty(area.getName())){
            return BaseResponse.error("名称不能为空");
        }
        return BaseResponse.of(wxCarService.getAreaInfoByCode(area));
    }

    /***
     *字典接口
     * @param type
     * @return
     */
    @RequestMapping("/getDict")
    @ResponseBody
    public BaseResponse getDict(String type){
        if (StringUtils.isEmpty(type)){
            return BaseResponse.error("名称不能为空");
        }
        return BaseResponse.of(wxCarService.getDict(type));
    }

}
