package com.dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vo.Book;
import com.vo.TotalFine;

/**
 * Servlet implementation class ShowFines
 */
@WebServlet("/ShowFines")
public class ShowFines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFines() {
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
		ShowFinesDAO rd=new ShowFinesDAO();
		ArrayList<TotalFine> tfal=rd.retrivedetails();
		HttpSession session = request.getSession();
		session.setAttribute("tfal", tfal);
		 request.getRequestDispatcher("/LibraryFines.jsp").include(request, response);

}
	
}
