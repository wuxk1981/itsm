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

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.core.controller.BaseController;
import com.zdhy.platform.itsm.core.mybatis.page.Pagination;
import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.core.utils.StringUtils3;
import com.zdhy.platform.itsm.entity.Technology;
import com.zdhy.platform.itsm.service.ITechnologyService;

/**
 * 功能: 
 * TechnologyController.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月9日-上午10:38:32
 * 
 * @version v1.0.0
 */
@Controller
@RequestMapping(value = "technology")
public class TechnologyController extends BaseController {
	@Autowired
	private ITechnologyService technologyService;

	/**
	 * 映射服务目录管理网页
	 * 
	 * @author 吴心宽
	 * @return 返回服务目录管理网页地址
	 */
	@RequestMapping(value = "manager",method = RequestMethod.GET)
	public String manager() {
		return "technology/technology";
	}

	/**
	 * 跳到服务目录添加页面 
	 * 创建人： 吴心宽 
	 * 时间： 2016年11月17日-下午5:11:52
	 * 
	 * @version 1.0.0
	 * @return
	 */
	@RequestMapping(value = "toAdd")
	public String toAdd() {

		return "technology/technologyAdd";
	}

	/**
	 * 
	 * 创建人： 吴心宽 时间： 2016年11月9日-下午4:48:42
	 * 
	 * @version 1.0.0
	 * @param Technology
	 * @return
	 */
	@RequestMapping(value = "doAdd")
	@ResponseBody
	public ResponseMessage doAdd(Technology technology) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(technologyService.insert(technology));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}

	@RequestMapping(value = "delete")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			technologyService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}

	@RequestMapping(value = "deleteBatch")
	@ResponseBody
	public ResponseMessage deleteBatch(String[] ids) {
		int count = 0;
		try {
			for (String id : ids) {
				technologyService.deleteByPrimaryKey(id);
				count++;
				System.out.println("第 " + count + " 条, 删除成功！");
			}
		} catch (Exception e) {
			return new ResponseMessage(1, "第 " + count + " 条, 删除失败！");
		}
		return new ResponseMessage(0, "一共 " + count + " 条, 删除成功！");
	}

	@RequestMapping(value = "toUpdate")
	@ResponseBody
	public ResponseMessage toUpdate(String id) {
		ResponseMessage responseMessage = new ResponseMessage(0, "更新成功！");
		try {
			Technology technologyFech = technologyService
					.selectByPrimaryKey(id);
			responseMessage.setEntity(technologyFech);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return responseMessage;
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public ResponseMessage update(Technology technology) {
		try {
			technologyService.updateByPrimaryKey(technology);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}

	@RequestMapping(value = "detail")
	public String indentDetail(ModelMap mm, String id) {
		Technology technology = technologyService.selectByPrimaryKey(id);
		mm.addAttribute("technology", technology);
		return "technology/technologyDetail";
	}


	@ModelAttribute
	public Technology get(@RequestParam(required = false) String id) {
		Technology entity = null;
		if (StringUtils3.isNotBlank(id)) {
			entity = technologyService.get(id);
		}
		if (entity == null) {
			entity = new Technology();
		}
		return entity;
	}

	/**
	 * 个人资料
	 * 
	 * @return 调试中
	 */
	@RequestMapping(value = "index2")
	public ModelAndView technologyIndex2(
			@RequestParam Map<String, Object> paramMap, ModelMap modelMap,
			Integer pageNo) {
		String findContent = (String) paramMap.get("findContent");
		String name = (String) paramMap.get("name");
		String address = (String) paramMap.get("address");
		modelMap.put("findContent", findContent);
		modelMap.put("name", name);
		modelMap.put("address", address);
		Pagination<Technology> Technology = technologyService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("technology/index", "page", Technology);
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
	public ModelAndView technologyIndex(String findContent, ModelMap modelMap,
			Integer pageNo) {
		modelMap.put("findContent", findContent);
		Pagination<Technology> technology = technologyService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("technology/index", "page", technology);
	}

	/*
	 * @RequiresPermissions("test:testData:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) 
	 * public ModelAndView list(Technology
	 * technology, HttpServletRequest request, HttpServletResponse response) {
	 * Page<Technology> page = technologyService.findPage(new
	 * Page<Technology>(request, response), technology); return new
	 * ModelAndView("technology/list","page",page); }
	 */

	@RequestMapping(value = "list")
	@ResponseBody
	public List<Technology> list() {
		List<Technology> list = technologyService.selectAll();
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
	@RequestMapping(value = "findTechnologyByMap", method = RequestMethod.POST)
	public String findTechnologyByMap(
			@RequestParam Map<String, Object> paramMap, Model model) {
		PageView pageView = technologyService.findTechnologyByMap(paramMap);
		model.addAttribute("page", pageView);
		model.addAttribute("paramMap", paramMap);
		return "technology/list";
	}

	/**
	 * Technology添加
	 * 
	 * @param Technology
	 * @return
	 */
	@RequestMapping(value = "addTechnology", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addTechnology(Technology technology) {
		try {
			int count = technologyService.insertSelective(technology);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加作业项报错。source[%s]",
					technology.toString());
		}
		return resultMap;
	}

	/**
	 * Technology修改
	 * 
	 * @param Technology
	 * @return
	 */
	@RequestMapping(value = "updateTechnology", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateTechnology(Technology technology) {
		try {
			int count = technologyService
					.updateByPrimaryKeySelective(technology);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "修改作业项报错。source[%s]",
					technology.toString());
		}
		return resultMap;
	}

	/**
	 * 删除Technology，根据ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteTechnologyById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteTechnologyById(String ids) {
		return technologyService.deleteTechnologyByIds(ids);
	}

	/**
	 * 偷懒一下，通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("technology/%s", page));
	}
}