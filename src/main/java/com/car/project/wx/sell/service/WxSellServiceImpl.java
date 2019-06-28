package com.car.project.wx.sell.service;

import com.car.common.core.text.Convert;
import com.car.common.utils.ToolsUtils;
import com.car.framework.util.ShiroUtils;
import com.car.project.wx.sell.domain.WxSellRequest;
import com.car.project.wx.sell.mapper.WxSellMapper;
import com.car.project.wx.sell.mapper.WxSellUploadMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class WxSellServiceImpl implements WxSellService {
    @Autowired
    private WxSellMapper sellMapper;

    @Autowired
    private WxSellUploadMapper sellUploadMapper;

    /**
     * 查询用户卖车信息
     *
     * @param sellId 用户卖车ID
     * @return 用户卖车信息
     */
    @Override
    public WxSellRequest selectSellById(Long sellId)
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
    public List<WxSellRequest> searchSell(WxSellRequest sell)
    {

        return sellMapper.searchSell(sell);
    }

    /**
     * 新增用户卖车
     *
     * @param sell 用户卖车信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String insertSell(WxSellRequest sell)
    {
        if (sell.getUserId()==null){
            sell.setUserId(ShiroUtils.getUserId());
        }
        String sellCode= ToolsUtils.getOrdersId("SELL");
        sell.setSellCode(sellCode);
        sell.setCreateTime(new Date());
        if (sellMapper.insertSell(sell)>0){
            if (sellUploadMapper.insertBySellUploads(sellCode,Convert.toStrArray(sell.getCarPic()))>0){
                return "添加成功";
            }
            return "添加图片失败";
        }
        return "添加失败";
    }

    /**
     * 修改用户卖车
     *
     * @param sell 用户卖车信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String updateSell(WxSellRequest sell)
    {
        sell.setUpdateTime(new Date());
        if (sellMapper.updateSell(sell)>0){
            sellUploadMapper.deleteSellUploadBySellCode(sell.getSellCode());
            if (sellUploadMapper.insertBySellUploads(sell.getSellCode(),Convert.toStrArray(sell.getCarPic()))>0){
                return "修改成功";
            }
            return "修改失败";
        }
        return "修改失败";
    }

    /**
     * 删除用户卖车对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public String deleteSellByIds(String ids)
    {

        if (sellMapper.deleteSellByIds(Convert.toStrArray(ids))>0){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public WxSellRequest detail(Long sellId)
    {
        WxSellRequest wxSell=sellMapper.selectSellById(sellId);
        wxSell.setUploads(sellUploadMapper.selectSellUploadByCode(wxSell.getSellCode()));
        return wxSell;
    }

    @Override
    public List<WxSellRequest> myByBuyList(WxSellRequest sell) {
        return sellMapper.searchSell(sell);
    }

    @Override
    public PageInfo searchSell(Long addressId, String keywords, Long typeId, Long brandId, Double startPrice, Double endPrice, Long pId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<WxSellRequest> list=sellMapper.selectBySellWxList( addressId,  keywords,  typeId,  brandId, startPrice, endPrice,null,pId);
        return new PageInfo(list);
    }

    @Override
    public PageInfo myByBuyList(Long addressId, String keywords, Long typeId, Long brandId, Double startPrice, Double endPrice, Long userId, Long pId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<WxSellRequest> list=sellMapper.selectBySellWxList( addressId,  keywords,  typeId,  brandId, startPrice, endPrice,userId,pId);
        return new PageInfo(list);
    }


}
