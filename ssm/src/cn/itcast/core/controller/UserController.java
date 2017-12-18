package cn.itcast.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.core.pojo.User;
import cn.itcast.core.service.SolrService;
import cn.itcast.core.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private SolrService solrService;
	
	@RequestMapping("/add")
	public String listUser(){
		System.out.println("111");
		return "insert";
	}
	
	@RequestMapping("/insert")
	public String  saveUser(User user) throws Exception{
		userService.saveUser(user);
		
		return "success";
	}
	
	
	
	@RequestMapping("/list")
	public String showList(Model model) throws Exception{
		List<User> userList = solrService.getUserList();
		model.addAttribute("userList", userList);
		return "list";
	}
	

}
