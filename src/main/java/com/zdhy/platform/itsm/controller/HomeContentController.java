package com.zdhy.platform.itsm.controller;


import io.swagger.annotations.Api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdhy.platform.itsm.core.pulgin.mybatis.plugin.PageView;
import com.zdhy.platform.itsm.core.utils.Common;
import com.zdhy.platform.itsm.entity.HomeContent;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.IHomeContentService;

@Api(value = "/homeContent", description = "内容の相关操作")
@Controller
@RequestMapping("/homeContent")
public class HomeContentController extends BaseController{
	
	@Autowired
	private IHomeContentService contentService;
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
		return Common.BACKGROUND_PATH+"/content/list";
	}
	
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query")
	public PageView query(HomeContent content,String pageNow,String pagesize) {
		pageView = contentService.query(getPageView(pageNow,pagesize), content);
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
	public Map<String, Object> add(HomeContent content) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			contentService.insert(content);
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
		return Common.BACKGROUND_PATH+"/content/add";
	}
	/**
	 * 跑到编辑界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model,String id) {
		HomeContent content = contentService.selectByPrimaryKey(id);
		model.addAttribute("content", content);
		return Common.BACKGROUND_PATH+"/content/edit";
	}
	/**
	 *是否存在
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(HomeContent content){
		HomeContent d = contentService.isExist(content);
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
					contentService.deleteByPrimaryKey(string);
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
	public Map<String, Object> update(Model model, HomeContent content) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			contentService.updateByPrimaryKey(content);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}

//	/**
//	* 获取所有内容
//	* http://localhost:8081/itsm/homeContent/getContents
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午11:19:07
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getContents")
//	@ResponseBody
//	public List<HomeContent> findAll(){
//		return service.selectAll();
//	}
//	
//	/**
//	* 根据id获取内容
//	* http://localhost:8081/itsm/homeContent/getContent
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午11:19:07
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getContent")
//	@ResponseBody
//	public HomeContent findContent(String id){
//		return service.selectByPrimaryKey(id);
//	}
//	/**
//	* 新增内容
//	* http://localhost:8081/itsm/homeContent/addContent
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午11:29:07
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "addContent")
//	@ResponseBody
//	public ResponseMessage add(HomeContent homeContent) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//				message.setEntity(service.insert(homeContent));
//			} catch (Exception e) {
//				return new ResponseMessage(1, "添加失败！");
//			}
//		return message;
//	}
//	/**
//	* 更新内容
//	* http://localhost:8081/itsm/homeContent/updateContent
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午11:19:07
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "updateContent")
//	@ResponseBody
//	public ResponseMessage update(HomeContent homeContent) {
//		try {
//			service.updateByPrimaryKey(homeContent);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "更新失败！");
//		}
//		return new ResponseMessage(0, "更新成功！");
//	}
//	
//	/**
//	* 删除内容
//	* http://localhost:8081/itsm/homeContent/deleteContent
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午11:39:07
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "deleteContent")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//			service.deleteByPrimaryKey(id);
//		} catch (Exception e) {
//			return new ResponseMessage(1, "删除失败！");
//		}
//		return new ResponseMessage(0, "删除成功！");
//	}
}