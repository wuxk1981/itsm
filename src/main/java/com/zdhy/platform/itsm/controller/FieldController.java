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
import com.zdhy.platform.itsm.entity.Field;
import com.zdhy.platform.itsm.service.IFieldService;

/**
 * 功能: 
 * FieldController.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月9日-上午10:38:32
 * 
 * @version v1.0.0
 */
@Controller
@RequestMapping(value = "field")
public class FieldController extends BaseController {
	@Autowired
	private IFieldService fieldService;

	/**
	 * 映射服务目录管理网页
	 * 
	 * @author 吴心宽
	 * @return 返回服务目录管理网页地址
	 */
	@RequestMapping(value = "manager")
	public String manager() {
		return "field/field";
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

		return "field/fieldAdd";
	}

	/**
	 * 
	 * 创建人： 吴心宽 时间： 2016年11月9日-下午4:48:42
	 * 
	 * @version 1.0.0
	 * @param Field
	 * @return
	 */
	@RequestMapping(value = "doAdd")
	@ResponseBody
	public ResponseMessage doAdd(Field Field) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(fieldService.insert(Field));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}

	@RequestMapping(value = "delete")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			fieldService.deleteByPrimaryKey(id);
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
				fieldService.deleteByPrimaryKey(id);
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
			Field fieldFech = fieldService
					.selectByPrimaryKey(id);
			responseMessage.setEntity(fieldFech);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return responseMessage;
	}

	@RequestMapping(value = "update")
	@ResponseBody
	public ResponseMessage update(Field field) {
		try {
			fieldService.updateByPrimaryKey(field);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}

	@RequestMapping(value = "detail")
	public String indentDetail(ModelMap mm, String id) {
		Field field = fieldService.selectByPrimaryKey(id);
		mm.addAttribute("field", field);
		return "field/fieldDetail";
	}

	@ModelAttribute
	public Field get(@RequestParam(required = false) String id) {
		Field entity = null;
		if (StringUtils3.isNotBlank(id)) {
			entity = fieldService.get(id);
		}
		if (entity == null) {
			entity = new Field();
		}
		return entity;
	}

	/**
	 * 个人资料
	 * 
	 * @return 调试中
	 */
	@RequestMapping(value = "index2")
	public ModelAndView FieldIndex2(
			@RequestParam Map<String, Object> paramMap, ModelMap modelMap,
			Integer pageNo) {
		String findContent = (String) paramMap.get("findContent");
		String name = (String) paramMap.get("name");
		String address = (String) paramMap.get("address");
		modelMap.put("findContent", findContent);
		modelMap.put("name", name);
		modelMap.put("address", address);
		Pagination<Field> field = fieldService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("field/index", "page", field);
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
	public ModelAndView FieldIndex(String findContent, ModelMap modelMap,
			Integer pageNo) {
		modelMap.put("findContent", findContent);
		Pagination<Field> field = fieldService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("field/index", "page", field);
	}

	/*
	 * @RequiresPermissions("test:testData:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) 
	 * public ModelAndView list(Field
	 * Field, HttpServletRequest request, HttpServletResponse response) {
	 * Page<Field> page = FieldService.findPage(new
	 * Page<Field>(request, response), Field); return new
	 * ModelAndView("Field/list","page",page); }
	 */

	@RequestMapping(value = "list")
	@ResponseBody
	public List<Field> list() {
		List<Field> list = fieldService.selectAll();
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
	@RequestMapping(value = "findFieldByMap", method = RequestMethod.POST)
	public String findFieldByMap(
			@RequestParam Map<String, Object> paramMap, Model model) {
		PageView pageView = fieldService.findFieldByMap(paramMap);
		model.addAttribute("page", pageView);
		model.addAttribute("paramMap", paramMap);
		return "field/list";
	}

	/**
	 * Field添加
	 * 
	 * @param field
	 * @return
	 */
	@RequestMapping(value = "addField", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addField(Field field) {
		try {
			int count = fieldService.insertSelective(field);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加作业项报错。source[%s]",
					field.toString());
		}
		return resultMap;
	}

	/**
	 * Field修改
	 * 
	 * @param field
	 * @return
	 */
	@RequestMapping(value = "updateField", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateField(Field field) {
		try {
			int count = fieldService
					.updateByPrimaryKeySelective(field);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "修改作业项报错。source[%s]",
					field.toString());
		}
		return resultMap;
	}

	/**
	 * 删除Field，根据ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteFieldById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteFieldById(String ids) {
		return fieldService.deleteFieldByIds(ids);
	}

	/**
	 * 偷懒一下，通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("field/%s", page));
	}
}