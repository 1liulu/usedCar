package com.car.project.wx.buy.service;

import com.car.common.core.text.Convert;
import com.car.project.wx.buy.domain.WxBuyEntity;
import com.car.project.wx.buy.domain.WxBuyRequest;
import com.car.project.wx.buy.mapper.WxBuyMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户求购 服务层实现
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Service
public class WxBuyServiceImpl implements WxBuyService
{
	@Autowired
	private WxBuyMapper buyMapper;

	/**
     * 查询用户求购信息
     * 
     * @param buyId 用户求购ID
     * @return 用户求购信息
     */
    @Override
	public WxBuyEntity selectBuyById(Long buyId)
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
	public PageInfo selectBuyList(Long addressId, Integer pageNum, Integer pageSize)
	{
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo(buyMapper.selectBuyWxList(addressId));
	}
	
    /**
     * 新增用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	@Override
	public int insertBuy(WxBuyRequest buy)
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
	public int updateBuy(WxBuyRequest buy)
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

	@Override
	public WxBuyEntity detail(Long buyId) {
		return buyMapper.selectBuyById(buyId);
	}

	@Override
	public PageInfo myByBuyList(Long userId, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum,pageSize);
		return new PageInfo(buyMapper.myByBuyList(userId));
	}


}
