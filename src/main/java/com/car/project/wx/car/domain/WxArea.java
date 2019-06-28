package com.car.project.wx.car.domain;

import com.car.common.core.domain.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 车辆品牌
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Getter
@Setter
public class WxArea
{

	/** 区域id */
	@JsonProperty("code")
	private Long code;

	/** 区域名称 */
	@JsonProperty("name")
	private String name;

	/** 上级区域id */
	@JsonProperty("pcode")
	private Long pcode;


	@JsonProperty("sareaList")
	private List<WxArea> sareaList;

	@JsonProperty("qareaList")
	private List<WxArea> qareaList;

}
