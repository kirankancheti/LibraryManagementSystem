package com.lib;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BorrowerUpdateDAO;

/**
 * Servlet implementation class BorrowerManagement
 */
@WebServlet("/BorrowerManagement")
public class BorrowerManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowerManagement() {
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
		String fname=request.getParameter("fname").trim();
		String lname=request.getParameter("lname").trim();
		String address=request.getParameter("address").trim();
		String phone=request.getParameter("phone").trim();
		String msg="";
		BorrowerUpdateDAO bud=new BorrowerUpdateDAO();
		if(!(fname.isEmpty()||lname.isEmpty()
				||address.isEmpty()||phone.isEmpty())){
		 msg=bud.updateBorrower(fname,lname,address,phone);
		}
		else{
		msg="CANNOT INSERT NULL VALUES";
		}
		HttpSession session=request.getSession();
		session.setAttribute("msg", msg);
		 request.getRequestDispatcher("/BorrowerManagement.jsp").include(request, response);
		}
	

}
