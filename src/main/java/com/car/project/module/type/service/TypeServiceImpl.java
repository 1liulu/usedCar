package com.car.project.module.type.service;

import com.car.common.core.text.Convert;
import com.car.project.module.type.domain.Type;
import com.car.project.module.type.mapper.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆类型 服务层实现
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Service("carType")
public class TypeServiceImpl implements ITypeService 
{
	@Autowired
	private TypeMapper typeMapper;

	/**
     * 查询车辆类型信息
     * 
     * @param typeId 车辆类型ID
     * @return 车辆类型信息
     */
    @Override
	public Type selectTypeById(Long typeId)
	{
	    return typeMapper.selectTypeById(typeId);
	}
	
	/**
     * 查询车辆类型列表
     * 
     * @param type 车辆类型信息
     * @return 车辆类型集合
     */
	@Override
	public List<Type> selectTypeList(Type type)
	{
	    return typeMapper.selectTypeList(type);
	}
	
    /**
     * 新增车辆类型
     * 
     * @param type 车辆类型信息
     * @return 结果
     */
	@Override
	public int insertType(Type type)
	{
		type.setCreateTime(new Date());
	    return typeMapper.insertType(type);
	}
	
	/**
     * 修改车辆类型
     * 
     * @param type 车辆类型信息
     * @return 结果
     */
	@Override
	public int updateType(Type type)
	{
	    type.setUpdateTime(new Date());
		return typeMapper.updateType(type);
	}

	/**
     * 删除车辆类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTypeByIds(String ids)
	{
		return typeMapper.deleteTypeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 停用车辆类型信息
	 *
	 * @param ids 需要停用的数据ID
	 * @return 结果
	 */
	@Override
	public int disableTypeByIds(String ids)
	{
		return typeMapper.disableTypeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 启用车辆类型信息
	 *
	 * @param ids 需要启用的数据ID
	 * @return 结果
	 */
	@Override
	public int enableTypeByIds(String ids)
	{
		return typeMapper.enableTypeByIds(Convert.toStrArray(ids));
	}

	/**
	 * 获取车辆类型
	 *
	 * @return 结果
	 */
	public List<Type> getTypeList(){
		Type type=new Type();
		type.setStatus(0);
		return typeMapper.selectTypeList(type);
	}
}
