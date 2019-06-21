package com.car.project.module.brand.service;

import com.car.common.core.text.Convert;
import com.car.project.module.brand.domain.Brand;
import com.car.project.module.brand.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 车辆品牌 服务层实现
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Service("brand")
public class BrandServiceImpl implements IBrandService
{
	@Autowired
	private BrandMapper brandMapper;

	/**
     * 查询车辆品牌信息
     * 
     * @param brandId 车辆品牌ID
     * @return 车辆品牌信息
     */
    @Override
	public Brand selectBrandById(Long brandId)
	{
	    return brandMapper.selectBrandById(brandId);
	}
	
	/**
     * 查询车辆品牌列表
     * 
     * @param brand 车辆品牌信息
     * @return 车辆品牌集合
     */
	@Override
	public List<Brand> selectBrandList(Brand brand)
	{
	    return brandMapper.selectBrandList(brand);
	}
	
    /**
     * 新增车辆品牌
     * 
     * @param brand 车辆品牌信息
     * @return 结果
     */
	@Override
	public int insertBrand(Brand brand)
	{
	    brand.setCreateTime(new Date());
	    return brandMapper.insertBrand(brand);
	}
	
	/**
     * 修改车辆品牌
     * 
     * @param brand 车辆品牌信息
     * @return 结果
     */
	@Override
	public int updateBrand(Brand brand)
	{
	    brand.setUpdateTime(new Date());
	    return brandMapper.updateBrand(brand);
	}

	/**
     * 删除车辆品牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteBrandByIds(String ids)
	{
		return brandMapper.deleteBrandByIds(Convert.toStrArray(ids));
	}

    /**
     * 查询车辆品牌第一级信息
     *
     * @return 结果
     */
    @Override
    public List<Brand> selectByBrandPId() {
        return brandMapper.selectByBrandPId();
    }

    /**
     * 停用车辆品牌
     *
     * @param ids 需要停用的数据ID
     * @return 结果
     */
    @Override
    public int disableBrandByIds(String ids)
    {
        return brandMapper.disableBrandByIds(Convert.toStrArray(ids));
    }

    /**
     * 启用车辆品牌
     *
     * @param ids 需要启用的数据ID
     * @return 结果
     */
    @Override
    public int enableBrandByIds(String ids)
    {
        return brandMapper.enableBrandByIds(Convert.toStrArray(ids));
    }

	/**
	 * 获取车辆品牌
	 *
	 * @return 结果
	 */
	public List<Brand> getBrandList(){
		Brand brand=new Brand();
		brand.setStatus(0);
		return brandMapper.selectBrandList(brand);
	}

	/**
	 * 获取车辆品牌第一级
	 *
	 * @return 结果
	 */
	public List<Brand> getBrandLevelList(){
		Brand brand=new Brand();
		return brandMapper.selectByBrandPId();
	}

	/**
	 * 获取车辆品牌第二级
	 *
	 *@param pId 上级品牌id
	 * @return 结果
	 */
	public List<Brand> getBrandLevelList(Long pId){
		Brand brand=new Brand();
		brand.setPId(pId);
		return brandMapper.selectBrandLevelList(brand);
	}

}
