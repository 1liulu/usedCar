package com.car.project.wx.recruit.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.car.common.core.domain.BaseEntity;

/**
 * 招聘表 c_recruit
 * 
 * @author wangben
 * @date 2019-06-28
 */
public class Recruit extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Long recruitId;
	/** 招聘类型1公司2车主 */
	private Integer recruitType;
	/** 招聘人数 */
	private Integer num;
	/** 工作地点id */
	private Long cityId;
	/** 驾照等级 */
	private String grade;
	/** 工资 */
	private String wage;
	/** 车辆类型 */
	private Long carTypeId;
	/** 车辆类型名称 */
	private String carTypeName;
	/** 驾驶路线 */
	private String drivePath;
	/** 发布用户id */
	private Long userId;
	/** 联系人姓名 */
	private String userName;
	/** 联系人手机号 */
	private String userPhone;
	/** 帐号状态（0正常 1停用） */
	private Integer status;
	/** 工作城市 */
	private String cityName;

	public void setRecruitId(Long recruitId) 
	{
		this.recruitId = recruitId;
	}

	public Long getRecruitId() 
	{
		return recruitId;
	}
	public void setRecruitType(Integer recruitType) 
	{
		this.recruitType = recruitType;
	}

	public Integer getRecruitType() 
	{
		return recruitType;
	}
	public void setNum(Integer num) 
	{
		this.num = num;
	}

	public Integer getNum() 
	{
		return num;
	}
	public void setCityId(Long cityId) 
	{
		this.cityId = cityId;
	}

	public Long getCityId() 
	{
		return cityId;
	}
	public void setGrade(String grade) 
	{
		this.grade = grade;
	}

	public String getGrade() 
	{
		return grade;
	}
	public void setWage(String wage) 
	{
		this.wage = wage;
	}

	public String getWage() 
	{
		return wage;
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
	public void setDrivePath(String drivePath) 
	{
		this.drivePath = drivePath;
	}

	public String getDrivePath() 
	{
		return drivePath;
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
	public void setCityName(String cityName) 
	{
		this.cityName = cityName;
	}

	public String getCityName() 
	{
		return cityName;
	}

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recruitId", getRecruitId())
            .append("recruitType", getRecruitType())
            .append("num", getNum())
            .append("cityId", getCityId())
            .append("grade", getGrade())
            .append("wage", getWage())
            .append("carTypeId", getCarTypeId())
            .append("carTypeName", getCarTypeName())
            .append("drivePath", getDrivePath())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("cityName", getCityName())
            .toString();
    }
}
