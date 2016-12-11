package com.zdhy.platform.itsm.dao;

import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.common.Pagger;


/**
 * 所有的Mapper继承这个接口
 * 已经实现民基本的 增,删,改,查接口,不需要重复写
 * @author lanyuan
 * @date 2014-2-10
 * @Email: mmm333zzz520@163.com
 * @version 1.0v
 */
public interface BaseMapper<Model, PK> extends Base<Model, PK> {
	
	/**
	 * 返回分页后的数据
	 * @param List
	 * @param t
	 * @return
	 */
	public List<Model> query(Map<String, Object> map);
	
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
}
