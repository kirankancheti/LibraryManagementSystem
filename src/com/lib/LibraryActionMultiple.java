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
 * Servlet implementation class LibraryActionMultiple
 */
@WebServlet("/LibraryActionMultiple")
public class LibraryActionMultiple extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibraryActionMultiple() {
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
		String bname=request.getParameter("bname").trim();
		String author=request.getParameter("author").trim();
		String isbn=request.getParameter("bookid").trim();
		
		
		
		if((!isbn.isEmpty())&&(author.isEmpty())&&(bname.isEmpty())){
		ArrayList<Book> ls=rd.retrivedetails(isbn);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	}
		
		
		 if((isbn.isEmpty())&&(author.isEmpty())&&(bname.isEmpty())){
			 System.out.println("inside condition");
			ArrayList<Book> ls=null;
				HttpSession session = request.getSession();
				session.setAttribute("booklist", ls);
				 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
			 
			 
		 }
	 if ((isbn.isEmpty())&&(!author.isEmpty())&&(bname.isEmpty())){
			ArrayList<Book> ls=rd.retriveDetailsByAuthor(author);
			HttpSession session = request.getSession();
			session.setAttribute("booklist", ls);
			 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
			
			
		}
 if ((isbn.isEmpty())&&(author.isEmpty())&&(!bname.isEmpty())){
	ArrayList<Book> ls=rd.retriveDetailsByBname(bname);
	HttpSession session = request.getSession();
	session.setAttribute("booklist", ls);
	 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	
	
			
		}
 
 if((isbn.isEmpty())&&(!author.isEmpty())&&(!bname.isEmpty())){
	 ArrayList<Book> ls=rd.retriveDetailsByBnameAuthor(bname, author);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	 
	 
 }
 
 
 if((isbn.isEmpty())&&(!author.isEmpty())&&(!bname.isEmpty())){
	 ArrayList<Book> ls=rd.retriveDetailsByBnameAuthor(bname, author);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	 
	 
 }
 
 if((!isbn.isEmpty())&&(!author.isEmpty())&&(bname.isEmpty())){
	 System.out.println("inside condition");
	 ArrayList<Book> ls=rd.retriveDetailsByBookIdAuthor(isbn, author);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	 
	 
 }
 
 
 if((!isbn.isEmpty())&&(author.isEmpty())&&(!bname.isEmpty())){
	 System.out.println("inside condition");
	 ArrayList<Book> ls=rd.retriveDetailsByBookIdBname(isbn, bname);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	 
	 
 }
 
 if((!isbn.isEmpty())&&(!author.isEmpty())&&(!bname.isEmpty())){
	 System.out.println("inside condition");
	 ArrayList<Book> ls=rd.retriveDetailsByBookIdBnameAuthor(isbn, bname,author);
		HttpSession session = request.getSession();
		session.setAttribute("booklist", ls);
		 request.getRequestDispatcher("/BookSearchMultiple.jsp").include(request, response);
	 
	 
 }
 
 
 
 
 
 
 
 
 
 
 
	 
	 


	}
	

}
