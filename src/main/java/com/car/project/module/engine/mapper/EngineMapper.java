package com.car.project.module.engine.mapper;

import com.car.project.module.engine.domain.Engine;

import java.util.List;

/**
 * 发动机品牌 数据层
 * 
 * @author wangben
 * @date 2019-05-25
 */
public interface EngineMapper 
{
	/**
     * 查询发动机品牌信息
     * 
     * @param engineId 发动机品牌ID
     * @return 发动机品牌信息
     */
	public Engine selectEngineById(Long engineId);
	
	/**
     * 查询发动机品牌列表
     * 
     * @param engine 发动机品牌信息
     * @return 发动机品牌集合
     */
	public List<Engine> selectEngineList(Engine engine);
	
	/**
     * 新增发动机品牌
     * 
     * @param engine 发动机品牌信息
     * @return 结果
     */
	public int insertEngine(Engine engine);
	
	/**
     * 修改发动机品牌
     * 
     * @param engine 发动机品牌信息
     * @return 结果
     */
	public int updateEngine(Engine engine);
	
	/**
     * 删除发动机品牌
     * 
     * @param engineId 发动机品牌ID
     * @return 结果
     */
	public int deleteEngineById(Long engineId);
	
	/**
     * 批量删除发动机品牌
     * 
     * @param engineIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteEngineByIds(String[] engineIds);

	/**
	 * 批量停用发动机品牌
	 *
	 * @param engineIds 需要停用的数据ID
	 * @return 结果
	 */
	public int disableEngineByIds(String[] engineIds);

	/**
	 * 批量启用发动机品牌
	 *
	 * @param engineIds 需要启用的数据ID
	 * @return 结果
	 */
	public int enableEngineByIds(String[] engineIds);
	
}