package com.demo.service;

import com.demo.beans.User;

public interface LoginService {

	User validate(String uname, String pass);

}
