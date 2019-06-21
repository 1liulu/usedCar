package com.car.project.module.sell.service;

import com.car.common.core.text.Convert;
import com.car.project.module.sell.domain.Sell;
import com.car.project.module.sell.mapper.SellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户卖车 服务层实现
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Service
public class SellServiceImpl implements ISellService
{
	@Autowired
	private SellMapper sellMapper;

	/**
     * 查询用户卖车信息
     * 
     * @param sellId 用户卖车ID
     * @return 用户卖车信息
     */
    @Override
	public Sell selectSellById(Long sellId)
	{
	    return sellMapper.selectSellById(sellId);
	}
	
	/**
     * 查询用户卖车列表
     * 
     * @param sell 用户卖车信息
     * @return 用户卖车集合
     */
	@Override
	public List<Sell> selectSellList(Sell sell)
	{
	    return sellMapper.selectSellList(sell);
	}
	
    /**
     * 新增用户卖车
     * 
     * @param sell 用户卖车信息
     * @return 结果
     */
	@Override
	public int insertSell(Sell sell)
	{
	    return sellMapper.insertSell(sell);
	}
	
	/**
     * 修改用户卖车
     * 
     * @param sell 用户卖车信息
     * @return 结果
     */
	@Override
	public int updateSell(Sell sell)
	{
	    return sellMapper.updateSell(sell);
	}

	/**
     * 删除用户卖车对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteSellByIds(String ids)
	{
		return sellMapper.deleteSellByIds(Convert.toStrArray(ids));
	}
	
}
