package com.car.project.wx.recruit.mapper;

import com.car.project.wx.recruit.domain.Recruit;

import java.util.List;

/**
 * 招聘 数据层
 * 
 * @author wangben
 * @date 2019-06-28
 */
public interface RecruitMapper 
{
	/**
     * 查询招聘信息
     * 
     * @param recruitId 招聘ID
     * @return 招聘信息
     */
	public Recruit selectRecruitById(Long recruitId);
	
	/**
     * 查询招聘列表
     * 
     * @param recruit 招聘信息
     * @return 招聘集合
     */
	public List<Recruit> selectRecruitList(Recruit recruit);
	
	/**
     * 新增招聘
     * 
     * @param recruit 招聘信息
     * @return 结果
     */
	public int insertRecruit(Recruit recruit);
	
	/**
     * 修改招聘
     * 
     * @param recruit 招聘信息
     * @return 结果
     */
	public int updateRecruit(Recruit recruit);
	
	/**
     * 删除招聘
     * 
     * @param recruitId 招聘ID
     * @return 结果
     */
	public int deleteRecruitById(Long recruitId);
	
	/**
     * 批量删除招聘
     * 
     * @param recruitIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteRecruitByIds(String[] recruitIds);
	
}