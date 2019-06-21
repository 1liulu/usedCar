package com.car.project.module.buy.controller;

import com.car.common.annotation.Log;
import com.car.common.core.controller.BaseController;
import com.car.common.core.domain.AjaxResult;
import com.car.common.core.page.TableDataInfo;
import com.car.common.enums.BusinessType;
import com.car.common.utils.poi.ExcelUtil;
import com.car.project.module.buy.domain.Buy;
import com.car.project.module.buy.service.IBuyService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户求购 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Controller
@RequestMapping("/module/buy")
public class BuyController extends BaseController
{
    private String prefix = "module/buy";
	
	@Autowired
	private IBuyService buyService;
	
	@RequiresPermissions("module:buy:view")
	@GetMapping()
	public String buy()
	{
	    return prefix + "/buy";
	}
	
	/**
	 * 查询用户求购列表
	 */
	@RequiresPermissions("module:buy:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Buy buy)
	{
		startPage();
        List<Buy> list = buyService.selectBuyList(buy);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出用户求购列表
	 */
	@RequiresPermissions("module:buy:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Buy buy)
    {
    	List<Buy> list = buyService.selectBuyList(buy);
        ExcelUtil<Buy> util = new ExcelUtil<Buy>(Buy.class);
        return util.exportExcel(list, "buy");
    }
	
	/**
	 * 新增用户求购
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存用户求购
	 */
	@RequiresPermissions("module:buy:add")
	@Log(title = "用户求购", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Buy buy)
	{		
		return toAjax(buyService.insertBuy(buy));
	}

	/**
	 * 修改用户求购
	 */
	@GetMapping("/edit/{buyId}")
	public String edit(@PathVariable("buyId") Long buyId, ModelMap mmap)
	{
		Buy buy = buyService.selectBuyById(buyId);
		mmap.put("buy", buy);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存用户求购
	 */
	@RequiresPermissions("module:buy:edit")
	@Log(title = "用户求购", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Buy buy)
	{		
		return toAjax(buyService.updateBuy(buy));
	}
	
	/**
	 * 删除用户求购
	 */
	@RequiresPermissions("module:buy:remove")
	@Log(title = "用户求购", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(buyService.deleteBuyByIds(ids));
	}
	
}
