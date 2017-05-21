package com.springplus.ssh.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springplus.ssh.model.ActiveUser;
import com.springplus.ssh.service.AuthorizeService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	private AuthorizeService authorizeService;
	
	@RequestMapping(value = "doLogin")
	public String doLogin(HttpServletRequest request, String userName, String password){
		ActiveUser activeUser = null;
		try {
			activeUser = authorizeService.authentication(userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("activeUser", activeUser);
		
		return "index";
	}
	
}
