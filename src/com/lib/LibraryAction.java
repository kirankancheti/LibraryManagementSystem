package com.lib;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.dao.RetriveDetailsDAO;
import com.vo.Book;

/**
 * Servlet implementation class LibraryAction
 */
@WebServlet("/LibraryAction")
public class LibraryAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryAction() {
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
		RetriveDetailsDAO rd=new RetriveDetailsDAO();
		String searchString=request.getParameter("searchstring");
		if(request.getParameter("radios").equalsIgnoreCase("bookid")){
		ArrayList<Book> ls=rd.retrivedetails(searchString);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/Index.jsp").include(request, response);
	}
		else if (request.getParameter("radios").equalsIgnoreCase("author")){
			ArrayList<Book> ls=rd.retriveDetailsByAuthor(searchString);
			HttpSession session = request.getSession();
			session.setAttribute("booklist", ls);
			 request.getRequestDispatcher("/Index.jsp").include(request, response);
			
			
		}
else if (request.getParameter("radios").equalsIgnoreCase("bname")){
	ArrayList<Book> ls=rd.retriveDetailsByBname(searchString);
	HttpSession session = request.getSession();
	session.setAttribute("booklist", ls);
	 request.getRequestDispatcher("/Index.jsp").include(request, response);
	
	
			
		}


	}

}
