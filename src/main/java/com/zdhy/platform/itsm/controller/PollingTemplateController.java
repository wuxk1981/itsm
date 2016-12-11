package com.zdhy.platform.itsm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.Common;
import com.zdhy.platform.itsm.entity.PollingTemplate;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.IPollingTemplateService;

/**
 * 功能:巡检模板Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-下午2:53:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/background/template")
public class PollingTemplateController extends BaseController {

	@Autowired
	private IPollingTemplateService templateService;
	
	/**
	* 获取所有
	* http:
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("list")
	public String list(Model model, Resources menu, String pageNow) {
		return Common.BACKGROUND_PATH+"/template/list";
	}
	
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query")
	public PageView query(PollingTemplate template,String pageNow,String pagesize) {
		pageView = templateService.query(getPageView(pageNow,pagesize), template);
		return pageView;
	}
	
	/**
	* 新增
	* http:
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(PollingTemplate template) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			templateService.insert(template);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	/**
	 * 跑到新增界面
	 * http:
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return Common.BACKGROUND_PATH+"/template/add";
	}
	/**
	 * 跑到编辑界面
	 * http:
	 * @param model
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model,String id) {
		PollingTemplate template = templateService.selectByPrimaryKey(id);
		model.addAttribute("template", template);
		return Common.BACKGROUND_PATH+"/template/edit";
	}
	/**
	 *是否存在
	 * http:
	 * @param model
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(PollingTemplate template){
		PollingTemplate d = templateService.isExist(template);
		if(d == null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除
	 * http:
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("deleteById")
	public Map<String, Object> deleteById(Model model, String ids) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			String id[] = ids.split(",");
			for (String string : id) {
				if(!Common.isEmpty(string)){
					templateService.deleteByPrimaryKey(string);
				}
			}
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	
	/**
	 * 更新
	 * http:
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("update")
	public Map<String, Object> update(Model model, PollingTemplate template) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			templateService.updateByPrimaryKey(template);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
//	/**
//	* 获取所有
//	* http://localhost:8081/itsm/template/getTemplates
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getTemplates")
//	@ResponseBody
//	public List<PollingTemplate> findAll(){
//		return templateService.selectAll();
//	}	
//	/**
//	* 根据id获取
//	* http://localhost:8081/itsm/template/getTemplate
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getTemplate")
//	@ResponseBody
//	public PollingTemplate findTemplate(String id){
//		return templateService.selectByPrimaryKey(id);
//	}
//	@RequestMapping("/addTemplate")
//	@ResponseBody
//	public ResponseMessage add(PollingTemplate pollingTemplate) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//			message.setEntity(templateService.insert(pollingTemplate));
//		} catch (Exception e) {
//			return new ResponseMessage(1, "添加失败！");
//		}
//		return message;
//	}
//	
//	/**
//	* 更新
//	* http://localhost:8081/itsm/template/updateTemplate
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/updateTemplate")
//	@ResponseBody
//	public ResponseMessage update(PollingTemplate pollingTemplate)
//	{
//		try
//		{
//			templateService.updateByPrimaryKey(pollingTemplate);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			return new ResponseMessage(1,"更新失败！");
//		}
//		return new ResponseMessage(0, "更新成功！");
//	}
//	
//	/**
//	* 删除
//	* http://localhost:8081/itsm/template/deleteTemplate
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/deleteTemplate")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//			templateService.deleteByPrimaryKey(id);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "删除失败！");
//		}
//		return new ResponseMessage(0, "删除成功！");
//	}
//	
//	/**
//	* 查询巡检模板下相应的巡检项目
//	* http://localhost:8081/itsm/template/listProjects
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/listProjects")
//	@ResponseBody
//	public PollingTemplate listProjects(String templateId) {
//		return templateService.listProjectsByTemplateId(templateId);
//	}
//	
//	/**
//	* 查询巡检模板下相应的巡检对象
//	* http://localhost:8081/itsm/template/listObjects
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/listObjects")
//	@ResponseBody
//	public PollingTemplate listObjects(String templateId) {
//		return templateService.listObjectsByTemplateId(templateId);
//	}
}

