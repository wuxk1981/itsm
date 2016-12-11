package com.zdhy.platform.itsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.Shift;
import com.zdhy.platform.itsm.service.IShiftService;

/**
 * 功能:班次Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月22日-下午3:00:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/shift")
public class ShiftController {

	@Autowired
	private IShiftService shiftService;
	
	/**
	* 获取所有
	* http://localhost:8081/itsm/shift/getShifts
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getShifts")
	@ResponseBody
	public List<Shift> findAll(){
		return shiftService.selectAll();
	}
	
	/**
	* 根据id获取
	* http://localhost:8081/itsm/shift/getShift
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getShift")
	@ResponseBody
	public Shift findShift(String id){
		return shiftService.selectByPrimaryKey(id);
	}
	
	/**
	* 新增
	* http://localhost:8081/itsm/shift/addShift
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "addShift")
	@ResponseBody
	public ResponseMessage add(Shift shift) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(shiftService.insert(shift));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新
	* http://localhost:8081/itsm/shift/updateShift
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "updateShift")
	@ResponseBody
	public ResponseMessage update(Shift shift) {
		try {
			shiftService.updateByPrimaryKey(shift);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除
	* http://localhost:8081/itsm/shift/deleteShift
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "deleteShift")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			shiftService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
	/**
	* 查询班次下的排班
	* http://localhost:8081/itsm/shift/listSchedulings
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "listSchedulings")
	@ResponseBody
	public Shift listSchedulings(String shiftId){
		return shiftService.listSchedulingsByShiftId(shiftId);
	}
}

