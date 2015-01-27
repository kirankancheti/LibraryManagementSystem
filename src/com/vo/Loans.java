package com.vo;

import java.sql.Date;

public class Loans {

	String color;
	 public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	String book_id ="";
     public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
	String cardNum ="";
     Date  date_out =null;
     Date due_date =null;
     Date date_in =null;
     String branch_Id ="";
     String loanId="";
     int noOfDaystoBeFined;
     double amount=0.25;
     double totalFine;
     boolean isReturned;
     
     public double getTotalFine() {
		return totalFine;
	}
	public void setTotalFine() {
		this.totalFine = getAmount()*getNoOfDaystoBeFined();
	}
	public int getNoOfDaystoBeFined() {
		return noOfDaystoBeFined;
	}
	public void setNoOfDaystoBeFined(int noOfDaystoBeFined) {
		this.noOfDaystoBeFined = noOfDaystoBeFined;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	String fname="";
		String lname="";
		String address="";
		String phone="";

	public String getFname() {
			return fname;
		}
		public void setFname(String fname) {
			this.fname = fname;
		}
		public String getLname() {
			return lname;
		}
		public void setLname(String lname) {
			this.lname = lname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public Date getDate_out() {
		return date_out;
	}
	public void setDate_out(Date date_out) {
		this.date_out = date_out;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getDate_in() {
		return date_in;
	}
	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}
	public String getBranch_Id() {
		return branch_Id;
	}
	public void setBranch_Id(String branch_Id) {
		this.branch_Id = branch_Id;
	}
     
     
}
