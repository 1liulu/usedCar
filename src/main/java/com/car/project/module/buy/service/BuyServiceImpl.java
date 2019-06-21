package com.car.project.module.buy.service;

import com.car.common.core.text.Convert;
import com.car.project.module.buy.domain.Buy;
import com.car.project.module.buy.mapper.BuyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户求购 服务层实现
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Service
public class BuyServiceImpl implements IBuyService 
{
	@Autowired
	private BuyMapper buyMapper;

	/**
     * 查询用户求购信息
     * 
     * @param buyId 用户求购ID
     * @return 用户求购信息
     */
    @Override
	public Buy selectBuyById(Long buyId)
	{
	    return buyMapper.selectBuyById(buyId);
	}
	
	/**
     * 查询用户求购列表
     * 
     * @param buy 用户求购信息
     * @return 用户求购集合
     */
	@Override
	public List<Buy> selectBuyList(Buy buy)
	{
	    return buyMapper.selectBuyList(buy);
	}
	
    /**
     * 新增用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	@Override
	public int insertBuy(Buy buy)
	{
	    return buyMapper.insertBuy(buy);
	}
	
	/**
     * 修改用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	@Override
	public int updateBuy(Buy buy)
	{
	    return buyMapper.updateBuy(buy);
	}

	/**
     * 删除用户求购对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBuyByIds(String ids)
	{
		return buyMapper.deleteBuyByIds(Convert.toStrArray(ids));
	}
	
}
