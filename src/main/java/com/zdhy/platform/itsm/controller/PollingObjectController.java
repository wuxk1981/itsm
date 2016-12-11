package com.zdhy.platform.itsm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.bean.easyui.ResponseMessage;
import com.zdhy.platform.itsm.entity.PollingObject;
import com.zdhy.platform.itsm.service.IPollingObjectService;

/**
 * 功能:巡检对象Controller
 * 创建人： 袁乐乐
 * 时间： 2016年11月17日-下午3:53:53
 * @version v1.0.0
 */
@Controller
@RequestMapping("/background/object")
public class PollingObjectController extends BaseController {

	@Autowired
	private IPollingObjectService objectService;
	
	/**
	* 获取所有
	* http://localhost:8081/itsm/object/getObjects
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getObjects")
	@ResponseBody
	public List<PollingObject> findAll(){
		return objectService.selectAll();
	}
	
	/**
	* 根据id获取
	* http://localhost:8081/itsm/object/getObject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping("/getObject")
	@ResponseBody
	public PollingObject findObject(String id){
		return objectService.selectByPrimaryKey(id);
	}
	
	/**
	* 新增
	* http://localhost:8081/itsm/object/addObject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "addObject")
	@ResponseBody
	public ResponseMessage add(PollingObject pollingObject) {
		ResponseMessage message = new ResponseMessage(0, "添加成功！");
		try {
			message.setEntity(objectService.insert(pollingObject));
		} catch (Exception e) {
			return new ResponseMessage(1, "添加失败！");
		}
		return message;
	}
	
	/**
	* 更新
	* http://localhost:8081/itsm/object/updateObject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "updateObject")
	@ResponseBody
	public ResponseMessage update(PollingObject pollingObject) {
		try {
			objectService.updateByPrimaryKey(pollingObject);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseMessage(1, "更新失败！");
		}
		return new ResponseMessage(0, "更新成功！");
	}
	
	/**
	* 删除
	* http://localhost:8081/itsm/object/deleteObject
	* 功能:
	* @return
	* 创建人： 袁乐乐
	* @version v1.0.0
	 */
	@RequestMapping(value = "deleteObject")
	@ResponseBody
	public ResponseMessage delete(String id) {
		try {
			objectService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			return new ResponseMessage(1, "删除失败！");
		}
		return new ResponseMessage(0, "删除成功！");
	}
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
//		return Common.BACKGROUND_PATH+"/object/list";
//	}
//	
//	/**
//	 * @param model
//	 * 存放返回界面的model
//	 * @return
//	 */
//	@ResponseBody
//	@RequestMapping("query")
//	public PageView query(PollingObject object,String pageNow,String pagesize) {
//		pageView = objectService.query(getPageView(pageNow,pagesize), object);
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
//	public Map<String, Object> add(PollingObject object) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			objectService.insert(object);
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
//		return Common.BACKGROUND_PATH+"/object/add";
//	}
//	/**
//	 * 跑到编辑界面
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("editUI")
//	public String editUI(Model model,String id) {
//		PollingObject object = objectService.selectByPrimaryKey(id);
//		model.addAttribute("object", object);
//		return Common.BACKGROUND_PATH+"/object/edit";
//	}
//	/**
//	 *是否存在
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("isExist")
//	@ResponseBody
//	public boolean isExist(PollingObject object){
//		PollingObject d = objectService.isExist(object);
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
//					objectService.deleteByPrimaryKey(string);
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
//	public Map<String, Object> update(Model model, PollingObject object) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			objectService.updateByPrimaryKey(object);
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}
		

	
}

