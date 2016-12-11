package com.zdhy.platform.itsm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.dao.ServiceItemMapper;
import com.zdhy.platform.itsm.entity.ServiceItem;
import com.zdhy.platform.itsm.service.IServiceItemService;

/**
 * 功能: 
 * ServiceItemServiceImpl.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月9日-上午10:29:28
 * 
 * @version v1.0.0
 */
@Service(value = "serviceItemService")
@Transactional
public class ServiceItemServiceImpl extends BaseServiceImpl<ServiceItem, String>
		implements IServiceItemService {

	@Autowired
	private ServiceItemMapper serviceItemMapper;

	@Override
	public BaseMapper<ServiceItem, String> getDao() {
		return serviceItemMapper;
	}

	@Override
	public ServiceItem get(String id) {
		return serviceItemMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页方法 (简单条件 查询   OR)
	 */
	@Override
	public Pagination<ServiceItem> findPage(Map<String, Object> resultMap, Integer pageNo,
			int pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@Override
	public PageView findServiceItemByMap(Map<String, Object> paramMap) {
		ServiceItem serviceItem = new ServiceItem();
		String name = (String)paramMap.get("name");
		if (name != null && !("".equals(name))){
			serviceItem.setName(name);
		}
		
		List<ServiceItem> list = serviceItemMapper.findServiceItemByMap(serviceItem);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}

	/**
	 * 批删
	 */
	@Override
	public Map<String, Object> deleteServiceItemByIds(String ids) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			int count=0;
			String resultMsg = "删除成功。";
			String[] idArray = new String[]{};
			if(StringUtils.contains(ids, ",")){
				idArray = ids.split(",");
			}else{
				idArray = new String[]{ids};
			}
			
			c:for (String idx : idArray) {
				String id = new String(idx);
				if(new Long(1).equals(id)){
					resultMsg = "操作成功，But'系统管理员不能删除。";
					continue c;
				}else{
					count+=this.deleteByPrimaryKey(id);
				}
			}
			resultMap.put("status", 200);
			resultMap.put("count", count);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "根据IDS删除用户出现错误，ids[%s]", ids);
			resultMap.put("status", 500);
			resultMap.put("message", "删除出现错误，请刷新后再试！");
		}
		return resultMap;
	}

}