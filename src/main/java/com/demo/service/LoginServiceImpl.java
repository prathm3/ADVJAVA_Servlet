package com.demo.service;

import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {

	private LoginDao logindao;
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
		logindao = new LoginDaoImpl();
	}
	@Override
	public User validate(String uname, String pass) {
		// TODO Auto-generated method stub
		return logindao.validate(uname, pass);
	}

}
