package com.car.project.module.buy.domain;

import com.car.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 用户求购表 c_buy
 * 
 * @author wangben
 * @date 2019-05-25
 */
public class Buy extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Long buyId;
	/** 发布用户id */
	private Long userId;
	/** 意向品牌id */
	private Long brandId;
	/** 意向品牌 */
	private String brandName;
	/** 意向车型id */
	private Long typeId;
	/** 意向车型 */
	private String typeName;
	/** 意向开始时间 */
	private Date startTime;
	/** 意向结束时间 */
	private Date endTime;
	/** 马力匹数   */
	private String horsepower;
	/** 求购数量 */
	private Integer amount;
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
	/** 帐号状态（0正常 1停用） */
	private Integer status;

	public void setBuyId(Long buyId) 
	{
		this.buyId = buyId;
	}

	public Long getBuyId() 
	{
		return buyId;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
	}
	public void setBrandId(Long brandId) 
	{
		this.brandId = brandId;
	}

	public Long getBrandId() 
	{
		return brandId;
	}
	public void setBrandName(String brandName) 
	{
		this.brandName = brandName;
	}

	public String getBrandName() 
	{
		return brandName;
	}
	public void setTypeId(Long typeId) 
	{
		this.typeId = typeId;
	}

	public Long getTypeId() 
	{
		return typeId;
	}
	public void setTypeName(String typeName) 
	{
		this.typeName = typeName;
	}

	public String getTypeName() 
	{
		return typeName;
	}
	public void setStartTime(Date startTime) 
	{
		this.startTime = startTime;
	}

	public Date getStartTime() 
	{
		return startTime;
	}
	public void setEndTime(Date endTime) 
	{
		this.endTime = endTime;
	}

	public Date getEndTime() 
	{
		return endTime;
	}
	public void setHorsepower(String horsepower) 
	{
		this.horsepower = horsepower;
	}

	public String getHorsepower() 
	{
		return horsepower;
	}
	public void setAmount(Integer amount) 
	{
		this.amount = amount;
	}

	public Integer getAmount() 
	{
		return amount;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserPhone(String userPhone) 
	{
		this.userPhone = userPhone;
	}

	public String getUserPhone() 
	{
		return userPhone;
	}
	public void setAddressId(Long addressId) 
	{
		this.addressId = addressId;
	}

	public Long getAddressId() 
	{
		return addressId;
	}
	public void setAddress(String address) 
	{
		this.address = address;
	}

	public String getAddress() 
	{
		return address;
	}
	public void setDetailedAddress(String detailedAddress) 
	{
		this.detailedAddress = detailedAddress;
	}

	public String getDetailedAddress() 
	{
		return detailedAddress;
	}
	public void setStatus(Integer status) 
	{
		this.status = status;
	}

	public Integer getStatus() 
	{
		return status;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("buyId", getBuyId())
            .append("userId", getUserId())
            .append("brandId", getBrandId())
            .append("brandName", getBrandName())
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("horsepower", getHorsepower())
            .append("amount", getAmount())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("addressId", getAddressId())
            .append("address", getAddress())
            .append("detailedAddress", getDetailedAddress())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
