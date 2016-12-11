package com.zdhy.platform.itsm.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.dao.PollingObjectPlanMapper;
import com.zdhy.platform.itsm.dao.PollingProjectMapper;
import com.zdhy.platform.itsm.dao.PollingTemplateMapper;
import com.zdhy.platform.itsm.entity.PollingProject;
import com.zdhy.platform.itsm.entity.PollingTemplate;
import com.zdhy.platform.itsm.service.IPollingProjectService;
import com.zdhy.platform.itsm.service.IPollingSubitemService;
import com.zdhy.platform.itsm.service.IPollingTemplateService;
import com.zdhy.platform.itsm.service.ServiceException;

/**
 * 功能:巡检模板业务层实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:18:19
 * @version v1.0.0
 */
@Service("pollingTemplateService")
@Transactional
public class PollingTemplateServiceImpl extends BaseServiceImpl<PollingTemplate, String> implements IPollingTemplateService{
	

	@Autowired
	private PollingTemplateMapper pollingTemplateMapper;
	@Autowired
	private PollingProjectMapper pollingProjectMapper;
	@Autowired
	private PollingObjectPlanMapper pollingObjectPlanmapper;
	@Autowired
	private IPollingProjectService pollingProjectService;
	@Autowired
	private IPollingSubitemService pollingSubitemService;
	
/*	@Override
	public PageView query(PageView pageView, PollingTemplate pollingTemplate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("pollingTemplate", pollingTemplate);
		List<PollingTemplate> list = pollingTemplateMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(PollingTemplate pollingTemplate) throws Exception {
		return pollingTemplateMapper.insert(pollingTemplate);
	}

	@Override
	public int insertSelective(PollingTemplate pollingTemplate) throws Exception {
		return pollingTemplateMapper.insertSelective(pollingTemplate);
	}

	
	@Override
	public void logicalDelete(String id) throws Exception {
		pollingTemplateMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PollingTemplate pollingTemplate) throws Exception {
		return pollingTemplateMapper.updateByPrimaryKeySelective(pollingTemplate);
	}

	@Override
	public int updateByPrimaryKey(PollingTemplate pollingTemplate) throws Exception {
		return pollingTemplateMapper.updateByPrimaryKey(pollingTemplate);
	}

	@Override
	public PollingTemplate selectByPrimaryKey(String id) {
		return pollingTemplateMapper.selectByPrimaryKey(id);
	}*/

	@Override
	public int insert(PollingTemplate pollingTemplate) {
		String name = pollingTemplate.getName();
		//校验该模板名称是否存在
		PollingTemplate template = pollingTemplateMapper.selectByName(name);
		if(template != null){
			throw new ServiceException("模板已经存在");
		}
		try {
			return pollingTemplateMapper.insert(pollingTemplate);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "插入出现错误", pollingTemplate);
		}
		return 0;
	}
	/*//添加模板时候，点击下一步，校验该模板名称是否存在
	@Override
	public Map<String,Object> selectTemplateByName(String name) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String resultMsg = "添加成功";
			if(StringUtils.isBlank(name)){
				resultMsg = "请输入名字";
			}else{
				PollingTemplate pollingTemplate = pollingTemplateMapper.selectByName(name);
				if(!StringUtils.isBlank(pollingTemplate)){
					resultMsg = "模板"+name+"已存在";
				}
			}
			resultMap.put("status", 200);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "系统异常!");
		}
		return resultMap;
	}*/

	@Override
	public int updateByPrimaryKeySelective(PollingTemplate pollingTemplate) throws Exception {
		String name = pollingTemplate.getName();
		//校验该模板名称是否存在
		PollingTemplate template = pollingTemplateMapper.selectByName(name);
		if(template != null){
			throw new ServiceException("模板已经存在");
		}
		return pollingTemplateMapper.updateByPrimaryKeySelective(pollingTemplate);
	}
	
	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		if(StringUtils.isBlank(id)){
			return -1;
		}
		//查看巡检模板是否被巡检计划使用，巡检计划与巡检对象有关联，巡检对象与巡检模板有关联
		List<String> names = pollingTemplateMapper.selectPlanNamesByTemplateId(id);
		//若被使用则不能删除。
		if(names.size()>0){
			return 111;
		}
		PollingTemplate pollingTemplate = pollingTemplateMapper.selectProjectListByTemplateId(id);
		//查看该巡检模板下是否有巡检项目，若有，删除
		List<PollingProject> pollingProjects = pollingTemplate.getPollingProjects();
		if(pollingProjects.size()>0){
			for(PollingProject pollingProject:pollingProjects){
				pollingProjectService.deleteByPrimaryKey(pollingProject.getId());
			}
		}
		return pollingTemplateMapper.deleteByPrimaryKey(id);
	}
	
	//批删
	@Override
	public int deleteTemplatesByIds(String ids){
		if(StringUtils.isBlank(ids)){
			return -1;
		}
		String[] idArray = new String[]{};
		if(StringUtils.contains(ids, ",")){
			idArray = ids.split(",");
		}else{
			idArray = new String[]{ids};
		}
		//查看巡检模板是否被巡检计划使用，巡检计划与巡检对象有关联，巡检对象与巡检模板有关联
		List<String> names = pollingTemplateMapper.selectPlanNamesByTemplateIds(idArray);
		//若被使用则不能删除。
		if(names.size()>0){
			return 111;
		}
		try {
			//删除关联的巡检项目
			pollingProjectService.deleteByTemplateIds(idArray);
			return pollingTemplateMapper.deleteByIds(idArray);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			LoggerUtils.fmtError(getClass(), e, "批删出现错误，ids[%s]", ids);
		}
		return 0;
	}
/*	@Override
	public List<PollingTemplate> selectAll() {
		return pollingTemplateMapper.selectAll();
	}

	@Override
	public PollingTemplate isExist(PollingTemplate pollingTemplate) {
		return pollingTemplateMapper.isExist(pollingTemplate);
	}

	@Override
	public List<PollingTemplate> queryAll(PollingTemplate pollingTemplate) {
		return pollingTemplateMapper.queryAll(pollingTemplate);
	}

	@Override
	public PollingTemplate selectByPrimaryKeyCascade(String id) {
		return pollingTemplateMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<PollingTemplate> queryByPage(int pageIndex, int pageSize) {
		return pollingTemplateMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return pollingTemplateMapper.queryPageTotal();
	}
	*/

	//查询巡检模板下相应的巡检项目
	@Override
	public PollingTemplate listProjectsByTemplateId(String templateId) {
		return pollingTemplateMapper.selectProjectListByTemplateId(templateId);
	}

	//查询巡检模板下相应的巡检对象
	@Override
	public PollingTemplate listObjectsByTemplateId(String templateId) {
		return pollingTemplateMapper.selectObjectListByTemplateId(templateId);
	}

	//根据模板查询下面的项目和子项
	@Override
	public List<Map<String, String>> findProjectAndSubitem(String templateId) {
		return pollingTemplateMapper.selectProjectAndSubitem(templateId);
	}
	
	@Override
	public BaseMapper<PollingTemplate, String> getDao() {
		return pollingTemplateMapper;
	}

/*	@Override
	public PollingTemplate selectByName(String name) {
		// TODO Auto-generated method stub
		return pollingTemplateMapper.selectByName(name);
	}
*/
	
}

