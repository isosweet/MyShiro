package com.springplus.ssh.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("login")
public class LoginController {
	
	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@RequestMapping(value = "doLogin", method = RequestMethod.POST)
	public String doLogin(String userName, String password){
		
		
		logger.info("执行登陆--->" + userName +"  password--->" + password);
		
		return "index";
	}
	
}
