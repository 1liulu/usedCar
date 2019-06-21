package com.car.project.module.typeBrand.mapper;

import com.car.project.module.typeBrand.domain.TypeBrand;

import java.util.List;

/**
 * 车辆类型和车辆品牌关联 数据层
 * 
 * @author wangben
 * @date 2019-05-26
 */
public interface TypeBrandMapper 
{
	/**
     * 查询车辆类型和车辆品牌关联信息
     * 
     * @param id 车辆类型和车辆品牌关联ID
     * @return 车辆类型和车辆品牌关联信息
     */
	public TypeBrand selectTypeBrandById(Long id);
	
	/**
     * 查询车辆类型和车辆品牌关联列表
     * 
     * @param typeBrand 车辆类型和车辆品牌关联信息
     * @return 车辆类型和车辆品牌关联集合
     */
	public List<TypeBrand> selectTypeBrandList(TypeBrand typeBrand);
	
	/**
     * 新增车辆类型和车辆品牌关联
     * 
     * @param typeBrand 车辆类型和车辆品牌关联信息
     * @return 结果
     */
	public int insertTypeBrand(TypeBrand typeBrand);
	
	/**
     * 修改车辆类型和车辆品牌关联
     * 
     * @param typeBrand 车辆类型和车辆品牌关联信息
     * @return 结果
     */
	public int updateTypeBrand(TypeBrand typeBrand);
	
	/**
     * 删除车辆类型和车辆品牌关联
     * 
     * @param id 车辆类型和车辆品牌关联ID
     * @return 结果
     */
	public int deleteTypeBrandById(Long id);
	
	/**
     * 批量删除车辆类型和车辆品牌关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeBrandByIds(String[] ids);

	/**
	 * 批量停用车辆类型和车辆品牌关联
	 *
	 * @param ids 需要停用的数据ID
	 * @return 结果
	 */
	public int disableTypeBrandByIds(String[] ids);

	/**
	 * 批量启用车辆类型和车辆品牌关联
	 *
	 * @param ids 需要启用的数据ID
	 * @return 结果
	 */
	public int enableTypeBrandByIds(String[] ids);
	
}