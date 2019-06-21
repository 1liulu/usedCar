package com.car.project.module.type.service;

import com.car.project.module.type.domain.Type;

import java.util.List;

/**
 * 车辆类型 服务层
 * 
 * @author wangben
 * @date 2019-05-26
 */
public interface ITypeService 
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
     * 删除车辆类型信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteTypeByIds(String ids);

	/**
	 * 停用车辆类型信息
	 *
	 * @param ids 需要停用的数据ID
	 * @return 结果
	 */
	int disableTypeByIds(String ids);

	/**
	 * 启用车辆类型信息
	 *
	 * @param ids 需要启用的数据ID
	 * @return 结果
	 */
	int enableTypeByIds(String ids);
	
}
