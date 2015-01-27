package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import com.vo.Fines;
import com.vo.Loans;

public class UpdateFinesDAO {
	
	public ArrayList<Loans> updateFines(){
		ArrayList<Loans> lns = new ArrayList<Loans>();
		try {
			DBConn db = new DBConn();
			Connection conn = db.getConnection();
			PreparedStatement ps = null;
			String query = "select * from book_loans"; // Create
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
			

			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			stmt.execute("use library;");
			ResultSet FinesRS=stmt.executeQuery("select * from fines;");
			HashMap<String, Fines> hm=new HashMap<String, Fines>();
			while(FinesRS.next()){
				Fines f=new Fines();
				f.setLoan_id(FinesRS.getString("loan_id"));
				f.setFine_amt((FinesRS.getDouble("fine_amt")));
				if(1==FinesRS.getInt("paid")){
					f.setPaid(true);
				}
				else{
					f.setPaid(false);
				}
				hm.put(f.getLoan_id(), f);
			}

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
			boolean isReturned;
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
				
				date_in=rs.getDate("date_in");
				l.setDate_in(date_in);
				
				if(date_in== null){
					 java.util.Date td=new java.util.Date();
		                java.sql.Date sqlDate = new java.sql.Date(td.getTime());
		                Calendar cal = Calendar.getInstance();
		                cal.setTime(sqlDate);
		                cal.add(Calendar.DAY_OF_YEAR,0);
		                cal.set(Calendar.HOUR_OF_DAY, 0);
		                cal.set(Calendar.MINUTE, 0);
		                cal.set(Calendar.SECOND, 0);
		                cal.set(Calendar.MILLISECOND, 0);
		                java.sql.Date today = new java.sql.Date(cal.getTimeInMillis());
		              //  System.out.println(today);
		                long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
		                if(due_date.before(today)){
		                int	noOfDaystoBeFined=(int)((today.getTime() - due_date.getTime()) / MILLISECONDS_IN_DAY);
						l.setNoOfDaystoBeFined(noOfDaystoBeFined);
						l.setTotalFine();
						l.setReturned(false);
		                lns.add(l);
		                }
				}
				else{
					long MILLISECONDS_IN_DAY = 24 * 60 * 60 * 1000;
					 if(date_in.after(due_date)){
						  int	noOfDaystoBeFined=(int)((date_in.getTime() - due_date.getTime()) / MILLISECONDS_IN_DAY);
							l.setNoOfDaystoBeFined(noOfDaystoBeFined);
							l.setTotalFine();
							l.setReturned(true);
							lns.add(l);
			                }
				}
				
				
			

				System.out.println();
			} // End while(rs.next())
			
			for(Loans l1:lns){
				if(hm.containsKey(l1.getLoanId())){
					Fines fineObj=hm.get(l1.getLoanId());
					if(!fineObj.isPaid()){
						if(fineObj.getFine_amt()<l1.getTotalFine()){
							updateFine(l1);
						}
						
					}
				}
			else{
					insertIntoFines(l1);
				}
			}
			
			for ( String key : hm.keySet() ) {
			    System.out.println( key );
			}
           
			// Do something with the data

			// Always close the recordset and connection.
			rs.close();
			db.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lns;
	}
	
	
	public void insertIntoFines(Loans f){
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		PreparedStatement ps = null;
		String query = "insert into library.fines values (?,?,?);"; // Create
		
		try{
			ps=conn.prepareStatement(query);
			ps.setString(1, f.getLoanId());
			ps.setDouble(2,f.getTotalFine());
			ps.setInt(3, 0);
			ps.executeUpdate();
			
			
			db.closeConnection(conn);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public void updateFine(Loans f){
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		PreparedStatement ps = null;
		String query = "update  library.fines set fine_amt=? where loan_id=?;"; // Create
		
		try{
			ps=conn.prepareStatement(query);
			ps.setString(2, f.getLoanId());
			ps.setDouble(1,f.getTotalFine());
		//	ps.setInt(3, 0);
			ps.executeUpdate();
			
			
			db.closeConnection(conn);

			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
