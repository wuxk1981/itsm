package com.zdhy.platform.itsm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zdhy.platform.itsm.core.controller.BaseController;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.core.utils.StringUtils3;
import com.zdhy.platform.itsm.entity.JobProject;
import com.zdhy.platform.itsm.service.IJobProjectService;

/**
 * 功能: 
 * JobProjectController.java 
 * 创建人： 吴心宽 
 * 时间： 2016年12月1日-上午10:23:34
 * 
 * @version v1.0.0
 */
@Controller
@RequestMapping("jobproject")
public class JobProjectController extends BaseController {
	@Autowired
	IJobProjectService jobProjectService;

	@ModelAttribute
	public JobProject get(@RequestParam(required = false) String id) {
		JobProject entity = null;
		if (StringUtils3.isNotBlank(id)) {
			entity = jobProjectService.get(id);
		}
		if (entity == null) {
			entity = new JobProject();
		}
		return entity;
	}

	/**
	 * 个人资料
	 * 
	 * @return 调试中
	 */
	@RequestMapping(value = "index2")
	public ModelAndView jobProjectIndex2(
			@RequestParam Map<String, Object> paramMap, ModelMap modelMap,
			Integer pageNo) {
		String findContent = (String) paramMap.get("findContent");
		String name = (String) paramMap.get("name");
		String address = (String) paramMap.get("address");
		modelMap.put("findContent", findContent);
		modelMap.put("name", name);
		modelMap.put("address", address);
		Pagination<JobProject> JobProject = jobProjectService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("jobproject/index", "page", JobProject);
	}

	/**
	 * 单条件模糊查询
	 * 
	 * @param findContent
	 * @param modelMap
	 * @param pageNo
	 * @return 调试OK
	 */
	@RequestMapping(value = "index")
	public ModelAndView jobProjectIndex(String findContent, ModelMap modelMap,
			Integer pageNo) {
		modelMap.put("findContent", findContent);
		Pagination<JobProject> jobProject = jobProjectService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("jobproject/index", "page", jobProject);
	}

	/*
	 * @RequiresPermissions("test:testData:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public ModelAndView list(JobProject
	 * JobProject, HttpServletRequest request, HttpServletResponse response) {
	 * Page<JobProject> page = jobProjectService.findPage(new
	 * Page<JobProject>(request, response), JobProject); return new
	 * ModelAndView("JobProject/list","page",page); }
	 */

	@RequestMapping(value = "list")
	@ResponseBody
	public List<JobProject> list() {
		List<JobProject> list = jobProjectService.selectAll();
		return list;
	}

	@RequestMapping(value = "goAdd")
	@ResponseBody
	public Map<String, Object> goAdd() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "小黑");
		return map;
	}

	/**
	 * 多条件模糊查询
	 * 
	 * @param paramMap
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "findJobProjectByMap", method = RequestMethod.POST)
	public String findJobProjectByMap(
			@RequestParam Map<String, Object> paramMap, Model model) {
		PageView pageView = jobProjectService.findJobProjectByMap(paramMap);
		model.addAttribute("page", pageView);
		model.addAttribute("paramMap", paramMap);
		return "jobproject/list";
	}

	/**
	 * JobProject添加
	 * 
	 * @param JobProject
	 * @return
	 */
	@RequestMapping(value = "addJobProject", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addJobProject(JobProject JobProject) {
		try {
			int count = jobProjectService.insertSelective(JobProject);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加作业项报错。source[%s]",
					JobProject.toString());
		}
		return resultMap;
	}

	/**
	 * JobProject修改
	 * 
	 * @param JobProject
	 * @return
	 */
	@RequestMapping(value = "updateJobProject", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateJobProject(JobProject JobProject) {
		try {
			int count = jobProjectService
					.updateByPrimaryKeySelective(JobProject);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "修改作业项报错。source[%s]",
					JobProject.toString());
		}
		return resultMap;
	}

	/**
	 * 删除JobProject，根据ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteJobProjectById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteRoleById(String ids) {
		return jobProjectService.deleteJobProjectByIds(ids);
	}

	/**
	 * 偷懒一下，通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("jobProject/%s", page));
	}

}
