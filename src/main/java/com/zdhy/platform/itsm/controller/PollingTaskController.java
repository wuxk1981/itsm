package com.zdhy.platform.itsm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.service.IPollingTaskService;

/**
 * 功能:巡检任务控制器
 * 创建人： 袁乐乐
 * 时间： 2016年11月28日-下午3:15:47
 * @version v1.0.0
 */
@Controller
@RequestMapping("")
public class PollingTaskController extends BaseController{
	
	@Autowired
	private IPollingTaskService pollingTaskService;
	
	@RequestMapping("")
	@ResponseBody
	public PageView query(Map<String, Object> paramMap) {
		return pollingTaskService.findByMap(paramMap);
	}
	

}

