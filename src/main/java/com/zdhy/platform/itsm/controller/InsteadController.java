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
import com.zdhy.platform.itsm.entity.Instead;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.IInsteadService;

/**
 * 功能:替班Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月22日-下午2:03:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/instead")
public class InsteadController extends BaseController{

	@Autowired
	private IInsteadService insteadService;
	
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
		return Common.BACKGROUND_PATH+"/instead/list";
	}
	
	/**
	 * 功能:值班管理界面多条件查询
	 * @param paramMap
	 * http://localhost:8081/itsm/instead/query
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="query",method = RequestMethod.POST)
	public PageView query(@RequestParam Map<String, Object> paramMap) {
		pageView = insteadService.findByMap(paramMap);
		return pageView;
	}
	
	/**
	 * 功能:个人界面多条件查询
	 * @param staff,paramMap
	 * http://localhost:8081/itsm/instead/queryMyInstead
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="queryMyInstead",method = RequestMethod.POST)
	public PageView queryMyInstead(String staff,@RequestParam Map<String, Object> paramMap) {
		pageView = insteadService.findMyInstead(staff,paramMap);
		return pageView;
	}
	/**
	* 根据id获取，查看详情
	* http://localhost:8081/itsm/instead/getInstead
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value ="getInstead",method = RequestMethod.GET)
	@ResponseBody
	public Instead findInstead(String id){
		return insteadService.selectByPrimaryKey(id);
	}
	
	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return Common.BACKGROUND_PATH+"/instead/add";
	}
	
	/**
	*  http://localhost:8081/itsm/instead/add
	* 功能: 新增
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value="add",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> add(Instead instead) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			insteadService.insert(instead);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	
//	/**
//	* 获取所有
//	* http://localhost:8081/itsm/instead/getInsteads
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getInsteads")
//	@ResponseBody
//	public List<Instead> findAll(){
//		return insteadService.selectAll();
//	}
//	
//	/**
//	* 根据id获取
//	* http://localhost:8081/itsm/Instead/getInstead
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getInstead")
//	@ResponseBody
//	public Instead findInstead(String id){
//		return insteadService.selectByPrimaryKey(id);
//	}
//	
//	/**
//	* 新增
//	* http://localhost:8081/itsm/instead/addInstead
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "addInstead")
//	@ResponseBody
//	public ResponseMessage add(Instead instead) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//			message.setEntity(insteadService.insert(instead));
//		} catch (Exception e) {
//			return new ResponseMessage(1, "添加失败！");
//		}
//		return message;
//	}
//	
//	/**
//	* 更新
//	* http://localhost:8081/itsm/instead/updateInstead
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "updateInstead")
//	@ResponseBody
//	public ResponseMessage update(Instead instead)
//	{
//		try
//		{
//			insteadService.updateByPrimaryKey(instead);
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
//	* http://localhost:8081/itsm/instead/deleteInstead
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "deleteInstead")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//			insteadService.deleteByPrimaryKey(id);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "删除失败！");
//		}
//		return new ResponseMessage(0, "删除成功！");
//	}
//	
}

