package com.zdhy.platform.itsm.core.common;

import java.util.List;

public interface IBaseDAO<T> {

	/*
	 * 添加
	 */
	int insert(T t);

	int insertSelective(T t);

	/*
	 * 删除
	 */
	int deleteByPrimaryKey(String id);

	/*
	 * 修改
	 */
	int updateByPrimaryKeySelective(T t);

	int updateByPrimaryKey(T t);

	/*
	 * 查询
	 */
	T selectByPrimaryKey(String id);
	/*
	 * 	级联查询
	 */
	T selectByPrimaryKeyCascade(String id);

	T selectByName(String name);

	public List<T> selectAll();

	public Pagger<T> queryByPage(int pageIndex, int pageSize);

	int queryPageTotal();
	
	
}
