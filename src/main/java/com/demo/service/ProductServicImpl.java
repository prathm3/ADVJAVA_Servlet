package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServicImpl implements ProductService{

	private ProductDao pdao;
	public ProductServicImpl() {
		pdao = new ProductDaoImpl();
	}
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.getProducts();
	}
	@Override
	public void addProduct(int pid, String pname, int qty, double price) {
		// TODO Auto-generated method stub
		pdao.add(pid, pname, qty, price );
		
	}
	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		pdao.delete(pid);
		
	}
	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return pdao.getProduct(id);
	}

}
