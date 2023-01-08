package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	List<Product> getProducts();

	void add(int pid, String pname, int qty, double price);

	void delete(int pid);

	Product getProduct(int pid);

}
