package com.savargaonkar.MemberWeb;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.savargaonkar.MemberDOA.MemberDAO;

import com.savargaonkar.MemberModel.MemberFamily;




@WebServlet("/HomeTree")
public class ServletFamily extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   // private MemberDAO userDAO;
	//private MemberFamily fam = new MemberFamily();
	public int id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFamily() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		MemberDAO userDAO = new MemberDAO();
		
		id = Integer.parseInt(request.getParameter("id"));
		MemberFamily fam = new MemberFamily(userDAO.GetUser(id));
		
		request.setAttribute("data", fam);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeTree.jsp");
		dispatcher.forward(request, response);
	}
}
