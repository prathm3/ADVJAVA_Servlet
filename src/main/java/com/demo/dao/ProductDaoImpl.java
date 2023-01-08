package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao {
	
	static Connection con;
	static PreparedStatement pget, padd, pdel, pgetByid;
	static {
		con = DBUtil.getMyConnection();
		try {
			pget = con.prepareStatement("select * from product");
			padd = con.prepareStatement("insert into product values(?,?,?,?)");
			pdel = con.prepareStatement("delete from product where pid=?");
			pgetByid = con.prepareStatement("select * from product where pid=?");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}


	@Override
	public List<Product> getProducts() {
		List<Product> plist = new ArrayList<Product>();
		ResultSet rs;
		try {
			rs = pget.executeQuery();
			while(rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
				plist.add(p);
			}
			if(plist.size() > 0) return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public void add(int pid, String pname, int qty, double price) {
		// TODO Auto-generated method stub
		try {
			padd.setInt(1, pid);
			padd.setString(2, pname);
			padd.setInt(3, qty);
			padd.setDouble(4, price);
			padd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		try {
			pdel.setInt(1, pid);
			pdel.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@Override
	public Product getProduct(int pid) {
		try {
			pgetByid.setInt(1, pid);
			ResultSet rs = pgetByid.executeQuery();
			if(rs.next()) 
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;
	}

}
