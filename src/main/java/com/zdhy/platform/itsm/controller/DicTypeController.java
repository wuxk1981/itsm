package com.zdhy.platform.itsm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.Common;
import com.zdhy.platform.itsm.entity.DicType;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.IDicTypeService;

/**
 * 
 * @author lanyuan
 * 2013-11-19
 * @Email: mmm333zzz520@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/dicType/")
public class DicTypeController extends BaseController{
	@Inject
	private IDicTypeService dicTypeService;
	
	@RequestMapping("list")
	public String list(Model model, Resources menu, String pageNow) {
		return Common.BACKGROUND_PATH+"/dicType/list";
	}
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query")
	public PageView query(DicType dicType,String pageNow,String pagesize) {
		pageView = dicTypeService.query(getPageView(pageNow,pagesize), dicType);
		return pageView;
	}
	
	/**
	 * 获取未科组匹配账号
	 * @param account
	 * @param pageNow
	 * @param pagesize
	 * @return
	 */
//	@ResponseBody
//	@RequestMapping("queryNoMatch")
//	public PageView queryNoMatch(DicType dicType,String pageNow,String pagesize) {
//		pageView = dicTypeService.queryNoMatch(dicType, getPageView(pageNow,pagesize));
//		return pageView;
//	}
	
	/**
	 * 保存数据
	 * 
	 * @param model
	 * @param videoType
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("add")
	@ResponseBody
	public Map<String, Object> add(DicType dicType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			dicTypeService.insert(dicType);
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
		return Common.BACKGROUND_PATH+"/dicType/add";
	}
	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model,String id) {
		DicType dicType = dicTypeService.selectByPrimaryKey(id);
		model.addAttribute("dicType", dicType);
		return Common.BACKGROUND_PATH+"/dicType/edit";
	}
	
	/**
	 * @author lanyuan
	 * Email：mmm333zzz520@163.com
	 * date：2014-2-19
	 * @param DicType dicType
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(DicType dicType){
		DicType dt = dicTypeService.isExist(dicType);
		if(dt == null){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 删除
	 * 
	 * @param model
	 * @param videoTypeId
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
					dicTypeService.deleteByPrimaryKey(string);
				}
			}
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	/**
	 * 删除
	 * 
	 * @param model
	 * @param videoTypeId
	 * @return
	 * @throws Exception 
	 */
//	@ResponseBody
//	@RequestMapping("updateState")
//	public Map<String, Object> updateState(Model model, String ids,String state) {
//		Map<String, Object> map = new HashMap<String, Object>();
//		try {
//			String id[] = ids.split(",");
//			for (String string : id) {
//				if(!Common.isEmpty(string)){
//					Account account = new Account();
//					account.setId(Integer.parseInt(string));
//					account.setState(state);
//					accountService.update(account);
//				}
//			}
//			map.put("flag", "true");
//		} catch (Exception e) {
//			map.put("flag", "false");
//		}
//		return map;
//	}
	/**
	 * 更新类型
	 * 
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("update")
	public Map<String, Object> update(Model model, DicType dicType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			dicTypeService.updateByPrimaryKey(dicType);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping("findDicType")
	public List<DicType> findDicType(Model model, DicType dicType) {
		return dicTypeService.selectAll();
	}
	
	@ResponseBody
	@RequestMapping("findDicTypeDetail")
	public Map<String, Object> findDicTypeDetail(Model model, DicType dicType) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
		    DicType qdicType = dicTypeService.selectByPrimaryKey(dicType.getId());
		    map.put("description", qdicType.getDescription());
		    map.put("id", qdicType.getId());
		} catch (Exception e) {
			
		}
		return map;
		
	}
}