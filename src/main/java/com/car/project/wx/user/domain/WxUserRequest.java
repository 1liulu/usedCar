package com.car.project.wx.user.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WxUserRequest //extends WxTokenRequest{
    {
    //用户id
    @JsonProperty("userId")
    private String userId;

    //头像
    @JsonProperty("avatar")
    private String avatar;

    //性别
    @JsonProperty("sex")
    private Integer sex;

    //昵称
    @JsonProperty("nickName")
    private String nickName;

    //姓名
    @JsonProperty("userName")
    private String userName;

    //openid
    @JsonProperty("openid")
    private String openid;

    /** 手机号码 */
    @JsonProperty("phonenumber")
    private String phonenumber;

    /** token */
    @JsonProperty("token")
    private String token;
    /** 备注 */
    @JsonProperty("remark")
    private String remark;

}
