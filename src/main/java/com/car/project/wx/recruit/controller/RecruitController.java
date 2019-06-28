package com.car.project.wx.recruit.controller;

import java.util.Date;

import com.car.common.entity.BaseResponse;
import com.car.common.enums.StatusCodeEnum;
import com.car.project.wx.recruit.domain.Page;
import com.car.project.wx.recruit.domain.Recruit;
import com.car.project.wx.recruit.service.IRecruitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.car.common.core.controller.BaseController;

/**
 * 招聘 信息操作处理
 * 
 * @author wangben
 * @date 2019-06-28
 */
@Controller
@RequestMapping("/wx/recruit")
public class RecruitController extends BaseController
{
	
	@Autowired
	private IRecruitService recruitService;

	/**
	 * 查询列表
	 */
	@PostMapping("/list")
	@ResponseBody
	public BaseResponse searRecruit(Recruit recruit, Page page)
	{
		if (page.getPage()==null){
			return BaseResponse.error("页数信息不能为空");
		}
		recruit.setStatus(0);
		PageHelper.startPage(page.getPage(),page.getPageSize());
		return BaseResponse.of(StatusCodeEnum.SUCCESS,"查询成功",new PageInfo(recruitService.selectRecruitList(recruit)));
	}

	/**
	 * 添加
	 */
	@PostMapping("/addRecruit")
	@ResponseBody
	public BaseResponse addRecruit(Recruit recruit)
	{
		recruit.setStatus(0);
		recruit.setCreateTime(new Date());
		recruit.setUpdateTime(new Date());
		int i=recruitService.insertRecruit(recruit);
		if(i>0){
			return BaseResponse.of(StatusCodeEnum.SUCCESS,"添加成功");
		}
		return BaseResponse.of(StatusCodeEnum.ERROR,"添加失败");
	}

	/**
	 * 修改
	 */
	@PostMapping("/editRecruit")
	@ResponseBody
	public BaseResponse editRecruit(Recruit recruit)
	{
		recruit.setUpdateTime(new Date());
		int i=recruitService.updateRecruit(recruit);
		if(i>0){
			return BaseResponse.of(StatusCodeEnum.SUCCESS,"修改成功");
		}
		return BaseResponse.of(StatusCodeEnum.ERROR,"修改失败");
	}

	/**
	 * 删除
	 */
	@PostMapping("/delRecruit")
	@ResponseBody
	public BaseResponse delRecruit(Long id)
	{

		Recruit recruit=new Recruit();
		recruit.setRecruitId(id);
		recruit.setStatus(1);
		int i=recruitService.updateRecruit(recruit);
		if(i>0){
			return BaseResponse.of(StatusCodeEnum.SUCCESS,"删除成功");
		}
		return BaseResponse.of(StatusCodeEnum.ERROR,"删除失败");
	}
	
}
