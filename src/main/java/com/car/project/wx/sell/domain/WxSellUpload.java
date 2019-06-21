package com.car.project.wx.sell.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 文件上传表 c_sell_upload
 * 
 * @author wangben
 * @date 2019-06-07
 */
@Getter
@Setter
public class WxSellUpload
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	private Integer id;
	/** 卖车code */
	private String sellCode;
	/** 图片名称 */
	private String uploadPath;

	private Integer status;

	/** 创建时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/** 更新时间 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;


}
