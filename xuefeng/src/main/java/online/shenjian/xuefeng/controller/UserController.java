package online.shenjian.xuefeng.controller;


import online.shenjian.xuefeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
