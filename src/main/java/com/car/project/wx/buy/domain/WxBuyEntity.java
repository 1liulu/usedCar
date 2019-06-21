package com.car.project.wx.buy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 用户求购表 c_buy
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Getter
@Setter
public class WxBuyEntity
{
	/** id */
	@JsonProperty("buyId")
	private Long buyId;
	/** 发布用户id */
	@JsonProperty("userId")
	private Long userId;
	/** 意向品牌id */
	@JsonProperty("brandId")
	private Long brandId;
	/** 意向品牌 */
	@JsonProperty("brandName")
	private String brandName;
	/** 意向车型id */
	@JsonProperty("typeId")
	private Long typeId;
	/** 意向车型 */
	@JsonProperty("typeName")
	private String typeName;
	/** 意向开始时间 */
	@JsonProperty("startTime")
	private Date startTime;
	/** 意向结束时间 */
	@JsonProperty("endTime")
	private Date endTime;
	/** 马力匹数   */
	@JsonProperty("horsepower")
	private String horsepower;
	/** 求购数量 */
	@JsonProperty("amount")
	private Integer amount;
	/** 联系人姓名 */
	@JsonProperty("userName")
	private String userName;
	/** 联系人手机号 */
	@JsonProperty("userPhone")
	private String userPhone;
	/** 交易地址id */
	@JsonProperty("addressId")
	private Long addressId;
	/** 交易地址 */
	@JsonProperty("address")
	private String address;
	/** 交易详细地址 */
	@JsonProperty("detailedAddress")
	private String detailedAddress;
	/** 帐号状态（0正常 1停用） */
	@JsonProperty("status")
	private Integer status;

	/** 备注 */
	@JsonProperty("remark")
	private String remark;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("createTime")
	private Date createTime;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("updateTime")
	private Date updateTime;

}
