package com.car.project.wx.sell.service;


import com.car.project.wx.sell.domain.WxSellRequest;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface WxSellService {

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
    public List<WxSellRequest> searchSell(WxSellRequest sell);

    /**
     * 新增用户卖车
     *
     * @param sell 用户卖车信息
     * @return 结果
     */
    public String insertSell(WxSellRequest sell);

    /**
     * 修改用户卖车
     *
     * @param sell 用户卖车信息
     * @return 结果
     */
    public String updateSell(WxSellRequest sell);

    /**
     * 删除用户卖车信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public String deleteSellByIds(String ids);

    public WxSellRequest detail(Long sellId);

    List<WxSellRequest> myByBuyList(WxSellRequest sell);

    PageInfo searchSell(Long addressId, String keywords, Long typeId, Long brandId, Double startPrice, Double endPrice, Long pId, Integer pageNum, Integer pageSize);

    PageInfo myByBuyList(Long addressId, String keywords, Long typeId, Long brandId, Double startPrice, Double endPrice, Long userId, Long pId, Integer pageNum, Integer pageSize);
}
