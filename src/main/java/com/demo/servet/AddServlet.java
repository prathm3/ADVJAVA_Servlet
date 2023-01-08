package com.demo.servet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.User;
import com.demo.service.ProductServicImpl;
import com.demo.service.ProductService;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = (User) request.getAttribute("user");
		if(u == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		int pid = Integer.parseInt(request.getParameter("pid"));
		String pname = request.getParameter("pname");
		int qty = Integer.parseInt(request.getParameter("qty"));
		double price =Double.parseDouble(request.getParameter("price"));
		ProductService pservice = new ProductServicImpl();
		
		pservice.addProduct(pid, pname, qty, price);
		RequestDispatcher rd = request.getRequestDispatcher("display");
		rd.forward(request, response);
	}

}
