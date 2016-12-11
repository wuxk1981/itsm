/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zdhy.platform.itsm.core.persistence;

import java.util.List;

import com.zdhy.platform.itsm.core.common.Pagger;

/**
 * DAO支持类实现
 * @author ThinkGem
 * @version 2014-05-16
 * @param <T>
 */
public interface CrudDao<T> extends BaseDao {

	public T get(String id);
	public T get(T entity);
	public List<T> findList(T entity);
	public List<T> findAllList(T entity);
	@Deprecated
	public List<T> findAllList();
	public int insert(T entity);
	public int update(T entity);
	@Deprecated
	public int delete(String id);
	public int delete(T entity);
	
	
	
	
	
	public int insert2(T entity)throws Exception;
	public int insertSelective(T entity)throws Exception;	
	public int deleteByPrimaryKey(String id)throws Exception;
	public void logicalDelete(String id)throws Exception;
	public int updateByPrimaryKeySelective(T entity)throws Exception;
	public int updateByPrimaryKey(T entity)throws Exception;
	public T selectByPrimaryKey(String id);
	List<T> selectAll();	
	
	//-------------------------  以下为扩展方法	----------------------------------------//
	public List<T> queryAll(T entity);
	public T selectByName(String name);
	public T isExist(T entity);
	public T selectByPrimaryKeyCascade(String id);
	public Pagger<T> queryByPage(int pageIndex, int pageSize);
	int queryPageTotal();
	public T selectOne();
	public List<T> selectList();		
	
}