package com.zdhy.platform.itsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.PollingProject;
import com.zdhy.platform.itsm.service.IPollingProjectService;

/**
 * 功能:巡检项目Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-下午3:33:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/background/project")
public class PollingProjectController extends BaseController {

	@Autowired
	private IPollingProjectService projectService;
	
//	/**
//	* 获取所有
//	* http://localhost:8081/itsm/
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("list")
//	public String list(Model model, Resources menu, String pageNow) {
//		return Common.BACKGROUND_PATH+"/project/list";
//	}
//	
//	/**
//	 * @param model
//	 * 存放返回界面的model
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("query")
//	public PageView query(PollingProject project,String pageNow,String pagesize) {
//		pageView = projectService.query(getPageView(pageNow,pagesize), project);
//		return pageView;
//	}
//	
//	/**
//	* 新增
//	* 
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("add")
//	@ResponseBody
//	public Map<String, Object> add(PollingProject project) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			projectService.insert(project);
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}
//	/**
//	 * 跑到新增界面
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("addUI")
//	public String addUI() {
//		return Common.BACKGROUND_PATH+"/project/add";
//	}
//	/**
//	 * 跑到编辑界面
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("editUI")
//	public String editUI(Model model,String id) {
//		PollingProject project = projectService.selectByPrimaryKey(id);
//		model.addAttribute("project", project);
//		return Common.BACKGROUND_PATH+"/project/edit";
//	}
//	/**
//	 *是否存在
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("isExist")
//	@ResponseBody
//	public boolean isExist(PollingProject project){
//		PollingProject d = projectService.isExist(project);
//		if(d == null){
//			return true;
//		}else{
//			return false;
//		}
//	}
//	/**
//	 * 删除
//	 * 
//	 * @param model
//	 * @return
//	 * @throws Exception 
//	 */
//	@ResponseBody
//	@RequestMapping("deleteById")
//	public Map<String, Object> deleteById(Model model, String ids) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			String id[] = ids.split(",");
//			for (String string : id) {
//				if(!Common.isEmpty(string)){
//					projectService.deleteByPrimaryKey(string);
//				}
//			}
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}
//	
//	/**
//	 * 更新
//	 * 
//	 * @param model
//	 * @return
//	 * @throws Exception 
//	 */
//	@ResponseBody
//	@RequestMapping("update")
//	public Map<String, Object> update(Model model, PollingProject project) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			projectService.updateByPrimaryKey(project);
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}
	
	/**
	* 获取所有
	* http://localhost:8081/itsm/project/getProjects
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getProjects")
	@ResponseBody
	public List<PollingProject> findAll(){
		return projectService.selectAll();
	}
	
	/**
	* 根据id获取
	* http://localhost:8081/itsm/project/getProject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getProject")
	@ResponseBody
	public PollingProject findProject(String id){
		return projectService.selectByPrimaryKey(id);
	}
	
	/**
	* 新增
	* http://localhost:8081/itsm/project/addProject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "addProject")
	@ResponseBody
	public ResponseMessage add(PollingProject pollingProject) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(projectService.insert(pollingProject));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新
	* http://localhost:8081/itsm/project/updateProject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "updateProject")
	@ResponseBody
	public ResponseMessage update(PollingProject pollingProject) {
		try {
			projectService.updateByPrimaryKey(pollingProject);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除
	* http://localhost:8081/itsm/project/deleteProject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "deleteProject")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			projectService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
	
	/**
	* 查找项目下的巡检子项
	* http://localhost:8081/itsm/project/listSubitems
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/listSubitems")
	@ResponseBody
	public PollingProject listSubitems(String projectId) {
		return projectService.listItemsByProjectId(projectId);
	}
}

