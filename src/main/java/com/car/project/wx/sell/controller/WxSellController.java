package com.car.project.wx.sell.controller;

import com.car.common.core.controller.BaseController;
import com.car.common.entity.BaseResponse;
import com.car.common.enums.StatusCodeEnum;
import com.car.common.utils.StringUtils;
import com.car.project.wx.sell.domain.WxSellRequest;
import com.car.project.wx.sell.service.WxSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户卖车 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Controller
@RequestMapping("/wx/sell")
public class WxSellController extends BaseController
{
	@Autowired
	private WxSellService sellService;
	

	
	/**
	 * 查询用户卖车列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public BaseResponse searchSell(WxSellRequest sell)
	{
//		sell.setPageNum((sell.getPageTotal()-1)*sell.getPageSize());
//		startPage();
		if (sell.getPage()==null){
			return BaseResponse.error("页数信息不能为空");
		}
		Integer page = sell.getPage();
		Integer pageSize = sell.getPageSize();
		Integer pageNum = (page - 1) * pageSize;
		return BaseResponse.of(StatusCodeEnum.SUCCESS,"查询成功",sellService.searchSell(sell.getAddressId(),sell.getKeywords(),sell.getTypeId(),sell.getBrandId(),sell.getStartPrice(),sell.getEndPrice(),sell.getPId(),pageNum,pageSize));
	}
	
	/**
	 * 新增保存用户卖车
	 */
	@PostMapping("/add")
	@ResponseBody
	public BaseResponse addSave(WxSellRequest sell)
	{
		if (StringUtils.isEmpty(sell.getUserName())){
			return BaseResponse.error("联系人姓名不能为空");
		}
		if (StringUtils.isEmpty(sell.getUserPhone())){
			return BaseResponse.error("联系人电话不能为空");
		}
		if (sell.getAddressId()==null){
			return BaseResponse.error("交易地址不能为空");
		}

		if (StringUtils.isEmpty(sell.getDetailedAddress())){
			return BaseResponse.error("交易详细地址不能为空");
		}
		if (sell.getTypeId()==null){
			return BaseResponse.error("车型不能为空");
		}
		if (sell.getBrandId()==null){
			return BaseResponse.error("品牌不能为空");
		}
		if (sell.getPrice()==null){
			return BaseResponse.error("价格不能为空");
		}
		if (sell.getEngineId()==null){
			return BaseResponse.error("发动机不能为空");
		}
		if (sell.getUserId()==null){
			return BaseResponse.error("用户id不能为空");
		}
		if (StringUtils.isEmpty(sell.getHorsepower())){
			return BaseResponse.error("马力匹数不能为空");
		}

		if (StringUtils.isEmpty(sell.getCarPic())){
			return BaseResponse.error("车辆照片不能为空");
		}

		return BaseResponse.ok(sellService.insertSell(sell));
	}

	/**
	 * 修改保存用户卖车
	 */
	@PostMapping("/edit")
	@ResponseBody
	public BaseResponse editSave(WxSellRequest sell)
	{
		if (sell.getSellId()==null){
			return BaseResponse.error("卖车id不能为空");
		}
		if (StringUtils.isEmpty(sell.getSellCode())){
			return BaseResponse.error("卖车code不能为空");
		}
		if (StringUtils.isEmpty(sell.getUserName())){
			return BaseResponse.error("联系人姓名不能为空");
		}
		if (StringUtils.isEmpty(sell.getUserPhone())){
			return BaseResponse.error("联系人电话不能为空");
		}
		if (sell.getAddressId()==null){
			return BaseResponse.error("交易地址不能为空");
		}

		if (StringUtils.isEmpty(sell.getDetailedAddress())){
			return BaseResponse.error("交易详细地址不能为空");
		}
		if (sell.getTypeId()==null){
			return BaseResponse.error("车型不能为空");
		}
		if (sell.getBrandId()==null){
			return BaseResponse.error("品牌不能为空");
		}
		if (sell.getEngineId()==null){
			return BaseResponse.error("发动机不能为空");
		}
		if (StringUtils.isEmpty(sell.getHorsepower())){
			return BaseResponse.error("马力匹数不能为空");
		}
		if (StringUtils.isEmpty(sell.getCarPic())){
			return BaseResponse.error("车辆照片不能为空");
		}
		return BaseResponse.ok(sellService.updateSell(sell));
	}
	
	/**
	 * 删除用户卖车
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public BaseResponse remove(String ids)
	{		
		return BaseResponse.ok(sellService.deleteSellByIds(ids));
	}

	/**
	 * 用户卖车
	 */
	@PostMapping( "/detail")
	@ResponseBody
	public BaseResponse detail(Long sellId)
	{
		if (sellId==null){
			return BaseResponse.error("卖车id不能为空");
		}
		return BaseResponse.of(sellService.detail(sellId));
	}

	@PostMapping( "/myBySellList")
	@ResponseBody
	public BaseResponse myByBuyList(WxSellRequest sell)
	{

		if (sell.getPage()==null){
			return BaseResponse.error("页数信息不能为空");
		}
		if (sell.getUserId()==null){
			return BaseResponse.error("用户id不能为空");
		}
		Integer page = sell.getPage();
		Integer pageSize = sell.getPageSize();
		Integer pageNum = (page - 1) * pageSize;
		return BaseResponse.of(sellService.myByBuyList(sell.getAddressId(),sell.getKeywords(),sell.getTypeId(),sell.getBrandId(),sell.getStartPrice(),sell.getEndPrice(),sell.getUserId(),sell.getPId(),pageNum,pageSize));
	}
	
}
