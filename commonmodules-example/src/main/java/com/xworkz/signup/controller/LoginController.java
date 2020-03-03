package com.xworkz.signup.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.signup.dto.LoginDTO;
import com.xworkz.signup.dto.SignupDTO;
import com.xworkz.signup.service.LoginService;
import com.xworkz.signup.service.SignupService;
@Controller
@RequestMapping("/")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;
	
	//PropertyPlaceholderConfigurer
	
	public LoginController() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}
	@RequestMapping("Login.do")
	public String onLogin(LoginDTO loginDTO,ModelMap map) {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
		
		logger.warn("warn message --> inside getMessage()....");
		logger.error("error message --> inside getMessage()....");
		logger.fatal("fatal message --> inside getMessage()....");
		
	try {
		System.out.println("Invoked onLogin method");
		
		boolean check = this.loginService.validateAndSave(loginDTO);
				
		if (check) {
			
			ModelMap Success = map.addAttribute("Success", "Login Successfull");
			
			return "Success";
			
		}else {
			
			ModelMap failure = map.addAttribute("Login", "Login Unsuccessfull");
			
			}
			
		} catch(NumberFormatException e) {
			logger.error("-->Exception occured");
		}
		return "Login";
	}
}


