package com.zdhy.platform.itsm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.zdhy.platform.itsm.entity.dto.ResponsePage;
import com.zdhy.platform.itsm.entity.page.Channel;
import com.zdhy.platform.itsm.entity.page.Job;
import com.zdhy.platform.itsm.entity.page.Knowledge;
import com.zdhy.platform.itsm.entity.page.SysRunState;
import com.zdhy.platform.itsm.entity.page.Workorder;
import com.zdhy.platform.itsm.service.IHomeTitleService;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月8日-下午8:01:38
 * @version v1.0.0
 */
@Controller
@RequestMapping("/workbench")
public class WorkbenchController {
	
	@Autowired
	private IHomeTitleService service;
	
	/**
	 * 
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月10日-下午3:22:43
	* @version v1.0.0
	 */
	@RequestMapping(value={"/home"},method=RequestMethod.GET)
	public String home() {
		return "/workbench/home";
	}
	
	/**
	 * http://localhost:8081/itsm/workbench/knowledgeDatagrid
	* 功能:知识库数据接口
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月10日-下午3:11:31
	* @version v1.0.0
	 */
	@RequestMapping(value = {"/knowledgeDatagrid"},method=RequestMethod.GET)
	@ResponseBody
	public String list(String userId) {
		List<Knowledge> list = new ArrayList<Knowledge>();
		ResponsePage responsePage = new ResponsePage();
		for(int i=0; i<10;i++){
			Knowledge know = new Knowledge(getUUID(),"知识测试"+i);
			list.add(know);
		}
		responsePage.setRows(list);
		responsePage.setTotal(list.size());
		return JSON.toJSONString(responsePage);
	}
	
	/**
	 * 功能:我的工单 ---未完成工单数据接口
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/unfinishedOrder")
	@ResponseBody
	public String unfinishedOrder(String userId){
		ResponsePage responsePage = new ResponsePage();
		List<Workorder> list = new ArrayList<Workorder>();
		for(int i=0; i<10;i++){
			Workorder workorder = new Workorder();
			workorder.setId(getUUID());
			workorder.setTitle("系统无法访问"+i);
			workorder.setStatus("已响应"+i);
			workorder.setCreateDate("2016-11-10 15:20:20");
			workorder.setHandleMan("张三"+i);
			list.add(workorder);
		}
		responsePage.setRows(list);
		responsePage.setTotal(list.size());
		return JSON.toJSONString(responsePage);
	}	
	
	/**
	 * 功能:我的工单 ---已完成工单数据接口
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/completedOrder")
	@ResponseBody
	public String completedOrder(String userId){
		ResponsePage responsePage = new ResponsePage();
		List<Workorder> list = new ArrayList<Workorder>();
		int count = 10;
		for(int i=0; i<count;i++){
			Workorder order = new Workorder();
			order.setId(getUUID());
			order.setTitle("系统无法访问"+i);
			order.setStatus("已响应"+i);
			order.setCreateDate("2016-11-10 15:20:20");
			order.setHandleMan("张三"+i);
			list.add(order);
		}
		responsePage.setRows(list);
		responsePage.setTotal(list.size());
		return JSON.toJSONString(responsePage);
	}
	
	/**
	 * http://localhost:8081/itsm/workbench/jobDatagrid
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月10日-下午4:54:10
	* @version v1.0.0
	 */
	
	/**
	 * 功能:我的任务 ---待办工单数据接口
	 * @return
	 */
	@RequestMapping(value = "/backlogOrder")
	@ResponseBody
	public String backlogOrder(){
		ResponsePage responsePage = new ResponsePage();
		List<Job> list = new ArrayList<Job>();
		int count = 10;
		for(int i=0; i<count;i++){
			Job job = new Job();
			job.setId(getUUID());
			job.setTitle("系统无法访问"+i);
			job.setStatus("已响应"+i);
			job.setCreateDate("2016-11-10 15:20:20");
			job.setCategory("事件工单"+i);
			list.add(job);
		}
		responsePage.setRows(list);
		responsePage.setTotal(list.size());
		return JSON.toJSONString(responsePage);
	}
	
	/**
	 * 我的任务 ---超时工单数据接口
	 * @return
	 */
	@RequestMapping(value = "/timeoutOrder")
	@ResponseBody
	public String timeoutOrder(){
		ResponsePage responsePage = new ResponsePage();
		List<Job> list = new ArrayList<Job>();
		int count = 10;
		for(int i=0; i<count;i++){
			Job job = new Job();
			job.setId(getUUID());
			job.setTitle("系统无法访问"+i);
			job.setStatus("已响应"+i);
			job.setCreateDate("2016-11-10 15:20:20");
			job.setCategory("事件工单"+i);
			list.add(job);
		}
		responsePage.setRows(list);
		responsePage.setTotal(list.size());
		return JSON.toJSONString(responsePage);
	}
	/**
	 * http:http://localhost:8081/itsm/workbench/channelDatagrid
	* 功能: 快速通道 数据接口
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月10日-下午4:54:10
	* @version v1.0.0
	 */
	@RequestMapping(value = "/channelDatagrid")
	@ResponseBody
	public String listChannel(String UserId) {
		ResponsePage responsePage = new ResponsePage();
		List<Channel> list = new ArrayList<Channel>();
		for(int i=0; i<10;i++){
			Channel channel = new Channel(String.valueOf(i+1),"新建事件"+i);
			list.add(channel);
		}
		responsePage.setRows(list);
		responsePage.setTotal(list.size());
		return JSON.toJSONString(responsePage);
	}
	
	/**
	 * http:http://localhost:8081/itsm/workbench/sysRunStateDatagrid
	* 功能: 服务器状态数据接口
	* @return
	* 创建人： 袁乐乐
	* 时间： 2016年11月10日-下午6:44:10
	* @version v1.0.0
	 */
	@RequestMapping(value = "/sysRunStateDatagrid")
	@ResponseBody
	public String sysRunStateDatagrid(){
			ResponsePage responsePage = new ResponsePage();
			List<SysRunState> list = new ArrayList<SysRunState>();
			int count = 10;
			for(int i=0; i<count;i++){
				SysRunState state = new SysRunState();
				state.setId(getUUID());
				state.setName("OA服务器"+i);
				state.setStatus("正常");
				list.add(state);
			}
			responsePage.setRows(list);
			responsePage.setTotal(list.size());
			return JSON.toJSONString(responsePage);
		}
	
	private String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}

