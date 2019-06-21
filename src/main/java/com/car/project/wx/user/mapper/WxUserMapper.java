package com.car.project.wx.user.mapper;

import com.car.project.wx.user.domain.WxUserRequest;

/**
 * 用户表 数据层
 * 
 * @author ruoyi
 */
public interface WxUserMapper
{

    /***
     * 根据openid查询是否存在该用户
     * @param openid
     * @return
     */
    WxUserRequest getByOpenid(String openid);

    WxUserRequest selectByOpenid(String openid);

    int insertByOpneid(String openid);

    int updateByUser(WxUserRequest request);

    WxUserRequest selectByUserId(String userId);
}
