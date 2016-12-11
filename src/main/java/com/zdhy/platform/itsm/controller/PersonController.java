package com.zdhy.platform.itsm.controller;

//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiImplicitParams;
//import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.zdhy.platform.itsm.entity.Person;
import com.zdhy.platform.itsm.service.IPersonService;

/**
 * 
 * 开发公司：中电弘业<br/>
 * 版权：中电弘业<br/>
 * <p>
 * 负责人管理
 * <p>
 * 
 * 区分　责任人　日期　　　　 说明<br/>
 * 创建　吴心宽　2016年12月3日 　<br/>
 * 
 * @author 吴心宽
 * @email i@中电弘业
 * @version 1.0,2016年12月3日 <br/>
 * 
 */
@Controller
@RequestMapping("/person")
@Api(value = "/person", description = "负责人的相关操作")
public class PersonController extends BaseController {

	@Autowired
	IPersonService personService;

	@ModelAttribute
	public Person get(@RequestParam(required = false) String id) {
		Person entity = null;
		if (StringUtils3.isNotBlank(id)) {
			entity = personService.get(id);
		}
		if (entity == null) {
			entity = new Person();
		}
		return entity;
	}

	/**
	 * 个人资料
	 * 
	 * @return 调试中
	 */
	@RequestMapping(value = "index2")
	public ModelAndView personIndex2(
			@RequestParam Map<String, Object> paramMap, ModelMap modelMap,
			Integer pageNo) {
		String findContent = (String) paramMap.get("findContent");
		String name = (String) paramMap.get("name");
		String address = (String) paramMap.get("address");
		modelMap.put("findContent", findContent);
		modelMap.put("name", name);
		modelMap.put("address", address);
		Pagination<Person> person = personService.findPage(modelMap, pageNo,
				pageSize);
		return new ModelAndView("person/index", "page", person);
	}

	// @ApiOperation(value = "获取带分页功能的负责人列表", notes = "")
	@RequestMapping(value = { "index" }, method = RequestMethod.GET)
	public ModelAndView personIndex(String findContent, ModelMap modelMap,
			Integer pageNo) {
		modelMap.put("findContent", findContent);
		Pagination<Person> person = personService.findPage(modelMap, pageNo,
				pageSize);
		return new ModelAndView("person/index", "page", person);
	}

	@ApiOperation(notes = "getUserList", value = "获取用户列表")
	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	@ResponseBody
	public List<Person> getUserList() {
		List<Person> list = personService.selectAll();
		return list;
	}

	/*
	 * @RequiresPermissions("test:testData:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public ModelAndView list(Person
	 * person, HttpServletRequest request, HttpServletResponse response) {
	 * Page<Person> page = personService.findPage(new Page<Person>(request,
	 * response), person); return new ModelAndView("person/list","page",page); }
	 */

	// @ApiOperation(value = "获取负责人列表json", notes = "")
	@RequestMapping(value = { "list" }, method = RequestMethod.GET)
	@ResponseBody
	public List<Person> list() {
		List<Person> list = personService.selectAll();
		return list;
	}

	/**
	 * 多条件模糊查询
	 * 
	 * @param paramMap
	 * @param model
	 * @return
	 */
	// @ApiOperation(value = "多条件模糊查询,获取负责人列表", notes = "")
	@RequestMapping(value = { "findPersonByMap" }, method = RequestMethod.POST)
	public String findPersonByMap(@RequestParam Map<String, Object> paramMap,
			Model model) {
		PageView pageView = personService.findPersonByMap(paramMap);
		model.addAttribute("page", pageView);
		model.addAttribute("paramMap", paramMap);
		return "person/list";
	}

	/**
	 * Person添加
	 * 
	 * @param person
	 * @return
	 */
	@ApiOperation(value = "创建负责人", notes = "根据Person对象创建负责人")
	@RequestMapping(value = "addPerson", method = RequestMethod.POST)
	@ApiImplicitParams({ @ApiImplicitParam(name = "person", value = "负责人详细实体person", required = true, dataType = "Person") })
	@ResponseBody
	public Map<String, Object> addPerson(@RequestBody Person person) {
		try {
			int count = personService.insertSelective(person);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加角色报错。source[%s]",
					person.toString());
		}
		return resultMap;
	}

	/**
	 * 删除Person，根据ID
	 * 
	 * @param id
	 * @return
	 */
	// @ApiOperation(value = "删除负责人", notes = "根据url的id来指定删除对象")
	// @ApiImplicitParam(name = "id", value = "负责人ID", required = true, dataType
	// = "String")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> deleteRoleById(String ids) {
		return personService.deletePersonByIds(ids);
	}

	// @ApiOperation(value = "获取负责人详细信息", notes = "根据url的name来获取负责人详细信息")
	// @ApiImplicitParam(name = "name", value = "负责人名", required = true,
	// dataType = "String")
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public Person getPerson(@PathVariable String name) {
		Person Person = personService.selectByName(name);
		return Person;
	}

	// @ApiOperation(value = "更新负责人详细信息", notes =
	// "根据url的id来指定更新对象，并根据传过来的Person信息来更新负责人详细信息")
	// @ApiImplicitParams({
	// @ApiImplicitParam(name = "id", value = "负责人ID", required = true, dataType
	// = "String"),
	// @ApiImplicitParam(name = "Person", value = "负责人详细实体Person", required =
	// true, dataType = "Person") })
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putPerson(@PathVariable String id, @RequestBody Person person) {
		person.setId(id);
		try {
			personService.updateByPrimaryKeySelective(person);
			return "success";
		} catch (Exception e) {

			return "failure";
		}
	}

	/**
	 * 通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	// @ApiOperation(value = "通用页面跳转", notes = "通用页面跳转")
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("person/%s", page));
	}

}
