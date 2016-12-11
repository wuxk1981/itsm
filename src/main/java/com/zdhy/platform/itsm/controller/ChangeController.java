package com.zdhy.platform.itsm.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.Common;
import com.zdhy.platform.itsm.entity.Change;
import com.zdhy.platform.itsm.service.IChangeService;

/**
 * 功能:换班Controller 创建人： 袁乐乐 时间： 2016年11月22日-下午1:50:53
 * 
 * @version v1.0.0
 */
@Controller
@RequestMapping("/change")
public class ChangeController extends BaseController{

	@Autowired
	private IChangeService changeService;

	/**
	 * 功能:值班管理界面多条件查询
	 * @param paramMap
	 *http://localhost:8081/itsm/change/query
	 * @return
	 */
	@RequestMapping(value = "query",method = RequestMethod.POST)
	@ResponseBody
	public PageView query(@RequestParam Map<String, Object> paramMap) {
		pageView = changeService.findByMap(paramMap);
		return pageView;
	}
	/**
	 * 功能:个人界面多条件查询
	 * @param staff,paramMap
	 *http://localhost:8081/itsm/change/queryMyChange
	 * @return
	 */
	@RequestMapping(value = "queryMyChange",method = RequestMethod.POST)
	@ResponseBody
	public PageView queryMyChange(String staff,@RequestParam Map<String, Object> paramMap) {
		pageView = changeService.findMyChange(staff,paramMap);
		return pageView;
	}
	/**
	 * 功能:根据id获取,查看详情
	 *  http://localhost:8081/itsm/change/getChange
	 * @return 创建人： 袁乐乐
	 * @version v1.0.0
	 */
	@RequestMapping(value ="getChange",method = RequestMethod.GET)
	@ResponseBody
	public Change findchange(String id) {
		return changeService.selectByPrimaryKey(id);
	}
	
	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return Common.BACKGROUND_PATH+"/change/add";
	}
	/**
	* 新增
	*  http://localhost:8081/itsm/change/add
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value="add",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(Change change) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			changeService.insert(change);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	
	/**
	 * 删除
	 * 
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
					changeService.deleteByPrimaryKey(string);
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
	 * 
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("update")
	public Map<String, Object> update(Model model, Change change) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			changeService.updateByPrimaryKey(change);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}

//	/**
//	 * 获取所有 http://localhost:8081/itsm/change/getChanges 
//	 * 功能:
//	 * 
//	 * @return 创建人： 袁乐乐
//	 * @version v1.0.0
//	 */
//	@RequestMapping("/getChanges")
//	@ResponseBody
//	public List<Change> findAll() {
//		return changeService.selectAll();
//	}
//
//	/**
//	 * 根据id获取 http://localhost:8081/itsm/change/getChange 
//	 * 功能:
//	 * 
//	 * @return 创建人： 袁乐乐
//	 * @version v1.0.0
//	 */
//	@RequestMapping("/getChange")
//	@ResponseBody
//	public Change findchange(String id) {
//		return changeService.selectByPrimaryKey(id);
//	}
//
//	/**
//	 * 新增 http://localhost:8081/itsm/change/addChange 功能:
//	 * 
//	 * @return 创建人： 袁乐乐
//	 * @version v1.0.0
//	 */
//	@RequestMapping(value = "addChange")
//	@ResponseBody
//	public ResponseMessage add(Change change) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//			message.setEntity(changeService.insert(change));
//		} catch (Exception e) {
//			message = new ResponseMessage(1, "添加失败！");
//		}
//		return message;
//	}
//
//	/**
//	 * 更新 http://localhost:8081/itsm/change/updateChange 
//	 * 功能:
//	 * 
//	 * @return 创建人： 袁乐乐
//	 * @version v1.0.0
//	 */
//	@RequestMapping(value = "updateChange")
//	@ResponseBody
//	public ResponseMessage update(Change change) {
//		try {
//			changeService.updateByPrimaryKey(change);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "更新失败！");
//		}
//		return new ResponseMessage(0, "更新成功！");
//	}
//
//	/**
//	 * 删除 http://localhost:8081/itsm/change/deleteChange 
//	 * 功能:
//	 * 
//	 * @return 创建人： 袁乐乐
//	 * @version v1.0.0
//	 */
//	@RequestMapping(value = "deleteChange")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//			changeService.deleteByPrimaryKey(id);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "删除失败！");
//		}
//		return new ResponseMessage(0, "删除成功！");
//	}
}