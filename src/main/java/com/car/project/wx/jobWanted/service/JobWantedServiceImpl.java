package com.car.project.wx.jobWanted.service;

import java.util.List;

import com.car.project.wx.jobWanted.domain.JobWanted;
import com.car.project.wx.jobWanted.mapper.JobWantedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.common.core.text.Convert;

/**
 * 求职 服务层实现
 * 
 * @author wangben
 * @date 2019-06-28
 */
@Service
public class JobWantedServiceImpl implements IJobWantedService 
{
	@Autowired
	private JobWantedMapper jobWantedMapper;

	/**
     * 查询求职信息
     * 
     * @param jobWantedId 求职ID
     * @return 求职信息
     */
    @Override
	public JobWanted selectJobWantedById(Long jobWantedId)
	{
	    return jobWantedMapper.selectJobWantedById(jobWantedId);
	}
	
	/**
     * 查询求职列表
     * 
     * @param jobWanted 求职信息
     * @return 求职集合
     */
	@Override
	public List<JobWanted> selectJobWantedList(JobWanted jobWanted)
	{
	    return jobWantedMapper.selectJobWantedList(jobWanted);
	}
	
    /**
     * 新增求职
     * 
     * @param jobWanted 求职信息
     * @return 结果
     */
	@Override
	public int insertJobWanted(JobWanted jobWanted)
	{
	    return jobWantedMapper.insertJobWanted(jobWanted);
	}
	
	/**
     * 修改求职
     * 
     * @param jobWanted 求职信息
     * @return 结果
     */
	@Override
	public int updateJobWanted(JobWanted jobWanted)
	{
	    return jobWantedMapper.updateJobWanted(jobWanted);
	}

	/**
     * 删除求职对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteJobWantedByIds(String ids)
	{
		return jobWantedMapper.deleteJobWantedByIds(Convert.toStrArray(ids));
	}
	
}
