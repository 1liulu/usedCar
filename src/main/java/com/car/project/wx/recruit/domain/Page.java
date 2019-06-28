package com.car.project.wx.recruit.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Page
{
	/**当前页*/
	private Integer page;

	private Integer pageNum=0;

	/**每页多少行*/
	private Integer pageSize=10;
}
