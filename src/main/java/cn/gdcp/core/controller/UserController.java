package cn.gdcp.core.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.api.io.ServerSession;

import cn.gdcp.core.po.User;
import cn.gdcp.core.service.UserService;

@Controller
@RequestMapping("/user")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public String register(User user, Model model) {
		boolean isRegister;
		try {
			isRegister = this.userService.register(user);
			if (isRegister) {
				return "redirect:/register_ok.jsp";
			} else {
				model.addAttribute("内部错误，请联系管理员！");
				return "redirect:/fail.jsp";
			}
		} catch (Throwable e) {
			model.addAttribute("内部错误，请联系管理员！");
			return "redirect:/fail.jsp";
		}
	}
	
    @RequestMapping("toLogin")
	public String toLogin() {
		return "redirect:/login.jsp";
	}
    
    @RequestMapping("login")
	public String login(String username, String password, HttpSession session, Model model) { 	
    	User user;
		try {
			user = this.userService.login(username, password);
			if(user==null) {
	    		model.addAttribute("LOGIN_FAIL", "登陆失败了,请重新登陆");
	    		return "forward:toLogin";
	    	}
	    	if(session.getAttribute("USER")!=null) {
	    		//跳转到index页面
	    	}else {
	    		session.setAttribute("USER", user);
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "redirect:/product/findHotNewProduct";
	}
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
    	if(session !=null) {
    		session.invalidate();
    	}
    	return "forward:toLogin";
    }
    

}
