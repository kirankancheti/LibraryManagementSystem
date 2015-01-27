package com.lib;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RetriveDetailsDAO;
import com.vo.Book;

/**
 * Servlet implementation class BorrowCheckOut
 */
@WebServlet("/BorrowCheckOut")
public class BorrowCheckOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowCheckOut() {
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
		RetriveDetailsDAO rd=new RetriveDetailsDAO();
		String bookid=request.getParameter("bookid");
		String branchid=request.getParameter("branchid");
		String bocid=request.getParameter("bocid");
		String res=rd.checkOut(bookid, branchid, bocid);
		System.out.println(res);
		
		HttpSession session = request.getSession();
		session.setAttribute("res", res);
		 request.getRequestDispatcher("/checkOut.jsp").include(request, response);
	
	}

}
