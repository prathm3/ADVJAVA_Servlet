package com.demo.dao;

import com.demo.beans.User;

public interface LoginDao {

	User validate(String uname, String pass);

}
