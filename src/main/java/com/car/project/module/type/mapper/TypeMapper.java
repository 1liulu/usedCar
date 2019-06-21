package com.car.project.module.type.mapper;

import com.car.project.module.type.domain.Type;

import java.util.List;

/**
 * 车辆类型 数据层
 * 
 * @author wangben
 * @date 2019-05-26
 */
public interface TypeMapper 
{
	/**
     * 查询车辆类型信息
     * 
     * @param typeId 车辆类型ID
     * @return 车辆类型信息
     */
	public Type selectTypeById(Long typeId);
	
	/**
     * 查询车辆类型列表
     * 
     * @param type 车辆类型信息
     * @return 车辆类型集合
     */
	public List<Type> selectTypeList(Type type);
	
	/**
     * 新增车辆类型
     * 
     * @param type 车辆类型信息
     * @return 结果
     */
	public int insertType(Type type);
	
	/**
     * 修改车辆类型
     * 
     * @param type 车辆类型信息
     * @return 结果
     */
	public int updateType(Type type);
	
	/**
     * 删除车辆类型
     * 
     * @param typeId 车辆类型ID
     * @return 结果
     */
	public int deleteTypeById(Long typeId);
	
	/**
     * 批量删除车辆类型
     * 
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeByIds(String[] typeIds);

	/**
	 * 批量停用车辆类型
	 *
	 * @param typeIds 需要停用的数据ID
	 * @return 结果
	 */
	public int disableTypeByIds(String[] typeIds);

	/**
	 * 批量启用车辆类型
	 *
	 * @param typeIds 需要启用的数据ID
	 * @return 结果
	 */
	public int enableTypeByIds(String[] typeIds);
	
}