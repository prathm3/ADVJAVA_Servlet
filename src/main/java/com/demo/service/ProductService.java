package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void addProduct(int pid, String pname, int qty, double  price);

	void delete(int pid);

	Product getById(int id);

}
