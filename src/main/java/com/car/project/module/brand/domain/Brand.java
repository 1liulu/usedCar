package com.car.project.module.brand.domain;

import com.car.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 车辆品牌表 c_brand
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Getter
@Setter
public class Brand extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** 品牌id */
	private Long brandId;
	/** 品牌名称 */
	private String brandName;
	/** 上级品牌id */
	@JsonProperty("pId")
	private Long pId;
	/** 上级品牌民称 */
    @JsonProperty("pName")
	private String pName;
	/** 帐号状态（0正常 1停用） */
	private Integer status;


    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("brandId", getBrandId())
            .append("brandName", getBrandName())
            .append("pId", getPId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .append("remark", getRemark())
            .toString();
    }
}
