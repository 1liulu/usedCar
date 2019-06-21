package com.car.project.wx.sell.mapper;

import com.car.project.wx.sell.domain.WxSellUpload;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 文件上传 数据层
 * 
 * @author wangben
 * @date 2019-06-07
 */
public interface WxSellUploadMapper
{
	/**
     * 查询文件上传信息
     * 
     * @param id 文件上传ID
     * @return 文件上传信息
     */
	public WxSellUpload selectSellUploadById(Integer id);
	
	/**
     * 查询文件上传列表
     * 
     * @param sellUpload 文件上传信息
     * @return 文件上传集合
     */
	public List<WxSellUpload> selectSellUploadList(WxSellUpload sellUpload);
	
	/**
     * 新增文件上传
     * 
     * @param sellUpload 文件上传信息
     * @return 结果
     */
	public int insertSellUpload(WxSellUpload sellUpload);
	
	/**
     * 修改文件上传
     * 
     * @param sellUpload 文件上传信息
     * @return 结果
     */
	public int updateSellUpload(WxSellUpload sellUpload);
	
	/**
     * 删除文件上传
     * 
     * @param id 文件上传ID
     * @return 结果
     */
	public int deleteSellUploadById(Integer id);

	/**
	 * 删除文件上传
	 *
	 * @param sellCode 卖车code
	 * @return 结果
	 */
	public int deleteSellUploadBySellCode(String sellCode);

	/**
     * 批量删除文件上传
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteSellUploadByIds(String[] ids);

    int insertBySellUploads(@Param("sellCode") String sellCode, @Param("array") String[] array);

	List<WxSellUpload> selectSellUploadByCode(String sellCode);
}