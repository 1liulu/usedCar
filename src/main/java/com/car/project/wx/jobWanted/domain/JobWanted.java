package com.car.project.wx.jobWanted.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.car.common.core.domain.BaseEntity;

/**
 * 求职表 c_job_wanted
 * 
 * @author wangben
 * @date 2019-06-28
 */
public class JobWanted extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 求职id */
	private Long jobWantedId;
	/** 籍贯 */
	private String nativePlace;
	/** 工作地点id */
	private Long cityId;
	/** 工作城市 */
	private String cityName;
	/** 驾照等级 */
	private String grade;
	/** 驾龄 */
	private String record;
	/** 车辆类型 */
	private Long carTypeId;
	/** 车辆类型名称 */
	private String carTypeName;
	/** 发布用户id */
	private Long userId;
	/** 联系人姓名 */
	private String userName;
	/** 联系人手机号 */
	private String userPhone;
	/** 帐号状态（0正常 1停用） */
	private Integer status;

	public void setJobWantedId(Long jobWantedId) 
	{
		this.jobWantedId = jobWantedId;
	}

	public Long getJobWantedId() 
	{
		return jobWantedId;
	}
	public void setNativePlace(String nativePlace) 
	{
		this.nativePlace = nativePlace;
	}

	public String getNativePlace() 
	{
		return nativePlace;
	}
	public void setCityId(Long cityId) 
	{
		this.cityId = cityId;
	}

	public Long getCityId() 
	{
		return cityId;
	}
	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}

	public String getCityName() 
	{
		return cityName;
	}
	public void setGrade(String grade) 
	{
		this.grade = grade;
	}

	public String getGrade() 
	{
		return grade;
	}
	public void setRecord(String record) 
	{
		this.record = record;
	}

	public String getRecord() 
	{
		return record;
	}
	public void setCarTypeId(Long carTypeId) 
	{
		this.carTypeId = carTypeId;
	}

	public Long getCarTypeId() 
	{
		return carTypeId;
	}
	public void setCarTypeName(String carTypeName) 
	{
		this.carTypeName = carTypeName;
	}

	public String getCarTypeName() 
	{
		return carTypeName;
	}
	public void setUserId(Long userId) 
	{
		this.userId = userId;
	}

	public Long getUserId() 
	{
		return userId;
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
            .append("jobWantedId", getJobWantedId())
            .append("nativePlace", getNativePlace())
            .append("cityId", getCityId())
            .append("cityName", getCityName())
            .append("grade", getGrade())
            .append("record", getRecord())
            .append("carTypeId", getCarTypeId())
            .append("carTypeName", getCarTypeName())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
