package com.zdhy.platform.itsm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.Scheduling;
import com.zdhy.platform.itsm.service.ISchedulingService;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月24日-下午1:44:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/scheduling")
public class SchedulingController {

	@Autowired
	private ISchedulingService schedulingService;
	
	/**
	 * 获取所有
	 * http://localhost:8081/itsm/scheduling/getSchedulings
	 * 功能:
	 * @return
	 * 创建人： 袁乐乐
	 * @version v1.0.0
	 */
	@RequestMapping("/getSchedulings")
	@ResponseBody
	public List<Map<String, Object>> getSchedulings(@RequestParam Map<String, Object> paramMap){
		return schedulingService.showSchedulings(paramMap);
	}
	
	/**
	* 根据id获取
	* http://localhost:8081/itsm/scheduling/getScheduling
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getScheduling")
	@ResponseBody
	public Scheduling findscheduling(String id){
		return schedulingService.selectByPrimaryKey(id);
	}
	
	/**
	* 新增
	* http://localhost:8081/itsm/scheduling/addScheduling
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "addScheduling")
	@ResponseBody
	public ResponseMessage add(Scheduling scheduling) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(schedulingService.insert(scheduling));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新
	* http://localhost:8081/itsm/scheduling/updateScheduling
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "updateScheduling")
	@ResponseBody
	public ResponseMessage update(Scheduling scheduling) {
		try {
			schedulingService.updateByPrimaryKey(scheduling);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除
	* http://localhost:8081/itsm/scheduling/deleteScheduling
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "deleteScheduling")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			schedulingService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
}

