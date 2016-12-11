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
import com.zdhy.platform.itsm.entity.PollingPlan;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.IPollingPlanService;

/**
 * 功能:巡检计划Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-下午4:05:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/background/plan")
public class PollingPlanController extends BaseController{

	@Autowired
	private IPollingPlanService planService;
	/**
	* 获取所有
	* http://localhost:8081/itsm/
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("list")
	public String list(Model model, Resources menu, String pageNow) {
		return Common.BACKGROUND_PATH+"/plan/list";
	}
	
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query")
	public PageView query(PollingPlan plan,String pageNow,String pagesize) {
		pageView = planService.query(getPageView(pageNow,pagesize), plan);
		return pageView;
	}
	
	/**
	* 新增
	* 
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(PollingPlan plan) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			planService.insert(plan);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return Common.BACKGROUND_PATH+"/plan/add";
	}
	/**
	 * 跑到编辑界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model,String id) {
		PollingPlan plan = planService.selectByPrimaryKey(id);
		model.addAttribute("plan", plan);
		return Common.BACKGROUND_PATH+"/plan/edit";
	}
	/**
	 *是否存在
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(PollingPlan plan){
		PollingPlan d = planService.isExist(plan);
		if(d == null){
			return true;
		}else{
			return false;
		}
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
					planService.deleteByPrimaryKey(string);
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
	public Map<String, Object> update(Model model, PollingPlan plan) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			planService.updateByPrimaryKey(plan);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
		
//	/**
//	* 获取所有
//	* http://localhost:8081/itsm/plan/getPlans
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getPlans")
//	@ResponseBody
//	public List<PollingPlan> findAll(){
//		return planService.selectAll();
//	}
//	
//	/**
//	* 根据id获取
//	* http://localhost:8081/itsm/plan/getPlan
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getPlan")
//	@ResponseBody
//	public PollingPlan findPlan(String id){
//		return planService.selectByPrimaryKey(id);
//	}
//	
//	/**
//	* 新增
//	* http://localhost:8081/itsm/plan/addPlan
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "addPlan")
//	@ResponseBody
//	public ResponseMessage add(PollingPlan pollingPlan) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//			message.setEntity(planService.insert(pollingPlan));
//		} catch (Exception e) {
//			return new ResponseMessage(1, "添加失败！");
//		}
//		return message;
//	}
//	
//	/**
//	* 更新
//	* http://localhost:8081/itsm/plan/updatePlan
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "updatePlan")
//	@ResponseBody
//	public ResponseMessage update(PollingPlan pollingPlan) {
//		try {
//			planService.updateByPrimaryKey(pollingPlan);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseMessage(1, "更新失败！");
//		}
//		return new ResponseMessage(0, "更新成功！");
//	}
//	
//	/**
//	* 删除
//	* http://localhost:8081/itsm/plan/deletePlan
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "deletePlan")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//			planService.deleteByPrimaryKey(id);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "删除失败！");
//		}
//		return new ResponseMessage(0, "删除成功！");
//	}
//	
//	/**
//	* 根据巡检计划查询调度计划
//	* http://localhost:8081/itsm/plan/findDispatchingPlan
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/findDispatchingPlan")
//	@ResponseBody
//	public PollingPlan findDispatchingPlan(String pollPlanId) {
//		return planService.findDispatchingPlan(pollPlanId);
//	}
}

