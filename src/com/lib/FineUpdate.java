package com.lib;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ShowFinesDAO;
import com.vo.TotalFine;

/**
 * Servlet implementation class FineUpdate
 */
@WebServlet("/FineUpdate")
public class FineUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FineUpdate() {
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
		String select[] = request.getParameterValues("mailId"); 
		for(int i=0;i<select.length;i++){
			System.out.println(select[i]);
		}
		rd.updateFines(select);
	//	HttpSession session = request.getSession();
	//	session.setAttribute("tfal", tfal);
		 request.getRequestDispatcher("/LibraryFines.jsp").include(request, response);
	}

}
