package com.car.project.module.brand.controller;

import com.car.common.annotation.Log;
import com.car.common.core.controller.BaseController;
import com.car.common.core.domain.AjaxResult;
import com.car.common.core.page.TableDataInfo;
import com.car.common.enums.BusinessType;
import com.car.common.utils.poi.ExcelUtil;
import com.car.project.module.brand.domain.Brand;
import com.car.project.module.brand.service.IBrandService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 车辆品牌 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Controller
@RequestMapping("/module/brand")
public class BrandController extends BaseController
{
    private String prefix = "module/brand";
	
	@Autowired
	private IBrandService brandService;
	
	@RequiresPermissions("module:brand:view")
	@GetMapping()
	public String brand()
	{
	    return prefix + "/brand";
	}
	
	/**
	 * 查询车辆品牌列表
	 */
	@RequiresPermissions("module:brand:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Brand brand)
	{
		startPage();
        List<Brand> list = brandService.selectBrandList(brand);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出车辆品牌列表
	 */
	@RequiresPermissions("module:brand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Brand brand)
    {
    	List<Brand> list = brandService.selectBrandList(brand);
        ExcelUtil<Brand> util = new ExcelUtil<Brand>(Brand.class);
        return util.exportExcel(list, "brand");
    }
	
	/**
	 * 新增车辆品牌
	 */
	@GetMapping("/add")
	public String add(ModelMap modelMap)
	{
	    modelMap.put("brandList",brandService.selectByBrandPId());
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆品牌
	 */
	@RequiresPermissions("module:brand:add")
	@Log(title = "车辆品牌", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Brand brand)
	{		
		return toAjax(brandService.insertBrand(brand));
	}

	/**
	 * 修改车辆品牌
	 */
	@GetMapping("/edit/{brandId}")
	public String edit(@PathVariable("brandId") Long brandId, ModelMap mmap)
	{
		Brand brand = brandService.selectBrandById(brandId);
		mmap.put("brand", brand);
		mmap.put("brandList",brandService.selectByBrandPId());
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆品牌
	 */
	@RequiresPermissions("module:brand:edit")
	@Log(title = "车辆品牌", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Brand brand)
	{		
		return toAjax(brandService.updateBrand(brand));
	}
	
	/**
	 * 删除车辆品牌
	 */
	@RequiresPermissions("module:brand:remove")
	@Log(title = "车辆品牌", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(brandService.deleteBrandByIds(ids));
	}

	/**
	 * 停用车辆品牌
	 */
	@RequiresPermissions("module:brand:disable")
	@Log(title = "车辆品牌", businessType = BusinessType.DISABLE)
	@PostMapping( "/disable")
	@ResponseBody
	public AjaxResult disable(String ids)
	{
		return toAjax(brandService.disableBrandByIds(ids));
	}
	/**
	 * 启用车辆品牌
	 */
	@RequiresPermissions("module:brand:enable")
	@Log(title = "车辆品牌", businessType = BusinessType.ENABLE)
	@PostMapping( "/enable")
	@ResponseBody
	public AjaxResult enable(String ids)
	{
		return toAjax(brandService.enableBrandByIds(ids));
	}
	
}
