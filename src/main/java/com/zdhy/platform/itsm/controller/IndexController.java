package com.zdhy.platform.itsm.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


//@Controller
public class IndexController {
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			HttpSession session,HttpServletRequest req, HttpServletResponse resp,Model m) {
		m.addAttribute("username","吴心宽");
		System.out.println(111111);
		return "login";
	}
	
	
//	@RequestMapping(value="main", method=RequestMethod.GET)
	public String index(HttpServletRequest request,Model m) { 
		return "main";
	}
	
	//@RequestMapping(value="top", method=RequestMethod.GET)
	public String top(HttpServletRequest request,Model m) { 
		//ManageUser systemUser=(ManageUser) request.getSession().getAttribute("systemUser");
		// m.addAttribute("username", systemUser.getUserName());
		m.addAttribute("username","admin");
		return "top";
	}
	
	//@RequestMapping(value="center", method=RequestMethod.GET)
	public String center(HttpServletRequest request,Model m) {
		String type = request.getParameter("type");
		if("workbench".equals(type)){
			m.addAttribute("type", type);
		}
		if("support".equals(type)){
			m.addAttribute("type", type);
		}
		
		return "center";
	}
	
	//@RequestMapping(value="left", method=RequestMethod.GET)
	public String left(HttpServletRequest request,Model m) { 
		return "left";
	}
	
//	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(
			HttpSession session,HttpServletRequest req, HttpServletResponse resp,Model m) {
		return "home";
	}
}
