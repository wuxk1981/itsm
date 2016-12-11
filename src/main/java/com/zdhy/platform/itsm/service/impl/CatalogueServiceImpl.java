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
import com.zdhy.platform.itsm.dao.CatalogueMapper;
import com.zdhy.platform.itsm.entity.Catalogue;
import com.zdhy.platform.itsm.service.ICatalogueService;

/**
 * 功能: 
 * CatalogueServiceImpl.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月9日-上午10:29:28
 * 
 * @version v1.0.0
 */
@Service(value = "catalogueService")
@Transactional
public class CatalogueServiceImpl extends BaseServiceImpl<Catalogue, String>
		implements ICatalogueService {

	@Autowired
	private CatalogueMapper catalogueMapper;

	@Override
	public BaseMapper<Catalogue, String> getDao() {
		return catalogueMapper;
	}

	@Override
	public Catalogue get(String id) {
		return catalogueMapper.selectByPrimaryKey(id);
	}

	/**
	 * 分页方法 (简单条件 查询   OR)
	 */
	@Override
	public Pagination<Catalogue> findPage(Map<String, Object> resultMap, Integer pageNo,
			int pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}


	/**
	 * 多条件模糊查询
	 */
	@Override
	public PageView findCatalogueByMap(Map<String, Object> paramMap) {
		Catalogue catalogue = new Catalogue();
		String name = (String)paramMap.get("name");
		if (name != null && !("".equals(name))){
			catalogue.setName(name);
		}
		
		List<Catalogue> list = catalogueMapper.findCatalogueByMap(catalogue);
		PageView pageView = new PageView();
		pageView.setRecords(list);
		return pageView;
	}


	/**
	 * 批删
	 */
	@Override
	public Map<String, Object> deleteCatalogueByIds(String ids) {
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