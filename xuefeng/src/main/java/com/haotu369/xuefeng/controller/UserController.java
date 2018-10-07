package com.haotu369.xuefeng.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haotu369.xuefeng.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**获取用户信息**/
	//沈健 5.15
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String getUser(Model model){	
		model.addAttribute("user",userService.getUser());
		return "index";
	}
	
}
