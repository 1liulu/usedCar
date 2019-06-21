package com.car.project.module.sell.mapper;

import com.car.project.module.sell.domain.Sell;

import java.util.List;

/**
 * 用户卖车 数据层
 * 
 * @author wangben
 * @date 2019-05-26
 */
public interface SellMapper 
{
	/**
     * 查询用户卖车信息
     * 
     * @param sellId 用户卖车ID
     * @return 用户卖车信息
     */
	public Sell selectSellById(Long sellId);
	
	/**
     * 查询用户卖车列表
     * 
     * @param sell 用户卖车信息
     * @return 用户卖车集合
     */
	public List<Sell> selectSellList(Sell sell);
	
	/**
     * 新增用户卖车
     * 
     * @param sell 用户卖车信息
     * @return 结果
     */
	public int insertSell(Sell sell);
	
	/**
     * 修改用户卖车
     * 
     * @param sell 用户卖车信息
     * @return 结果
     */
	public int updateSell(Sell sell);
	
	/**
     * 删除用户卖车
     * 
     * @param sellId 用户卖车ID
     * @return 结果
     */
	public int deleteSellById(Long sellId);
	
	/**
     * 批量删除用户卖车
     * 
     * @param sellIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteSellByIds(String[] sellIds);
	
}