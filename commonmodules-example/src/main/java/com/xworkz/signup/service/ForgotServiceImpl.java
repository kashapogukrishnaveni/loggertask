package com.xworkz.signup.service;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xworkz.signup.dao.ForgotDAO;
import com.xworkz.signup.dao.SignupDAOImpl;
import com.xworkz.signup.dto.ForgotDTO;
import com.xworkz.signup.entity.SignupEntity;

@Service
public class ForgotServiceImpl implements ForgotService{
	
	private static Logger logger = Logger.getLogger(ForgotServiceImpl.class);
	
	@Autowired
	private ForgotDAO forgotDAO;
	
	public ForgotServiceImpl() {
		logger.info("inside getMessage()....of"+this.getClass().getSimpleName());
	}

	public boolean validateForgotPassword(ForgotDTO forgotDTO) {
		boolean valid = false;
	try {
		System.out.println(" invoked validateForgot....");

		if (Objects.nonNull(forgotDTO)) {
			System.out.println("starting validation for " + forgotDTO);

			String email = forgotDTO.getEmail();

			if (email != null && email.contains("@") && email.length() >= 10) {
				System.out.println("email is valid");
				  valid = true;
				  
			} else {
				System.out.println("email is invalid");
					valid = false;
				}
			}
		
		String password = forgotDTO.getPassword();

		if (password != null && password.isEmpty() && password.length() >= 6) {
			System.out.println("password is valid");
			  valid = true;
			  
		} else {
			System.out.println("password is invalid");
				valid = false;
			}
		
	String conformpassword = forgotDTO.getEmail();

	if (conformpassword != null && conformpassword.isEmpty() && conformpassword.length() >= 6) {
		System.out.println("conformpassword is valid");
		  valid = true;
		  
	} else {
		System.out.println("conformpassword is invalid");
			valid = false;
		}
	
		
		if (valid) {
			System.out.println("email is valid");

			SignupEntity signupEntity = new SignupEntity();
			BeanUtils.copyProperties(forgotDTO, signupEntity);

			SignupEntity signupEntity2 = forgotDAO.fetchByEmail( forgotDTO.getPassword(),forgotDTO.getEmail());

			//if (signupEntity2 == null && signupEntity1 == null)
			if (signupEntity2 == null) {
				System.out.println("Entity is ready \t" + signupEntity);

			} else {
				System.out.println("Email is not valid");
				}
			}
	
			
		}  catch(NumberFormatException e) {
			logger.error("-->Exception occured");
		}
		return valid;

	}

	
	public String validateForgot(ForgotDTO forgotDTO) {
		
		SignupEntity signupEntity = new SignupEntity();
		//BeanUtils.copyProperties(forgotDTO, signupEntity);
		SignupEntity signupEntity1 = forgotDAO.fetchByEmail(forgotDTO.getEmail(), forgotDTO.getPassword());
		
		//SignupEntity signupEntity2 = forgotDAO.updatePasswordByEmail(forgotDTO.getPassword(), forgotDTO.getEmail());
		//if(signupEntity2 == null && signupEntity1 == null) {
			if(Objects.nonNull(signupEntity1)) {
				
				System.out.println("Entity is exist"+signupEntity1);
			} else {
				
				System.out.println("Entity not found");
			}

		return null;
	}		
}

