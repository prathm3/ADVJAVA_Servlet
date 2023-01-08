package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao {
	static Connection con;
	static PreparedStatement pval;
	static {
		con = DBUtil.getMyConnection();
		try {
			pval = con.prepareStatement("select * from user where uname=? and pass=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public User validate(String uname, String pass) {
		User u = null;
		try {
			pval.setString(1, uname);
			pval.setString(2, pass);
			ResultSet rs = pval.executeQuery();
			if(rs.next())
				return new User(rs.getString(1), rs.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
