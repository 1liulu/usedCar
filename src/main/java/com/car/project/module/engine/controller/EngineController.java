package com.car.project.module.engine.controller;

import com.car.common.annotation.Log;
import com.car.common.core.controller.BaseController;
import com.car.common.core.domain.AjaxResult;
import com.car.common.core.page.TableDataInfo;
import com.car.common.enums.BusinessType;
import com.car.common.utils.poi.ExcelUtil;
import com.car.project.module.engine.domain.Engine;
import com.car.project.module.engine.service.IEngineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 发动机品牌 信息操作处理
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Controller
@RequestMapping("/module/engine")
public class EngineController extends BaseController
{
    private String prefix = "module/engine";
	
	@Autowired
	private IEngineService engineService;
	
	@RequiresPermissions("module:engine:view")
	@GetMapping()
	public String engine()
	{
	    return prefix + "/engine";
	}
	
	/**
	 * 查询发动机品牌列表
	 */
	@RequiresPermissions("module:engine:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(Engine engine)
	{
		startPage();
        List<Engine> list = engineService.selectEngineList(engine);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出发动机品牌列表
	 */
	@RequiresPermissions("module:engine:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Engine engine)
    {
    	List<Engine> list = engineService.selectEngineList(engine);
        ExcelUtil<Engine> util = new ExcelUtil<Engine>(Engine.class);
        return util.exportExcel(list, "engine");
    }
	
	/**
	 * 新增发动机品牌
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存发动机品牌
	 */
	@RequiresPermissions("module:engine:add")
	@Log(title = "发动机品牌", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(Engine engine)
	{		
		return toAjax(engineService.insertEngine(engine));
	}

	/**
	 * 修改发动机品牌
	 */
	@GetMapping("/edit/{engineId}")
	public String edit(@PathVariable("engineId") Long engineId, ModelMap mmap)
	{
		Engine engine = engineService.selectEngineById(engineId);
		mmap.put("engine", engine);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存发动机品牌
	 */
	@RequiresPermissions("module:engine:edit")
	@Log(title = "发动机品牌", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(Engine engine)
	{		
		return toAjax(engineService.updateEngine(engine));
	}
	
	/**
	 * 删除发动机品牌
	 */
	@RequiresPermissions("module:engine:remove")
	@Log(title = "发动机品牌", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(engineService.deleteEngineByIds(ids));
	}

	/**
	 * 停用发动机品牌
	 */
	@RequiresPermissions("module:engine:disable")
	@Log(title = "发动机品牌", businessType = BusinessType.DISABLE)
	@PostMapping( "/disable")
	@ResponseBody
	public AjaxResult disable(String ids)
	{
		return toAjax(engineService.disableEngineByIds(ids));
	}
	/**
	 * 启用发动机品牌
	 */
	@RequiresPermissions("module:engine:enable")
	@Log(title = "发动机品牌", businessType = BusinessType.ENABLE)
	@PostMapping( "/enable")
	@ResponseBody
	public AjaxResult enable(String ids)
	{
		return toAjax(engineService.enableEngineByIds(ids));
	}
	
}
