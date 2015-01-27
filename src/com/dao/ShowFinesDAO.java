package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;

import com.vo.Borrower;
import com.vo.TotalFine;

public class ShowFinesDAO {

	public ArrayList<TotalFine> retrivedetails() {

		ArrayList<TotalFine> tfal = new ArrayList<TotalFine>();
		try {
			DBConn db = new DBConn();
			Connection conn = db.getConnection();
			PreparedStatement ps = null;
			String query = "select bl.card_no,sum(fine_amt),br.fname,br.lname,f.paid from fines f,book_loans bl,borrower br where f.loan_id=bl.loan_id and br.card_no=bl.card_no group by bl.card_no,f.paid; "; // Create a SQL statement
													// object and execute the
													// query.
			Statement stmt = conn.createStatement();

			ps = conn.prepareStatement(query);

			// Set the current database, if not already set in the getConnection
			// Execute a SQL statement
			stmt.execute("use library;");

			// Execute a SQL query using SQL as a String object
			ResultSet rs = ps.executeQuery();
			String card_no = "";
			String fname = "";
			String lastName = "";
			boolean paid;
			double total_sum;
			// Iterate through the result set using ResultSet class's next()
			// method
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

			while (rs.next()) {
				// Keep track of the line/tuple count

				// Populate field variables
				TotalFine tf = new TotalFine();
				card_no = rs.getString("card_no");
				tf.setCard_no(card_no);
				PreparedStatement ps3 = null;
				ps3 = conn.prepareStatement("select * from book_loans where card_no=?");
				ps3.setString(1,card_no );
				ResultSet allLoansPaid = ps3.executeQuery();
				while (allLoansPaid.next()) {

					java.sql.Date date_in = allLoansPaid.getDate("date_in");
					java.sql.Date due_date=allLoansPaid.getDate("due_date");
				
					if(date_in == null){
						if(due_date.before(today)){	tf.setReturned(false);
						break;}
					
					}

				}
				total_sum = rs.getDouble("sum(fine_amt)");
				tf.setTotal_sum(total_sum);

				fname = rs.getString("fname");
				tf.setFname(fname);

				lastName = rs.getString("lname");
				tf.setLastName(lastName);

				if (1 == rs.getInt("paid")) {
					tf.setPaid(true);
				} else {
					tf.setPaid(false);
				}

				tfal.add(tf);
				// Do something with the data
				System.out.print(card_no + ".\t");
				System.out.print(total_sum + "\t");
				System.out.print(fname + "\t");
				System.out.print(lastName + "\t");
				System.out.println();
			} // End while(rs.next())

			// Always close the recordset and connection.
			rs.close();
			db.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tfal;

	}
	
	public void updateFines(String[] select) {
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		ResultSet rs=null;

	
		try {
			
			PreparedStatement ps = null;
			PreparedStatement ps2 = null;
			String query = "select * from library.book_loans where card_no=?"; // Create
			String query2="update library.fines set  paid=1 where loan_id=? ";
			ps = conn.prepareStatement(query);
			ps2=conn.prepareStatement(query2);
			
			// a
			for(int i=0;i<select.length;i++){
			
																							// SQL
																							// statement
			ps.setString(1,select[i] )	;
			rs=ps.executeQuery();
			
			while(rs.next()){
				
			String loan_id=	rs.getString("loan_id");
			
			ps2.setString(1, loan_id);
			ps2.executeUpdate();
			
				
			}
			}																	// object
																							// and
																							// execute
																							// the
																							// query.
			
			
			// End while(rs.next())

			// Always close the recordset and connection.
			rs.close();
			db.closeConnection(conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
