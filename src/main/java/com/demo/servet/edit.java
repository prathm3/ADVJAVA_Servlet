package com.demo.servet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.service.ProductServicImpl;
import com.demo.service.ProductService;

/**
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User u = (User) request.getAttribute("user");
		if(u == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		int id=Integer.parseInt(request.getParameter("pid"));
		ProductService pservice=new ProductServicImpl();
		Product p=pservice.getById(id);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		out.println("<form action='add' method='post'> ");



		out.println("Product Id: <input type='text' name='pid' id='pid' value='"+p.getPid()+"' readonly><br> ");

		out.println("Product name: <input type='text' name='pname' id='pname' value='"+p.getPname()+"'><br> ");

		out.println("Product qty: <input type='text' name='qty' id='qty' value='"+p.getQty()+"'><br> ");

		out.println("Product price: <input type='text' name='price' id='price' value='"+p.getPrice()+"'> <br>");


		out.println("<button type='submit' name='btn' id='btn' value='update'>Update Product</button> ");

		out.print("</form>");
	}

	

}
