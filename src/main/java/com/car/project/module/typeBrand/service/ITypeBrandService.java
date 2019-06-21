package com.car.project.module.typeBrand.service;

import com.car.project.module.typeBrand.domain.TypeBrand;

import java.util.List;

/**
 * 车辆类型和车辆品牌关联 服务层
 * 
 * @author wangben
 * @date 2019-05-26
 */
public interface ITypeBrandService 
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
     * 删除车辆类型和车辆品牌关联信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeBrandByIds(String ids);

	/**
	 * 停用车辆类型和车辆品牌关联信息
	 *
	 * @param ids 需要停用的数据ID
	 * @return 结果
	 */
	int disableTypeBrandByIds(String ids);

	/**
	 * 启用车辆类型和车辆品牌关联信息
	 *
	 * @param ids 需要启用的数据ID
	 * @return 结果
	 */
	int enableTypeBrandByIds(String ids);
	
}
