package com.zdhy.platform.itsm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zdhy.platform.itsm.core.common.Pagger;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;

/**
 * GenericService的实现类, 其他的自定义 ServiceImpl, 继承自它,可以获得常用的增删查改操作, 未实现的方法有 子类各自实现
 * <p/>
 * Model : 代表数据库中的表 映射的Java对象类型 PK :代表对象的主键类型
 *
 * @author 吴心宽
 * @since 2016年11月29日 下午6:14:06
 */
public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK> {

	
	/**
	 * 定义成抽象方法,由子类实现,完成dao的注入
	 * 
	 * @return GenericDao实现类
	 */
	public abstract BaseMapper<Model, PK> getDao();

	/**
	 * 插入对象
	 *
	 * @param model
	 *            对象
	 * @throws Exception
	 */
	public int insert(Model model) throws Exception {
		return getDao().insertSelective(model);
	}

	/**
	 * 更新对象
	 *
	 * @param model
	 *            对象
	 * @throws Exception
	 */
	public int update(Model model) throws Exception {
		return getDao().updateByPrimaryKeySelective(model);
	}

	/**
	 * 通过主键, 删除对象
	 *
	 * @param id
	 *            主键
	 * @throws Exception
	 */
	public int delete(PK id) throws Exception {
		return getDao().deleteByPrimaryKey(id);
	}

	/**
	 * 通过主键, 查询对象
	 *
	 * @param id
	 *            主键
	 * @return
	 */
	public Model selectById(PK id) {
		return getDao().selectByPrimaryKey(id);
	}

	@Override
	public int insertSelective(Model model) throws Exception {
		return getDao().insertSelective(model);
	}

	@Override
	public int deleteByPrimaryKey(PK id) throws Exception {
		return getDao().deleteByPrimaryKey(id);
	}

	@Override
	public void logicalDelete(PK id) throws Exception {
		getDao().logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Model model) throws Exception {
		return getDao().updateByPrimaryKeySelective(model);
	}

	@Override
	public int updateByPrimaryKey(Model model) throws Exception {
		return getDao().updateByPrimaryKey(model);
	}

	@Override
	public Model selectByPrimaryKey(PK id) {
		return getDao().selectByPrimaryKey(id);
	}

	@Override
	public PageView query(PageView pageView, Model model) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("t", model);
		List<Model> list = getDao().query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<Model> selectAll() {
		return getDao().selectAll();
	}

	@Override
	public List<Model> queryAll(Model model) {
		return getDao().queryAll(model);
	}

	@Override
	public Model selectByName(String name) {
		return getDao().selectByName(name);
	}

	@Override
	public Model isExist(Model model) {
		return getDao().isExist(model);
	}

	@Override
	public Model selectByPrimaryKeyCascade(PK id) {
		return getDao().selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<Model> queryByPage(int pageIndex, int pageSize) {
		return getDao().queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return getDao().queryPageTotal();
	}
}