package com.car.project.wx.car.domain;

import com.car.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 车辆品牌
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Getter
@Setter
public class WxBrand
{

	/** 品牌id */
	@JsonProperty("brand_id")
	private Long brandId;

	/** 品牌名称 */
	@JsonProperty("brand_name")
	private String brandName;

	/** 上级品牌id */
	@JsonProperty("p_id")
	private Long pId;

	/** 帐号状态（0正常 1停用） */
	@JsonProperty("status")
	private Integer status;

	@JsonProperty("brandList")
	private List<WxBrand> brandList;

	/** 类型id */
	@JsonProperty("type_id")
	private Long typeId;

}
