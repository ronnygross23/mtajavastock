package com.mta.javacourse;
import java.io.IOException;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Stock  extends HttpServlet {
	private String sympol;

	public String getSympol() {
		return sympol;
	}

	public void setSympol(String sympol) {
		this.sympol = sympol;
	}
	
	private float Ask;
	
	public float getAsk() {
		return Ask;
	}

	public void setAsk(float ask) {
		Ask = ask;
	}
	
	private float Bid;
	
	public float getBid() {
		return Bid;
	}

	public void setBid(float bid) {
		Bid = bid;
	}
	
	private java.util.Date date; 

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}
	
	public String getHtmlDescription() {
		String strdate = date.getMonth()+"/"+date.getDate()+"/"+date.getYear();
		String stockHtmlDetailsString= "<b>Stock symbol </b>"+":"+getSympol()+" "+"<b>Ask</b>"+":"+getAsk()+" "+"<b>Bit</b>"+":"+getBid()+" "+"<b>date</b>"+":" +strdate;  
		return stockHtmlDetailsString;
	}

	public Stock(){
		sympol="Unknown";
		Ask=0;
		Bid=0;
		date=null;
	}
	

	
	

}
