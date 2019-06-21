package com.car.project.module.brand.service;

import com.car.project.module.brand.domain.Brand;

import java.util.List;

/**
 * 车辆品牌 服务层
 * 
 * @author wangben
 * @date 2019-05-25
 */
public interface IBrandService 
{
	/**
     * 查询车辆品牌信息
     * 
     * @param brandId 车辆品牌ID
     * @return 车辆品牌信息
     */
	public Brand selectBrandById(Long brandId);
	
	/**
     * 查询车辆品牌列表
     * 
     * @param brand 车辆品牌信息
     * @return 车辆品牌集合
     */
	public List<Brand> selectBrandList(Brand brand);
	
	/**
     * 新增车辆品牌
     * 
     * @param brand 车辆品牌信息
     * @return 结果
     */
	public int insertBrand(Brand brand);
	
	/**
     * 修改车辆品牌
     * 
     * @param brand 车辆品牌信息
     * @return 结果
     */
	public int updateBrand(Brand brand);
		
	/**
     * 删除车辆品牌信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBrandByIds(String ids);

    /**
     * 查询车辆品牌第一级信息
     *
     * @return 结果
     */
    List<Brand> selectByBrandPId();

	/**
	 * 停用发动机品牌信息
	 *
	 * @param ids 需要停用的数据ID
	 * @return 结果
	 */
	int disableBrandByIds(String ids);

	/**
	 * 启用发动机品牌信息
	 *
	 * @param ids 需要启用的数据ID
	 * @return 结果
	 */
	int enableBrandByIds(String ids);
}
