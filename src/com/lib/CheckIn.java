package com.lib;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RetriveCheckInDAO;
import com.vo.Book;
import com.vo.Loans;

/**
 * Servlet implementation class CheckIn
 */
@WebServlet("/CheckIn")
public class CheckIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RetriveCheckInDAO rd=new RetriveCheckInDAO();
		String searchString=request.getParameter("searchstring");
		if(request.getParameter("radios").equalsIgnoreCase("bocid")){
			ArrayList<Loans> lns=rd.retrivedetailsbyCardId(searchString);
			HttpSession session = request.getSession();
			session.setAttribute("loanlist", lns);
			 request.getRequestDispatcher("/checkIn.jsp").include(request, response);
			
	
	}
		else if (request.getParameter("radios").equalsIgnoreCase("bname")){
			ArrayList<Loans> lns=rd.retrivedetailsbyBorrowerName(searchString);
			HttpSession session = request.getSession();
			session.setAttribute("loanlist", lns);
			 request.getRequestDispatcher("/checkIn.jsp").include(request, response);
			
		
			
			
		}
else if (request.getParameter("radios").equalsIgnoreCase("bookid")){
	ArrayList<Loans> lns=rd.retrivedetailsbyBookId(searchString);
	HttpSession session = request.getSession();
	session.setAttribute("loanlist", lns);
	 request.getRequestDispatcher("/checkIn.jsp").include(request, response);
	
	
			
		}
	}

}
