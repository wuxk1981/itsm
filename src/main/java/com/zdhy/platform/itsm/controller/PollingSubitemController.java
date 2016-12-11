package com.zdhy.platform.itsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.PollingSubitem;
import com.zdhy.platform.itsm.service.IPollingSubitemService;

/**
 * 功能:巡检项目子项Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-下午4:15:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/background/subitem")
public class PollingSubitemController extends BaseController{

	@Autowired
	private IPollingSubitemService subitemService;
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
//		return Common.BACKGROUND_PATH+"/subitem/list";
//	}
//	
//	/**
//	 * @param model
//	 * 存放返回界面的model
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("query")
//	public PageView query(PollingSubitem subitem,String pageNow,String pagesize) {
//		pageView = subitemService.query(getPageView(pageNow,pagesize), subitem);
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
//	public Map<String, Object> add(PollingSubitem subitem) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			subitemService.insert(subitem);
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
//		return Common.BACKGROUND_PATH+"/subitem/add";
//	}
//	/**
//	 * 跑到编辑界面
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("editUI")
//	public String editUI(Model model,String id) {
//		PollingSubitem subitem = subitemService.selectByPrimaryKey(id);
//		model.addAttribute("subitem", subitem);
//		return Common.BACKGROUND_PATH+"/subitem/edit";
//	}
//	/**
//	 *是否存在
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("isExist")
//	@ResponseBody
//	public boolean isExist(PollingSubitem subitem){
//		PollingSubitem d = subitemService.isExist(subitem);
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
//					subitemService.deleteByPrimaryKey(string);
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
//	public Map<String, Object> update(Model model, PollingSubitem subitem) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			subitemService.updateByPrimaryKey(subitem);
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}
//	
	/**
	* 获取所有
	* http://localhost:8081/itsm/subitem/getSubitems
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getSubitems")
	@ResponseBody
	public List<PollingSubitem> findAll(){
		return subitemService.selectAll();
	}
	
	/**
	* 根据id获取
	* http://localhost:8081/itsm/subitem/getSubitem
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getSubitem")
	@ResponseBody
	public PollingSubitem findSubitem(String id){
		return subitemService.selectByPrimaryKey(id);
	}
	
	/**
	* 新增
	* http://localhost:8081/itsm/subitem/addSubitem
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "addSubitem")
	@ResponseBody
	public ResponseMessage add(PollingSubitem pollingSubitem) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(subitemService.insert(pollingSubitem));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新
	* http://localhost:8081/itsm/subitem/updateSubitem
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "updateSubitem")
	@ResponseBody
	public ResponseMessage update(PollingSubitem pollingSubitem) {
		try {
			subitemService.updateByPrimaryKey(pollingSubitem);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除
	* http://localhost:8081/itsm/subitem/deleteSubitem
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "deleteSubitem")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			subitemService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
	
}