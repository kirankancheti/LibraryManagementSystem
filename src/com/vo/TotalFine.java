package com.vo;

public class TotalFine {
    String loan_id ="";
    String fname ="";
    String lastName ="";
    String card_no="";
    boolean isReturned=true;
   public boolean isReturned() {
		return isReturned;
	}
	public void setReturned(boolean isReturned) {
		this.isReturned = isReturned;
	}
public String getCard_no() {
		return card_no;
	}
	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
boolean paid;
   double total_sum;
public String getLoan_id() {
	return loan_id;
}
public void setLoan_id(String loan_id) {
	this.loan_id = loan_id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public boolean isPaid() {
	return paid;
}
public void setPaid(boolean paid) {
	this.paid = paid;
}
public double getTotal_sum() {
	return total_sum;
}
public void setTotal_sum(double total_sum) {
	this.total_sum = total_sum;
}
   
   

}
