package com.lib;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.RetriveCheckInDAO;

/**
 * Servlet implementation class checkInUpdate
 */
@WebServlet("/checkInUpdate")
public class checkInUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkInUpdate() {
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
		//String searchString=request.getParameter("mailId");
		String select[] = request.getParameterValues("mailId"); 
		//System.out.println(searchString);
		if (select != null && select.length != 0) {
			System.out.println("You have selected: ");
			for (int i = 0; i < select.length; i++) {
			System.out.println(select[i]); 
			}
			RetriveCheckInDAO rd=new RetriveCheckInDAO();
			rd.updateBookLoans(select);
			}
		 request.getRequestDispatcher("/checkIn.jsp").include(request, response);
	}

}
