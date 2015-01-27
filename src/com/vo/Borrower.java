package com.vo;

public class Borrower {
	
	public Borrower(String fname1, String lname1, String address1) {
		super();
		this.fname1 = fname1;
		this.lname1 = lname1;
		this.address1 = address1;
	}

	String fname1="";
	String lname1="";
	public Borrower() {
		super();
		// TODO Auto-generated constructor stub
	}

	String address1="";
	public String getFname1() {
		return fname1;
	}
	public void setFname1(String fname1) {
		this.fname1 = fname1;
	}
	public String getLname1() {
		return lname1;
	}
	public void setLname1(String lname1) {
		this.lname1 = lname1;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	
 @Override
 public boolean equals(Object o) {
	 if ((o instanceof Borrower) && (((Borrower)o).getFname1().equalsIgnoreCase(this.fname1))
		&& (((Borrower)o).getLname1().equalsIgnoreCase(this.lname1))	
		&& (((Borrower)o).getAddress1().equalsIgnoreCase(this.address1))
		) {
		
	 return true;
	 } else {
		
	 return false;
	 }
	 }
 
 public int hashCode() { return (fname1.length() * 17); }
	
	

}
