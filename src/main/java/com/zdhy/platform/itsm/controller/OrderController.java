package com.zdhy.platform.itsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.Order;
import com.zdhy.platform.itsm.service.IOrderService;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月14日-下午6:17:11
 * @version v1.0.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService service;
	@RequestMapping("/manager")
	public String manager(){
		return "workbench/order";
	}

	/**
	* 获取所有工单
	* http://localhost:8081/itsm/order/getOrders
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月15日-上午9:19:07
	* @version v1.0.0
	 */
	@RequestMapping("/getOrders")
	@ResponseBody
	public List<Order> list(){
		List<Order> list = service.selectAll();
		return list;
	}
	
	/**
	* 根据id查找工单
	* http://localhost:8081/itsm/order/searchOrder
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月15日-上午9:25:07
	* @version v1.0.0
	 */
	@RequestMapping("/searchOrder")
	@ResponseBody
	public Order searchById(String id){
		return service.selectByPrimaryKey(id);
	}
	
	/**
	* 新增工单
	* http://localhost:8081/itsm/order/addOrder
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月15日-上午9:30:07
	* @version v1.0.0
	 */
	@RequestMapping("/addOrder")
	@ResponseBody
	public ResponseMessage add(Order order) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(service.insert(order));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新工单
	* http://localhost:8081/itsm/order/updateOrder
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月15日-上午9:35:37
	* @version v1.0.0
	 */
	@RequestMapping("/updateOrder")
	@ResponseBody
	public ResponseMessage update(Order order)
	{
		try
		{
			service.updateByPrimaryKey(order);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return new ResponseMessage(1,"更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除工单
	* http://localhost:8081/itsm/order/deleteOrder
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月15日-上午9:45:37
	* @version v1.0.0
	 */
	@RequestMapping("/deleteOrder")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			service.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
}

