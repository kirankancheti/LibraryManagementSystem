package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

import com.vo.Borrower;

public class BorrowerUpdateDAO {

	public String updateBorrower(String fname, String lname, String address,
			String phone) {
		String message = "";
		DBConn db = new DBConn();
		Connection conn = db.getConnection();
		String fname1 = "";
		String lname1 = "";
		String address1 = "";

		try {
			PreparedStatement ps2 = null;
			PreparedStatement ps = null;
			PreparedStatement ps3 = null;

			String query1 = "select max(card_no) from library.borrower;";
			String query2 = "select * from library.borrower;";

			String query4 = "insert into library.borrower(card_no,fname,lname,address,phone) values (?,?,?,?,?);"; // Create
																													// a
																													// SQL
																													// statement
																													// object
																													// and
																													// execute
																													// the
																													// query.
			ps2 = conn.prepareStatement(query4);

			ps3 = conn.prepareStatement(query2);
			ResultSet allBorrowers = ps3.executeQuery();
			HashSet<Borrower> hm = new HashSet<Borrower>();
			while (allBorrowers.next()) {

				fname1 = allBorrowers.getString("fname");

				lname1 = allBorrowers.getString("lname");

				address1 = allBorrowers.getString("address");

				Borrower b = new Borrower(fname1, lname1, address1);
				hm.add(b);
			}
			System.out.println(hm.size());
			Borrower inputUser = new Borrower(fname, lname, address);
			if (hm.add(inputUser)) {
				ps = conn.prepareStatement(query1);
				ResultSet maxCarRS = ps.executeQuery();
				String max_card_no = "";
				int max_card_num;
				while (maxCarRS.next()) {
					max_card_no = maxCarRS.getString("max(card_no)");
				}
				max_card_num = Integer.parseInt(max_card_no);
				max_card_num = max_card_num + 1;

				ps2.setInt(1, max_card_num);
				ps2.setString(2, fname);
				ps2.setString(3, lname);
				ps2.setString(4, address);
				ps2.setString(5, phone);

				int updt = ps2.executeUpdate();
				System.out.println(updt);

				if (updt == 1) {
					message = "NEW BORROWER CREATED,BORROWER ID : "+max_card_num;
				} else {
					message = "FAILED TO CREATE NEW BORROWER";
				}

			} else {
				message = "USER ALREADY EXISTS IN DATA BASE";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "EXCEPTION";
		}

		db.closeConnection(conn);
		return message;
	}

}
