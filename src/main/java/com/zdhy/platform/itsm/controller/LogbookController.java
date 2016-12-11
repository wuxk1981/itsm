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
import com.zdhy.platform.itsm.entity.Logbook;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.ILogbookService;

/**
 * 功能:值班日志Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月22日-下午2:30:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/logbook")
public class LogbookController extends BaseController{

	@Autowired
	private ILogbookService logbookService;

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
		return Common.BACKGROUND_PATH+"/logbook/list";
	}
	
	/**
	 * 功能:值班管理界面多条件查询
	 * http://localhost:8081/itsm/logbook/query
	 * @param paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="query",method = RequestMethod.POST)
	public PageView query(@RequestParam Map<String, Object> paramMap) {
		pageView = logbookService.findByMap(paramMap);
		return pageView;
	}
	/**
	 * 功能:个人界面多条件查询
	 * http://localhost:8081/itsm/logbook/queryMyLogbook
	 * @param staff,paramMap
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryMyLogbook",method = RequestMethod.POST)
	public PageView queryMyLogbook(String staff,@RequestParam Map<String, Object> paramMap) {
		pageView = logbookService.findMyLogbook(staff,paramMap);
		return pageView;
	}
	
	/**
	* 根据id获取，查看详情
	* http://localhost:8081/itsm/logbook/getLogbook
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getLogbook")
	@ResponseBody
	public Logbook findLogbook(String id){
		return logbookService.selectByPrimaryKey(id);
	}
	
	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return Common.BACKGROUND_PATH+"/logbook/add";
	}
	
	/**
	* 新增
	* 
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value="add",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(Logbook logbook) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			logbookService.insert(logbook);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	
	/**
	 * 跑到编辑界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model,String id) {
		Logbook logbook = logbookService.selectByPrimaryKey(id);
		model.addAttribute("logbook", logbook);
		return Common.BACKGROUND_PATH+"/logbook/edit";
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
					logbookService.deleteByPrimaryKey(string);
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
	public Map<String, Object> update(Model model, Logbook logbook) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			logbookService.updateByPrimaryKey(logbook);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}

//	/**
//	* 获取所有
//	* http://localhost:8081/itsm/logbook/getLogbooks
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getLogbooks")
//	@ResponseBody
//	public List<Logbook> findAll(){
//		return logbookService.selectAll();
//	}
//	
//	/**
//	* 根据id获取
//	* http://localhost:8081/itsm/logbook/getLogbook
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getLogbook")
//	@ResponseBody
//	public Logbook findLogbook(String id){
//		return logbookService.selectByPrimaryKey(id);
//	}
//	
//	/**
//	* 新增
//	* http://localhost:8081/itsm/logbook/addLogbook
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "addLogbook")
//	@ResponseBody
//	public ResponseMessage add(Logbook logbook) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//			message.setEntity(logbookService.insert(logbook));
//		} catch (Exception e) {
//			return new ResponseMessage(1, "添加失败！");
//		}
//		return message;
//	}
//	
//	/**
//	* 更新
//	* http://localhost:8081/itsm/logbook/updateLogbook
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "updateLogbook")
//	@ResponseBody
//	public ResponseMessage update(Logbook logbook)
//	{
//		try
//		{
//			logbookService.updateByPrimaryKey(logbook);
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			return new ResponseMessage(1,"更新失败！");
//		}
//		return new ResponseMessage(0, "更新成功！");
//	}
//	
//	/**
//	* 删除
//	* http://localhost:8081/itsm/logbook/deleteLogbook
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "deleteLogbook")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//			logbookService.deleteByPrimaryKey(id);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "删除失败！");
//		}
//		return new ResponseMessage(0, "删除成功！");
//	}
//	
}

