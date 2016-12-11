package com.zdhy.platform.itsm.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdhy.platform.itsm.entity.dto.TreeJson;
import com.zdhy.platform.itsm.service.ICategoryService;

/**   
 * @Title: Controller  
 * @Description: 个人表
 * @author onlineGenerator
 * @date 2016-11-04 12:46:58
 * @version V1.0   
 */
@Controller
@RequestMapping("/categoryController")
public class CategoryController extends BaseController {
	private static final Logger logger = Logger.getLogger(CategoryController.class);

	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value="tree")
	public void listCategorys(HttpServletResponse res) throws IOException{ 
		List<TreeJson> list = categoryService.getCategoryInfo(); 
		String jsonString= JSONArray.fromObject(list).toString(); 
		res.setHeader("Pragma", "No-cache"); 
		res.setHeader("Cache-Control", "no-cache"); 
		res.setCharacterEncoding("UTF-8"); 
		res.getWriter().print(jsonString); 
		res.getWriter().flush(); 
		res.getWriter().close(); 
		}
	@RequestMapping(value="toTreePage")
	public String toTreePage(HttpServletResponse res){
		return "category/toTreePage"; 
		
	}
	
	
}