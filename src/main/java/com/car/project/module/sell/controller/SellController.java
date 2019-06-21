package com.car.project.module.sell.controller;

import com.car.common.annotation.Log;
import com.car.common.core.controller.BaseController;
import com.car.common.core.domain.AjaxResult;
import com.car.common.core.page.TableDataInfo;
import com.car.common.enums.BusinessType;
import com.car.common.utils.poi.ExcelUtil;
import com.car.project.module.sell.domain.Sell;
import com.car.project.module.sell.service.ISellService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户卖车 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Controller
@RequestMapping("/module/sell")
public class SellController extends BaseController
{
    private String prefix = "module/sell";
	
	@Autowired
	private ISellService sellService;
	
	@RequiresPermissions("module:sell:view")
	@GetMapping()
	public String sell()
	{
	    return prefix + "/sell";
	}
	
	/**
	 * 查询用户卖车列表
	 */
	@RequiresPermissions("module:sell:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Sell sell)
	{
		startPage();
        List<Sell> list = sellService.selectSellList(sell);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户卖车列表
	 */
	@RequiresPermissions("module:sell:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Sell sell)
    {
    	List<Sell> list = sellService.selectSellList(sell);
        ExcelUtil<Sell> util = new ExcelUtil<Sell>(Sell.class);
        return util.exportExcel(list, "sell");
    }
	
	/**
	 * 新增用户卖车
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户卖车
	 */
	@RequiresPermissions("module:sell:add")
	@Log(title = "用户卖车", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Sell sell)
	{		
		return toAjax(sellService.insertSell(sell));
	}

	/**
	 * 修改用户卖车
	 */
	@GetMapping("/edit/{sellId}")
	public String edit(@PathVariable("sellId") Long sellId, ModelMap mmap)
	{
		Sell sell = sellService.selectSellById(sellId);
		mmap.put("sell", sell);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户卖车
	 */
	@RequiresPermissions("module:sell:edit")
	@Log(title = "用户卖车", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Sell sell)
	{		
		return toAjax(sellService.updateSell(sell));
	}
	
	/**
	 * 删除用户卖车
	 */
	@RequiresPermissions("module:sell:remove")
	@Log(title = "用户卖车", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(sellService.deleteSellByIds(ids));
	}
	
}
