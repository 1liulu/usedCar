package com.car.project.wx.recruit.service;

import java.util.List;

import com.car.project.wx.recruit.domain.Recruit;
import com.car.project.wx.recruit.mapper.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.car.common.core.text.Convert;

/**
 * 招聘 服务层实现
 * 
 * @author wangben
 * @date 2019-06-28
 */
@Service
public class RecruitServiceImpl implements IRecruitService 
{
	@Autowired
	private RecruitMapper recruitMapper;

	/**
     * 查询招聘信息
     * 
     * @param recruitId 招聘ID
     * @return 招聘信息
     */
    @Override
	public Recruit selectRecruitById(Long recruitId)
	{
	    return recruitMapper.selectRecruitById(recruitId);
	}
	
	/**
     * 查询招聘列表
     * 
     * @param recruit 招聘信息
     * @return 招聘集合
     */
	@Override
	public List<Recruit> selectRecruitList(Recruit recruit)
	{
	    return recruitMapper.selectRecruitList(recruit);
	}
	
    /**
     * 新增招聘
     * 
     * @param recruit 招聘信息
     * @return 结果
     */
	@Override
	public int insertRecruit(Recruit recruit)
	{
	    return recruitMapper.insertRecruit(recruit);
	}
	
	/**
     * 修改招聘
     * 
     * @param recruit 招聘信息
     * @return 结果
     */
	@Override
	public int updateRecruit(Recruit recruit)
	{
	    return recruitMapper.updateRecruit(recruit);
	}

	/**
     * 删除招聘对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteRecruitByIds(String ids)
	{
		return recruitMapper.deleteRecruitByIds(Convert.toStrArray(ids));
	}
	
}
