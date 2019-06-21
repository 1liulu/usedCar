package com.car.project.module.sell.domain;

import com.car.common.core.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 用户卖车表 c_sell
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Getter
@Setter
public class Sell extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Long sellId;
	/** code */
	private String sellCode;
	/** 发布用户id */
	private Long userId;
	/** 联系人姓名 */
	private String userName;
	/** 联系人手机号 */
	private String userPhone;
	/** 交易地址id */
	private Long addressId;
	/** 交易地址 */
	private String address;
	/** 交易详细地址 */
	private String detailedAddress;
	/** 车型id */
	private Long typeId;
	/** 车型 */
	private String typeName;
	/** 车辆品牌id */
	private Long brandId;
	/** 车辆品牌 */
	private String brandName;
	/** 车辆价格 */
	private Double price;
	/** 车辆年份 */
	private Date carTime;
	/** 排放标准 */
	private String emissionStandard;
	/** 驱动形式 */
	private String drive;
	/** 发动机id */
	private Long engineId;
	/** 发动机品牌 */
	private String engineName;
	/** 燃料类型 */
	private String fuelType;
	/** 马力匹数   */
	private String horsepower;
	/** 是否可过户   1是2否 */
	private Integer transferOwnership;
	/** 是否可提档  1是2否 */
	private Integer toFile;
	/** 显示里程数 */
	private Long mileage;
	/** 车辆颜色 */
	private String colour;
	/** 车辆特色 */
	private String feature;
	/** 帐号状态（0正常 1停用） */
	private Integer status;

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sellId", getSellId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("addressId", getAddressId())
            .append("address", getAddress())
            .append("detailedAddress", getDetailedAddress())
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .append("brandId", getBrandId())
            .append("brandName", getBrandName())
            .append("price", getPrice())
            .append("carTime", getCarTime())
            .append("emissionStandard", getEmissionStandard())
            .append("drive", getDrive())
            .append("engineId", getEngineId())
            .append("engineName", getEngineName())
            .append("fuelType", getFuelType())
            .append("horsepower", getHorsepower())
            .append("transferOwnership", getTransferOwnership())
            .append("toFile", getToFile())
            .append("mileage", getMileage())
            .append("colour", getColour())
            .append("feature", getFeature())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
