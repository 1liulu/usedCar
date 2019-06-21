package com.car.project.module.typeBrand.domain;

import com.car.common.core.domain.BaseEntity;
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
public class TypeBrand extends BaseEntity
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Long id;
	/** 车辆类型id */
	private Long typeId;
	/** 车辆类型名称 */
	private String typeName;
	/** 品牌类型 */
	private Long brandId;
	/** 品牌类型名称 */
	private String brandName;
	/** 帐号状态（0正常 1停用） */
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
