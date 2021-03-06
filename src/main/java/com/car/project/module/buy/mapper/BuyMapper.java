package com.car.project.module.buy.mapper;

import com.car.project.module.buy.domain.Buy;

import java.util.List;

/**
 * 用户求购 数据层
 * 
 * @author wangben
 * @date 2019-05-25
 */
public interface BuyMapper 
{
	/**
     * 查询用户求购信息
     * 
     * @param buyId 用户求购ID
     * @return 用户求购信息
     */
	public Buy selectBuyById(Long buyId);
	
	/**
     * 查询用户求购列表
     * 
     * @param buy 用户求购信息
     * @return 用户求购集合
     */
	public List<Buy> selectBuyList(Buy buy);
	
	/**
     * 新增用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	public int insertBuy(Buy buy);
	
	/**
     * 修改用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	public int updateBuy(Buy buy);
	
	/**
     * 删除用户求购
     * 
     * @param buyId 用户求购ID
     * @return 结果
     */
	public int deleteBuyById(Long buyId);
	
	/**
     * 批量删除用户求购
     * 
     * @param buyIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBuyByIds(String[] buyIds);
	
}