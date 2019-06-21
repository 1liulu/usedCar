package com.car.project.wx.car.domain;

import com.car.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆类型和车辆品牌关联表 c_type_brand
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Getter
@Setter
public class WxTypeBrand extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	@JsonProperty("id")
	private Long id;

	/** 车辆类型id */
	@JsonProperty("type_id")
	private Long typeId;

	/** 车辆类型名称 */
	@JsonProperty("type_name")
	private String typeName;

	/** 品牌类型 */
	@JsonProperty("brand_id")
	private Long brandId;

	/** 品牌类型名称 */
	@JsonProperty("brand_name")
	private String brandName;

	/** 帐号状态（0正常 1停用） */
	@JsonProperty("status")
	private Integer status;

    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("typeId", getTypeId())
            .append("brandId", getBrandId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
