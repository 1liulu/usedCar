package com.car.project.wx.sell.mapper;

import com.car.project.wx.sell.domain.WxSellEntity;
import com.car.project.wx.sell.domain.WxSellRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户卖车 数据层
 * 
 * @author wangben
 * @date 2019-05-26
 */
public interface WxSellMapper
{
	/**
     * 查询用户卖车信息
     * 
     * @param sellId 用户卖车ID
     * @return 用户卖车信息
     */
	public WxSellRequest selectSellById(Long sellId);

	/**
     * 查询用户卖车列表
     * 
     * @param sell 用户卖车信息
     * @return 用户卖车集合
     */

	List<WxSellRequest> searchSell(WxSellRequest sell);


	/**
     * 新增用户卖车
     * 
     * @param sell 用户卖车信息
     * @return 结果
     */
	public int insertSell(WxSellRequest sell);
	
	/**
     * 修改用户卖车
     * 
     * @param sell 用户卖车信息
     * @return 结果
     */
	public int updateSell(WxSellRequest sell);
	
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


    List<WxSellEntity> selectBySellWxList(@Param("addressId") Long addressId, @Param("keywords") String keywords, @Param("typeId") Long typeId, @Param("brandId") Long brandId, @Param("startPrice") Double startPrice, @Param("endPrice") Double endPrice, @Param("userId") Long userId, @Param("pId") Long pId);
}