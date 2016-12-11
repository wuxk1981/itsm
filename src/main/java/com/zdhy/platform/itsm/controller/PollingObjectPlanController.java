package com.zdhy.platform.itsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.PollingObjectPlan;
import com.zdhy.platform.itsm.service.IPollingObjectPlanService;

/**
 * 功能:巡检对象计划关联Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-下午4:30:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/background/objectPlan")
public class PollingObjectPlanController extends BaseController {

	@Autowired
	private IPollingObjectPlanService objectPlanService;
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
//		return Common.BACKGROUND_PATH+"/objectPlan/list";
//	}
//	
//	/**
//	 * @param model
//	 * 存放返回界面的model
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("query")
//	public PageView query(PollingObjectPlan objectPlan,String pageNow,String pagesize) {
//		pageView = objectPlanService.query(getPageView(pageNow,pagesize), objectPlan);
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
//	public Map<String, Object> add(PollingObjectPlan objectPlan) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			objectPlanService.insert(objectPlan);
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
//		return Common.BACKGROUND_PATH+"/objectPlan/add";
//	}
//	/**
//	 * 跑到编辑界面
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("editUI")
//	public String editUI(Model model,String id) {
//		PollingObjectPlan objectPlan = objectPlanService.selectByPrimaryKey(id);
//		model.addAttribute("objectPlan", objectPlan);
//		return Common.BACKGROUND_PATH+"/objectPlan/edit";
//	}
//	/**
//	 *是否存在
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("isExist")
//	@ResponseBody
//	public boolean isExist(PollingObjectPlan objectPlan){
//		PollingObjectPlan d = objectPlanService.isExist(objectPlan);
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
//					objectPlanService.deleteByPrimaryKey(string);
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
//	public Map<String, Object> update(Model model, PollingObjectPlan objectPlan) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			objectPlanService.updateByPrimaryKey(objectPlan);
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}	
	/**
	* 获取所有
	* http://localhost:8081/itsm/objectPlan/getObjectPlans
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getObjectPlans")
	@ResponseBody
	public List<PollingObjectPlan> findAll(){
		return objectPlanService.selectAll();
	}
	
	/**
	* 根据id获取
	* http://localhost:8081/itsm/objectPlan/getObjectPlan
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getObjectPlan")
	@ResponseBody
	public PollingObjectPlan findObjectPlan(String id){
		return objectPlanService.selectByPrimaryKey(id);
	}
	
	/**
	* 新增
	* http://localhost:8081/itsm/objectPlan/addObjectPlan
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "addObjectPlan")
	@ResponseBody
	public ResponseMessage add(PollingObjectPlan pollingObjectPlan) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(objectPlanService.insert(pollingObjectPlan));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新
	* http://localhost:8081/itsm/objectPlan/updateObjectPlan
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "updateObjectPlan")
	@ResponseBody
	public ResponseMessage update(PollingObjectPlan pollingObjectPlan)
	{
		try
		{
			objectPlanService.updateByPrimaryKey(pollingObjectPlan);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseMessage(1,"更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除
	* http://localhost:8081/itsm/objectPlan/deleteObjectPlan
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "deleteObjectPlan")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			objectPlanService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
	
}

