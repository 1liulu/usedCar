package com.car.project.wx.jobWanted.controller;

import java.util.Date;
import java.util.List;

import com.car.common.entity.BaseResponse;
import com.car.common.enums.StatusCodeEnum;
import com.car.project.wx.jobWanted.domain.JobWanted;
import com.car.project.wx.jobWanted.service.IJobWantedService;
import com.car.project.wx.recruit.domain.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.common.annotation.Log;
import com.car.common.enums.BusinessType;
import com.car.common.core.controller.BaseController;
import com.car.common.core.page.TableDataInfo;
import com.car.common.core.domain.AjaxResult;
import com.car.common.utils.poi.ExcelUtil;

/**
 * 求职 信息操作处理
 * 
 * @author wangben
 * @date 2019-06-28
 */
@Controller
@RequestMapping("/wx/jobWanted")
public class JobWantedController extends BaseController
{
	
	@Autowired
	private IJobWantedService jobWantedService;

	/**
	 * 查询列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public BaseResponse searJobWanted(JobWanted jobWanted, Page page)
	{
		if (page.getPage()==null){
			return BaseResponse.error("页数信息不能为空");
		}
		jobWanted.setStatus(0);
		PageHelper.startPage(page.getPage(),page.getPageSize());
		return BaseResponse.of(StatusCodeEnum.SUCCESS,"查询成功",new PageInfo(jobWantedService.selectJobWantedList(jobWanted)));
	}

	/**
	 * 添加
	 */
	@PostMapping("/addJobWanted")
	@ResponseBody
	public BaseResponse addJobWanted(JobWanted jobWanted)
	{
		jobWanted.setStatus(0);
		jobWanted.setCreateTime(new Date());
		jobWanted.setUpdateTime(new Date());
		int i=jobWantedService.insertJobWanted(jobWanted);
		if(i>0){
			return BaseResponse.of(StatusCodeEnum.SUCCESS,"添加成功");
		}
		return BaseResponse.of(StatusCodeEnum.ERROR,"添加失败");
	}

	/**
	 * 修改
	 */
	@PostMapping("/editJobWanted")
	@ResponseBody
	public BaseResponse editJobWanted(JobWanted jobWanted)
	{
		jobWanted.setUpdateTime(new Date());
		int i=jobWantedService.updateJobWanted(jobWanted);
		if(i>0){
			return BaseResponse.of(StatusCodeEnum.SUCCESS,"修改成功");
		}
		return BaseResponse.of(StatusCodeEnum.ERROR,"修改失败");
	}

	/**
	 * 删除
	 */
	@PostMapping("/delJobWanted")
	@ResponseBody
	public BaseResponse delJobWanted(Long id)
	{

		JobWanted jobWanted=new JobWanted();
		jobWanted.setJobWantedId(id);
		jobWanted.setStatus(1);
		int i=jobWantedService.updateJobWanted(jobWanted);
		if(i>0){
			return BaseResponse.of(StatusCodeEnum.SUCCESS,"删除成功");
		}
		return BaseResponse.of(StatusCodeEnum.ERROR,"删除失败");
	}
}
