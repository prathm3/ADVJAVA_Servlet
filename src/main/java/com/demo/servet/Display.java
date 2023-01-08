package com.demo.servet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
 * Servlet implementation class Display
 */
@WebServlet("/display")
public class Display extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		ProductService pservice = new ProductServicImpl();
		List<Product> plist = pservice.getAllProducts();
		User u = (User) request.getAttribute("user");
		if(u == null) {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);
		}
		out.println("<a href='add.html'>Add Product</a>");
		out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>qty</th>");
		out.println("<th>price</th><th>cid</th><th>operations</th></tr>");
		for(Product p :plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>");
			out.println("<td><a href='delete?pid="+p.getPid()+"'>delete</a> / <a href='edit?pid="+p.getPid()+"'>edit</a></td></tr>");
		}
		out.println("</table>");
		
		
	}

	

}
