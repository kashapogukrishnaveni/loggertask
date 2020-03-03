package com.xworkz.signup.controller;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.signup.dto.ForgotDTO;
import com.xworkz.signup.service.ForgotService;

@Controller
public class ForgotController {
	
	private static Logger logger = Logger.getLogger(ForgotController.class);
	
	@Autowired
	private ForgotService forgotService;

	public ForgotController() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	@RequestMapping("Forgot.do")
	public String onForgot(ForgotDTO forgotDTO,ModelMap map) {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
		
		logger.warn("warn message --> inside getMessage()....");
		logger.error("error message --> inside getMessage()....");
		logger.fatal("fatal message --> inside getMessage()....");
		
	try {
		System.out.println("Invoked onForgot method");
		System.out.println(forgotDTO);

		 String check = this.forgotService.validateForgot(forgotDTO);
		 boolean check1 = this.forgotService.validateForgotPassword(forgotDTO);
			if (check1) {
			  ModelMap email = map.addAttribute("Forgot", "Email is valid");
			  ModelMap password = map.addAttribute("Forgot", "Email is valid");
			  
			} else { 
				ModelMap failure = map.addAttribute("Forgot","Email Invalid"); }
			 	
		} catch(NumberFormatException e) {
			logger.error("-->Exception occured");
		}

		return "Forgot";
	}
}



