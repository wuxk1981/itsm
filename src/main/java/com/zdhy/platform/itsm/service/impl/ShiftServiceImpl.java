package com.zdhy.platform.itsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.dao.ShiftMapper;
import com.zdhy.platform.itsm.entity.Shift;
import com.zdhy.platform.itsm.service.IShiftService;
import com.zdhy.platform.itsm.service.ServiceException;

/**
 * 功能:班次业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-上午10:59:19
 * @version v1.0.0
 */
@Service("shiftService")
@Transactional
public class ShiftServiceImpl extends BaseServiceImpl<Shift, String> implements IShiftService{

	@Autowired
	private ShiftMapper shiftMapper;
	
	@Override
	public int insert(Shift shift) throws Exception {
		List<Shift> lists = shiftMapper.selectAll();
		if(lists.size()>3){
			throw new ServiceException("最多增加到3个班次");
		}
		return shiftMapper.insert(shift);
	}
/*	@Override
	public PageView query(PageView pageView, Shift shift) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("shift", shift);
		List<Shift> list = shiftMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(Shift shift) throws Exception {
		return shiftMapper.insert(shift);
	}

	@Override
	public int insertSelective(Shift shift) throws Exception {
		return shiftMapper.insertSelective(shift);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		return shiftMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		shiftMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Shift shift) throws Exception {
		return shiftMapper.updateByPrimaryKeySelective(shift);
	}

	@Override
	public int updateByPrimaryKey(Shift shift) throws Exception {
		return shiftMapper.updateByPrimaryKey(shift);
	}

	@Override
	public Shift selectByPrimaryKey(String id) {
		return shiftMapper.selectByPrimaryKey(id);
	}

	@Override
	public Shift selectByName(String name) {
		return shiftMapper.selectByName(name);
	}

	@Override
	public List<Shift> selectAll() {
		return shiftMapper.selectAll();
	}

	@Override
	public Shift isExist(Shift shift) {
		return shiftMapper.isExist(shift);
	}

	@Override
	public List<Shift> queryAll(Shift shift) {
		return shiftMapper.queryAll(shift);
	}

	@Override
	public Shift selectByPrimaryKeyCascade(String id) {
		return shiftMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<Shift> queryByPage(int pageIndex, int pageSize) {
		return shiftMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return shiftMapper.queryPageTotal();
	}*/
	

	//查询班次下的排班
	@Override
	public Shift listSchedulingsByShiftId(String shiftId) {
		return shiftMapper.selectSchedulingsByShiftId(shiftId);
	}

	@Override
	public BaseMapper<Shift, String> getDao() {
		return shiftMapper;
	}

}

