package com.xworkz.signup.dao;
import com.xworkz.signup.entity.SignupEntity;

public interface ForgotDAO {

	public SignupEntity fetchByEmail(String email,String password);
	//public SignupEntity updatePasswordByEmail(String password, String email);
}

	

