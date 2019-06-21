package com.car.project.module.engine.service;

import com.car.common.core.text.Convert;
import com.car.project.module.engine.domain.Engine;
import com.car.project.module.engine.mapper.EngineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 发动机品牌 服务层实现
 * 
 * @author wangben
 * @date 2019-05-25
 */
@Service
public class EngineServiceImpl implements IEngineService 
{
	@Autowired
	private EngineMapper engineMapper;

	/**
     * 查询发动机品牌信息
     * 
     * @param engineId 发动机品牌ID
     * @return 发动机品牌信息
     */
    @Override
	public Engine selectEngineById(Long engineId)
	{
	    return engineMapper.selectEngineById(engineId);
	}
	
	/**
     * 查询发动机品牌列表
     * 
     * @param engine 发动机品牌信息
     * @return 发动机品牌集合
     */
	@Override
	public List<Engine> selectEngineList(Engine engine)
	{
	    return engineMapper.selectEngineList(engine);
	}
	
    /**
     * 新增发动机品牌
     * 
     * @param engine 发动机品牌信息
     * @return 结果
     */
	@Override
	public int insertEngine(Engine engine)
	{
	    engine.setCreateTime(new Date());
		return engineMapper.insertEngine(engine);
	}
	
	/**
     * 修改发动机品牌
     * 
     * @param engine 发动机品牌信息
     * @return 结果
     */
	@Override
	public int updateEngine(Engine engine)
	{
	    engine.setUpdateTime(new Date());
	    return engineMapper.updateEngine(engine);
	}

	/**
     * 删除发动机品牌对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteEngineByIds(String ids)
	{
		return engineMapper.deleteEngineByIds(Convert.toStrArray(ids));
	}

	/**
     * 停用发动机品牌对象
     *
     * @param ids 需要停用的数据ID
     * @return 结果
     */
	@Override
	public int disableEngineByIds(String ids)
	{
		return engineMapper.disableEngineByIds(Convert.toStrArray(ids));
	}

	/**
     * 启用发动机品牌对象
     *
     * @param ids 需要启用的数据ID
     * @return 结果
     */
	@Override
	public int enableEngineByIds(String ids)
	{
		return engineMapper.enableEngineByIds(Convert.toStrArray(ids));
	}
	
}
