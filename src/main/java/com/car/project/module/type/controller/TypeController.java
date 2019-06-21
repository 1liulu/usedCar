package com.car.project.module.type.controller;

import com.car.common.annotation.Log;
import com.car.common.core.controller.BaseController;
import com.car.common.core.domain.AjaxResult;
import com.car.common.core.page.TableDataInfo;
import com.car.common.enums.BusinessType;
import com.car.common.utils.poi.ExcelUtil;
import com.car.project.module.type.domain.Type;
import com.car.project.module.type.service.ITypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 车辆类型 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Controller
@RequestMapping("/module/type")
public class TypeController extends BaseController
{
    private String prefix = "module/type";
	
	@Autowired
	private ITypeService typeService;
	
	@RequiresPermissions("module:type:view")
	@GetMapping()
	public String type()
	{
	    return prefix + "/type";
	}
	
	/**
	 * 查询车辆类型列表
	 */
	@RequiresPermissions("module:type:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Type type)
	{
		startPage();
        List<Type> list = typeService.selectTypeList(type);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出车辆类型列表
	 */
	@RequiresPermissions("module:type:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Type type)
    {
    	List<Type> list = typeService.selectTypeList(type);
        ExcelUtil<Type> util = new ExcelUtil<Type>(Type.class);
        return util.exportExcel(list, "type");
    }
	
	/**
	 * 新增车辆类型
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存车辆类型
	 */
	@RequiresPermissions("module:type:add")
	@Log(title = "车辆类型", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Type type)
	{		
		return toAjax(typeService.insertType(type));
	}

	/**
	 * 修改车辆类型
	 */
	@GetMapping("/edit/{typeId}")
	public String edit(@PathVariable("typeId") Long typeId, ModelMap mmap)
	{
		Type type = typeService.selectTypeById(typeId);
		mmap.put("type", type);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存车辆类型
	 */
	@RequiresPermissions("module:type:edit")
	@Log(title = "车辆类型", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Type type)
	{		
		return toAjax(typeService.updateType(type));
	}
	
	/**
	 * 删除车辆类型
	 */
	@RequiresPermissions("module:type:remove")
	@Log(title = "车辆类型", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(typeService.deleteTypeByIds(ids));
	}

	/**
	 * 停用车辆类型
	 */
	@RequiresPermissions("module:type:disable")
	@Log(title = "车辆类型", businessType = BusinessType.DISABLE)
	@PostMapping( "/disable")
	@ResponseBody
	public AjaxResult disable(String ids)
	{
		return toAjax(typeService.disableTypeByIds(ids));
	}
	/**
	 * 启用车辆类型
	 */
	@RequiresPermissions("module:type:enable")
	@Log(title = "车辆类型", businessType = BusinessType.ENABLE)
	@PostMapping( "/enable")
	@ResponseBody
	public AjaxResult enable(String ids)
	{
		return toAjax(typeService.enableTypeByIds(ids));
	}

}
