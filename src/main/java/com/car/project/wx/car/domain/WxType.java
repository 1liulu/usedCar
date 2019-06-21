package com.car.project.wx.car.domain;

import com.car.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆类型表 c_type
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Getter
@Setter
public class WxType extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 类型id */
	@JsonProperty("type_id")
	private Long typeId;
	/** 车辆类型名称 */
	@JsonProperty("type_name")
	private String typeName;
	/** 帐号状态（0正常 1停用） */
	@JsonProperty("status")
	private Integer status;


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
