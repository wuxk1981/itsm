package com.zdhy.platform.itsm.controller;

import io.swagger.annotations.Api;

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
import com.zdhy.platform.itsm.entity.Business;
import com.zdhy.platform.itsm.service.IBusinessService;

/**
 * 功能: BusinessController.java 创建人： 吴心宽 时间： 2016年11月9日-上午10:38:32
 * 
 * @version v1.0.0
 */
@Api(value = "/business", description = "业务服务の相关操作")
@Controller
@RequestMapping(value = "/business")
public class BusinessController extends BaseController {
	@Autowired
	private IBusinessService businessService;

	@ModelAttribute
	public Business get(@RequestParam(required = false) String id) {
		Business entity = null;
		if (StringUtils3.isNotBlank(id)) {
			entity = businessService.get(id);
		}
		if (entity == null) {
			entity = new Business();
		}
		return entity;
	}

	/**
	 * 映射服务目录管理网页
	 * 
	 * @author 吴心宽
	 * @return 返回服务目录管理网页地址
	 */
	@RequestMapping(value = "manager", method = RequestMethod.GET)
	public String manager() {
		return "business/business";
	}

	/**
	 * 跳到服务目录添加页面 创建人： 吴心宽 时间： 2016年11月17日-下午5:11:52
	 * 
	 * @version 1.0.0
	 * @return
	 */
	@RequestMapping(value = "toAdd", method = RequestMethod.GET)
	public String toAdd() {

		return "business/businessAdd";
	}

	/**
	 * 
	 * 创建人： 吴心宽 时间： 2016年11月9日-下午4:48:42
	 * 
	 * @version 1.0.0
	 * @param business
	 * @return
	 */
	@RequestMapping(value = "doAdd", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage doAdd(Business business) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(businessService.insert(business));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			businessService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}

	@RequestMapping(value = "deleteBatch", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage deleteBatch(String[] ids) {
		int count = 0;
		try {
			for (String id : ids) {
				businessService.deleteByPrimaryKey(id);
				count++;
				System.out.println("第 " + count + " 条, 删除成功！");
			}
		} catch (Exception e) {
			return new ResponseMessage(1, "第 " + count + " 条, 删除失败！");
		}
		return new ResponseMessage(0, "一共 " + count + " 条, 删除成功！");
	}

	@RequestMapping(value = "toUpdate", method = RequestMethod.GET)
	@ResponseBody
	public ResponseMessage toUpdate(String id) {
		ResponseMessage responseMessage = new ResponseMessage(0, "更新成功！");
		try {
			Business businessFech = businessService.selectByPrimaryKey(id);
			responseMessage.setEntity(businessFech);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return responseMessage;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage update(Business business) {
		try {
			businessService.updateByPrimaryKey(business);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String indentDetail(ModelMap mm, String id) {
		Business business = businessService.selectByPrimaryKey(id);
		mm.addAttribute("Business", business);
		return "business/businessDetail";
	}

	/**
	 * 个人资料
	 * 
	 * @return 调试中
	 */
	@RequestMapping(value = "index2", method = RequestMethod.POST)
	public ModelAndView BusinessIndex2(
			@RequestParam Map<String, Object> paramMap, ModelMap modelMap,
			Integer pageNo) {
		String findContent = (String) paramMap.get("findContent");
		String name = (String) paramMap.get("name");
		String address = (String) paramMap.get("address");
		modelMap.put("findContent", findContent);
		modelMap.put("name", name);
		modelMap.put("address", address);
		Pagination<Business> business = businessService.findPage(modelMap,
				pageNo, pageSize);
		return new ModelAndView("business/index", "page", business);
	}

	/**
	 * 单条件模糊查询
	 * 
	 * @param findContent
	 * @param modelMap
	 * @param pageNo
	 * @return 调试OK
	 */
	@RequestMapping(value = "index", method = RequestMethod.POST)
	public ModelAndView BusinessIndex(String findContent, ModelMap modelMap,
			Integer pageNo) {
		modelMap.put("findContent", findContent);
		Pagination<Business> business = businessService.findPage(modelMap,
				pageNo, pageSize);
		return new ModelAndView("business/index", "page", business);
	}

	/*
	 * @RequiresPermissions("test:testData:view")
	 * 
	 * @RequestMapping(value = {"list", ""}) public ModelAndView list(Business
	 * business, HttpServletRequest request, HttpServletResponse response) {
	 * Page<Business> page = BusinessService.findPage(new
	 * Page<Business>(request, response), business); return new
	 * ModelAndView("Business/list","page",page); }
	 */

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public List<Business> list() {
		List<Business> list = businessService.selectAll();
		return list;
	}

	@RequestMapping(value = "goAdd", method = RequestMethod.GET)
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
	@RequestMapping(value = "findBusinessByMap", method = RequestMethod.POST)
	public String findBusinessByMap(@RequestParam Map<String, Object> paramMap,
			Model model) {
		PageView pageView = businessService.findBusinessByMap(paramMap);
		model.addAttribute("page", pageView);
		model.addAttribute("paramMap", paramMap);
		return "business/list";
	}

	/**
	 * Business添加
	 * 
	 * @param business
	 * @return
	 */
	@RequestMapping(value = "addBusiness", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addBusiness(Business business) {
		try {
			int count = businessService.insertSelective(business);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "添加失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "添加业务服务报错。source[%s]",
					business.toString());
		}
		return resultMap;
	}

	/**
	 * Business修改
	 * 
	 * @param business
	 * @return
	 */
	@RequestMapping(value = "updateBusiness", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> updateBusiness(Business business) {
		try {
			int count = businessService.updateByPrimaryKeySelective(business);
			resultMap.put("status", 200);
			resultMap.put("successCount", count);
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败，请刷新后再试！");
			LoggerUtils.fmtError(getClass(), e, "修改业务服务报错。source[%s]",
					business.toString());
		}
		return resultMap;
	}

	/**
	 * 删除Business，根据ID
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteBusinessById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteBusinessById(String ids) {
		return businessService.deleteBusinessByIds(ids);
	}

	/**
	 * 偷懒一下，通用页面跳转
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "{page}", method = RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page") String page) {
		return new ModelAndView(String.format("Business/%s", page));
	}
}