package com.car.project.module.type.domain;

import com.car.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆类型表 c_type
 * 
 * @author wangben
 * @date 2019-05-26
 */
public class Type extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 类型id */
	private Long typeId;
	/** 车辆类型名称 */
	private String typeName;
	/** 帐号状态（0正常 1停用） */
	private Integer status;

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
            .append("typeId", getTypeId())
            .append("typeName", getTypeName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
