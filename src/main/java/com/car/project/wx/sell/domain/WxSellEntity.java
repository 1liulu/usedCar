package com.car.project.wx.sell.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 用户卖车表 c_sell
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Getter
@Setter
public class WxSellEntity
{
	private static final long serialVersionUID = 1L;


	/** id */
	@JsonProperty("sellId")
	private Long sellId;

	/** code */
	@JsonProperty("sellCode")
	private String sellCode;

	/** 发布用户id */
	@JsonProperty("userId")
	private Long userId;

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

	/** 车型id */
	@JsonProperty("typeId")
	private Long typeId;

	/** 车型 */
	@JsonProperty("typeName")
	private String typeName;
	/** 车辆品牌id */
	@JsonProperty("brandId")
	private Long brandId;
	/** 车辆品牌 */
	@JsonProperty("brandName")
	private String brandName;
	/** 车辆价格 */
	@JsonProperty("price")
	private Double price;
	/** 车辆年份 */
	@JsonProperty("carTime")
	private Date carTime;
	/** 排放标准 */
	@JsonProperty("emissionStandard")
	private String emissionStandard;
	/** 驱动形式 */
	@JsonProperty("drive")
	private String drive;


	/** 发动机id */
	@JsonProperty("engineId")
	private Long engineId;
	/** 发动机品牌 */
	@JsonProperty("engineName")
	private String engineName;
	/** 燃料类型 */
	@JsonProperty("fuelType")
	private String fuelType;
	/** 马力匹数   */
	@JsonProperty("horsepower")
	private String horsepower;
	/** 是否可过户   1是2否 */
	@JsonProperty("transferOwnership")
	private Integer transferOwnership;
	/** 是否可提档  1是2否 */
	@JsonProperty("toFile")
	private Integer toFile;
	/** 显示里程数 */
	@JsonProperty("mileage")
	private Long mileage;
	/** 车辆颜色 */
	@JsonProperty("colour")
	private String colour;
	/** 车辆特色 */
	@JsonProperty("feature")
	private String feature;
	/** 帐号状态（0正常 1停用） */
	@JsonProperty("status")
	private Integer status;

	/** 车辆起始价格 */
	@JsonProperty("startPrice")
	private Double startPrice;

	/** 车辆结束价格 */
	@JsonProperty("endPrice")
	private Double endPrice;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("createTime")
	private Date createTime;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonProperty("updateTime")
	private Date updateTime;

	/** 车辆图片 */
	private String carPic;

	/** 备注 */
	@JsonProperty("remark")
	private String remark;

	/** 图片列表 */
	@JsonProperty("uploads")
	private List<WxSellUpload> uploads;

	/** 上级品牌id */
	@JsonProperty("pId")
	private Long pId;

	/** 上级品牌名称 */
	@JsonProperty("pName")
	private String pName;

	/** 图片路径 */
	@JsonProperty("uploadPath")
	private String uploadPath;


}
