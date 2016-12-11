package com.zdhy.platform.itsm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.OrderMapper;
import com.zdhy.platform.itsm.entity.Order;
import com.zdhy.platform.itsm.service.IOrderService;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月14日-下午6:57:46
 * @version v1.0.0
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl extends BaseServiceImpl<Order, String> implements IOrderService{

	@Autowired
	private OrderMapper orderMapper;

	@Override
	public BaseMapper<Order, String> getDao() {
		return orderMapper;
	}

/*	@Override
	public PageView query(PageView pageView, Order order) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("order", order);
		List<Order> list = orderMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(Order order) throws Exception {
		return orderMapper.insert(order);
	}

	@Override
	public int insertSelective(Order order) throws Exception {
		return orderMapper.insertSelective(order);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return orderMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		orderMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Order order) throws Exception {
		return orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public int updateByPrimaryKey(Order order) throws Exception {
		return orderMapper.updateByPrimaryKey(order);
	}

	@Override
	public Order selectByPrimaryKey(String id) {
		return orderMapper.selectByPrimaryKey(id);
	}

	@Override
	public Order selectByName(String name) {
		return orderMapper.selectByName(name);
	}

	@Override
	public List<Order> selectAll() {
		return orderMapper.selectAll();
	}

	@Override
	public Order isExist(Order order) {
		return orderMapper.isExist(order);
	}

	@Override
	public List<Order> queryAll(Order order) {
		return orderMapper.queryAll(order);
	}

	@Override
	public Order selectByPrimaryKeyCascade(String id) {
		return orderMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<Order> queryByPage(int pageIndex, int pageSize) {
		return orderMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return orderMapper.queryPageTotal();
	}*/
	
}

