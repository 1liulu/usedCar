package com.car.project.wx.jobWanted.service;

import com.car.project.wx.jobWanted.domain.JobWanted;

import java.util.List;

/**
 * 求职 服务层
 * 
 * @author wangben
 * @date 2019-06-28
 */
public interface IJobWantedService 
{
	/**
     * 查询求职信息
     * 
     * @param jobWantedId 求职ID
     * @return 求职信息
     */
	public JobWanted selectJobWantedById(Long jobWantedId);
	
	/**
     * 查询求职列表
     * 
     * @param jobWanted 求职信息
     * @return 求职集合
     */
	public List<JobWanted> selectJobWantedList(JobWanted jobWanted);
	
	/**
     * 新增求职
     * 
     * @param jobWanted 求职信息
     * @return 结果
     */
	public int insertJobWanted(JobWanted jobWanted);
	
	/**
     * 修改求职
     * 
     * @param jobWanted 求职信息
     * @return 结果
     */
	public int updateJobWanted(JobWanted jobWanted);
		
	/**
     * 删除求职信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteJobWantedByIds(String ids);
	
}
