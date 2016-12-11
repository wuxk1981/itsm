package com.zdhy.platform.itsm.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdhy.platform.itsm.core.base.BaseMapper;
import com.zdhy.platform.itsm.core.base.BaseServiceImpl;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.dao.PollingProjectMapper;
import com.zdhy.platform.itsm.dao.PollingSubitemMapper;
import com.zdhy.platform.itsm.entity.PollingProject;
import com.zdhy.platform.itsm.entity.PollingSubitem;
import com.zdhy.platform.itsm.service.IPollingProjectService;
import com.zdhy.platform.itsm.service.IPollingSubitemService;
import com.zdhy.platform.itsm.service.ServiceException;

/**
 * 功能:巡检项目业务实现
 * 创建人： 袁乐乐
 * 时间： 2016年11月16日-上午9:38:58
 * @version v1.0.0
 */
@Service("pollingProjectService")
@Transactional
public class PollingProjectServiceImpl extends BaseServiceImpl<PollingProject, String> implements IPollingProjectService{

	@Autowired
	private PollingProjectMapper pollingProjectMapper;
	@Autowired
	private PollingSubitemMapper pollingSubitemMapper;
	@Autowired
	private IPollingSubitemService pollingSubitemService;
/*	@Override
	public PageView query(PageView pageView, PollingProject pollingProject) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("paging", pageView);
		map.put("pollingProject", pollingProject);
		List<PollingProject> list = pollingProjectMapper.query(map);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public int insert(PollingProject pollingProject) throws Exception {
		return pollingProjectMapper.insert(pollingProject);
	}

	@Override
	public int insertSelective(PollingProject pollingProject) throws Exception {
		return pollingProjectMapper.insertSelective(pollingProject);
	}

	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		//查找巡检项目下的巡检子项并删除
		PollingProject pollingProject = pollingProjectMapper.selectSubitemListByProjectId(id);
		List<PollingSubitem> pollingSubitems = pollingProject.getPollingSubitems();
		if(pollingSubitems.size()>0){
			pollingSubitemService.deleteSubitemsByProjectId(id);
		}
		return pollingProjectMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void logicalDelete(String id) throws Exception {
		pollingProjectMapper.logicalDelete(id);
	}

	@Override
	public int updateByPrimaryKeySelective(PollingProject pollingProject) throws Exception {
		return pollingProjectMapper.updateByPrimaryKeySelective(pollingProject);
	}

	@Override
	public int updateByPrimaryKey(PollingProject pollingProject) throws Exception {
		return pollingProjectMapper.updateByPrimaryKey(pollingProject);
	}

	@Override
	public PollingProject selectByPrimaryKey(String id) {
		return pollingProjectMapper.selectByPrimaryKey(id);
	}

	@Override
	public PollingProject selectByName(String name) {
		return pollingProjectMapper.selectByName(name);
	}

	@Override
	public List<PollingProject> selectAll() {
		return pollingProjectMapper.selectAll();
	}

	@Override
	public PollingProject isExist(PollingProject pollingProject) {
		return pollingProjectMapper.isExist(pollingProject);
	}

	@Override
	public List<PollingProject> queryAll(PollingProject pollingProject) {
		return pollingProjectMapper.queryAll(pollingProject);
	}

	@Override
	public PollingProject selectByPrimaryKeyCascade(String id) {
		return pollingProjectMapper.selectByPrimaryKeyCascade(id);
	}

	@Override
	public Pagger<PollingProject> queryByPage(int pageIndex, int pageSize) {
		return pollingProjectMapper.queryByPage(pageIndex, pageSize);
	}

	@Override
	public int queryPageTotal() {
		return pollingProjectMapper.queryPageTotal();
	}*/
	@Override
	public int insert(PollingProject pollingProject,String templateId) throws Exception {
		String name = pollingProject.getName();
		//校验该项目名称是否存在
		PollingProject project = pollingProjectMapper.selectByNameAndTemplateId(name, templateId);
		if(project != null){
			throw new ServiceException("巡检项目已经存在");
		}
		pollingProject.setTemplateId(templateId);
		return pollingProjectMapper.insert(pollingProject);
	}
	
	@Override
	public int updateByPrimaryKeySelective(PollingProject pollingProject) throws Exception {
		String name = pollingProject.getName();
		String templateId = pollingProject.getTemplateId();
		//校验该项目名称是否存在
		PollingProject project = pollingProjectMapper.selectByNameAndTemplateId(name, templateId);
		if(project != null){
			throw new ServiceException("巡检项目已经存在");
		}
		return pollingProjectMapper.updateByPrimaryKeySelective(pollingProject);
	}
	
	@Override
	public int deleteByPrimaryKey(String id) throws Exception {
		if(StringUtils.isBlank(id)){
			throw new ServiceException("巡检项目id不存在");
		}
		//查找巡检项目下的巡检子项并删除
		PollingProject pollingProject = pollingProjectMapper.selectSubitemListByProjectId(id);
		List<PollingSubitem> pollingSubitems = pollingProject.getPollingSubitems();
		if(pollingSubitems.size()>0){
			pollingSubitemService.deleteSubitemsByProjectId(id);
		}
		return pollingProjectMapper.deleteByPrimaryKey(id);
	}
	
	//批删
	@Override
	public int deleteProjectsByIds(String ids){
		if(StringUtils.isBlank(ids)){
			throw new ServiceException("巡检项目id不存在");
		}
		String[] idArray = new String[]{};
		if(StringUtils.contains(ids, ",")){
			idArray = ids.split(",");
		}else{
			idArray = new String[]{ids};
		}
		try {
			pollingSubitemService.deleteByProjectIds(idArray);
			return pollingProjectMapper.deleteByIds(idArray);
		} catch (Exception e) {
			LoggerUtils.fmtError(getClass(), e, "批删出现错误，ids[%s]", ids);
		}
		return 0;
	}
	//根据巡检项目id查询巡检子项
	@Override
	public PollingProject listItemsByProjectId(String projectId) {
		if(StringUtils.isBlank(projectId)){
			throw new ServiceException("巡检项目id不存在");
		}
		return pollingProjectMapper.selectSubitemListByProjectId(projectId);
				
	}

	/*//添加项目时，点击提交，校验该项目名称是否存在
	@Override
	public Map<String, Object> selectProjectByName(String name) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		try {
			String resultMsg = "添加成功";
			if(StringUtils.isBlank(name)){
				resultMsg = "请输入名字";
			}else{
				PollingProject pollingProject = pollingProjectMapper.selectByName(name);
				if(!StringUtils.isBlank(pollingProject)){
					resultMsg = "项目"+name+"已经存在";
				}
			}
			resultMap.put("status", 200);
			resultMap.put("resultMsg", resultMsg);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "系统异常!");
		}
		return resultMap;
	}
*/

	@Override
	public int deleteByTemplateIds(String[] idArray) {
		//删除关联的巡检子项
		pollingSubitemService.deleteByTemplateIds(idArray);
		return pollingProjectMapper.deleteByTemplateIds(idArray);
	}

	@Override
	public BaseMapper<PollingProject, String> getDao() {
		return pollingProjectMapper;
	}
}

