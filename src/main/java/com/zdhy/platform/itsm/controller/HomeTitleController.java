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
import com.zdhy.platform.itsm.entity.HomeTitle;
import com.zdhy.platform.itsm.entity.Resources;
import com.zdhy.platform.itsm.service.IHomeTitleService;

/**
 * 功能:
 * 创建人： 袁乐乐
 * 时间： 2016年11月8日-下午8:01:38
 * @version v1.0.0
 */
@Api(value = "/homeTitle", description = "标题の相关操作")
@Controller
@RequestMapping("/homeTitle")
public class HomeTitleController extends BaseController{
	
	@Autowired
	private IHomeTitleService titleService;
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
		return Common.BACKGROUND_PATH+"/title/list";
	}
	
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@ResponseBody
	@RequestMapping("query")
	public PageView query(HomeTitle title,String pageNow,String pagesize) {
		pageView = titleService.query(getPageView(pageNow,pagesize), title);
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
	public Map<String, Object> add(HomeTitle title) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			titleService.insert(title);
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
		return Common.BACKGROUND_PATH+"/title/add";
	}
	/**
	 * 跑到编辑界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("editUI")
	public String editUI(Model model,String id) {
		HomeTitle title = titleService.selectByPrimaryKey(id);
		model.addAttribute("title", title);
		return Common.BACKGROUND_PATH+"/title/edit";
	}
	/**
	 *是否存在
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("isExist")
	@ResponseBody
	public boolean isExist(HomeTitle title){
		HomeTitle d = titleService.isExist(title);
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
					titleService.deleteByPrimaryKey(string);
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
	public Map<String, Object> update(Model model, HomeTitle title) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			titleService.updateByPrimaryKey(title);
			map.put("flag", "true");
		} catch (Exception e) {
			map.put("flag", "false");
		}
		return map;
	}

//  /**
//	* 获取所有标题
//	* http://localhost:8081/itsm/homeTitle/getTitles
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月10日-下午2:39:07
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getTitles")
//	@ResponseBody
//	public List<HomeTitle> findAll(){
//		return homeTitleService.selectAll();
//	}
//	
//	/**
//	* 根据id获取标题
//	* http://localhost:8081/itsm/homeTitle/getTitle
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月10日-下午2:39:07
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getTitle")
//	@ResponseBody
//	public HomeTitle findTitle(String id){
//		return homeTitleService.selectByPrimaryKey(id);
//	}
//	
//	/**
//	* 根据标题查找内容
//	* http://localhost:8081/itsm/homeTitle/getContentList
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月10日-上午10:29:07
//	* @version v1.0.0
//	 */
//
//	@RequestMapping("/titleCascade")
//	@ResponseBody
//	public HomeTitle titleCascade(@RequestParam(value="id", required=true) String titleId){
//		HomeTitle title = homeTitleService.findTitleByPKCascade(titleId);
//		return title;
//	}
//	@RequestMapping("/titleCascadePage")
//	public String titleCascade2(@RequestParam(value="id", required=true) String titleId,ModelMap modelMap){
//		HomeTitle title = homeTitleService.findTitleByPKCascade(titleId);
//		modelMap.addAttribute("title", title);
//		return "workbench/titleCascadePage";
//	}
//	
//	/**
//	* 根据标题查找前十条内容
//	* http://localhost:8081/itsm/homeTitle/getTopTenContentList
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月10日-上午10:29:07
//	* @version v1.0.0
//	 */
//	@RequestMapping("/getTopTenContentList")
//	@ResponseBody
//	public List<HomeContent> getTopTenContentList(String hpsId){
//		List<HomeContent> lists = homeTitleService.listTopTenContentsByTitleId(hpsId);
//		return lists;
//	}
//	/**
//	* 新增标题
//	* http://localhost:8081/itsm/homeTitle/addTitle
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午10:39:07
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "addTitle")
//	@ResponseBody
//	public ResponseMessage add(HomeTitle homeTitle) {
//		ResponseMessage message = new ResponseMessage(0, "添加成功！");
//		try {
//				message.setEntity(homeTitleService.insert(homeTitle));
//			} catch (Exception e) {
//				return new ResponseMessage(1, "添加失败！");
//			}
//		return message;
//	}
//	
//	/**
//	* 更新标题
//	* http://localhost:8081/itsm/homeTitle/updateTitle
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午10:43:07
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "updateTitle")
//	@ResponseBody
//	public ResponseMessage update(HomeTitle homeTitle)
//	{
//		try
//		{
//				homeTitleService.updateByPrimaryKey(homeTitle);
//			} catch (Exception e) {
//				e.printStackTrace();
//				return new ResponseMessage(1,"更新失败！");
//			}
//		return new ResponseMessage(0, "更新成功！");
//	}
//	
//	/**
//	* 删除标题
//	* http://localhost:8081/itsm/homeTitle/deleteTitle
//	* 功能:
//	* @return
//	* 创建人： 袁乐乐
//	* 时间： 2016年11月11日-上午10:49:07
//	* @version v1.0.0
//	 */
//	@RequestMapping(value = "deleteTitle")
//	@ResponseBody
//	public ResponseMessage delete(String id) {
//		try {
//				homeTitleService.deleteByPrimaryKey(id);
//			} catch (Exception e) {
//				return new ResponseMessage(1, "删除失败！");
//			}
//		return new ResponseMessage(0, "删除成功！");
//	}
}