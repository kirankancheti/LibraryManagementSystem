package com.lib;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UpdateFinesDAO;
import com.vo.Loans;

/**
 * Servlet implementation class UpdateFines
 */
@WebServlet("/UpdateFines")
public class UpdateFines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFines() {
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
		
		UpdateFinesDAO ufine=new UpdateFinesDAO();
		ArrayList<Loans> loanDet=ufine.updateFines();
		for(int i=0;i<loanDet.size();i++){
			Loans l=loanDet.get(i);
			System.out.print(l.getLoanId() + ".\t");
			System.out.print(l.getBook_id() + "\t");
			System.out.print(l.getBranch_Id() + "\t");
			System.out.print(l.getCardNum() + "\t");
			System.out.print(l.getDate_out() + "\t");
			System.out.print(l.getDue_date() + "\t");
			System.out.print(l.getDate_in() + "\t");
			System.out.print(l.getNoOfDaystoBeFined() + "\t");
			System.out.print(l.getTotalFine() + "\t");
            System.out.println("\n");
			
		}
		 request.getRequestDispatcher("/LibraryFines.jsp").include(request, response);
	}

}
