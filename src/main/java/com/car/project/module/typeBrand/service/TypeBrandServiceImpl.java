package com.car.project.module.typeBrand.service;

import com.car.common.core.text.Convert;
import com.car.project.module.typeBrand.domain.TypeBrand;
import com.car.project.module.typeBrand.mapper.TypeBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆类型和车辆品牌关联 服务层实现
 * 
 * @author wangben
 * @date 2019-05-26
 */
@Service("typeBrand")
public class TypeBrandServiceImpl implements ITypeBrandService
{
	@Autowired
	private TypeBrandMapper typeBrandMapper;

	/**
     * 查询车辆类型和车辆品牌关联信息
     * 
     * @param id 车辆类型和车辆品牌关联ID
     * @return 车辆类型和车辆品牌关联信息
     */
    @Override
	public TypeBrand selectTypeBrandById(Long id)
	{
	    return typeBrandMapper.selectTypeBrandById(id);
	}
	
	/**
     * 查询车辆类型和车辆品牌关联列表
     * 
     * @param typeBrand 车辆类型和车辆品牌关联信息
     * @return 车辆类型和车辆品牌关联集合
     */
	@Override
	public List<TypeBrand> selectTypeBrandList(TypeBrand typeBrand)
	{
	    return typeBrandMapper.selectTypeBrandList(typeBrand);
	}
	
    /**
     * 新增车辆类型和车辆品牌关联
     * 
     * @param typeBrand 车辆类型和车辆品牌关联信息
     * @return 结果
     */
	@Override
	public int insertTypeBrand(TypeBrand typeBrand)
	{
		typeBrand.setCreateTime(new Date());
	    return typeBrandMapper.insertTypeBrand(typeBrand);
	}
	
	/**
     * 修改车辆类型和车辆品牌关联
     * 
     * @param typeBrand 车辆类型和车辆品牌关联信息
     * @return 结果
     */
	@Override
	public int updateTypeBrand(TypeBrand typeBrand)
	{
		typeBrand.setUpdateTime(new Date());
	    return typeBrandMapper.updateTypeBrand(typeBrand);
	}

	/**
     * 删除车辆类型和车辆品牌关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTypeBrandByIds(String ids)
	{
		return typeBrandMapper.deleteTypeBrandByIds(Convert.toStrArray(ids));
	}

	/**
	 * 停用车辆类型和车辆品牌关联
	 *
	 * @param ids 需要停用的数据ID
	 * @return 结果
	 */
	@Override
	public int disableTypeBrandByIds(String ids)
	{
		return typeBrandMapper.disableTypeBrandByIds(Convert.toStrArray(ids));
	}

	/**
	 * 启用车辆类型和车辆品牌关联
	 *
	 * @param ids 需要启用的数据ID
	 * @return 结果
	 */
	@Override
	public int enableTypeBrandByIds(String ids)
	{
		return typeBrandMapper.enableTypeBrandByIds(Convert.toStrArray(ids));
	}


	
}
