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
				model.addAttribute("鍐呴儴閿欒锛岃鑱旂郴绠＄悊鍛橈紒");
				return "redirect:/fail.jsp";
			}
		} catch (Throwable e) {
			model.addAttribute("鍐呴儴閿欒锛岃鑱旂郴绠＄悊鍛橈紒");
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
	    		model.addAttribute("LOGIN_FAIL", "鐧婚檰澶辫触浜�,璇烽噸鏂扮櫥闄�");
	    		return "forward:toLogin";
	    	}
	    	if(session.getAttribute("USER")!=null) {
	    		//璺宠浆鍒癷ndex椤甸潰
	    	}else {
	    		session.setAttribute("USER", user);
	    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return "redirect:/findHotNewProduct";
	}
    
    @RequestMapping("logout")
    public String logout(HttpSession session) {
    	if(session !=null) {
    		session.invalidate();
    	}
    	return "forward:toLogin";
    }
    

}
