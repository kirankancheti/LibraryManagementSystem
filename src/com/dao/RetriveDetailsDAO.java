package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.vo.Book;

public class RetriveDetailsDAO {
	
	public ArrayList<Book> retrivedetails(String bookId){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2=null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and b.book_id like ?;";		  // Create a SQL statement object and execute the query.
        Statement stmt = conn.createStatement();
        
        ps=conn.prepareStatement(query);
        
        ps.setString(1, "%" + bookId + "%");
        String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
        ps2=conn.prepareStatement(query2);
        
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        
        
        
        while (rs.next()) {
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
             
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())

        // Always close the recordset and connection.
        rs.close();
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	public ArrayList<Book> retriveDetailsByAuthor(String author){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and ba.author_name like ?;";		  // Create a SQL statement object and execute the query.
        Statement stmt = conn.createStatement();
        String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
        ps2=conn.prepareStatement(query2);
        
        ps=conn.prepareStatement(query);
      //  ps.setString(1, author);
        ps.setString(1, "%" + author + "%");
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        
        while (rs.next()) {
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
            
          
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())

        // Always close the recordset and connection.
        rs.close();
        
        
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	public ArrayList<Book> retriveDetailsByBname(String bName){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and b.title like ?;";		  // Create a SQL statement object and execute the query.
		 String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
	        ps2=conn.prepareStatement(query2);
		Statement stmt = conn.createStatement();
        
        ps=conn.prepareStatement(query);
        ps.setString(1, "%" + bName + "%");
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        
        while (rs.next()) {
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())

        // Always close the recordset and connection.
        rs.close();
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	public ArrayList<Book> retriveDetailsByBnameAuthor(String bName,String author){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and b.title like ? and ba.author_name like ?;";		  // Create a SQL statement object and execute the query.
		 String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
	        ps2=conn.prepareStatement(query2);
		Statement stmt = conn.createStatement();
        
        ps=conn.prepareStatement(query);
        ps.setString(1, "%" + bName + "%");
        
   
        ps.setString(2, "%" + author + "%");
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        boolean dataForauthorBname=false;
        while (rs.next()) {
        	dataForauthorBname=true;
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())
        
        
        if(!dataForauthorBname){
        	
        	ls=retriveDetailsByAuthor(author);
        	
        }
        
        if(ls.isEmpty()){
        	ls=retriveDetailsByBname(bName);
        }

        // Always close the recordset and connection.
        rs.close();
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	
	
	public ArrayList<Book> retriveDetailsByBookIdAuthor(String bookId,String author){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and ba.author_name like ? and b.book_id like ? ;";		  // Create a SQL statement object and execute the query.
		 String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
	        ps2=conn.prepareStatement(query2);
		Statement stmt = conn.createStatement();
        
        ps=conn.prepareStatement(query);
       
        
   
        ps.setString(1, "%" + author + "%");
        ps.setString(2, "%" + bookId + "%");
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        boolean dataForauthorBname=false;
        while (rs.next()) {
        	dataForauthorBname=true;
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())
        
        
        if(!dataForauthorBname){
        	
        	ls=retriveDetailsByAuthor(author);
        	
        }
        
        if(ls.isEmpty()){
        	ls=retrivedetails(bookId);
        }

        // Always close the recordset and connection.
        rs.close();
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	
	
	public ArrayList<Book> retriveDetailsByBookIdBname(String bookId,String bname){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and b.title like ? and b.book_id like ?  ;";		  // Create a SQL statement object and execute the query.
		 String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
	        ps2=conn.prepareStatement(query2);
		Statement stmt = conn.createStatement();
        
        ps=conn.prepareStatement(query);
       
        
   
        ps.setString(1, "%" + bname + "%");
        ps.setString(2, "%" + bookId + "%");
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        boolean dataForauthorBname=false;
        while (rs.next()) {
        	dataForauthorBname=true;
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())
        
        
        if(!dataForauthorBname){
        	
        	ls=retriveDetailsByBname(bname);
        	
        }
        
        if(ls.isEmpty()){
        	
        	ls=retrivedetails(bookId);
        }

        // Always close the recordset and connection.
        rs.close();
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	
	public ArrayList<Book> retriveDetailsByBookIdBnameAuthor(String bookId,String bname,String author){
		ArrayList<Book> ls=new ArrayList<Book>();
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		String query="select * from book b,book_authors ba,book_copies bc where b.book_id=ba.book_id and b.book_id=bc.book_id and b.title like ? and b.book_id like ? and ba.author_name like ? ;";		  // Create a SQL statement object and execute the query.
		 String query2="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
	        ps2=conn.prepareStatement(query2);
		Statement stmt = conn.createStatement();
        
        ps=conn.prepareStatement(query);
       
        
   
        ps.setString(1, "%" + bname + "%");
        ps.setString(2, "%" + bookId + "%");
        ps.setString(3, "%" + author + "%");
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
        stmt.execute("use library;");

        // Execute a SQL query using SQL as a String object
        ResultSet rs = ps.executeQuery();
        String book_id ="";
        String title ="";
        String lastName ="";
        String authorName ="";
        String minit ="";
        String branch_Id ="";
        String no_of_copies="";
        // Iterate through the result set using ResultSet class's next() method
        boolean dataForauthorBname=false;
        while (rs.next()) {
        	dataForauthorBname=true;
            // Keep track of the line/tuple count
           
            // Populate field variables
            Book b=new Book();
             book_id = rs.getString("book_id");
             b.setBook_id(book_id);
             title = rs.getString("Title");
             b.setTitle(title);
            
             authorName = rs.getString("author_name");
             b.setAuthorName(authorName);
           
             branch_Id = rs.getString("branch_id");
             b.setBranch_Id(branch_Id);
             no_of_copies= rs.getString("no_of_copies");
             b.setNo_of_copies(no_of_copies);
             ps2.setString(1, book_id);
             ps2.setString(2, branch_Id);
             ResultSet NoBooksRS=ps2.executeQuery();
             int no_LoanBooks=0;
             while(NoBooksRS.next()){
            	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
             }
             int no_of_cop=Integer.parseInt(no_of_copies);
             int avail=no_of_cop-no_LoanBooks;
             Integer av=new Integer(avail);
             b.setAvail_no_of_copies(av.toString());
        ls.add(b);
            // Do something with the data
            System.out.print(book_id + ".\t");
            System.out.print(title + "\t");
            System.out.print(authorName + "\t");
            System.out.print(minit + "\t");
            System.out.print(lastName + "\t");
            System.out.print(branch_Id + "\t");
            System.out.print(no_of_copies + "\t");
            System.out.println();
        } // End while(rs.next())
        
      
        if(!dataForauthorBname){
        	
        	ls=retriveDetailsByBnameAuthor(bname, author);
        	
        }
        
        if(ls.isEmpty()){
        	
        	ls=retriveDetailsByBookIdAuthor(bookId, author);
        }
        
        if(ls.isEmpty()){
        	ls=retriveDetailsByBookIdBname(bookId, bname);
        }

        // Always close the recordset and connection.
        rs.close();
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		}
		return ls;
	}
	
	
	public String checkOut(String bookId,String branchId,String bocid){
		
		int i=-1;
		String message="";
		try{
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		PreparedStatement ps = null;
		PreparedStatement ps10 = null;
		Statement stmt=conn.createStatement();
		boolean availabilityOfBooks=true;
		boolean availabilityOfLoans=false;
		boolean availabilityOfFines=false;
		 String query10="select count(book_id) from book_loans where date_in is null and book_id=? and branch_id=? group by book_id,branch_id";
	        ps10=conn.prepareStatement(query10);
	
		 stmt.execute("use library;");
		
		String query="insert into book_loans(book_id,branch_id,card_no,date_out,due_date) values (?,?,?,?,?);";		  // Create a SQL statement object and execute the query.
		 PreparedStatement ps2 = null;
		 
		    ps10.setString(1, bookId);
            ps10.setString(2, branchId);
		  ResultSet NoBooksRS=ps10.executeQuery();
          int no_LoanBooks=0;
          while(NoBooksRS.next()){
         	no_LoanBooks=NoBooksRS.getInt("count(book_id)");
          }
        
       String query1="select * from book_copies where book_id=? and branch_id=?;";		  // Create a SQL statement object and execute the query.
       ps2=conn.prepareStatement(query1);
        ps2.setString(1,bookId );
        ps2.setString(2,branchId );
        ResultSet bookAvailable=ps2.executeQuery();
        String Copies="";
        while(bookAvailable.next()){
        	 Copies=bookAvailable.getString("no_of_copies");
        	System.out.println("Copies"+Copies);
        	int noOfCopies=Integer.parseInt(Copies);
        	 noOfCopies=noOfCopies-no_LoanBooks;
        	 System.out.println("loans "+no_LoanBooks+" Copies" +Copies);
        	if(noOfCopies<1){
        		availabilityOfBooks=false;
        	}
        	
        }
      
        
   
    
        String query2="select count(*) from book_loans where card_no=? and date_in is NULL;";	
         ps2 = conn.prepareStatement(query2);
        ps2.setString(1,bocid );
    
        ResultSet loansToBeReturned=ps2.executeQuery();
        
        while(loansToBeReturned.next()){
        	String loansAtPresent=loansToBeReturned.getString("count(*)");
        	System.out.println("loansAtPresent"+loansAtPresent);
        	int noOfloans=Integer.parseInt(loansAtPresent);
        	if(noOfloans<3){
        		availabilityOfLoans=true;
        	}
        	
        }
        
        
        String query3="select loan_id from book_loans where card_no=?;";	
        ps2 = conn.prepareStatement(query3);
       ps2.setString(1,bocid );
   
       ResultSet loan_id_rs=ps2.executeQuery();
       
       while(loan_id_rs.next()){
       	String loandi=loan_id_rs.getString("loan_id");
       
       	   PreparedStatement ps21=conn.prepareStatement("select * from fines where loan_id=?;");
       	   ps21.setString(1, loandi);
       	   
       	   ResultSet Fnrs=ps21.executeQuery();
       	   
       	   while(Fnrs.next()){
       		   
       		availabilityOfFines=true;
       		break;
       	   }
       	
       }
        
        
        if(availabilityOfBooks&&availabilityOfLoans&&(!availabilityOfFines)){
        	
        	
        	   String query4="update book_copies set no_of_copies=no_of_copies-1 where book_id=? and branch_id=?;";		  // Create a SQL statement object and execute the query.
        	    ps2 = conn.prepareStatement(query4);
                ps2.setString(1,bookId );
                ps2.setString(2, branchId);
            
             //   int updt=ps2.executeUpdate();	
        	
        ps=conn.prepareStatement(query);
        ps.setString(1, bookId);
        ps.setString(2, branchId);
        ps.setString(3, bocid);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        java.util.Date td=new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(td.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(sqlDate);
        cal.add(Calendar.DAY_OF_YEAR,14);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        java.sql.Date sqlTommorow = new java.sql.Date(cal.getTimeInMillis());
        ps.setDate(4, sqlDate);
        ps.setDate(5, sqlTommorow);
    
        // Set the current database, if not already set in the getConnection
        // Execute a SQL statement
       

        // Execute a SQL query using SQL as a String object
         i = ps.executeUpdate();
        
       
              System.out.println(i);
        		
        }
        if(i==1){
        	message="CHECKED OUT SUCCESFULLY";
        }
        else{
        	message="CHECKING FAILED";
        }
        
        if(!availabilityOfBooks){
        	message="SORRY BOOKS NOT AVAILABLE IN BRANCH";
        }
        else{
        	if(!availabilityOfLoans)
        	{
        		message="SORRY EXCEEDED MAXIMUM NUMBER OF LOANS";
        	}
        	else if(availabilityOfFines){
        		message="PLEASE PAY THE FINE TO CHECK OUT";
        	}
        }
      
        // Iterate through the result set using ResultSet class's next() method
        
   
       

        // Always close the recordset and connection.
       
      db.closeConnection(conn);
        
		}
		catch (Exception e) {
		e.printStackTrace();
		message="EXCEPTION";
		}
		return message;
	}


}
