package com.zdhy.platform.itsm.controller;

//import io.swagger.annotations.ApiImplicitParam;
//import io.swagger.annotations.ApiOperation;

import io.swagger.annotations.Api;

import java.util.Date;
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
import com.zdhy.platform.itsm.core.utils.Common;
import com.zdhy.platform.itsm.core.utils.LoggerUtils;
import com.zdhy.platform.itsm.core.utils.StringUtils3;
import com.zdhy.platform.itsm.entity.Catalogue;
import com.zdhy.platform.itsm.service.ICatalogueService;

/**
 * 功能: 服务目录
 * CatalogueController.java 
 * 创建人： 吴心宽 
 * 时间： 2016年11月9日-上午10:38:32
 * 
 * @version v1.0.0
 */
@Api(value = "/catalogue", description = "服务目录の相关操作")
@Controller
@RequestMapping(value = "/catalogue")
public class CatalogueController extends BaseController{
	@Autowired
	private ICatalogueService catalogueService;

	/**
	 * 映射服务目录管理网页
	 * 
	 * @author 吴心宽
	 * @return 返回服务目录管理网页地址
	 */
	@RequestMapping(value = "/manager")
	public String manager() {
		return Common.LOGIN_PAGE_PATH+"/catalogue/catalogue";
	}

	/**
	 * 跳到服务目录添加页面 创建人： 吴心宽 时间： 2016年11月17日-下午5:11:52
	 * 
	 * @version 1.0.0
	 * @return
	 */
	@RequestMapping(value = "/toAdd")
	public String toAdd() {

		return Common.LOGIN_PAGE_PATH+"/catalogue/add";
	}
	@RequestMapping(value = "/toAdd2")
	public String toAdd2() {
		
		return Common.LOGIN_PAGE_PATH+"/catalogue/add2";
	}

//    @ApiOperation(value = "创建服务目录", notes = "根据Catalogue对象创建服务目录")  
//    @ApiImplicitParam(name = "catalogue", value = "服务目录详细实体catalogue", required = true, dataType = "Catalogue")
	@RequestMapping(value = {"/doAdd"})
	@ResponseBody
	public ResponseMessage doAdd(Catalogue catalogue) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			catalogueService.insert(catalogue);
			message.setEntity(catalogue);
		} catch (Exception e) {
			message = new ResponseMessage(1, "添加失败！");
		}
		return message;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ResponseMessage delete(String id) {
		ResponseMessage message = new ResponseMessage(0, "删除成功！");
		try {
				catalogueService.deleteByPrimaryKey(id);
			} catch (Exception e) {
				message = new ResponseMessage(1, "删除失败！");
			}
		return message;
	}
	
	@RequestMapping(value = "/deleteBatch")
	@ResponseBody
	public ResponseMessage deleteBatch(String[] ids) {
		ResponseMessage message = new ResponseMessage(0, "删除成功！");
		for (String id : ids) {
			try {
				catalogueService.deleteByPrimaryKey(id);
			} catch (Exception e) {
				message = new ResponseMessage(0, "删除失败！");
			}
		}
		return message;
	}

	@RequestMapping(value = "/doUpdate")
	@ResponseBody
	public ResponseMessage doUpdate(Catalogue catalogue) {
		ResponseMessage message = new ResponseMessage(0, "修改成功！");
		catalogue.setLastModifyTime(new Date());
		try {
			catalogueService.updateByPrimaryKey(catalogue);
		} catch (Exception e) {
			message = new ResponseMessage(1, "更新失败！");
		}
		return message;
	}
	
	@RequestMapping(value = "/release")
	@ResponseBody
	public ResponseMessage release(Catalogue catalogue) {
		ResponseMessage message = new ResponseMessage(0, "修改成功！");
		catalogue.setLastModifyTime(new Date());
		try {
			catalogueService.updateByPrimaryKeySelective(catalogue);
		} catch (Exception e) {
			message = new ResponseMessage(1, "发布失败！");
		}
		return message;
	}

	@RequestMapping(value = "/detail")
	public String indentDetail(ModelMap modelMap, String id) {
		Catalogue catalogue = catalogueService.selectByPrimaryKey(id);
		modelMap.addAttribute("catalogue", catalogue);
		return Common.LOGIN_PAGE_PATH+"/catalogue/catalogueDetail";
	}

	@ModelAttribute
	public Catalogue get(@RequestParam(required = false) String id) {
		Catalogue entity = null;
		if (StringUtils3.isNotBlank(id)) {
			entity = catalogueService.get(id);
		}
		if (entity == null) {
			entity = new Catalogue();
		}
		return entity;
	}

	/**
	 * 个人资料
	 * 
	 * @return 调试中
	 */
	@RequestMapping(value = "index2")
	public ModelAndView catalogueIndex2(
			@RequestParam Map<String, Object> paramMap, ModelMap modelMap,
			Integer pageNo) {
		String findContent = (String) paramMap.get("findContent");
		String name = (String) paramMap.get("name");
		String address = (String) paramMap.get("address");
		modelMap.put("findContent", findContent);
		modelMap.put("name", name);
		modelMap.put("address", address);
		Pagination<Catalogue> catalogue = catalogueService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("catalogue/index", "page", catalogue);
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
	public ModelAndView catalogueIndex(String findContent, ModelMap modelMap,
			Integer pageNo) {
		modelMap.put("findContent", findContent);
		Pagination<Catalogue> catalogue = catalogueService.findPage(
				modelMap, pageNo, pageSize);
		return new ModelAndView("catalogue/index", "page", catalogue);
	}

	/*
	 * @RequiresPermissions("test:testData:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) 
	 * public ModelAndView list(Catalogue
	 * catalogue, HttpServletRequest request, HttpServletResponse response) {
	 * Page<Catalogue> page = catalogueService.findPage(new
	 * Page<Catalogue>(request, response), catalogue); return new
	 * ModelAndView("catalogue/list","page",page); }
	 */

	@RequestMapping(value = "list")
	@ResponseBody
	public List<Catalogue> list() {
		List<Catalogue> list = catalogueService.selectAll();
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
	@RequestMapping(value = "findCatalogueByMap", method = RequestMethod.POST)
	public String findCatalogueByMap(
			@RequestParam Map<String, Object> paramMap, Model model) {
		PageView pageView = catalogueService.findCatalogueByMap(paramMap);
		model.addAttribute("page", pageView);
		model.addAttribute("paramMap", paramMap);
		return "catalogue/list";
	}

	/**
	 * Catalogue添加
	 * 
	 * @param Catalogue
	 * @return
	 */
	@RequestMapping(value = "addCatalogue", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCatalogue(Catalogue catalogue) {
		try {
			int count = catalogueService.insertSelective(catalogue);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加作业项报错。source[%s]",
					catalogue.toString());
		}
		return resultMap;
	}

	/**
	 * Catalogue修改
	 * 
	 * @param Catalogue
	 * @return
	 */
	@RequestMapping(value = "updateCatalogue", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateCatalogue(Catalogue catalogue) {
		try {
			int count = catalogueService
					.updateByPrimaryKeySelective(catalogue);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "修改作业项报错。source[%s]",
					catalogue.toString());
		}
		return resultMap;
	}

	/**
	 * 删除Catalogue，根据ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteCatalogueById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteCatalogueById(String ids) {
		return catalogueService.deleteCatalogueByIds(ids);
	}

	/**
	 * 偷懒一下，通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("catalogue/%s", page));
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}