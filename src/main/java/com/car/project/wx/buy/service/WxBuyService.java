package com.car.project.wx.buy.service;

import com.car.project.wx.buy.domain.WxBuyRequest;
import com.github.pagehelper.PageInfo;

/**
 * 用户求购 服务层
 * 
 * @author wangben
 * @date 2019-05-25
 */
public interface WxBuyService
{
	/**
     * 查询用户求购信息
     * 
     * @param buyId 用户求购ID
     * @return 用户求购信息
     */
	public WxBuyRequest selectBuyById(Long buyId);
	
	/**
     * 查询用户求购列表
     * 
     * @param addressId 地址
     * @param keywords
	 * @return 用户求购集合
     */
	public PageInfo selectBuyList(Long addressId, String keywords, Integer pageNum, Integer pageSize);
	
	/**
     * 新增用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	public int  insertBuy(WxBuyRequest buy);

	/**
     * 修改用户求购
     * 
     * @param buy 用户求购信息
     * @return 结果
     */
	public int updateBuy(WxBuyRequest buy);
		
	/**
     * 删除用户求购信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBuyByIds(String ids);

	WxBuyRequest detail(Long buyId);

	PageInfo myByBuyList(Long userId, Integer pageNum, Integer pageSize);
}
