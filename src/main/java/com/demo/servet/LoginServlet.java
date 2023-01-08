package com.demo.servet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LoginService loginservice = new LoginServiceImpl();
		User u = loginservice.validate(uname, pass);
		if(u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			RequestDispatcher rd = request.getRequestDispatcher("display");
			rd.forward(request, response);
		}else {
			out.println("<h6>Invalid Details </h6>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
	}
	
	

}
