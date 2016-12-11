package com.zdhy.platform.itsm.dao;

import java.util.List;

import com.zdhy.platform.itsm.core.common.Pagger;


public interface Base<Model, PK> {

	/**
	 * 插入对象
	 * 
	 * @param model
	 *            对象
	 * @return
	 * @throws Exception
	 */
	public int insert(Model model) throws Exception;

	public int insertSelective(Model model) throws Exception;

	/**
	 * 通过主键,删除对象
	 * 
	 * @param id
	 *            主键
	 * @return
	 * @throws Exception
	 */
	public int deleteByPrimaryKey(PK id) throws Exception;

	/**
	 * 通过主键,逻辑删除对象
	 * 
	 * @param id
	 * @throws Exception
	 */
	public void logicalDelete(PK id) throws Exception;

	/**
	 * 更新对象
	 * 
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public int updateByPrimaryKeySelective(Model model) throws Exception;

	public int updateByPrimaryKey(Model model) throws Exception;

	/**
	 * 通过主键, 查询对象
	 * 
	 * @param id
	 *            主键
	 * @return
	 */
	public Model selectByPrimaryKey(PK id);
	
	
	
	
	
	/**
	 *从BaseMapper里考过来的接口 _start
	 */
	
	/**
	 * 查所有
	 * 
	 * @return
	 */
	List<Model> selectAll();

	// ------------------------- 以下为扩展方法
	// ----------------------------------------//
	public List<Model> queryAll(Model model);

	public Model selectByName(String name);

	public Model isExist(Model model);

	/*
	 * 级联查询 1-N 和 N-N
	 */
	public Model selectByPrimaryKeyCascade(PK id);

	/*
	 * 分页
	 */
	public Pagger<Model> queryByPage(int pageIndex, int pageSize);

	int queryPageTotal();
	
	
	
	
	/**
	 *从BaseMapper里考过来的接口 _end
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
