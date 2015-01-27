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

import com.vo.Loans;

public class RetriveCheckInDAO {

	public ArrayList<Loans> retrivedetailsbyBookId(String bookId) {
		ArrayList<Loans> lns = new ArrayList<Loans>();
		try {
			DBConn db = new DBConn();
			Connection conn = db.getConnection();
			PreparedStatement ps = null;
			String query = "select * from book_loans bl,borrower br where date_in is NULL and bl.book_id=? and bl.card_no=br.card_no"; // Create
																							// a
																							// SQL
																							// statement
																							// object
																							// and
																							// execute
																							// the
																							// query.
			Statement stmt = conn.createStatement();

			ps = conn.prepareStatement(query);
			ps.setString(1, bookId);

			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			stmt.execute("use library;");

			// Execute a SQL query using SQL as a String object
			ResultSet rs = ps.executeQuery();
			String book_id = "";
			String cardNum = "";
			Date date_out = null;
			Date due_date = null;
			Date date_in = null;
			String branch_Id = "";
			String fname="";
			String lname="";
			String address="";
			String phone="";
			String loanId="";

			// Iterate through the result set using ResultSet class's next()
			// method

			while (rs.next()) {
				// Keep track of the line/tuple count

				// Populate field variables
				Loans l = new Loans();
				 loanId = rs.getString("loan_id");
					l.setLoanId(loanId);
				book_id = rs.getString("book_id");
				l.setBook_id(book_id);
				cardNum = rs.getString("card_no");
				l.setCardNum(cardNum);

				date_out = rs.getDate("date_out");
				l.setDate_out(date_out);

				due_date = rs.getDate("due_date");
				l.setDue_date(due_date);

				branch_Id = rs.getString("branch_id");
				l.setBranch_Id(branch_Id);
				
				fname=rs.getString("fname");
                l.setFname(fname);
                
                lname=rs.getString("lname");
                l.setLname(lname);
                
                address=rs.getString("address");
                l.setAddress(address);
                
                phone=rs.getString("phone");
                l.setPhone(phone);
                
                
                
				lns.add(l);
				// Do something with the data
				System.out.print(book_id + ".\t");
				System.out.print(cardNum + "\t");
				System.out.print(date_out + "\t");
				System.out.print(due_date + "\t");
				System.out.print(branch_Id + "\t");
				System.out.print(fname + "\t");
				System.out.print(lname + "\t");
				System.out.print(address + "\t");
				System.out.print(phone + "\t");

				System.out.println();
			} // End while(rs.next())

			// Always close the recordset and connection.
			rs.close();
			db.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lns;
	}
	
	
	public ArrayList<Loans> retrivedetailsbyCardId(String bocid) {
		ArrayList<Loans> lns = new ArrayList<Loans>();
		try {
			DBConn db = new DBConn();
			Connection conn = db.getConnection();
			PreparedStatement ps = null;
			String query = "select * from book_loans bl,borrower br where date_in is NULL and bl.card_no=? and bl.card_no=br.card_no"; // Create
																							// a
																							// SQL
																							// statement
																							// object
																							// and
																							// execute
																							// the
																							// query.
			Statement stmt = conn.createStatement();

			ps = conn.prepareStatement(query);
			ps.setString(1, bocid);

			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			stmt.execute("use library;");

			// Execute a SQL query using SQL as a String object
			ResultSet rs = ps.executeQuery();
			String book_id = "";
			String cardNum = "";
			Date date_out = null;
			Date due_date = null;
			Date date_in = null;
			String branch_Id = "";
			String fname="";
			String lname="";
			String address="";
			String phone="";
			String loanId="";

			// Iterate through the result set using ResultSet class's next()
			// method

			while (rs.next()) {
				// Keep track of the line/tuple count

				// Populate field variables
				Loans l = new Loans();
				 loanId = rs.getString("loan_id");
				l.setLoanId(loanId);
				book_id = rs.getString("book_id");
				l.setBook_id(book_id);
				cardNum = rs.getString("card_no");
				l.setCardNum(cardNum);

				date_out = rs.getDate("date_out");
				l.setDate_out(date_out);

				due_date = rs.getDate("due_date");
				l.setDue_date(due_date);

				branch_Id = rs.getString("branch_id");
				l.setBranch_Id(branch_Id);
				
				fname=rs.getString("fname");
                l.setFname(fname);
                
                lname=rs.getString("lname");
                l.setLname(lname);
                
                address=rs.getString("address");
                l.setAddress(address);
                
                phone=rs.getString("phone");
                l.setPhone(phone);
                
                
                
				lns.add(l);
				// Do something with the data
				System.out.print(book_id + ".\t");
				System.out.print(cardNum + "\t");
				System.out.print(date_out + "\t");
				System.out.print(due_date + "\t");
				System.out.print(branch_Id + "\t");
				System.out.print(fname + "\t");
				System.out.print(lname + "\t");
				System.out.print(address + "\t");
				System.out.print(phone + "\t");

				System.out.println();
			} // End while(rs.next())

			// Always close the recordset and connection.
			rs.close();
			db.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lns;
	}
	
	public ArrayList<Loans> retrivedetailsbyBorrowerName(String bname) {
		ArrayList<Loans> lns = new ArrayList<Loans>();
		try {
			DBConn db = new DBConn();
			Connection conn = db.getConnection();
			PreparedStatement ps = null;
			String query = "select * from book_loans bl,borrower br where date_in is NULL and (br.fname like ? or br.lname like 	?)and bl.card_no=br.card_no;"; // Create
																							// a
																							// SQL
																							// statement
																							// object
																							// and
																							// execute
																							// the
																							// query.
			Statement stmt = conn.createStatement();

			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + bname + "%");
			ps.setString(2, "%" + bname + "%");

			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			stmt.execute("use library;");

			// Execute a SQL query using SQL as a String object
			ResultSet rs = ps.executeQuery();
			String book_id = "";
			String cardNum = "";
			Date date_out = null;
			Date due_date = null;
			Date date_in = null;
			String branch_Id = "";
			String fname="";
			String lname="";
			String address="";
			String phone="";
			String loanId="";

			// Iterate through the result set using ResultSet class's next()
			// method

			while (rs.next()) {
				// Keep track of the line/tuple count

				// Populate field variables
				Loans l = new Loans();
				loanId=rs.getString("loan_id");
				l.setLoanId(loanId);
				book_id = rs.getString("book_id");
				l.setBook_id(book_id);
				cardNum = rs.getString("card_no");
				l.setCardNum(cardNum);

				date_out = rs.getDate("date_out");
				l.setDate_out(date_out);

				due_date = rs.getDate("due_date");
				l.setDue_date(due_date);

				branch_Id = rs.getString("branch_id");
				l.setBranch_Id(branch_Id);
				
				fname=rs.getString("fname");
                l.setFname(fname);
                
                lname=rs.getString("lname");
                l.setLname(lname);
                
                address=rs.getString("address");
                l.setAddress(address);
                
                phone=rs.getString("phone");
                l.setPhone(phone);
                
                
                
				lns.add(l);
				// Do something with the data
				System.out.print(book_id + ".\t");
				System.out.print(cardNum + "\t");
				System.out.print(date_out + "\t");
				System.out.print(due_date + "\t");
				System.out.print(branch_Id + "\t");
				System.out.print(fname + "\t");
				System.out.print(lname + "\t");
				System.out.print(address + "\t");
				System.out.print(phone + "\t");

				System.out.println();
			} // End while(rs.next())

			// Always close the recordset and connection.
			rs.close();
			db.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lns;
	}
	
	
	public void updateBookLoans(String loansId[]){
		DBConn db=new DBConn();
		Connection conn=db.getConnection();
		try{
		PreparedStatement ps2 = null;
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		 String query1="select * from library.book_loans where loan_id=?;";		  // Create a SQL statement object and execute the query.
	      
	        
		  String query4="update library.book_loans set date_in=? where loan_id=?;";	
		  ps2 = conn.prepareStatement(query4);
		for (int i = 0; i < loansId.length; i++) {
			   ps = conn.prepareStatement(query1);
		        ps.setString(1,loansId[i] );
		        ResultSet loanDetails=ps.executeQuery();
		        String book_id="";
		        String branch_id="";
		        while(loanDetails.next()){
		        	book_id=loanDetails.getString("book_id");
		        	branch_id=loanDetails.getString("branch_id");}
		   
  java.util.Date td=new java.util.Date();
  java.sql.Date sqlDate = new java.sql.Date(td.getTime());
  ps2.setDate(1,sqlDate );
  ps2.setString(2, loansId[i]);
  int updt=ps2.executeUpdate();	
  System.out.println(updt);
  String query2="update library.book_copies set no_of_copies=no_of_copies+1 where book_id=? and branch_id=?;";		  // Create a SQL statement object and execute the query.
  ps1=conn.prepareStatement(query2);
  ps1.setString(1, book_id);
  ps1.setString(2, branch_id);
 // int updt2=ps1.executeUpdate();
  }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		db.closeConnection(conn);	
}
}
