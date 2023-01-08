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
 * Servlet implementation class DeleteServelt
 */
@WebServlet("/delete")
public class DeleteServelt extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		User u = (User) request.getAttribute("user");
		if(u == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProductService pservice = new ProductServicImpl();
		
		pservice.delete(pid);
		RequestDispatcher rd = request.getRequestDispatcher("display");
		rd.forward(request, response);
	}


}
