package com.savargaonkar.MemberWeb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.savargaonkar.MemberDOA.LoginDAO;

/**
 * Servlet implementation class ServletLogin
 */
//@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDAO log;
    private int id;
    private String pass;
    private boolean check;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In login Servlet");
		log = new LoginDAO();
		id = Integer.parseInt(request.getParameter("id"));
		pass = request.getParameter("password");
		check = log.login(id, pass);
		if(check) {
			System.out.println("In login Positive");
			response.sendRedirect("HomeTree?id=" + id);
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}
