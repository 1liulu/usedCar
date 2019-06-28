package com.car.project.wx.buy.controller;

import com.car.common.core.controller.BaseController;
import com.car.common.entity.BaseResponse;
import com.car.common.utils.StringUtils;
import com.car.project.wx.buy.domain.WxBuyRequest;
import com.car.project.wx.buy.service.WxBuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/wx/buy")
public class WxBuyController extends BaseController {

    @Autowired
    private WxBuyService buyService;

    /**
     * 查询用户求购列表
     */
    @PostMapping("/list")
    @ResponseBody
    public BaseResponse list(WxBuyRequest buy)
    {
//        startPage();
        if (buy.getPage()==null){
            return BaseResponse.error("页数信息不能为空");
        }
        Integer page = buy.getPage();
        Integer pageSize = buy.getPageSize();
        Integer pageNum = (page - 1) * pageSize;
//        List<WxBuyRequest> list = buyService.selectBuyList(buy.getAddressId(),pageNum,pageSize);
        return BaseResponse.of(buyService.selectBuyList(buy.getAddressId(),buy.getKeywords(),page,pageSize));
    }

    /**
     * 新增保存用户求购
     */
    @PostMapping("/add")
    @ResponseBody
    public BaseResponse addSave(WxBuyRequest buy)
    {
        if (buy.getBrandId()==null){
            return BaseResponse.error("品牌不能为空");
        }
        if (buy.getTypeId()==null){
            return BaseResponse.error("类型不能为空");
        }
        if (buy.getAddressId()==null){
            return BaseResponse.error("地址不能为空");
        }
        if (buy.getAmount()==null){
            return BaseResponse.error("求购数量不能为空");
        }
        if (StringUtils.isEmpty(buy.getDetailedAddress())){
            return BaseResponse.error("详细地址不能为空");
        }
        if (StringUtils.isEmpty(buy.getUserName())){
            return BaseResponse.error("联系人姓名不能为空");
        }
        if (StringUtils.isEmpty(buy.getUserPhone())){
            return BaseResponse.error("联系人电话不能为空");
        }
        buy.setCreateTime(new Date());

        if (buyService.insertBuy(buy)>0){
            return BaseResponse.ok("添加成功");
        }
        return BaseResponse.error("添加失败");
    }


    /**
     * 修改保存用户求购
     */
    @PostMapping("/edit")
    @ResponseBody
    public BaseResponse editSave(WxBuyRequest buy)
    {
        if (buy.getBuyId()==null){
            return BaseResponse.error("求购id不能为空");
        }
        if (buy.getUserId()==null){
            return BaseResponse.error("用户id不能为空");
        }
        if (buy.getBrandId()==null){
            return BaseResponse.error("品牌不能为空");
        }
        if (buy.getTypeId()==null){
            return BaseResponse.error("类型不能为空");
        }
        if (buy.getAddressId()==null){
            return BaseResponse.error("地址不能为空");
        }
        if (buy.getAmount()==null){
            return BaseResponse.error("求购数量不能为空");
        }
        if (StringUtils.isEmpty(buy.getDetailedAddress())){
            return BaseResponse.error("详细地址不能为空");
        }
        if (StringUtils.isEmpty(buy.getUserName())){
            return BaseResponse.error("联系人姓名不能为空");
        }
        if (StringUtils.isEmpty(buy.getUserPhone())){
            return BaseResponse.error("联系人电话不能为空");
        }
        buy.setUpdateTime(new Date());
        if (buyService.updateBuy(buy)>0){
            return BaseResponse.ok("修改成功");
        }

        return BaseResponse.error("修改失败");
    }

    /**
     * 删除用户求购
     */
    @PostMapping( "/remove")
    @ResponseBody
    public BaseResponse remove(String ids)
    {
        if (buyService.deleteBuyByIds(ids)>0){
            return BaseResponse.ok("删除成功");
        }
        return BaseResponse.error("删除失败");
    }

    /**
     * 用户求购详情
     */
    @PostMapping( "/detail")
    @ResponseBody
    public BaseResponse detail(Long buyId)
    {
        if (buyId==null){
            return BaseResponse.error("求购id不能为空");
        }
        return BaseResponse.of(buyService.detail(buyId));
    }


    @PostMapping( "/myByBuyList")
    @ResponseBody
    public BaseResponse myByBuyList(WxBuyRequest buy)
    {
//        startPage();
        if (buy.getPage()==null){
            return BaseResponse.error("页数信息不能为空");
        }
        if (buy.getUserId()==null){
            return BaseResponse.error("用户id不能为空");
        }
        Integer page = buy.getPage();
        Integer pageSize = buy.getPageSize();
        Integer pageNum = (page - 1) * pageSize;
//        List<WxBuyRequest> list=buyService.myByBuyList(buy.getUserId(),pageNum,pageSize);
        return BaseResponse.of(buyService.myByBuyList(buy.getUserId(),page,pageSize));
    }

}
