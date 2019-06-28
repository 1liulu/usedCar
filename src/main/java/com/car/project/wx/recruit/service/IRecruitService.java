package com.car.project.wx.recruit.service;

import com.car.project.wx.recruit.domain.Recruit;

import java.util.List;

/**
 * 招聘 服务层
 * 
 * @author wangben
 * @date 2019-06-28
 */
public interface IRecruitService 
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
     * 删除招聘信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteRecruitByIds(String ids);
	
}
