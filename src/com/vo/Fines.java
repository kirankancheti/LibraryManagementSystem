package com.vo;

public class Fines {
	String loan_id;
	public String getLoan_id() {
		return loan_id;
	}
	public void setLoan_id(String loan_id) {
		this.loan_id = loan_id;
	}
	public double getFine_amt() {
		return fine_amt;
	}
	public void setFine_amt(double fine_amt) {
		this.fine_amt = fine_amt;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	double fine_amt;
	boolean paid;
	 public boolean equals(Object o) {
		 if ((o instanceof Fines) && (((Fines)o).getLoan_id().equalsIgnoreCase(this.loan_id))

			) {
			
		 return true;
		 } else {
			
		 return false;
		 }
		 }
	 
	 public int hashCode() { return (loan_id.length() * 17); }
	

}
