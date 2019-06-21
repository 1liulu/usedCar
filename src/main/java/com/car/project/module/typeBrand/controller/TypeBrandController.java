package com.car.project.module.typeBrand.controller;

import com.car.common.annotation.Log;
import com.car.common.core.controller.BaseController;
import com.car.common.core.domain.AjaxResult;
import com.car.common.core.page.TableDataInfo;
import com.car.common.enums.BusinessType;
import com.car.common.utils.poi.ExcelUtil;
import com.car.project.module.typeBrand.domain.TypeBrand;
import com.car.project.module.typeBrand.service.ITypeBrandService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 车辆类型和车辆品牌关联 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Controller
@RequestMapping("/module/typeBrand")
public class TypeBrandController extends BaseController
{
    private String prefix = "module/typeBrand";
	
	@Autowired
	private ITypeBrandService typeBrandService;
	
	@RequiresPermissions("module:typeBrand:view")
	@GetMapping()
	public String typeBrand()
	{
	    return prefix + "/typeBrand";
	}
	
	/**
	 * 查询车辆类型和车辆品牌关联列表
	 */
	@RequiresPermissions("module:typeBrand:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(TypeBrand typeBrand)
	{
		startPage();
        List<TypeBrand> list = typeBrandService.selectTypeBrandList(typeBrand);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出车辆类型和车辆品牌关联列表
	 */
	@RequiresPermissions("module:typeBrand:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TypeBrand typeBrand)
    {
    	List<TypeBrand> list = typeBrandService.selectTypeBrandList(typeBrand);
        ExcelUtil<TypeBrand> util = new ExcelUtil<TypeBrand>(TypeBrand.class);
        return util.exportExcel(list, "typeBrand");
    }
	
	/**
	 * 新增车辆类型和车辆品牌关联
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆类型和车辆品牌关联
	 */
	@RequiresPermissions("module:typeBrand:add")
	@Log(title = "车辆类型和车辆品牌关联", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(TypeBrand typeBrand)
	{		
		return toAjax(typeBrandService.insertTypeBrand(typeBrand));
	}

	/**
	 * 修改车辆类型和车辆品牌关联
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap)
	{
		TypeBrand typeBrand = typeBrandService.selectTypeBrandById(id);
		mmap.put("typeBrand", typeBrand);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆类型和车辆品牌关联
	 */
	@RequiresPermissions("module:typeBrand:edit")
	@Log(title = "车辆类型和车辆品牌关联", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(TypeBrand typeBrand)
	{		
		return toAjax(typeBrandService.updateTypeBrand(typeBrand));
	}
	
	/**
	 * 删除车辆类型和车辆品牌关联
	 */
	@RequiresPermissions("module:typeBrand:remove")
	@Log(title = "车辆类型和车辆品牌关联", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(typeBrandService.deleteTypeBrandByIds(ids));
	}

	/**
	 * 停用车辆类型和车辆品牌关联
	 */
	@RequiresPermissions("module:typeBrand:disable")
	@Log(title = "车辆类型和车辆品牌关联", businessType = BusinessType.DISABLE)
	@PostMapping( "/disable")
	@ResponseBody
	public AjaxResult disable(String ids)
	{
		return toAjax(typeBrandService.disableTypeBrandByIds(ids));
	}
	/**
	 * 启用车辆类型和车辆品牌关联
	 */
	@RequiresPermissions("module:typeBrand:enable")
	@Log(title = "车辆类型和车辆品牌关联", businessType = BusinessType.ENABLE)
	@PostMapping( "/enable")
	@ResponseBody
	public AjaxResult enable(String ids)
	{
		return toAjax(typeBrandService.enableTypeBrandByIds(ids));
	}
}
