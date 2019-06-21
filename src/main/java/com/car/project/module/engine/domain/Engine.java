package com.car.project.module.engine.domain;

import com.car.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 发动机品牌表 c_engine
 * 
 * @author wangben
 * @date 2019-05-25
 */
public class Engine extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 发动机id */
	private Long engineId;
	/** 发动机品牌 */
	private String engineName;
	/** 帐号状态（0正常 1停用） */
	private Integer status;

	public void setEngineId(Long engineId) 
	{
		this.engineId = engineId;
	}

	public Long getEngineId() 
	{
		return engineId;
	}
	public void setEngineName(String engineName) 
	{
		this.engineName = engineName;
	}

	public String getEngineName() 
	{
		return engineName;
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
            .append("engineId", getEngineId())
            .append("engineName", getEngineName())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
